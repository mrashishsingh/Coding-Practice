/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var minimumChanges = function (s, k) {
    const n = s.length;
    const INF = 10000;
    const BIG = 1e9;

    const cost = Array.from({ length: n + 1 }, () => new Array(n + 1).fill(BIG));
    const memo = Array.from({ length: n + 1 }, () => new Array(k + 1).fill(-1));

    for (let d = 1; d <= Math.floor(n / 2); d++) {
        const tmp = Array.from({ length: n + 1 }, () => new Array(n + 1).fill(0));
        for (let len = 2 * d; len <= n; len += d) {
            for (let idx = 0; idx + len <= n; idx++) {
                let ops = 0;
                for (let o = 0; o < d; o++) {
                    if (s[idx + o] !== s[idx + len - d + o]) ops++;
                }
                tmp[idx][len] = ops + tmp[idx + d][len - 2 * d];
                cost[idx][len] = Math.min(cost[idx][len], tmp[idx][len]);
            }
        }
    }

    const solve = (idx, parts) => {
        if (idx === n || parts === 0) return idx === n && parts === 0 ? 0 : INF;
        if (memo[idx][parts] !== -1) return memo[idx][parts];
        let res = INF;
        for (let len = 2; idx + len <= n; len++) {
            res = Math.min(res, cost[idx][len] + solve(idx + len, parts - 1));
        }
        return (memo[idx][parts] = res);
    };

    return solve(0, k);
};
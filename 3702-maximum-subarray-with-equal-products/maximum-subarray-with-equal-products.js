
var maxLength = function(nums) {
    let n = nums.length;
    let ans = 0;

    function gcd(a, b) {
        while (b !== 0) {
            let temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    function lcm(a, b) {
        return (a / gcd(a, b)) * b;
    }

    for (let i = 0; i < n; i++) {
        let product = 1;
        let g = 0;
        let l = 1;

        for (let j = i; j < n; j++) {
            product *= nums[j];

            g = gcd(g, nums[j]);
            l = lcm(l, nums[j]);

            if (product === g * l) {
                ans = Math.max(ans, j - i + 1);
            }
        }
    }

    return ans;
};
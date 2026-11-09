class BIT:
    def __init__(self,n):
        self.n = n
        self.tree = [0] * (n + 1)
    
    def update(self, index, val):
        while index <= self.n:
            self.tree[index] += val
            index += index & -index
    
    def pref_sum(self, index):
        ans = 0
        while index > 0:
            ans += self.tree[index]
            index -= index & -index
        return ans
    
    def range_sum(self,i,j):
        return self.pref_sum(j) - self.pref_sum(i-1)

class Solution:
    def busiestServers(self, k: int, arrival: list[int], load: list[int]) -> list[int]:
        n = 2*k
        bit = BIT(n)
        for i in range(n):
            bit.update(i+1,1)
        self.cnt = 0
        freq = defaultdict(int)
        pq = [] #Stores time and server_id
        def find_server(start,end):
            while start < end:
                mid = start + (end-start)//2
                total = bit.range_sum(start+1,mid+1)
                if total > 0:
                    end = mid
                else:
                    start = mid + 1
            return start
                
        for i,time in enumerate(arrival):
            while pq and pq[0][0] <= time:
                t, s = heapq.heappop(pq)
                self.cnt -= 1
                bit.update(s+1,1)
                bit.update(s+k+1,1)
            if self.cnt == k:
                continue
            # Now find the suitable server
            start = (i%k)
            end = start + k
            idx = find_server(start,end)
            self.cnt += 1
            bit.update(idx+1,-1)
            if idx >= k:
                bit.update(idx+1-k,-1)
                heapq.heappush(pq,(time+load[i],idx-k))
                freq[idx-k] += 1
            else:
                bit.update(idx+1+k,-1)
                heapq.heappush(pq,(time+load[i],idx))
                freq[idx] += 1

        mx = max(freq.values())
        arr = []
        for key in freq.keys():
            if freq[key] == mx:
                arr.append(key)
        return  arr



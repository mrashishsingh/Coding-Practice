class Solution {
public:
    int firstStableIndex(vector<int>& a, int k) {
        int n=a.size(), m=a[0];
        vector<int>s(n);
        s[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--) s[i]=min(a[i],s[i+1]);
        for(int i=0;i<n;i++){
            m=max(m,a[i]);
            if(m-s[i]<=k) return i;
        }
        return -1;
    }
};
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        //Constructing Digit Sum Array
        int[] digit = new int[n];
        for(int i=0; i<n; i++){
            int x = nums[i];
            while(x>0){
                digit[i] += x%10;
                x=x/10;
            }
        }

       //Create map of element & index
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<n; i++) map.put(nums[i], i);
        
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) indexes[i] = i;

        //Custom Sorting array based on digit sum & each element(if equal digit sum is found)
        Arrays.sort(indexes, (i1, i2) -> {
            int d1 = digit[i1];
            int d2 = digit[i2];
            if (d1 != d2) return Integer.compare(d1, d2);
            return Integer.compare(nums[i1], nums[i2]);
        });

        // Rebuild primitive array using the sorted indexes
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = nums[indexes[i]];
        }

        //Comparing each element of sorted with each element of num finding it's correct index and swapping
        int ans=0;
        for(int i=0; i<n; i++){
            if(nums[i]!=sorted[i]){
                int idx = map.get(sorted[i]);
                //Updating our map with swapped indexes
                map.put(nums[i], idx);
                map.put(sorted[i], i);
                //Swapping elements
                nums[idx] = nums[i];
                nums[i] = sorted[i];
                ans++;
            }
        }
        
        return ans;
    }
}
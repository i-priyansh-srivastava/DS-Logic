class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        
        int n = startTime.length; 
        List<Integer> free = new ArrayList<>(); 
        free.add(startTime[0]); 

        for(int i = 1; i < n; i++) { 
            free.add(startTime[i] - endTime[i - 1]); 
        } 
        free.add(eventTime - endTime[n - 1]); 
 
        int freeSum = 0; 
        for(int i=0;i<k+1;i++) 
            freeSum += free.get(i); 
        
 
        int maxFree = freeSum; 
        for(int i = k+1;i<free.size();i++) { 
            freeSum += free.get(i) - free.get(i - (k + 1)); 
            maxFree = Math.max(maxFree, freeSum); 
        } 
 
        return maxFree; 
    }
}©leetcode

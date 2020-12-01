//Time Complexity-O(n)
//Space Complexity-O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer>map=new HashMap();
        int maxFrequency=Integer.MIN_VALUE;
        int maxCount=0;
        for(Character c:tasks)
        {
            map.put(c,map.getOrDefault(c,0)+1);
            maxFrequency=Math.max(maxFrequency,map.get(c));
        }
        for(int i:map.values())
        {
            if(i==maxFrequency)
            {
                maxCount++;
            }
        }
        int partition=maxFrequency-1;
        int empty=(n-(maxCount-1))*partition;
        int pending=tasks.length-(maxCount*maxFrequency);
        int idle=Math.max(0,empty-pending);
        return(idle+tasks.length);
    }
}
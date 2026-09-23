class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<deck.length;i++){
            q.offer(i);
        }

        Arrays.sort(deck);

        int i = 0;

        while(!q.isEmpty()){

            int idx = q.poll();

            result[idx] = deck[i];

            i++;

            if(!q.isEmpty()){
                int prev = q.poll();
            
                q.offer(prev);
            }
        }
        return result;
    }
}
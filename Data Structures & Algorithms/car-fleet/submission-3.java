class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> cars = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        int fleet = 0;

        for (int i = 0; i < speed.length; i++) {
            int[] stat = {position[i], speed[i]};
            cars.add(stat);
        }
        cars.sort( (a, b) -> { return b[0] - a[0];} );

        for(int[] car: cars) {
            if (!stack.isEmpty()) {
                int[] top = stack.peek();
                if ((double)(target-top[0])/top[1] >= (double)(target- car[0])/car[1]) continue;
            }
            stack.push(car);
        }

        while(!stack.isEmpty()) {
            fleet++;
            stack.pop();
        }
        return fleet;
    }
}

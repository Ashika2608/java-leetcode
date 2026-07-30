class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (s.isEmpty() || asteroids[i] > 0) {
                s.push(asteroids[i]);
            } else {

                while (true) {

                    if (s.isEmpty() || s.peek() < 0) {
                        s.push(asteroids[i]);
                        break;
                    }

                    if (s.peek() == -asteroids[i]) {
                        s.pop();
                        break;
                    }

                    if (s.peek() > -asteroids[i]) {
                        break; // current asteroid destroyed
                    }

                    s.pop(); // current asteroid bigger

                    if (s.isEmpty()) {
                        s.push(asteroids[i]);
                        break;
                    }
                }
            }
        }

        int[] ans = new int[s.size()];

        for (int i = s.size() - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }
}
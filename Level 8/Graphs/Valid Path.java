public class Solution {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
    boolean[][] visited = new boolean[A + 1][B + 1];
        
        boolean[][] possible = new boolean[A + 1][B + 1];
        
        for (int i = 0; i < possible.length; i++) {
            Arrays.fill(possible[i], true);
        }
        
        for (int i = 0; i < possible.length; i++) {
            for (int j = 0; j < possible[i].length; j++) {
                for (int k = 0; k < E.size(); k++) {
                    int x = E.get(k);
                    int y = F.get(k);
                    
                    if ((x - i) * (x - i) + (y - j) * (y - j) <= D * D) {
                        possible[i][j] = false;
                        break;
                    }
                }
            }
        }
        
        if (path(0, 0, possible, visited)) {
            return "YES";
        } else {
            return "NO";
        }
    }
    
    private boolean path(int x, int y, boolean[][] possible, boolean[][] visited) {
        if (x >= possible.length || x < 0 || y >= possible[0].length || y < 0) {
            return false;
        }
        
        if (visited[x][y]) {
            return false;
        }
        
        if (!possible[x][y]) {
            return false;
        }
        
        if (x == possible.length - 1 && y == possible[possible.length - 1].length - 1) {
            return true;
        }
        
        visited[x][y] = true;
        
        return path(x + 1, y, possible, visited) || path(x + 1, y + 1, possible, visited) || path(x, y + 1, possible, visited) || path(x + 1, y - 1, possible, visited) || path(x - 1, y + 1, possible, visited) || path(x - 1, y, possible, visited) || path(x, y - 1, possible, visited) || path(x - 1, y - 1, possible, visited); 
    }
}


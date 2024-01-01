import java.util.ArrayList;

class Solution {

    public static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private Point getIntersection(long a1 , long b1 , long c1, long a2, long b2, long c2){
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    private Point GetMinimumPoint(Point[] points){
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for(Point point : points){
            minX = Math.min(minX, point.x);
            minY = Math.min(minY, point.y);
        }

        return new Point(minX, minY);
    }

    private Point GetMaximumPoint(Point[] points){
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for(Point point : points){
            maxX = Math.max(maxX, point.x);
            maxY = Math.max(maxY, point.y);
        }

        return new Point(maxX, maxY);
    }

    public String[] solution(int[][] line) {
        ArrayList<Point> points = new ArrayList<>();

        for(int i = 0 ; i < line.length; i++){
            for(int j = i + 1; j < line.length; j++){
                long a1 = line[i][0];
                long b1 = line[i][1];
                long c1 = line[i][2];

                long a2 = line[j][0];
                long b2 = line[j][1];
                long c2 = line[j][2];

                Point point = getIntersection(a1, b1, c1, a2, b2, c2);
                if(point != null){
                    points.add(point);
                }
            }
        }

        Point minPoint = GetMinimumPoint(points.toArray(new Point[0]));
        Point maxPoint = GetMaximumPoint(points.toArray(new Point[0]));

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] board = new char[height][width];
        for(int i = 0 ; i < height; i++){
            for(int j = 0 ; j < width; j++){
                board[i][j] = '.';
            }
        }

        for(Point point : points){
            board[(int) (maxPoint.y - point.y)][(int) (point.x - minPoint.x)] = '*';
        }

        String[] answer = new String[height];
        for(int i = 0 ; i < height; i++){
            answer[i] = new String(board[i]);
        }

        return answer;
    }

}

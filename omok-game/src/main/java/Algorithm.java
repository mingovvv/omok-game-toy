import java.util.Map;

public class Algorithm {
    public static boolean Result(int[][] board) {
        Map<String, Integer> lastStone = Board.getLastStone();

        int color = lastStone.get("색상");
        int x축 = lastStone.get("x축");
        int y축 = lastStone.get("y축");

        if(check가로(color, x축, y축, board) || check세로(color, x축, y축, board) ||
                check대각선(color, x축, y축, board) || check역대각선(color, x축, y축, board)) {
            return true;
        }
        return false;
    }

    private static boolean check역대각선(int color, int x축, int y축, int[][] board) {
        return false;
    }

    private static boolean check대각선(int color, int x축, int y축, int[][] board) {
        int indexX = 0;
        int indexY = 0;
        int cnt = 0;

        try {
            // 가장 왼쪽 가장 아래 좌표 구하기
            for (int i = 0; i< 5; i++) {
                if(board[x축 + i][y축 - i] != color) {
                    break;
                }
                indexX = x축 - i;
                indexY = y축 + i;
            }
            System.out.println("===가장 아래 x축=== : " + indexX);
            System.out.println("===가장 아래 y축=== : " + indexY);

            // 가장 왼쪽 아래쪽 좌표부터 대각선으로 5개가 일치하는지 확인
            for (int j = 0; j < 5; j++) {
                if(board[indexX - j][indexY + j] == color) {
                    cnt++;
                }
            }
            System.out.println("===연결 트루=== : " + cnt);
        } catch (ArrayIndexOutOfBoundsException e) {
            return cnt == 5 ? true : false;
        }

        return cnt == 5 ? true : false;
    }

    private static boolean check세로(int color, int x축, int y축, int[][] board) {

        int index = 0;
        int cnt = 0;

        try {
            // 가장 아래쪽 y좌표 구하기
            for (int i = 0; i< 5; i++) {
                if(board[x축][y축 + i] != color) {
                    break;
                }
                index = y축 + i;
            }
            System.out.println("===가장 아래=== : " + index);

            // 가장 아래쪽 y좌표부터 5개가 일치하는지 확인
            for (int j = index; j > index-5; j--) {
                if(board[j][y축] == color) {
                    cnt++;
                }
            }
            System.out.println("===연결 트루=== : " + cnt);
        } catch (ArrayIndexOutOfBoundsException e) {
            return cnt == 5 ? true : false;
        }

        return cnt == 5 ? true : false;
    }

    private static boolean check가로(int color, int x축, int y축, int[][] board) {

        int index = 0;
        int cnt = 0;

        try {
            // 가장 왼쪽 x 좌표 구하기
            for (int i = 0; i< 5; i++) {
                if(board[x축 - i][y축] != color) {
                    break;
                }
                index = x축 - i;
            }
            System.out.println("===가장 왼쪽=== : " + index);

            // 가장 왼쪽 x좌표부터 5개가 일치하는지 확인
            for (int j = index; j < index+5; j++) {
                if(board[x축][j] == color) {
                    cnt++;
                }
            }
            System.out.println("===연결 트루=== : " + cnt);
        } catch (ArrayIndexOutOfBoundsException e) {
            return cnt == 5 ? true : false;
        }

        return cnt == 5 ? true : false;
    }
}

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class OmokGameMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("오목게임 시작합니다.");

        while(true) {
            System.out.println("오목판 사이즈 n을 입력해주세요. (n x n) 최소 10, 최대 30 입니다.");
            int size = sc.nextInt();

            if(size < 10 || size > 30) {
                System.out.println("사이즈가 허용범위를 벗어났습니다. 재설정 해주세요.");
            } else {
                // 오목판 생성
                Board.createBoard(size);

                // 오목 좌표 생성
                Board.createXYAxis(size);
                break;
            }
        }

        int blackCnt = 1;
        int whiteCnt = 1;
        int tatolCnt = 1;
        while (true) {
            System.out.println("============================================");
            System.out.println(Board.getXAxis());

            int[][] board = Board.getBoard();

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {

                    if(j==0) System.out.print(Board.getYAxis(i));


                    if(board[i][j] == 1) {
                        System.out.print(" ● ");
                    }else if(board[i][j] == 2) {
                        System.out.print(" ○ ");
                    }else {
                        System.out.print(" · ");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================================");

            // 알고리즘 비교
            if(tatolCnt != 1){
                boolean endGame = Algorithm.Result(board);
                if(endGame == true) {
                    System.out.println("================================================");
                    System.out.println(tatolCnt % 2 == 1 ? "백 돌의 승리입니다." : "흑 돌의 승리입니다.");
                    System.out.println("================================================");
                    break;
                }
            }


            while (true) {

                String Axis;
                if (tatolCnt % 2 == 1) {
                    // 흑돌 차례
                    System.out.println("흑 돌의 " + blackCnt + "번 째 차례입니다.");
                    System.out.println("x좌표와 y좌표를 쉼표를 사용하여 입력해주세요.");
                    Axis = sc.next();
                    boolean isValid = Board.validation(Axis, "black");
                    if(isValid == true) {
                        blackCnt++;
                        tatolCnt++;
                        break;
                    } else {
                        System.out.println("유요한 값을 입력하지 않았습니다. 다시 입력해주세요.");
                    }
                } else {
                    // 백돌 차례
                    System.out.println("백 돌의 " + whiteCnt + "번 째 차례입니다.");
                    System.out.println("x좌표와 y좌표를 쉼표를 사용하여 입력해주세요.");
                    Axis = sc.next();
                    boolean isValid = Board.validation(Axis, "white");
                    if(isValid == true) {
                        whiteCnt++;
                        tatolCnt++;
                        break;
                    } else {
                        System.out.println("유요한 값을 입력하지 않았습니다. 다시 입력해주세요.");
                    }
                }
            }
        }
    }
}

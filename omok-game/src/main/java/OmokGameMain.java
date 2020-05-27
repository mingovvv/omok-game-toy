import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Scanner;

public class OmokGameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("오목게임 시작하기");
        System.out.println("오목게임은 2인용으로 진행되며 먼저 연결된 5돌을 만드는 것이 승리조건 입니다.");

        while(true) {
            System.out.println("오목판 사이즈를 n을 입력해주세요. (n x n)");
            int size = sc.nextInt();

            if(size <= 10 || size >= 30) {
                System.out.println("사이즈가 허용범위를 벗어났습니다. 재설정 해주세요.");
            } else {
                // 오목판 생성
                Board.createBoard(size);

                // 오목 좌표 생성
                Board.createXYAxis(size);
                break;
            }
        }


        String[] 세로 = new String[] {"1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String 가로 = Arrays.toString(세로).replace(",", " ").substring(1,Arrays.toString(세로).length()-1);

        while (true) {
            System.out.println("============================================");
            System.out.println(Board.getXAxis());

            int[][] board = Board.getBoard();
            board[1][2] = 1;
            board[4][6] = 2;
            board[6][7] = 1;
            board[1][4] = 2;
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
            System.exit(0);
        }
    }
}

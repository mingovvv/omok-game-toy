public class Board {
    private static int[][] board;
    private static String xAxis = "";
    private static String[] yAxis;

    // 오목판 생성
    public static void createBoard(int size) {
        board = new int[size][size];
    }

    // 오목판 불러오기
    public static int[][] getBoard(){
        return board;
    }

    // 오목판 X, Y 축 생성
    public static void createXYAxis(int size) {

        String[] sampleAxis = new String[]{"1","2","3","4","5","6","7","8","9","a",
                                           "b","c","d","e","f","g","h","i","j","k",
                                           "l","m","n","o","p","q","r","s","t","u"};

        String[] axis = new String[size];
        for (int i = 0; i < axis.length ; i++) {
            axis[i] = sampleAxis[i];

            // X축
            xAxis +="  " + axis[i];
        }

        // y축
        yAxis = axis;
    }

    public static String getXAxis() {
        return xAxis;
    }

    public static String getYAxis(int i) {
        return yAxis[i];
    }

    public static boolean validation(String axis, String color) {
        if(true) {
            String[] splitAxis = axis.split(",");

            int x축 = 0;
            int y축 = 0;

            for (int i = 0; i < yAxis.length; i++) {
                if (yAxis[i].equals(splitAxis[0]))
                    x축 = i;
                if (yAxis[i].equals(splitAxis[1]))
                    y축 = i;
            }

            switch (color) {
                case "white" :
                    board[x축][y축] = 2;
                    break;
                case "black" :
                    board[x축][y축] = 1;
                    break;
            }
            return true;
        } else {
            return false;
        }
    }
}

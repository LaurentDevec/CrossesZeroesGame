import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Игрок № 1, как тебя зовут?");
        String player1 = scanner.nextLine();
        System.out.println("Игрок № 2, как тебя зовут?");
        String player2 = scanner.nextLine();

        // создание поля
        char[][] board = new char[3][3];
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '_';
                }
            }
            boolean isPlayer1 = true;

            boolean gameEnded = false;

            while(!gameEnded) {

                drawBoard(board);

                char symbol = ' ';
                if (isPlayer1) {
                    symbol = 'x';
                } else {
                    symbol = 'o';
                }

                if (isPlayer1) {
                    System.out.println(player1 + " , твоя очередь ходить (крестики)!");
                } else {
                    System.out.println(player2 + " , твоя очередь ходить (нолики)!");
                }

                byte row1 = 0;
                byte column1 = 0;

                while (true) {
                    // Ввод игроком ряда и колонки
                    System.out.println("Введите ряд (цифрой 0, 1, 2): ");
                    row1 = scanner.nextByte();
                    System.out.println("Введите колонку (цифрой 0, 1, 2): ");
                    column1 = scanner.nextByte();

                    // Проверка правильности введённых пользолвателем чисел
                    if (row1 < 0 || column1 < 0 || row1 > 2 || column1 > 2) {
                        System.out.println("Введено неверное значение ряда и колонки!");
                    } else if (board[row1][column1] != '_') {
                        System.out.println("Кто-то из игроков уже занял это поле!");
                    } else {
                        break;
                    }
                }

                // Определение позиции символа, поставленного игроком
                board[row1][column1] = symbol;

                // проверка, выиграл ли игрок
                if (hasWon(board) == 'x') {
                    System.out.println(player1 + " выиграл!");
                    gameEnded = true;
                } else if (hasWon(board) == 'o') {
                    System.out.println(player2 + " выиграл!");
                    gameEnded = true;
                } else {
                    if (hasTied(board)) {
                        System.out.println("Ничья! Совсем ничья");
                    } else {
                        isPlayer1 = !isPlayer1;
                    }
                }
            }
        drawBoard(board);
    }
    // создание игрового поля
    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static char hasWon(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '_') {
                return board[i][0];
                }
            }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '_') {
                return board[0][j];
            }
        }
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '_') {
            return board[0][0];
        }
        if(board[2][0] == board[1][1] && board [1][1] == board [0][2] && board[2][0] != '_') {
            return board[2][0];
        }
        return '_';
    }

    // Проверка заполненности поля
    public static boolean hasTied(char[][] board) {
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == '_'){
                    return false;
                }
            }
        }
        return true;
    }
}

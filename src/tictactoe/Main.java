package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int size = 3;
        char[][] inputs = new char[size][size];
        boolean isPlaying = false;
        boolean isX = false;
        boolean isO = false;
        boolean isTurnOfX = true;
        int countOfX = 0;
        int countOfO = 0;
        char previous = ' ';

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inputs[i][j] = ' ';
            }
        }

        System.out.println("---------");
        System.out.println("| " + inputs[0][0] + " " + inputs[0][1] + " " + inputs[0][2] + " |");
        System.out.println("| " + inputs[1][0] + " " + inputs[1][1] + " " + inputs[1][2] + " |");
        System.out.println("| " + inputs[2][0] + " " + inputs[2][1] + " " + inputs[2][2] + " |");
        System.out.println("---------");

        while (true) {
            isPlaying = false;

            while (true) {
                int row = 0;
                int column = 0;

                System.out.print("Enter the coordinates: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("You should enter numbers!");
                } else {
                    row = scanner.nextInt();

                    if (!scanner.hasNextInt()) {
                        System.out.println("You should enter numbers!");
                    } else {
                        column = scanner.nextInt();

                        if (row < 1 || row > 3 || column < 1 || column > 3) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else if (inputs[row - 1][column - 1] != ' ') {
                            System.out.println("This cell is occupied! Choose another one!");
                        } else {
                            if (isTurnOfX) {
                                inputs[row - 1][column - 1] = 'X';
                                isTurnOfX = false;
                            } else {
                                inputs[row - 1][column - 1] = 'O';
                                isTurnOfX = true;
                            }
                            break;
                        }
                    }
                }
            }

            System.out.println("---------");
            System.out.println("| " + inputs[0][0] + " " + inputs[0][1] + " " + inputs[0][2] + " |");
            System.out.println("| " + inputs[1][0] + " " + inputs[1][1] + " " + inputs[1][2] + " |");
            System.out.println("| " + inputs[2][0] + " " + inputs[2][1] + " " + inputs[2][2] + " |");
            System.out.println("---------");

            for (int i = 0; i < size; i++) {
                previous = ' ';
                for (int j = 0; j < size; j++) {
                    if (inputs[i][j] == ' ') {
                        break;
                    }

                    if (previous == ' ') {
                        previous = inputs[i][j];
                    } else if (inputs[i][j] != previous) {
                        break;
                    }

                    if (j == size - 1) {
                        if (previous == 'X') {
                            isX = true;
                        } else {
                            isO = true;
                        }
                    }
                }

                previous = ' ';
                for (int j = 0; j < size; j++) {
                    if (inputs[j][i] == ' ') {
                        break;
                    }

                    if (previous == ' ') {
                        previous = inputs[j][i];
                    } else if (inputs[j][i] != previous) {
                        break;
                    }

                    if (j == size - 1) {
                        if (previous == 'X') {
                            isX = true;
                        } else {
                            isO = true;
                        }
                    }
                }
            }

            previous = ' ';
            for (int i = 0; i < size; i++) {
                if (inputs[i][i] == ' ') {
                    break;
                }

                if (previous == ' ') {
                    previous = inputs[i][i];
                } else if (inputs[i][i] != previous) {
                    break;
                }

                if (i == size - 1) {
                    if (previous == 'X') {
                        isX = true;
                    } else {
                        isO = true;
                    }
                }
            }

            previous = ' ';
            for (int i = 0; i < size; i++) {
                if (inputs[i][Math.abs(i - 2)] == ' ') {
                    break;
                }

                if (previous == ' ') {
                    previous = inputs[i][Math.abs(i - 2)];
                } else if (inputs[i][Math.abs(i - 2)] != previous) {
                    break;
                }

                if (i == size - 1) {
                    if (previous == 'X') {
                        isX = true;
                    } else {
                        isO = true;
                    }
                }
            }

            countOfX = 0;
            countOfO = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (inputs[i][j] == ' ') {
                        isPlaying = true;
                    } else if (inputs[i][j] == 'X') {
                        countOfX++;
                    } else {
                        countOfO++;
                    }
                }
            }

            if (Math.abs(countOfX - countOfO) > 1 || (isX && isO)) {
                System.out.println("Impossible");
            } else if (!isX && !isO && !isPlaying) {
                System.out.println("Draw");
                break;
            } else if (isX && !isO) {
                System.out.println("X wins");
                break;
            } else if (!isX && isO) {
                System.out.println("O wins");
                break;
            } else {
                System.out.println("Game not finished");
            }
        }
    }
}

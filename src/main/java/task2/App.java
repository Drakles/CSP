package task2;

import task2.boardgame.FutoshikiSquareBoardGameImpl;
import task2.loader.Loader;


public class App {
    public static void main(String[] args) {

        FutoshikiSquareBoardGameImpl futoshikiBoardGame = Loader.scanFutoshikiBoard("resources/test_futo_4_0.txt");
        System.out.println(futoshikiBoardGame);
    }
}

package csp;

import csp.boardgame.FutoshikiBoardGame;
import csp.loader.Loader;


public class App {
    public static void main(String[] args) {

        FutoshikiBoardGame futoshikiBoardGame = Loader.scanFutoshikiBoard("resources/test_futo_4_0.txt");
        System.out.println(futoshikiBoardGame);
    }
}

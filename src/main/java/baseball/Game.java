package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Balls computerBalls;
    private GameStatus status;

    public Game(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    private void computerBallReset() {
        computerBalls = new Balls();
    }


    private void gameOver() {
        GameIO.gameRestartPrint();
        Command command = Command.findByCommand(Console.readLine());
        if (command.isEnd()) {
            status = GameStatus.END;
            return;
        }
        computerBallReset();
    }

    public void play() {
        status = GameStatus.PLAY;

        GameIO.gameStartPrint();
        while (status.isPlay()) {
            GameIO.gameInputPrint();

            Balls playerBalls = GameIO.scanGameBalls();
            boolean isMatching = computerBalls.match(playerBalls);

            if (isMatching) {
                gameOver();
            }
        }
    }
}

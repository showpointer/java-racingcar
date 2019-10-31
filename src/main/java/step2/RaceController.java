package step2;

import java.util.List;

public class RaceController {

    public static void main(String[] args) {
        String nameOfCars = InputView.getNameOfCars();
        int tryCount = InputView.getTryCount();

        RacingGame racingGame = new RacingGame(nameOfCars);

        ResultView.printStartMessage(racingGame.getCars().getCarNames());

        for (int i = 0; i < tryCount; i++) {
            ResultView.print(racingGame.move());
        }

        List<String> winners = racingGame.selectWinners();
        ResultView.printWinner(winners);
    }
}

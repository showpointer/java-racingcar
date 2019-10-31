package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private String nameOfCars = "pobi,crong,honux";
    private String[] carNames = {"pobi", "crong", "honux"};

    private RacingGame racingGame = new RacingGame(nameOfCars);

    @Test
    void splitCarNameInputTest() {
        assertThat(racingGame.splitCarNameInput(this.nameOfCars)).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void extractNumberOfCarsTest() {
        Cars cars = new Cars();
        cars.createCars(carNames);

        assertThat(cars.extractNumberOfCars()).isEqualTo(3);
    }

    @Test
    void generateRandomTest() {
        assertThat(racingGame.generateRandom()).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "4:4:5"}, delimiter = ':')
    void moveForwardTest(int random, int before, int after) {
        assertThat(racingGame.moveForward(random, before)).isEqualTo(after);
    }

    @Test
    void iterateCarMoveTest() {
        assertThat(racingGame.iterateCarMove(3)).isBetween(3, 4);
    }

    @Test
    void moveTest() {
        assertThat(racingGame.move().getCars()).hasSize(3);
        assertThat(racingGame.move().getCars().get(0).getPosition()).isLessThanOrEqualTo(racingGame.move().getCars().get(0).getPosition());
        assertThat(racingGame.move()).isInstanceOf(Cars.class);
    }
}

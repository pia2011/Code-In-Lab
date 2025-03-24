package stream.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stream.Dish;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchingTest {

    List<Dish> dishes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        dishes = Collections.unmodifiableList(Arrays.asList(
                Dish.of("바나나", 0),
                Dish.of("딸기", 200),
                Dish.of("사과", 300),
                Dish.of("포도", 400),
                Dish.of("오징어", 500),
                Dish.of("계란", 600)
        ));
    }

    @Test
    @DisplayName("프레디케이트가 주어진 스트림에서 적어도 한 요소와 일치하는지 확인한다.")
    void anyMatchTest() {
        boolean result = dishes.stream()
                .anyMatch(dish -> dish.getCalories() < 400);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("프레디케이트가 주어진 스트림의 모든 요소와 일치하는지 확인한다.")
    void allMatchTest() {
        boolean result = dishes.stream()
                .allMatch(dish -> dish.getCalories() < 400);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("프레디케이트가 주어진 스트림의 모든 요소와 일치하지 않는지 확인한다.")
    void noneMatchTest() {
        boolean result = dishes.stream()
                .noneMatch(dish -> dish.getCalories() > 600);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("현재 스트림에서 임의의 요소를 반환한다.")
    void findAnyTest() {
        Optional<Dish> result = dishes.stream()
                .filter(dish -> dish.getCalories() > 400)
                .findAny();

        assertThat(result).isPresent();
    }

    @Test
    @DisplayName("현재 스트림에서 첫번째 요소를 반환한다.")
    void findFirstTest() {
        Optional<Dish> result = dishes.stream()
                .filter(dish -> dish.getCalories() >= 400)
                .findFirst();

        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("포도");
    }

}

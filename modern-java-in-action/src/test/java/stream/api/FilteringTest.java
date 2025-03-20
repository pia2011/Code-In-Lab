package stream.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class FilteringTest {

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
    void 프레디케이트로_필터링() {
        // 프레디케이트는 Boolean 을 반환하는 함수를 인자로 받아서 이를 통해 filter 메서드는 프레디케이트와 일치하는 모든 요소를 포함하는 스트림을 반환한다.

        List<Dish> vegetarianMenu = dishes.stream()
                .filter(Dish::isVegetarian) // isVegetarian() 메서드는 프레디케이트와 일치하는 모든 요소 [ 칼로리가 0 인 요리 ] 를 포함하는 스트림을 반환한다.
                .collect(toList()); // 스트림 -> 리스트

        assertThat(vegetarianMenu.size()).isEqualTo(1);
    }

    @Test
    void 고유_요소_필터링() {
        // distinct 메서드는 스트림에서 고유 요소만 필터링한다.
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        List<Integer> uniqueNumbers = numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(toList());

        assertThat(uniqueNumbers.size()).isEqualTo(2);
    }

}

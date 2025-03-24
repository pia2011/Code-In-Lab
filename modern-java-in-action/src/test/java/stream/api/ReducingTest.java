package stream.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stream.Dish;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ReducingTest {

    List<Dish> dishes = new ArrayList<>();
    int sum = 0;

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

        List<Integer> its = dishes.stream()
                .map(Dish::getCalories)
                .collect(Collectors.toList());

        for(Integer it : its) {
            sum += it;
        };


    }

    @Test
    @DisplayName("모든 스트림 요소를 처리해서 값으로 도출하는 질의를 리듀싱 연산이라고 한다.")
    void reducingTest() {
        Integer result = dishes.stream()
                .map(Dish::getCalories)
                .reduce(0, (a, b) -> a + b);


        assertThat(result).isEqualTo(sum);
    }

    @Test
    void reducingTest2() {
        Optional<Integer> optionalResult = dishes.stream()
                .map(Dish::getCalories)
                .reduce(Integer::sum);

        Integer result = optionalResult.get();
        assertThat(result).isEqualTo(sum);
    }


}

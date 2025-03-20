package stream.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stream.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SlicingTest {

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
    void 칼로리_300_이하의_요리() {
        List<Dish> collect = dishes.stream()
                .filter(dish -> dish.getCalories() <= 200) // 200 이하만 담는다.
                .collect(Collectors.toList());
        
        assertThat(collect.size()).isEqualTo(2);
    }

    @Test
    void TAKEWHILE을_활용() {
        // 이미 리스트가 정렬이 되어 있다면 takeWhile 을 사용하여 탐색을 중단하는 것이 더 효율적이다.

        List<Dish> collect = dishes.stream()
                .takeWhile(dish -> dish.getCalories() <= 200) // 200 이하까지 담는다.
                .collect(Collectors.toList());

        assertThat(collect.size()).isEqualTo(2);
    }

    @Test
    void DROPWHILE을_활용() {
        // dropWhile 은 takeWhile 과 반대로 프레디케이트가 처음으로 거짓이 되는 지점까지 탐색된 요소를 버린다.

        List<Dish> collect = dishes.stream()
                .dropWhile(dish -> dish.getCalories() <= 200) // 200 이하의 요리는 버린다.
                .collect(Collectors.toList()); // 나머지를 반환한다.

        assertThat(collect.size()).isEqualTo(4);
    }

    @Test
    void N개_이하의_크기를_갖는_새로운_스트림을_반환한다() {
        List<Dish> collect = dishes.stream()
                .filter(dish -> dish.getCalories() <= 200) // 200 이하의 요리만 담는다.
                .limit(1) // 그 중 첫번째 요리만 담는다.
                .collect(Collectors.toList());

        assertThat(collect.get(0).getName()).isEqualTo("바나나");
        assertThat(collect.size()).isEqualTo(1);
    }

    @Test
    void 처음_N_개을_제외한_나머지_값을_반환한다() {
        List<Dish> collect = dishes.stream()
                .filter(dish -> dish.getCalories() <= 200) // 200 이하의 요리만 담는다. 탐색순서는 리스트의 순서대로 진행된다.
                .skip(1) // 그 중 첫번째 요리를 제외한 나머지 요리만 담는다.
                .collect(Collectors.toList());

        assertThat(collect.get(0).getName()).isEqualTo("딸기");
        assertThat(collect.size()).isEqualTo(1);
    }

}

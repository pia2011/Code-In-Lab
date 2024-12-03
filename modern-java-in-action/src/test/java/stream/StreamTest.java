package stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StreamTest {

    List<Dish> dishes = new ArrayList<>();

    @BeforeEach
    void setUp(){
        dishes = Collections.unmodifiableList(Arrays.asList(
                Dish.of("바나나", 100),
                Dish.of("딸기", 200),
                Dish.of("사과", 300),
                Dish.of("포도", 400),
                Dish.of("오징어", 500),
                Dish.of("계란", 600)
        ));
    }

    @Test
    void 스트림_예시() {

        List<String> lowCaloricDishesName = dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    @Test
    void 병렬_스트림_예시() {

        List<String> lowCaloricDishesName = dishes.parallelStream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    @Test
    void 스트림_처리_연산() {

        List<String> threeHighCaloricDishNames = dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .sorted(comparing(Dish::getCalories).reversed())
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());

        System.out.println(threeHighCaloricDishNames);
    }

    @Test
    void 컬렉션_인터페이스_for_each_외부_반복() {
        // 사용자가 직접 요소를 반복해야한다.
        List<Dish> todayMenus = new ArrayList<>();
        for (Dish dish: dishes) { // 명시적으로 순차 반복
            todayMenus.add(dish); // 추출해서 리스트에 추가
        }
    }

    @Test
    void 스트림_라이브러리는_내부_반복() {
        // 반복자가 필요없다.
        List<Dish> todayMenus = dishes.stream().toList();
    }


}

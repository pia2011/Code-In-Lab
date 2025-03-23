package stream.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stream.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MappingTest {

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
    void Mapping_test() {
        List<String> collect = dishes.stream()
                .map(Dish::getName)
                .collect(toList());
    }

    @Test
    void Mapping_test2() {
        List<String> words = Arrays.asList("Hello", "World");
        List<String[]> collect = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
    }

    @Test
    void Array_stream_test() {
        String[] words = {"Hello", "World"};
        List<Stream<String>> collect = Arrays.stream(words)
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
    }

    @Test
    @DisplayName("FlatMap 은 각 배열을 스트림이 아닌 개별 요소로 매핑하는 기능을 제공한다.")
    void Flat_mapping_test() {

        List<String> words = Arrays.asList("Hello", "World");
        List<String> collect = words.stream()
                .map(word -> word.split("")) // 각 단어를 개별 문자를 포함하는 배열로 변환
                .flatMap(Arrays::stream) // 생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .collect(toList());
    }
}

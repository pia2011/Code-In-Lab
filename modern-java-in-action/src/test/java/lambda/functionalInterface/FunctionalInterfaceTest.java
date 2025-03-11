package lambda.functionalInterface;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
// 250312
class FunctionalInterfaceTest {
    @Test
    void Predicate_함수는_T_객체를_받아_Boolean_을_반환할_때_사용한다() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> lessThanFivePredicate = (Integer num) -> num < 5; // 반환형 Boolean 타입, T 타입에 대한 Boolean 값 정의
        List<Integer> result = PredicateProcess.filter(integers, lessThanFivePredicate);
        Assertions.assertThat(result.size()).isEqualTo(4);
    }

    @Test
    void Consumer_함수는_T_객체를_받아_void_를_반환하며_동작을_수행한다() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        Consumer<Integer> printConsumer = num -> System.out.println(num); // 반환형 없음, T 타입에 대한 행위 정의
        ConsumerProcess.foreach(integers, printConsumer);
    }

    @Test
    void Function_함수는_T_객체를_인수로_받고_R_객체를_반환하며_입력_출력을_매핑할때_사용한다() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Function<Integer, Integer> plusFiveFunction = num -> num + 5; // 반환형 R, 인자 T : 객체 T 를 받아 반환형 R 로 반환하는 행위 정의
        List<Integer> map = FunctionProcess.map(list, plusFiveFunction);
        Assertions.assertThat(map.get(0)).isEqualTo(6);
        Assertions.assertThat(map.get(list.size() - 1)).isEqualTo(10);
    }
}
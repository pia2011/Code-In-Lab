package lambda;

import behavior_parameterization.Apple;
import behavior_parameterization.Color;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
// 250312
public class MethodReferenceTest {

    private List<Apple> apples = new ArrayList<>();

    @BeforeEach
    void setUp() {
        apples = Arrays.asList(
                Apple.of(Color.RED, 100),
                Apple.of(Color.GREEN, 50),
                Apple.of(Color.GREEN, 40),
                Apple.of(Color.BLACK, 20),
                Apple.of(Color.BLACK, 10)
        );
    }

    @Test
    void 정적_메서드_참조() {

        long freshAppleCount = apples.stream()
//                .filter(apple -> Apple.isFresh(apple))
                .filter(Apple::isFresh) // 메서드 참조
                .count();

        Assertions.assertThat(freshAppleCount).isEqualTo(3);
    }

    @Test
    void 인스턴스_메서드_참조() {
        List<Integer> nums = Arrays.asList(5, 2, 3, 1, 4);
//        nums.sort((num1, num2) -> num1.compareTo(num2));
        nums.sort(Integer::compareTo);
        Assertions.assertThat(nums.get(0)).isEqualTo(1);
    }

    @Test
    void Comparator_조합_comparing() {
//        apples.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
//        Comparator.comparing((Apple a) -> a.getWeight());
//        Function<Apple, Integer> f = (Apple apple) -> apple.getWeight();
        Comparator<Apple> appleComparator = Comparator.comparing(Apple::getWeight);
        apples.sort(appleComparator);
        Assertions.assertThat(apples.get(0).getWeight()).isEqualTo(10);
    }

    @Test
    void Comparator_조합_reversed() {
        apples.sort(Comparator.comparing(Apple::getWeight).reversed());
        Assertions.assertThat(apples.get(0).getWeight()).isEqualTo(100);
    }

    @Test
    void Predicate_조합_negate() {
        Predicate <Apple> isFresh = Apple::isFresh;
        Predicate <Apple> isNotFresh = isFresh.negate();

        long freshCount = apples.stream().filter(isFresh).count();
        long notFreshCount = apples.stream().filter(isNotFresh).count();

        Assertions.assertThat(freshCount).isEqualTo(3);
        Assertions.assertThat(notFreshCount).isEqualTo(2);
    }

    @Test
    void Predicate_조합_or() {
        Predicate<Apple> isFresh = Apple::isFresh;
        Predicate<Apple> isFreshOrHeavy = isFresh.or(Apple::isHeavy);
        long count = apples.stream().filter(isFreshOrHeavy).count();

        Assertions.assertThat(count).isEqualTo(3);
    }
}

package lambda.avoidautoboxing;

import lambda.functionalInterface.IntPredicate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class AvoidAutoBoxingTest {

    @Test
    void 오토박싱이_일어나는_예시() {
        Predicate<Integer> evenNum = (Integer num) -> num % 2 == 0;
        boolean flag = evenNum.test(2);
        Assertions.assertThat(flag).isTrue();
    }

    @Test
    void 오토박싱이_일어나지_않는_예시_기본형_특화_함수형_인터페이스_활용() {
        IntPredicate evenNum = (int num) -> num % 2 == 0;
        boolean flag = evenNum.test(2);
        Assertions.assertThat(flag).isTrue();
    }
}

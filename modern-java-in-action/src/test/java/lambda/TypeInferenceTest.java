package lambda;

import behavior_parameterization.Apple;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
// 250312
public class TypeInferenceTest {

    @Test
    void 타입_추론_사용하지_않는_경우() {
        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
    }

    @Test
    void 타입_추론_사용하는_경우() {
        Comparator<Apple> c = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
    }
}

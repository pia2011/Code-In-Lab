package behavior_parameterization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 250312
@DisplayName("동작 파라미터화 테스트")
public class BehaviorParameterizationTest {

    List<Apple> appleList = Collections.emptyList();

    @BeforeEach
    void setUp(){
        appleList = Collections.unmodifiableList(Arrays.asList(
                Apple.of(Color.RED, 400),
                Apple.of(Color.RED, 600),
                Apple.of(Color.GREEN, 400),
                Apple.of(Color.GREEN, 600)
        ));
    }

    @Test
    void 익명클래스를_이용한_동작_파라미터화(){
        List<Apple> apples = AppleCollector.filterApples(appleList, new ApplePredicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == Color.GREEN;
            }
        });

        Assertions.assertEquals(apples.size(), 2);
    }

    @Test
    void 람다식을_이용한_동작_파라미터화(){
        List<Apple> apples = AppleCollector.filterApples(appleList, (Apple apple) -> apple.getColor() == Color.GREEN);
        Assertions.assertEquals(apples.size(), 2);
    }

}

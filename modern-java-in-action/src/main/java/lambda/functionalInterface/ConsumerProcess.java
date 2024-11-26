package lambda.functionalInterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerProcess {
    public static <T> void foreach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}

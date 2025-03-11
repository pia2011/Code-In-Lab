package lambda;

import java.io.BufferedReader;
import java.io.IOException;
// 250312
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}

package lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
// 250312
public class ExecuteAroundPatternTest {

    @Test
    void 실행_어라운드_패턴_테스트() throws IOException {
        String s = FileProcessor.processFile((BufferedReader br) -> br.readLine());
        Assertions.assertEquals("모던", s);
    }

    @Test
    void 실행_어라운드_패턴_테스트2() throws IOException {
        String s = FileProcessor.processFile((BufferedReader br) -> br.readLine() + br.readLine());
        Assertions.assertEquals("모던자바", s);
    }
}

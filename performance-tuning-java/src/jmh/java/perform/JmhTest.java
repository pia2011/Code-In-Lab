package perform;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JmhTest {

    private static String str = "A";

    @Benchmark
    public String getByString(){
        String result = str;
        for(int i = 0; i<10000; i++){
            result += str;
        }
        return result;
    }

    @Benchmark
    public String getByStringBuffer(){
        StringBuffer result = new StringBuffer(str);
        for(int i = 0; i<10000; i++){
            result.append(str);
        }
        return result.toString();
    }

    @Benchmark
    public String getStringBuilder(){
        StringBuilder result = new StringBuilder("A");
        for(int i = 0; i<10000; i++){
            result.append(str);
        }
        return result.toString();
    }

}

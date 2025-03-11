package lambda;

import java.io.*;
// 250312
public class FileProcessor {
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        InputStream fileResourceAsStream = FileProcessor.class.getClassLoader().getResourceAsStream("data.txt");
        try(BufferedReader br = new BufferedReader(new InputStreamReader(fileResourceAsStream))) {
            return bufferedReaderProcessor.process(br);
        }
    }
}

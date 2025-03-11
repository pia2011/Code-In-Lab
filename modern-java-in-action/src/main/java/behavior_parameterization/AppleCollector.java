package behavior_parameterization;

import java.util.ArrayList;
import java.util.List;
// 250312
public class AppleCollector {

    public static <T> List<T> filterApples(List<T> list, ApplePredicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }
}

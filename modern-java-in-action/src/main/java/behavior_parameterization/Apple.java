package behavior_parameterization;

import lombok.Getter;

import java.util.Set;

@Getter
public class Apple {

    private static Set<Color> freshColors = Set.of(Color.GREEN, Color.RED);
    private static int standardHeavyWeight = 50;

    private Color color;
    private Integer weight;

    private Apple(){}

    private Apple(Color color, Integer weight){
        this.color = color;
        this.weight = weight;
    }

    public static Apple of(Color color, Integer weight){
        return new Apple(color, weight);
    }

    public static boolean isFresh(Apple apple){
        return freshColors.contains(apple.color);
    }

    public static boolean isHeavy(Apple apple) {
        return standardHeavyWeight < apple.getWeight();
    }
}

package behavior_parameterization;

import lombok.Getter;

@Getter
public class Apple {

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
}

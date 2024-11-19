package behavior_parameterization;

public class Banana {

    private Color color;
    private Integer weight;

    private Banana(){}

    private Banana(Color color, Integer weight){
        this.color = color;
        this.weight = weight;
    }

    public static Banana of(Color color, Integer weight){
        return new Banana(color, weight);
    }
}

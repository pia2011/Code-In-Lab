package stream;

import lombok.Getter;

@Getter
public class Dish {

    private String name;
    private int calories;

    private Dish(String name, int calories){
        this.name = name;
        this.calories = calories;
    }
    public static Dish of (String name, int calories){
        return new Dish(name, calories);
    }

}

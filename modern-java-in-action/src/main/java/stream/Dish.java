package stream;

import lombok.Getter;
// 250317
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

    public boolean isVegetarian(){
        return this.calories == 0;
    }

}

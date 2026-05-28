package com.pluralsight.models;



public class PizzaTopping<T> {
    private T topping;
    private boolean extra;

    public PizzaTopping(T topping, boolean extra){
        this.topping = topping;
        this.extra = extra;
    }

    public T getTopping(){
        return topping;
    }

    public boolean isExtra(){
        return extra;
    }

}

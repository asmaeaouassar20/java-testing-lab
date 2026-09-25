package org.algostyle;

import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private int age;
    public static final List<String> acceptedColors = Arrays.asList("RED","GREEN");

    public Player(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    @Override
    public boolean equals(Object obj){
        Player player = (Player) obj;
        return this.name.equals(player.name);
    }

    public static int validateStartingRuleGame(String color, int cardNumber){
        if(colorIsAccepted(color) && cardNumberIsValid(cardNumber)){
            return cardNumber;
        }
        return -1;
    }

    public static boolean colorIsAccepted(String color){
        if(!acceptedColors.contains(color)){
            throw new IllegalArgumentException("Color "+color + " not within accepted colors");
        }
        return true;
    }
    private static boolean cardNumberIsValid(int cardNumber){
        if(cardNumber < 0){
            throw new InvalidCardNumber("cardNumber must be greater than 0");
        }
        return true;
    }

    public boolean isMajor(){
        return age>18;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Asus
 */
public class Boyfriend extends Info {

    String name;
    int fun, attention, food, sleep;

    public Boyfriend(String s, String t, String p, String n, int f, int a, int fo, int sl) {
        super(s,t,p);

        this.name = n;
        this.fun = f;
        this.attention = a;
        this.food = fo;
        this.sleep = sl;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setFun(int f) {
        this.fun = f;
    }

    public int getFun() {
        return fun;
    }

    public void setFood(int f) {
        this.food = f;
    }

    public int getFood() {
        return food;
    }

    public void setSleep(int s) {
        this.sleep = s;
    }

    public int getSleep() {
        return sleep;
    }

    public void setAttenction(int a) {
        this.attention = a;
    }

    public int getAttention() {
        return attention;
    }

}

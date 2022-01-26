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
abstract public class Info implements PocketBoyfriend {

    protected String shirt,theme, position;

    public Info(String s,String t, String p) {
        this.shirt = s;
        this.theme = t;
        this.position = p;
    }

    @Override
    public void setShirt(String s) {
        this.shirt = s;
    }

    @Override
    public String getShirt() {
        return shirt;
    }

    @Override
    public void setTheme(String t) {
        this.theme = t;
    }

    @Override
    public String getTheme() {
        return theme;
    }
    
    @Override
    public String getPosition(){
        return position;
    }
    
    @Override
    public void setPosition(String p){
        this.position = p;
    }

}

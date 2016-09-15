package mawashi.alex.mvpsimpleformat.Model;

/**
 * Created by alessandro.argentier on 15/09/2016.
 */
public class Model {
    private String name;
    private String number;

    public Model(){

    }

    public Model(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setNumber(String number){
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }



}

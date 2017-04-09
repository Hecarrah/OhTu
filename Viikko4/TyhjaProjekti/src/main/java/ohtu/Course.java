/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author Peter
 */
public class Course {
    private String name;
    private String term;
    private int week1;
    private int week2;
    private int week3;
    private int week4;
    private int week5;
    private int week6;
    private int week7;
    
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return name;
    }
    public void setTerm(String n){
        this.term = n;
    }
    public String getTerm(){
        return term;
    }
    
    public void setWeek1(int n){
        this.week1 = n;
    }
    public Integer getWeek1(){
        return week1;
    }
    public void setWeek2(int n){
        this.week2 = n;
    }
    public Integer getWeek2(){
        return week2;
    }
    public void setWeek3(int n){
        this.week3 = n;
    }
    public Integer getWeek3(){
        return week3;
    }
    public void setWeek4(int n){
        this.week4 = n;
    }
    public Integer getWeek4(){
        return week4;
    }
    public void setWeek5(int n){
        this.week5 = n;
    }
    public Integer getWeek5(){
        return week5;
    }
    public void setWeek6(int n){
        this.week6 = n;
    }
    public Integer getWeek6(){
        return week6;
    }
    public void setWeek7(int n){
        this.week7 = n;
    }
    public Integer getWeek7(){
        return week7;
    }
    @Override
    public String toString(){
        return "Kurssin nimi: "+name+", "+term;
    }
}

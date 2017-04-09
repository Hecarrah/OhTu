package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.fluent.Request;

public class Submission {
    private String student_number;
    private Integer week;
    private String hours;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private String url = "https://ohtustats2017.herokuapp.com/courses/1.json";
    private String bodyText;
    private Gson mapper;
    private Course course;
    
    private ArrayList<Integer> al = new ArrayList();
    
    public Submission() throws IOException {
        bodyText = Request.Get(url).execute().returnContent().asString();
        mapper = new Gson();
        course = mapper.fromJson(bodyText, Course.class);
    }
    
    public String getStudent_number() {
        return student_number;
    }
    public Integer getWeek(){
        return week;
    }
    public void setWeek(Integer w){
        week = w;
    }
    public String getHours(){
        return hours;
    }
    public void setHours(String h){
        hours = h;
    }
    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    
    
    public void setA1(boolean a){
            a1 = a;
    }
    public boolean getA1(){
        if(a1){
            al.add(1);
        }return a1;
    }
    public void setA2(boolean a){
            a2 = a;
    }
    public boolean getA2(){
        if(a2){
            al.add(2);
        }return a2;
    }
    public void setA3(boolean a){
            a3 = a;
    }
    public boolean getA3(){
        if(a3){
            al.add(3);
        }return a3;
    }
    public void setA4(boolean a){
            a4 = a;
    }
    public boolean getA4(){
        if(a4){
            al.add(4);
        }return a4;
    }
    public void setA5(boolean a){
            a4 = a;
    }
    public boolean getA5(){
        if(a5){
            al.add(5);
        }return a5;
    }
    public void setA6(boolean a){
            a6 = a;
    }
    public boolean getA6(){
        if(a6){
            al.add(6);
        }return a6;
    }
    public void setA7(boolean a){
            a7 = a;
    }
    public boolean getA7(){
        if(a7){
            al.add(7);
        }return a7;
    }
    public void setA8(boolean a){
            a8 = a;
    }
    public boolean getA8(){
        if(a8){
            al.add(8);
        }return a8;
    }
    public void setA9(boolean a){
            a9 = a;
    }
    public boolean getA9(){
        if(a9){
            al.add(9);
        }return a9;
    }
    public void setA10(boolean a){
            a10 = a;
    }
    public boolean getA10(){
        if(a10){
            al.add(10);
        }return a10;
    }
    public void setA11(boolean a){
            a11 = a;
    }
    public boolean getA11(){
        if(a11){
            al.add(11);
        }return a11;
    }
    public void setA12(boolean a){
            a12 = a;
    }
    public boolean getA12(){
        if(a12){
            al.add(12);
        }return a12;
    }
    public Integer week(){
        return week;
    }
    public String maxTehtavat(Integer week){
        if(week == 1){
            return course.getWeek1().toString();
        }else if(week == 2){
            return course.getWeek2().toString();
        }else if(week == 3){
            return course.getWeek3().toString();
        }else if(week == 4){
            return course.getWeek4().toString();
        }else if(week == 5){
            return course.getWeek5().toString();
        }else if(week == 6){
            return course.getWeek6().toString();
        }else if(week == 7){
            return course.getWeek7().toString();
        }return "";
        
    }

    @Override
    public String toString() {
        getA1();
        getA2();
        getA3();
        getA4();
        getA5();
        getA6();
        getA7();
        getA8();
        getA9();
        getA10();
        getA11();
        getA12();
        
        return course+"\n"+student_number+": "+" Viikko "+week+", Tunteja: "+hours+", Tehtävät: "+al.toString()+"( max: "+maxTehtavat(week())+" )";
    }
    
}
package statistics;

import statistics.matcher.*;

public class QueryBuilder{
    //private ArrayList<Matcher> al = new ArrayList<Matcher>();
    private Matcher matcher;
    
    public QueryBuilder(){
        this.matcher = new And();
    }
    public Matcher build(){
        Matcher b = this.matcher;
        this.matcher = new And();
        return b;
    }
    public QueryBuilder oneOf(Matcher...matchers){
        this.matcher = new Or(matchers);
        return this;
    }
    public QueryBuilder playsIn(String t){
        this.matcher = new And(this.matcher, new PlaysIn(t));
        return this;
    }
    public QueryBuilder hasAtLeast(int num, String type){
        this.matcher = new And(this.matcher, new HasAtLeast(num,type));
        return this;
    }
    public QueryBuilder hasFewerThan(int num, String type){
        this.matcher = new And(this.matcher, new HasFewerThan(num,type));
        return this;
    }
}

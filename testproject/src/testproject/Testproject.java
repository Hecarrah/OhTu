/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testproject;

/**
 *
 * @author Peter
 */
public class Testproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = "test ä";
        input = input.replaceAll("ä", "{\\\\\"a}");
        System.out.println(input);
    }
    
}

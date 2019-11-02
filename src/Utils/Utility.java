/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author luca lorenzo guerrin
 */
public class Utility {

    public static boolean isNumeric(String str) {
        boolean ok = false;
        try{
        Double.parseDouble(str);
        ok=true;
        }
        catch (Exception e) {
        }
        return ok;
    }
}

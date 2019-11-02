package GUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Billones
 */
public class Mymain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set default frame
        /**
         * shortcut to Dashboard d = new Dashboard(); d.setVisible(true);
         */
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss EEEE");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);
        new Dashboard().setVisible(true);
        /*
         * Author: Nethons Pal
         * URL: www.webprogs.com
         */
    }

}

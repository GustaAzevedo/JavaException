package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Chek-in date (dd/mm/yyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Chek-out date (dd/mm/yyy): ");
        Date checkout = sdf.parse(sc.next());

        // Method check if the first date comes after the other
        if(!checkout.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after checkin date");
        }
        else{
            Reservation reservation = new Reservation(number, checkin, checkout);
            System.out.println("Reservation " + reservation.toString());

            System.out.println("Enter data to update the Reservation");
            System.out.print("Chek-in date (dd/mm/yyy): ");
            Date checkin2 = sdf.parse(sc.next());
            System.out.print("Chek-out date (dd/mm/yyy): ");
            Date checkout2 = sdf.parse(sc.next());

            Date now = new Date();
            if(checkin2.before(now) || checkout2.before(now)){
                System.out.println("Error in reservation: Reservation dates must be future");
            }
            else if(!checkout.after(checkin2)){
                System.out.println("Error in reservation: Check-out date must be after checkin date");
            }
            else {
                reservation.updateDates(checkin2, checkout2);
                System.out.println(reservation.toString());
            }
        }


        sc.close();

    }
}

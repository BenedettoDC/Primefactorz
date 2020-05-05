package fahrkartenautomat;


import java.util.Locale;
import java.util.Scanner;

public class TicketVendorApplication {
//in die main Automat und eine Instanz von UI las Listener registrieren (a.addListener(myUI))

    public static void main(String[] args){


        Automat a = new Automat(1);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bitte wählen Sie ihre gewünschte Ziel-Zone aus :");

        int userInput = scanner.nextInt();

        if(userInput > 4 || userInput < 1){
            System.out.println("Bitte geben Sie eine gültige Zone ein!");
        }
        else a.calculatePrice(userInput);

        System.out.println("Der zu zahlende Betrag liegt bei " + (double)a.calculatePrice(1) / 100 + " Euro.");
    }



}

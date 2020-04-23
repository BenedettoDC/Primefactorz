package fahrkartenautomat;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Automat {

    private int position;
    private int pricePerZone = 230;
    private int currentPrice;
    private int priceToPay;

    public Automat(int position) {
        this.position = position;
    }

    // TODO MJ: in eigene Klasse, die die Initialisierung vom Automaten vornimmt und die Bespielung via Konsole ermöglicht.
    public static void main(String[] args) {

    }

    public int calculatePrice(int destinationZone) {
        currentPrice = pricePerZone * (Math.abs(destinationZone - position) + 1);
        priceToPay = currentPrice;
        return currentPrice;
    }

    public int missingMoney(Money userMoneyInput) {
        priceToPay = priceToPay - userMoneyInput.getMoneyValue();
        if (priceToPay <= 0){
         printTicket();
         if(priceToPay < 0){
             returnMoney();
         }
        }
        return priceToPay;
    }

    private void returnMoney() {
        //Notes
        int modHundredEuro = abs(priceToPay) % Money.HUNDRED_EURO.getMoneyValue();
        int modFiftyEuro = modHundredEuro % Money.FIFTY_EURO.getMoneyValue();
        int modTwentyEuro = modHundredEuro % Money.TWENTY_EURO.getMoneyValue();
        int modTenEuro = modHundredEuro % Money.TEN_EURO.getMoneyValue();
        int modFiveEuro = modHundredEuro % Money.TEN_EURO.getMoneyValue();
        //Coins
        int modTwoEuro = modHundredEuro % Money.TWO_EURO.getMoneyValue();
        int modOneEuro = modHundredEuro % Money.ONE_EURO.getMoneyValue();
        int modFiftyCent = modHundredEuro % Money.FIFTY_CENT.getMoneyValue();
        int modTwentyCent = modHundredEuro % Money.TWENTY_CENT.getMoneyValue();
        int modTenCent = modHundredEuro % Money.TEN_CENT.getMoneyValue();
        int modFiveCent = modHundredEuro % Money.FIVE_CENT.getMoneyValue();
        int modTwoCent = modHundredEuro % Money.TWO_CENT.getMoneyValue();
        int modOneCent = modHundredEuro % Money.ONE_CENT.getMoneyValue();

        //Notes
        int numHundredEuro = (int)((abs(priceToPay) - modHundredEuro) / (10000));
        int numFiftyEuro = (int)((abs(modHundredEuro) - modFiftyEuro) / (5000));
        int numTwentyEuro = (int)((abs(modFiftyEuro) - modTwentyEuro) / (2000));
        int numTenEuro = (int)((abs(modTwentyEuro) - modTenEuro) / (1000));
        int numFiveEuro = (int)((abs(modTwentyEuro) - modFiveEuro) / (500));
        //Coins
        int numTwoEuro = (int)((abs(modFiveEuro) - modTwoEuro) / (200));
        int numOneEuro = (int)((abs(modTwoEuro) - modOneEuro) / (100));
        int numFiftyCent = (int)((abs(modOneEuro) - modFiftyCent) / (50));
        int numTwentyCent = (int)((abs(modFiftyCent) - modTwentyCent) / (20));
        int numTenCent = (int)((abs(modTwentyCent) - modTenCent) / (10));
        int numFiveCent = (int)((abs(modTenCent) - modFiveCent) / (5));
        int numTwoCent = (int)((abs(modFiveCent) - modTwoCent) / (2));
        int numOneCent = (int)((abs(modTwoCent) - modOneCent) / (1));

        System.out.println("Your change is in total " + abs(priceToPay) + " Euro/s. You recieve :");
        if(numHundredEuro >= 1){
            System.out.println(numHundredEuro + " 100-Euro-Note/s");
        }
        if(numFiftyEuro >= 1){
            System.out.println(numFiftyEuro + " 50-Euro-Note/s");
        }
        if(numTwentyEuro >= 1){
            System.out.println(numTwentyEuro + " 20-Euro-Note/s");
        }
        if(numTenEuro >= 1){
            System.out.println(numTenEuro + " 10-Euro-Note/s");
        }
        if(numFiveEuro >= 1){
            System.out.println(numFiveEuro + " 5-Euro-Note/s");
        }
        if(numTwoEuro >= 1){
            System.out.println(numTwoEuro + " 2-Euro-Note/s");
        }
        if(numOneEuro >= 1){
            System.out.println(numOneEuro + " 1-Euro-Note/s");
        }
        if(numFiftyCent >= 1){
            System.out.println(numFiftyCent + " 50-Euro-Note/s");
        }
        if(numTwentyCent >= 1){
            System.out.println(numTwentyCent + " 20-Euro-Note/s");
        }
        if(numTenCent >= 1){
            System.out.println(numTenCent + " 10-Euro-Note/s");
        }
        if(numFiveCent >= 1){
            System.out.println(numFiveCent + " 5-Euro-Note/s");
        }
        if(numTwoCent >= 1) {
            System.out.println(numTwoCent + " 2-Euro-Note/s");
        }
        if(numOneCent >= 1){
            System.out.println(numOneCent + " 1-Euro-Note/s");
        }

    }

    private void printTicket() {
        System.out.println("printing Ticket...");
    }

    private void cancel(int c){
        if (c == 1){
            returnMoney();
            c = 0;
        }
        else if(c == 2) {
            //return to main-screen
            c = 0;
        }
    }

}

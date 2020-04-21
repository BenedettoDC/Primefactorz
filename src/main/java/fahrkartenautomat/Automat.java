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

    public static void main(String[] args) {

    }

    public int calculatePrice(int destinationZone) {
        currentPrice = pricePerZone * (Math.abs(destinationZone - position) + 1);
        priceToPay = currentPrice;
        return currentPrice;
    }

    public int missingMoney(Coin userinput) {
        priceToPay = priceToPay - userinput.getCoinValue();
        if (priceToPay <= 0){
         printTicket();
         if(priceToPay < 0){
             returnMoney();
         }
        }
        return priceToPay;
    }

    private void returnMoney() {
        int modTwoEuro = abs(priceToPay) % Coin.TWO_EURO.getCoinValue();
        int modOneEuro = modTwoEuro % Coin.ONE_EURO.getCoinValue();
        int modFiftyCent = modTwoEuro % Coin.FIFTY_CENT.getCoinValue();
        int modTwentyCent = modTwoEuro % Coin.TWENTY_CENT.getCoinValue();
        int modTenCent = modTwoEuro % Coin.TEN_CENT.getCoinValue();
        int modFiveCent = modTwoEuro % Coin.FIVE_CENT.getCoinValue();
        int modTwoCent = modTwoEuro % Coin.TWO_CENT.getCoinValue();
        int modOneCent = modTwoEuro % Coin.ONE_CENT.getCoinValue();

        int numTwoEuro = (int)((abs(priceToPay) - modTwoEuro) / (200));
        int numOneEuro = (int)((abs(modTwoEuro) - modOneEuro) / (100));
        int numFiftyCent = (int)((abs(modOneEuro) - modFiftyCent) / (50));
        int numTwentyCent = (int)((abs(modFiftyCent) - modTwentyCent) / (20));
        int numTenCent = (int)((abs(modTwentyCent) - modTenCent) / (10));
        int numFiveCent = (int)((abs(modTenCent) - modFiveCent) / (5));
        int numTwoCent = (int)((abs(modFiveCent) - modTwoCent) / (2));
        int numOneCent = (int)((abs(modTwoCent) - modOneCent) / (1));

        System.out.println("Your change is in total " + abs(priceToPay) + " Euro/s. You  recieve :" +"\n"+ numTwoEuro +" 2-Euro-Coins, ");
        System.out.println(numOneEuro + " 1-Euro-Coins,");
        System.out.println(numFiftyCent + " Fifty-Cent-Coins,");
        System.out.println(numTwentyCent + " Twenty-Cent-Coins");
        System.out.println(numTenCent + " Ten-Cent-Coins,");
        System.out.println(numFiveCent + " Five-Cent-Coins,");
        System.out.println(numTwoCent + " Two-Cent-Coins,");
        System.out.println(numOneCent + " One-Cent-Coins.");
    }

    private void printTicket() {
        System.out.println("printing Ticket...");
    }

}

package fahrkartenautomat;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;
import static java.lang.Math.round;

public class Automat {

    private int position;
    private int pricePerZone = 230;
    private int currentPrice;
    private int remainingPrice;
    private List<AutomatListener> listeners;
    private Map<Money, Integer> change;


    public Automat(int position) {
        this.position = position;
        this.listeners = new ArrayList<>();
        this.change = new HashMap<>();
    }


    // TODO MJ: in eigene Klasse, die die Initialisierung vom Automaten vornimmt und die Bespielung via Konsole ermöglicht.
    public static void main(String[] args) {

    }


    public int calculatePrice(int destinationZone) {
        currentPrice = pricePerZone * (Math.abs(destinationZone - position) + 1);
        remainingPrice = currentPrice;
        return currentPrice;
    }

    public int missingMoney(Money userMoneyInput) {
        remainingPrice = remainingPrice - userMoneyInput.getMoneyValue();
        if (remainingPrice <= 0) {
            printTicket();
            if (remainingPrice < 0) {
                for (AutomatListener listener : listeners) {
                    listener.paymentComplete();

                }
            }
        }
        else {
            for (AutomatListener listener : listeners) {
                listener.remainingMoneyChanged(remainingPrice);
            }
        }
        return remainingPrice;
    }

    void addListener(AutomatListener listener) {
        listeners.add(listener);
    } //Wofür steht der Code hier ?

    public void calculateChange() {
        //Notes
        int modHundredEuro = abs(remainingPrice) % Money.HUNDRED_EURO.getMoneyValue(); //Auf alle übertragen
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
        int numHundredEuro = (int) ((abs(remainingPrice) - modHundredEuro) / (10000));
        int numFiftyEuro = (int) ((abs(modHundredEuro) - modFiftyEuro) / (5000));
        int numTwentyEuro = (int) ((abs(modFiftyEuro) - modTwentyEuro) / (2000));
        int numTenEuro = (int) ((abs(modTwentyEuro) - modTenEuro) / (1000));
        int numFiveEuro = (int) ((abs(modTwentyEuro) - modFiveEuro) / (500));
        //Coins
        int numTwoEuro = (int) ((abs(modFiveEuro) - modTwoEuro) / (200));
        int numOneEuro = (int) ((abs(modTwoEuro) - modOneEuro) / (100));
        int numFiftyCent = (int) ((abs(modOneEuro) - modFiftyCent) / (50));
        int numTwentyCent = (int) ((abs(modFiftyCent) - modTwentyCent) / (20));
        int numTenCent = (int) ((abs(modTwentyCent) - modTenCent) / (10));
        int numFiveCent = (int) ((abs(modTenCent) - modFiveCent) / (5));
        int numTwoCent = (int) ((abs(modFiveCent) - modTwoCent) / (2));
        int numOneCent = (int) ((abs(modTwoCent) - modOneCent) / (1));


        //System.out.println("Your change is in total " + (double)abs(priceToPay) / 100 + " Euro/s. You recieve :");
        if (numHundredEuro >= 1) {
            // System.out.println(numHundredEuro + " 100-Euro-Note/s");
            change.put(Money.HUNDRED_EURO, numHundredEuro);
        }
        if (numFiftyEuro >= 1) {
            change.put(Money.FIFTY_EURO, numFiftyEuro);
        }
        if (numTwentyEuro >= 1) {
            change.put(Money.TWENTY_EURO, numTwentyEuro);
        }
        if (numTenEuro >= 1) {
            change.put(Money.TEN_EURO, numTenEuro);
        }
        if (numFiveEuro >= 1) {
            change.put(Money.FIVE_EURO, numFiveEuro);
        }
        if (numTwoEuro >= 1) {
            change.put(Money.TWO_EURO, numTwoEuro);
        }
        if (numOneEuro >= 1) {
            change.put(Money.ONE_EURO, numOneEuro);
        }
        if (numFiftyCent >= 1) {
            change.put(Money.FIFTY_CENT, numFiftyCent);
        }
        if (numTwentyCent >= 1) {
            change.put(Money.TWENTY_CENT, numTwentyCent);
        }
        if (numTenCent >= 1) {
            change.put(Money.TEN_CENT, numTenCent);
        }
        if (numFiveCent >= 1) {
            change.put(Money.FIVE_CENT, numFiveCent);
        }
        if (numTwoCent >= 1) {
            change.put(Money.TWO_CENT, numTwoCent);
        }
        if (numOneCent >= 1) {
            change.put(Money.ONE_CENT, numOneCent);
        }

    }

    private void printTicket() {
        System.out.println("printing Ticket...");
    }

    /*private void cancel(int c) {  //ähnlich implementieren wie missingMoney
        if (c == 1) {
            returnMoney();
            c = 0;
        } else if (c == 2) {
            //return to main-screen
            c = 0;
        }
    }
    /*public int missingMoney(Money userMoneyInput) {
        remainingPrice = remainingPrice - userMoneyInput.getMoneyValue();
        if (remainingPrice <= 0) {
            printTicket();
            if (remainingPrice < 0) {
                for (AutomatListener listener : listeners) {
                    listener.paymentComplete();*/

    public Map<Money, Integer> getChange() {
        return change;
    }
}



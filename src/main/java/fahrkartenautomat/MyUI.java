package fahrkartenautomat;

import java.util.Map;

public class MyUI implements AutomatListener{

    Automat a;
    MyUI(Automat automat){
        a = automat;
    }


    @Override
    public void remainingMoneyChanged(int remainingMoney) {

    }

    public void paymentComplete(){
        Map<Money, Integer> change = a.getChange();
        for (Money money : change.keySet()) {
            System.out.println("Münzwert : " + money.getDisplayName() + "Anzahl: " + change.get(money));
        }
    }

    public void userHasCancelled(){
        Map<Money, Integer> change = a.getChange();
        for (Money money : change.keySet()) {
            System.out.println("Münzwert : " + money.getDisplayName() + "Anzahl: " + change.get(money));
        }
    }
}

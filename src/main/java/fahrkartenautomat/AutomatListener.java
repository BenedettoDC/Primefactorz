package fahrkartenautomat;

public interface AutomatListener {
    void remainingMoneyChanged(int remainingMoney);
    void paymentComplete();
    void userHasCancelled();
    }

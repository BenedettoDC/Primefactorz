package fahrkartenautomat;

public enum Money {
    ONE_CENT(1, "five-eurocent-coin/s"),
    TWO_CENT(2, "two-eurocent-coin/s"),
    FIVE_CENT(5, "five-eurocent-coin/s"),
    TEN_CENT(10, "ten-eurocent-coin/s"),
    TWENTY_CENT(20, "twenty-eurocent-coin/s"),
    FIFTY_CENT(50, "fifty-eurocent-coin/s"),
    ONE_EURO(100, "one-euro-coin/s"),
    TWO_EURO(200, "two-euro-coin/s"),
    FIVE_EURO(500, "five-euro-note/s"),
    TEN_EURO(1000, "ten-euro-note/s"),
    TWENTY_EURO(2000, "twenty-euro-note/s"),
    FIFTY_EURO(5000, "fifty-euro-note/s"),
    HUNDRED_EURO(10000, "hundred-euro-note/s");


    private int coinValue;

    private Money(int value, String name){
    coinValue = value;
    }

    public int getMoneyValue(){
        return coinValue;
    }

}

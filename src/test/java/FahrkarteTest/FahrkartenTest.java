package FahrkarteTest;

import fahrkartenautomat.Coin;
import org.junit.Test;
import fahrkartenautomat.Automat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;


public class FahrkartenTest {

    @Test
    public void testPriceCalculator() {
        Automat a = new Automat(1);
        assertThat(a.calculatePrice(1), is(230));
        a = new Automat(2);
        assertThat(a.calculatePrice(2), is(230));
        a = new Automat(1);
        assertThat(a.calculatePrice(4), is(920));
    }

    @Test
    public void testRemainingMoney(){
        Automat a = new Automat(1);
        a.calculatePrice(1);
        a.missingMoney(Coin.FIFTY_CENT);
        a.missingMoney(Coin.TWENTY_CENT);
        int remainingMoney = a.missingMoney(Coin.TWO_EURO);
        assertEquals(-40,remainingMoney);
    }
}

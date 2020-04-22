package FahrkarteTest;

import fahrkartenautomat.Coin;
import fahrkartenautomat.Note;
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
        a.noteCounting(Note.FIVE_EURO);
        a.noteCounting(Note.HUNDRED_EURO);
        a.missingMoney(Coin.TEN_CENT);
        int remainingMoney = a.missingMoney(Coin.TWENTY_CENT);
        assertEquals(-10300,remainingMoney);
    }
}

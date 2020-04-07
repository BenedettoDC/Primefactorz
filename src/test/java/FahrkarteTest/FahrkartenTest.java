package FahrkarteTest;

        import org.junit.Test;
        import fahrkartenautomat.Automat;

        import java.util.ArrayList;
        import java.util.List;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.CoreMatchers.is;


public class FahrkartenTest {

    @Test
    public void fkTest(){
        Automat a = new Automat();
        a.setPosition(1);
        assertThat(a.getPosition(), is(1));
        assertThat(a.calculatePrice(1), is(2.3));
        assertThat(a.calculatePrice(2), is(4.6));
        a.setPosition(5);
        assertThat(a.calculatePrice(1), is(11.5));
        a.setPosition(1);
        assertThat(a.getPosition(), is (1));
        a.calculatePrice(1);
        assertThat(a.calculatePrice(1), is(2.3));
        a.setCashInput (0.5);
        assertThat(a.getCashInput(), is(0.5));
        assertThat(a.payment(), is(1.8));
    }
}

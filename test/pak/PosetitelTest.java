package pak;

import org.junit.Test;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

import static org.mockito.Mockito.*;


/**
 * Created by dbogdanov on 20.11.14.
 */
public class PosetitelTest {


    static int scale = 10;
    static int range = 5 * scale;

    public static VerificationMode at(final int cnt) {
        return new VerificationMode() {

            @Override
            public void verify(VerificationData data) {
                int count = 0;
                for (Invocation invocation : data.getAllInvocations()) {
                    if (data.getWanted().hasSimilarMethod(invocation))
                        count++;
                }
                if ((count < cnt - range) || (count > cnt + range))
                    throw new MockitoAssertionError(String.format("Для метода " + data.getWanted().getMethod().getName()
                            + " ожидалась вероятность между %d и %d, но получилось %d", cnt - range, cnt + range, count));

            }
        };
    }

    @Test
    public void testDeviation() {
        Casir casir = mock(Casir.class);


        reset(casir);
        when(casir.areYouFree()).thenReturn(true);
        Posetitel posetitel = new Posetitel();
        for (int cnt = 0; cnt < 100 * scale; cnt++) {


            posetitel.askCasir(casir);
        }


        verify(casir, at(25 * scale)).changeCash();
        verify(casir, at(30 * scale)).comunalca();
        verify(casir, at(40 * scale)).addCash();
        verify(casir, at(5 * scale)).perevod();
    }


}

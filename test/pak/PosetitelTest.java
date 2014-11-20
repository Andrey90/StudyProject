package pak;

import org.junit.Test;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by dbogdanov on 20.11.14.
 */
public class PosetitelTest {

    public static VerificationMode between(final int from, final int to) {
        return new VerificationMode() {

            @Override
            public void verify(VerificationData data) {
                int count = 0;
                for (Invocation invocation : data.getAllInvocations()) {
                    if (data.getWanted().hasSimilarMethod(invocation))
                        count++;
                }
                if ((count <= from) || (count >= to))
                    throw new MockitoAssertionError(String.format("Для метода " + data.getWanted().getMethod().getName()
                            + " ожидалась вероятность между %d и %d, но получилось %d", from, to, count));

            }
        };
    }

    @Test
    public void testDeviation() {
        Casir casir = mock(Casir.class);
        Posetitel posetitel = new Posetitel();
        for (int i = 0; i < 100; i++) {
            posetitel.askCasir(casir);
        }


        verify(casir, between(20, 30)).changeCash();
        verify(casir, between(15, 35)).comunalca();
        verify(casir, between(20, 25)).addCash();
        verify(casir, between(25, 30)).perevod();


    }
}

package pak;

import java.util.Random;


public class Posetitel {
    Random r = new Random();


    public void askCasir(Casir ivanuch) {
        if (ivanuch.areYouFree()) {
            int obmenValut = 25;
            int oplataKomUslug = 30;
            int popolnenie = 40;
            int perevod = 5;


            int verOperacii = r.nextInt(100);
            /* Обмен валют 30%
            * Оплата комуналки 15%
            * Пополнение счета 25%
            * Денежные переводы 30%
            * Вероятность = 40*/
            if (verOperacii <= obmenValut) {
                ivanuch.changeCash();
            }
            /*Вероятность выпадения операции больше обмен валют и меньше или равна оплата комуналки*/
            else if (verOperacii <= oplataKomUslug + obmenValut) {
                /*(40 > 30) && (40 <= 45)*/
                ivanuch.comunalca();
            }
            /*Вероятность выпадения больше оплаты комуналки и меньше или равна пополнению счета */
            else if (verOperacii <= popolnenie + obmenValut + oplataKomUslug) {
                ivanuch.addCash();
            } else {
                ivanuch.perevod();
            }

        }
    }
}

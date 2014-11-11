package pak;

import java.util.Random;


public class Posetitel {
    Random r = new Random();

    public void askCasir(Casir ivanuch) {
        if (ivanuch.areYouFree()) {
            int obmenValut = 20 + r.nextInt(10);
            int oplataKomUslug = 15 + r.nextInt(20);
            int popolnenie = 20 + r.nextInt(5);
            int perevod = 25 + r.nextInt(5);

            float koef = 100 / (obmenValut + oplataKomUslug + popolnenie + perevod);
            obmenValut = (int) (obmenValut * koef);
            oplataKomUslug = (int) (oplataKomUslug * koef);
            popolnenie = (int) (popolnenie * koef);
            perevod = 100 - (obmenValut + oplataKomUslug + popolnenie);
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
            if ((verOperacii > obmenValut) && (verOperacii <= oplataKomUslug + obmenValut)) {
                /*(40 > 30) && (40 <= 45)*/
                ivanuch.comunalca();
            }
            /*Вероятность выпадения больше оплаты комуналки и меньше или равна пополнению счета */
            if ((verOperacii > oplataKomUslug + obmenValut) && (verOperacii <= popolnenie + obmenValut + oplataKomUslug)) {
                ivanuch.addCash();
            }
            if ((verOperacii > oplataKomUslug + obmenValut + popolnenie)) {
                ivanuch.perevod();
            }

        }
    }
}

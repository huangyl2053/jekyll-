/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 意見書作成督促方法を表す列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IkenshoSakuseiTokusokuHohoTest extends DbeTestBase {

    public static class toValue extends DbeTestBase {

        @Test
        public void 引数が1の時_toValueは_督促状郵送を返す() {
            assertThat(IkenshoSakuseiTokusokuHoho.toValue(new RString("1")), is(IkenshoSakuseiTokusokuHoho.督促状郵送));
        }

        @Test
        public void 引数が2の時_toValueは_督促状ＦＡＸを返す() {
            assertThat(IkenshoSakuseiTokusokuHoho.toValue(new RString("2")), is(IkenshoSakuseiTokusokuHoho.督促状ＦＡＸ));
        }

        @Test
        public void 引数が3の時_toValueは_電話を返す() {
            assertThat(IkenshoSakuseiTokusokuHoho.toValue(new RString("3")), is(IkenshoSakuseiTokusokuHoho.電話));
        }

        @Test
        public void 引数が4の時_toValueは_その他を返す() {
            assertThat(IkenshoSakuseiTokusokuHoho.toValue(new RString("4")), is(IkenshoSakuseiTokusokuHoho.その他));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が99の時_toValueは_IllegalArgumentExceptionを投げる() {
            IkenshoSakuseiTokusokuHoho.toValue(new RString("99"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数がNULLの時_toValueは_IllegalArgumentExceptionを投げる() {
            IkenshoSakuseiTokusokuHoho.toValue(null);
        }
    }
}

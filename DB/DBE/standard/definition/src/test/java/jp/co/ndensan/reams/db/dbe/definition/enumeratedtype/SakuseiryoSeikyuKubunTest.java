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
 * 作成料請求区分を表す列挙型のテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class SakuseiryoSeikyuKubunTest extends DbeTestBase {

    public static class toValue extends DbeTestBase {

        @Test
        public void 引数が11の時_toValueは_在宅新規を返す() {
            assertThat(SakuseiryoSeikyuKubun.toValue(new RString("11")), is(SakuseiryoSeikyuKubun.在宅新規));
        }

        @Test
        public void 引数が12の時_toValueは_在宅継続を返す() {
            assertThat(SakuseiryoSeikyuKubun.toValue(new RString("12")), is(SakuseiryoSeikyuKubun.在宅継続));
        }

        @Test
        public void 引数が21の時_toValueは_施設新規を返す() {
            assertThat(SakuseiryoSeikyuKubun.toValue(new RString("21")), is(SakuseiryoSeikyuKubun.施設新規));
        }

        @Test
        public void 引数が22の時_toValueは_施設継続を返す() {
            assertThat(SakuseiryoSeikyuKubun.toValue(new RString("22")), is(SakuseiryoSeikyuKubun.施設継続));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が99の時_toValueは_IllegalArgumentExceptionを投げる() {
            SakuseiryoSeikyuKubun.toValue(new RString("99"));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数がNULLの時_toValueは_IllegalArgumentExceptionを投げる() {
            SakuseiryoSeikyuKubun.toValue(null);
        }
    }
}

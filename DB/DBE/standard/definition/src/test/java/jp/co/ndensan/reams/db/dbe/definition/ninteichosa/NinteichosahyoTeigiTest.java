/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査票定義情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosahyoTeigiTest {

    public static class get調査票定義 {

        @Test
        public void 改定年度に指定がある時_get調査票定義は_該当の調査票定義を返す() {
            assertThat(NinteichosahyoTeigi.get調査票定義(2006).size(), is(76));
        }

        @Test
        public void 調査票項目に設定がある時_get調査票定義は_該当の調査票項目を返す() {
            assertThat(NinteichosahyoTeigi.get調査票定義(2006).get(ChosaKomoku.麻痺等の有無_左上肢).get表示名称(), is(new RString("麻痺等の有無 左上肢")));
        }
    }
}

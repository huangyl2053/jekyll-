/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * TeikeibunShubetsuTokkiのテストです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class TeikeibunShubetsuTokkiTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            TeikeibunShubetsuTokki sut = TeikeibunShubetsuTokki.その他特記;
            assertThat(TeikeibunShubetsuTokki.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            TeikeibunShubetsuTokki sut = TeikeibunShubetsuTokki.toValue(new RString("111"));
        }
    }

    public static class toRString extends DbzTestBase {

        @Test
        public void toRStringは_Enumクラスのnameと同じ値を返す() {
            assertThat(TeikeibunShubetsuTokki.その他特記.toRString().toString(), is(
                    TeikeibunShubetsuTokki.その他特記.name()));
        }
    }
}

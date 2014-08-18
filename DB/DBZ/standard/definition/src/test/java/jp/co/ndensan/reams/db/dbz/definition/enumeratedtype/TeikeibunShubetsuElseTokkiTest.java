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
 * TeikeibunShubetsuElseTokkiのテストです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class TeikeibunShubetsuElseTokkiTest extends DbzTestBase {

    public static class ToValue extends DbzTestBase {

        @Test
        public void toValueは_指定のコードに対応する列挙子があれば_それを返す() {
            TeikeibunShubetsuElseTokki sut = TeikeibunShubetsuElseTokki.申請理由;
            assertThat(TeikeibunShubetsuElseTokki.toValue(sut.getCode()), is(sut));
        }

        @Test(expected = IllegalArgumentException.class)
        public void toValueは_指定のコードに対応する列挙子がなければ_IllegalArgumentExceptionを返す() {
            TeikeibunShubetsuElseTokki sut = TeikeibunShubetsuElseTokki.toValue(new RString("111"));
        }
    }

    public static class toRString extends DbzTestBase {

        @Test
        public void toRStringは_Enumクラスのnameと同じ値を返す() {
            assertThat(TeikeibunShubetsuElseTokki.申請理由.toRString().toString(), is(
                    TeikeibunShubetsuElseTokki.申請理由.name()));
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShikakuHihokenshaKubun;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 資格被保険者区分のテストクラスです。
 *
 * @author N2218 村松 優
 */
@RunWith(Enclosed.class)
public class ShikakuHihokenshaKubunTest {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数が設定内の資格被保険者区分コードである1の場合_toValueは_enum第１号被保険者を返す() {
            ShikakuHihokenshaKubun sut = ShikakuHihokenshaKubun.toValue(new RString("1"));
            assertThat(sut, is(ShikakuHihokenshaKubun.第１号被保険者));
        }

        @Test
        public void 引数が設定内の資格被保険者区分コードである2の場合_toValueは_enum第２号被保険者を返す() {
            ShikakuHihokenshaKubun sut = ShikakuHihokenshaKubun.toValue(new RString("2"));
            assertThat(sut, is(ShikakuHihokenshaKubun.第２号被保険者));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の資格被保険者区分コードである3の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            ShikakuHihokenshaKubun.toValue(new RString("3"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である資格被保険者区分コードがnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            ShikakuHihokenshaKubun.toValue(null);
        }
    }

    public static class getコード extends DbxTestBase {

        @Test
        public void 資格被保険者区分が住所地特例者の場合_getコードは_1を返す() {
            assertThat(ShikakuHihokenshaKubun.第１号被保険者.getコード(), is(new RString("1")));
        }
    }

    public static class get名称 extends DbxTestBase {

        @Test
        public void 資格被保険者区分が通常資格者の場合_get名称は_２号を返す() {
            assertThat(ShikakuHihokenshaKubun.第２号被保険者.get名称(), is(new RString("２号")));
        }
    }

    public static class toRStringTest extends DbxTestBase {

        @Test
        public void LDNS_資格被保険者区分が第１号被保険者の場合_toRStringは_第１号被保険者を返す() {
            assertThat(ShikakuHihokenshaKubun.第１号被保険者.toRString(), is(new RString("第１号被保険者")));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_資格被保険者区分が第１号被保険者の場合_valueOfは_第１号被保険者を返す() {
            assertThat(ShikakuHihokenshaKubun.valueOf("第１号被保険者"), is(ShikakuHihokenshaKubun.第１号被保険者));
        }
    }
}

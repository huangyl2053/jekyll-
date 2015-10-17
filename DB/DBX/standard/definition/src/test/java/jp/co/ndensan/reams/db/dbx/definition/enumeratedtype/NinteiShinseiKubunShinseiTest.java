/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;

/**
 *
 * @author N2806 太田 智之
 */
@RunWith(Enclosed.class)
public class NinteiShinseiKubunShinseiTest extends DbxTestBase {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数に1を指定した場合_toValueは_新規申請を返す() {
            assertThat(NinteiShinseiKubunShinsei.toValue(1), is(NinteiShinseiKubunShinsei.新規申請));
        }

        @Test
        public void 引数に2を指定した場合_toValueは_更新申請を返す() {
            assertThat(NinteiShinseiKubunShinsei.toValue(2), is(NinteiShinseiKubunShinsei.更新申請));
        }

        @Test
        public void 引数に3を指定した場合_toValueは_区分変更申請を返す() {
            assertThat(NinteiShinseiKubunShinsei.toValue(3), is(NinteiShinseiKubunShinsei.区分変更申請));
        }

        @Test
        public void 引数に4を指定した場合_toValueは_職権を返す() {
            assertThat(NinteiShinseiKubunShinsei.toValue(4), is(NinteiShinseiKubunShinsei.職権));
        }

        @Test
        public void 引数に5を指定した場合_toValueは_転入申請を返す() {
            assertThat(NinteiShinseiKubunShinsei.toValue(5), is(NinteiShinseiKubunShinsei.転入申請));
        }

        @Test
        public void 引数に6を指定した場合_toValueは_資格喪失_死亡を返す() {
            assertThat(NinteiShinseiKubunShinsei.toValue(6), is(NinteiShinseiKubunShinsei.資格喪失_死亡));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に7を指定した場合_toValueは_IllegalArgumentExceptionを発生させる() {
            NinteiShinseiKubunShinsei.toValue(7);
        }
    }

    public static class コードTest extends DbxTestBase {

        @Test
        public void LDNS_NinteiShinseiKubunShinseiに新規申請を指定した場合_コードは_1を返す() {
            assertThat(NinteiShinseiKubunShinsei.新規申請.コード(), is(1));
        }

        @Test
        public void LDNS_NinteiShinseiKubunShinseiに更新申請を指定した場合_コードは_2を返す() {
            assertThat(NinteiShinseiKubunShinsei.更新申請.コード(), is(2));
        }

        @Test
        public void LDNS_NinteiShinseiKubunShinseiに区分変更申請を指定した場合_コードは_3を返す() {
            assertThat(NinteiShinseiKubunShinsei.区分変更申請.コード(), is(3));
        }

        @Test
        public void LDNS_NinteiShinseiKubunShinseiに職権を指定した場合_コードは_4を返す() {
            assertThat(NinteiShinseiKubunShinsei.職権.コード(), is(4));
        }

        @Test
        public void LDNS_NinteiShinseiKubunShinseiに転入申請を指定した場合_コードは_5を返す() {
            assertThat(NinteiShinseiKubunShinsei.転入申請.コード(), is(5));
        }

        @Test
        public void LDNS_NinteiShinseiKubunShinseiに資格喪失_死亡を指定した場合_コードは_6を返す() {
            assertThat(NinteiShinseiKubunShinsei.資格喪失_死亡.コード(), is(6));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_引数が転入申請の場合_NinteiShinseiKubunShinseiは_転入申請を返す() {
            assertThat(NinteiShinseiKubunShinsei.valueOf("転入申請"), is(NinteiShinseiKubunShinsei.転入申請));
        }
    }
}

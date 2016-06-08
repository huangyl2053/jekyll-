/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.NinteiShinseiKubunHorei;
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
public class NinteiShinseiKubunHoreiTest extends DbxTestBase {

    public static class toValueTest extends DbxTestBase {

        @Test
        public void 引数に1を指定した場合_toValueは_新規申請を返す() {
            assertThat(NinteiShinseiKubunHorei.toValue(1), is(NinteiShinseiKubunHorei.新規申請));
        }

        @Test
        public void 引数に2を指定した場合_toValueは_更新申請を返す() {
            assertThat(NinteiShinseiKubunHorei.toValue(2), is(NinteiShinseiKubunHorei.更新申請));
        }

        @Test
        public void 引数に3を指定した場合_toValueは_区分変更申請を返す() {
            assertThat(NinteiShinseiKubunHorei.toValue(3), is(NinteiShinseiKubunHorei.区分変更申請));
        }

        @Test
        public void 引数に4を指定した場合_toValueは_職権を返す() {
            assertThat(NinteiShinseiKubunHorei.toValue(4), is(NinteiShinseiKubunHorei.職権));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に5を指定した場合_toValueは_IllegalArgumentExceptionを発生させる() {
            NinteiShinseiKubunHorei.toValue(5);
        }
    }

    public static class getコードTest extends DbxTestBase {

        @Test
        public void LDNS_NinteiShinseiKubunHoreiに新規申請を指定した場合_コードは_1を返す() {
            assertThat(NinteiShinseiKubunHorei.新規申請.getコード(), is(1));
        }

        @Test
        public void LDNS_NinteiShinseiKubunHoreiに更新申請を指定した場合_コードは_2を返す() {
            assertThat(NinteiShinseiKubunHorei.更新申請.getコード(), is(2));
        }

        @Test
        public void LDNS_NinteiShinseiKubunHoreiに区分変更申請を指定した場合_コードは_3を返す() {
            assertThat(NinteiShinseiKubunHorei.区分変更申請.getコード(), is(3));
        }

        @Test
        public void LDNS_NinteiShinseiKubunHoreiに職権を指定した場合_コードは_4を返す() {
            assertThat(NinteiShinseiKubunHorei.職権.getコード(), is(4));
        }
    }

    public static class valueOfTest extends DbxTestBase {

        @Test
        public void LDNS_引数が更新申請の場合_NinteiShinseiKubunHoreiは_更新申請を返す() {
            assertThat(NinteiShinseiKubunHorei.valueOf("更新申請"), is(NinteiShinseiKubunHorei.更新申請));
        }
    }
}

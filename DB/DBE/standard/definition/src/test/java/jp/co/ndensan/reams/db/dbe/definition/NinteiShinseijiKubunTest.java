/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定申請区分_申請時の列挙型を表すクラスのテストクラスです。
 *
 * @author n8107
 */
@RunWith(Enclosed.class)
public class NinteiShinseijiKubunTest extends TestBase {

    public static class toValueTest extends TestBase {

        @Test
        public void 引数が設定内の認定申請区分_申請時である01の場合_toValueは_enum新規申請を返す() {
            NinteiShinseijiKubun sut = NinteiShinseijiKubun.toValue(new RString("01"));
            assertThat(sut, is(NinteiShinseijiKubun.新規申請));
        }

        @Test
        public void 引数が設定内の認定申請区分_申請時である02の場合_toValueは_enum更新申請を返す() {
            NinteiShinseijiKubun sut = NinteiShinseijiKubun.toValue(new RString("02"));
            assertThat(sut, is(NinteiShinseijiKubun.更新申請));
        }

        @Test
        public void 引数が設定内の認定申請区分_申請時である03の場合_toValueは_enum区分変更申請を返す() {
            NinteiShinseijiKubun sut = NinteiShinseijiKubun.toValue(new RString("03"));
            assertThat(sut, is(NinteiShinseijiKubun.区分変更申請));
        }

        @Test
        public void 引数が設定内の認定申請区分_申請時である04の場合_toValueは_enum職権を返す() {
            NinteiShinseijiKubun sut = NinteiShinseijiKubun.toValue(new RString("04"));
            assertThat(sut, is(NinteiShinseijiKubun.職権));
        }

        @Test
        public void 引数が設定内の認定申請区分_申請時である05の場合_toValueは_enum転入申請を返す() {
            NinteiShinseijiKubun sut = NinteiShinseijiKubun.toValue(new RString("05"));
            assertThat(sut, is(NinteiShinseijiKubun.転入申請));
        }

        @Test
        public void 引数が設定内の認定申請区分_申請時である06の場合_toValueは_enum資格喪失_死亡を返す() {
            NinteiShinseijiKubun sut = NinteiShinseijiKubun.toValue(new RString("06"));
            assertThat(sut, is(NinteiShinseijiKubun.資格喪失_死亡));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数が設定外の認定申請区分_申請時である00の場合_toValueは_IllegalArgumentExceptionエラーを投げる() {
            NinteiShinseijiKubun.toValue(new RString("00"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数である認定申請区分_申請時がnullの場合_toValueは_NullPointerExceptionエラーを投げる() {
            NinteiShinseijiKubun.toValue(null);
        }
    }

    public static class getCode {

        @Test
        public void 認定申請区分_申請時が新規申請の場合_getCodeは_01を返す() {
            assertThat(NinteiShinseijiKubun.新規申請.getCode(), is(new RString("01")));
        }

        @Test
        public void 認定申請区分_申請時が更新申請の場合_getCodeは_02を返す() {
            assertThat(NinteiShinseijiKubun.更新申請.getCode(), is(new RString("02")));
        }

        @Test
        public void 認定申請区分_申請時が区分変更申請の場合_getCodeは_03を返す() {
            assertThat(NinteiShinseijiKubun.区分変更申請.getCode(), is(new RString("03")));
        }

        @Test
        public void 認定申請区分_申請時が職権の場合_getCodeは_04を返す() {
            assertThat(NinteiShinseijiKubun.職権.getCode(), is(new RString("04")));
        }

        @Test
        public void 認定申請区分_申請時が転入申請の場合_getCodeは_05を返す() {
            assertThat(NinteiShinseijiKubun.転入申請.getCode(), is(new RString("05")));
        }

        @Test
        public void 認定申請区分_申請時が資格喪失_死亡の場合_getCodeは_06を返す() {
            assertThat(NinteiShinseijiKubun.資格喪失_死亡.getCode(), is(new RString("06")));
        }
    }

    public static class toRString {

        @Test
        public void 認定申請区分_申請時が新規申請の場合_toRStringは_新規申請を返す() {
            assertThat(NinteiShinseijiKubun.新規申請.toRString(), is(new RString("新規申請")));
        }

        @Test
        public void 認定申請区分_申請時が更新申請の場合_toRStringは_更新申請を返す() {
            assertThat(NinteiShinseijiKubun.更新申請.toRString(), is(new RString("更新申請")));
        }

        @Test
        public void 認定申請区分_申請時が区分変更申請の場合_toRStringは_区分変更申請を返す() {
            assertThat(NinteiShinseijiKubun.区分変更申請.toRString(), is(new RString("区分変更申請")));
        }

        @Test
        public void 認定申請区分_申請時が職権の場合_toRStringは_職権を返す() {
            assertThat(NinteiShinseijiKubun.職権.toRString(), is(new RString("職権")));
        }

        @Test
        public void 認定申請区分_申請時が転入申請の場合_toRStringは_転入申請を返す() {
            assertThat(NinteiShinseijiKubun.転入申請.toRString(), is(new RString("転入申請")));
        }

        @Test
        public void 認定申請区分_申請時が資格喪失_死亡の場合_toRStringは_資格喪失_死亡を返す() {
            assertThat(NinteiShinseijiKubun.資格喪失_死亡.toRString(), is(new RString("資格喪失_死亡")));
        }
    }
}

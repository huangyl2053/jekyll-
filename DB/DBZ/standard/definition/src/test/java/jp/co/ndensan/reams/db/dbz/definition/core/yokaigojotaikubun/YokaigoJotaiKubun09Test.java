package jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 要介護状態区分コード09のテストクラスです。
 * 
 * @author LDNS 
 */
public class YokaigoJotaiKubun09Test extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        YokaigoJotaiKubun09.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        YokaigoJotaiKubun09.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_非該当を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("01")), is(YokaigoJotaiKubun09.非該当));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_要支援1を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("12")), is(YokaigoJotaiKubun09.要支援1));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_要支援2を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("13")), is(YokaigoJotaiKubun09.要支援2));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_要介護1を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("21")), is(YokaigoJotaiKubun09.要介護1));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_要介護2を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("22")), is(YokaigoJotaiKubun09.要介護2));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_要介護3を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("23")), is(YokaigoJotaiKubun09.要介護3));
    }

    @Test
    public void 引数に24を指定した場合_toValueは_要介護4を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("24")), is(YokaigoJotaiKubun09.要介護4));
    }

    @Test
    public void 引数に25を指定した場合_toValueは_要介護5を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("25")), is(YokaigoJotaiKubun09.要介護5));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_再調査を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("31")), is(YokaigoJotaiKubun09.再調査));
    }

    @Test
    public void 引数に88を指定した場合_toValueは_取消を返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("88")), is(YokaigoJotaiKubun09.取消));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_なしを返す() {
        assertThat(YokaigoJotaiKubun09.toValue(new RString("99")), is(YokaigoJotaiKubun09.なし));
    }

    @Test
    public void 非該当を指定した場合_getコードは_01を返す() {
        assertThat(YokaigoJotaiKubun09.非該当.getコード(), is(new RString("01")));
    }

    @Test
    public void 要支援1を指定した場合_getコードは_12を返す() {
        assertThat(YokaigoJotaiKubun09.要支援1.getコード(), is(new RString("12")));
    }

    @Test
    public void 要支援2を指定した場合_getコードは_13を返す() {
        assertThat(YokaigoJotaiKubun09.要支援2.getコード(), is(new RString("13")));
    }

    @Test
    public void 要介護1を指定した場合_getコードは_21を返す() {
        assertThat(YokaigoJotaiKubun09.要介護1.getコード(), is(new RString("21")));
    }

    @Test
    public void 要介護2を指定した場合_getコードは_22を返す() {
        assertThat(YokaigoJotaiKubun09.要介護2.getコード(), is(new RString("22")));
    }

    @Test
    public void 要介護3を指定した場合_getコードは_23を返す() {
        assertThat(YokaigoJotaiKubun09.要介護3.getコード(), is(new RString("23")));
    }

    @Test
    public void 要介護4を指定した場合_getコードは_24を返す() {
        assertThat(YokaigoJotaiKubun09.要介護4.getコード(), is(new RString("24")));
    }

    @Test
    public void 要介護5を指定した場合_getコードは_25を返す() {
        assertThat(YokaigoJotaiKubun09.要介護5.getコード(), is(new RString("25")));
    }

    @Test
    public void 再調査を指定した場合_getコードは_31を返す() {
        assertThat(YokaigoJotaiKubun09.再調査.getコード(), is(new RString("31")));
    }

    @Test
    public void 取消を指定した場合_getコードは_88を返す() {
        assertThat(YokaigoJotaiKubun09.取消.getコード(), is(new RString("88")));
    }

    @Test
    public void なしを指定した場合_getコードは_99を返す() {
        assertThat(YokaigoJotaiKubun09.なし.getコード(), is(new RString("99")));
    }

    @Test
    public void 非該当を指定した場合_get名称は_非該当を返す() {
        assertThat(YokaigoJotaiKubun09.非該当.get名称(), is(new RString("非該当")));
    }

    @Test
    public void 要支援1を指定した場合_get名称は_要支援1を返す() {
        assertThat(YokaigoJotaiKubun09.要支援1.get名称(), is(new RString("要支援1")));
    }

    @Test
    public void 要支援2を指定した場合_get名称は_要支援2を返す() {
        assertThat(YokaigoJotaiKubun09.要支援2.get名称(), is(new RString("要支援2")));
    }

    @Test
    public void 要介護1を指定した場合_get名称は_要介護1を返す() {
        assertThat(YokaigoJotaiKubun09.要介護1.get名称(), is(new RString("要介護1")));
    }

    @Test
    public void 要介護2を指定した場合_get名称は_要介護2を返す() {
        assertThat(YokaigoJotaiKubun09.要介護2.get名称(), is(new RString("要介護2")));
    }

    @Test
    public void 要介護3を指定した場合_get名称は_要介護3を返す() {
        assertThat(YokaigoJotaiKubun09.要介護3.get名称(), is(new RString("要介護3")));
    }

    @Test
    public void 要介護4を指定した場合_get名称は_要介護4を返す() {
        assertThat(YokaigoJotaiKubun09.要介護4.get名称(), is(new RString("要介護4")));
    }

    @Test
    public void 要介護5を指定した場合_get名称は_要介護5を返す() {
        assertThat(YokaigoJotaiKubun09.要介護5.get名称(), is(new RString("要介護5")));
    }

    @Test
    public void 再調査を指定した場合_get名称は_再調査を返す() {
        assertThat(YokaigoJotaiKubun09.再調査.get名称(), is(new RString("再調査")));
    }

    @Test
    public void 取消を指定した場合_get名称は_取消を返す() {
        assertThat(YokaigoJotaiKubun09.取消.get名称(), is(new RString("取消")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(YokaigoJotaiKubun09.なし.get名称(), is(new RString("なし")));
    }

}

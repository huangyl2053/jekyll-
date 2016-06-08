package jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 要介護状態区分コード99のテストクラスです。
 * 
 * @author LDNS 
 */
public class YokaigoJotaiKubun99Test extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        YokaigoJotaiKubun99.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        YokaigoJotaiKubun99.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_非該当を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("01")), is(YokaigoJotaiKubun99.非該当));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_みなし非該当を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("09")), is(YokaigoJotaiKubun99.みなし非該当));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_経過的要介護を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("11")), is(YokaigoJotaiKubun99.経過的要介護));
    }

    @Test
    public void 引数に19を指定した場合_toValueは_みなし要支援を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("19")), is(YokaigoJotaiKubun99.みなし要支援));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_要介護1を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("21")), is(YokaigoJotaiKubun99.要介護1));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_要介護2を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("22")), is(YokaigoJotaiKubun99.要介護2));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_要介護3を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("23")), is(YokaigoJotaiKubun99.要介護3));
    }

    @Test
    public void 引数に24を指定した場合_toValueは_要介護4を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("24")), is(YokaigoJotaiKubun99.要介護4));
    }

    @Test
    public void 引数に25を指定した場合_toValueは_要介護5を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("25")), is(YokaigoJotaiKubun99.要介護5));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_再調査を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("31")), is(YokaigoJotaiKubun99.再調査));
    }

    @Test
    public void 引数に32を指定した場合_toValueは_照会を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("32")), is(YokaigoJotaiKubun99.照会));
    }

    @Test
    public void 引数に88を指定した場合_toValueは_取消を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("88")), is(YokaigoJotaiKubun99.取消));
    }

    @Test
    public void 引数に98を指定した場合_toValueは_保留を返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("98")), is(YokaigoJotaiKubun99.保留));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_なしを返す() {
        assertThat(YokaigoJotaiKubun99.toValue(new RString("99")), is(YokaigoJotaiKubun99.なし));
    }

    @Test
    public void 非該当を指定した場合_getコードは_01を返す() {
        assertThat(YokaigoJotaiKubun99.非該当.getコード(), is(new RString("01")));
    }

    @Test
    public void みなし非該当を指定した場合_getコードは_09を返す() {
        assertThat(YokaigoJotaiKubun99.みなし非該当.getコード(), is(new RString("09")));
    }

    @Test
    public void 経過的要介護を指定した場合_getコードは_11を返す() {
        assertThat(YokaigoJotaiKubun99.経過的要介護.getコード(), is(new RString("11")));
    }

    @Test
    public void みなし要支援を指定した場合_getコードは_19を返す() {
        assertThat(YokaigoJotaiKubun99.みなし要支援.getコード(), is(new RString("19")));
    }

    @Test
    public void 要介護1を指定した場合_getコードは_21を返す() {
        assertThat(YokaigoJotaiKubun99.要介護1.getコード(), is(new RString("21")));
    }

    @Test
    public void 要介護2を指定した場合_getコードは_22を返す() {
        assertThat(YokaigoJotaiKubun99.要介護2.getコード(), is(new RString("22")));
    }

    @Test
    public void 要介護3を指定した場合_getコードは_23を返す() {
        assertThat(YokaigoJotaiKubun99.要介護3.getコード(), is(new RString("23")));
    }

    @Test
    public void 要介護4を指定した場合_getコードは_24を返す() {
        assertThat(YokaigoJotaiKubun99.要介護4.getコード(), is(new RString("24")));
    }

    @Test
    public void 要介護5を指定した場合_getコードは_25を返す() {
        assertThat(YokaigoJotaiKubun99.要介護5.getコード(), is(new RString("25")));
    }

    @Test
    public void 再調査を指定した場合_getコードは_31を返す() {
        assertThat(YokaigoJotaiKubun99.再調査.getコード(), is(new RString("31")));
    }

    @Test
    public void 照会を指定した場合_getコードは_32を返す() {
        assertThat(YokaigoJotaiKubun99.照会.getコード(), is(new RString("32")));
    }

    @Test
    public void 取消を指定した場合_getコードは_88を返す() {
        assertThat(YokaigoJotaiKubun99.取消.getコード(), is(new RString("88")));
    }

    @Test
    public void 保留を指定した場合_getコードは_98を返す() {
        assertThat(YokaigoJotaiKubun99.保留.getコード(), is(new RString("98")));
    }

    @Test
    public void なしを指定した場合_getコードは_99を返す() {
        assertThat(YokaigoJotaiKubun99.なし.getコード(), is(new RString("99")));
    }

    @Test
    public void 非該当を指定した場合_get名称は_非該当を返す() {
        assertThat(YokaigoJotaiKubun99.非該当.get名称(), is(new RString("非該当")));
    }

    @Test
    public void みなし非該当を指定した場合_get名称は_みなし非該当を返す() {
        assertThat(YokaigoJotaiKubun99.みなし非該当.get名称(), is(new RString("みなし非該当")));
    }

    @Test
    public void 経過的要介護を指定した場合_get名称は_経過的要介護を返す() {
        assertThat(YokaigoJotaiKubun99.経過的要介護.get名称(), is(new RString("経過的要介護")));
    }

    @Test
    public void みなし要支援を指定した場合_get名称は_みなし要支援を返す() {
        assertThat(YokaigoJotaiKubun99.みなし要支援.get名称(), is(new RString("みなし要支援")));
    }

    @Test
    public void 要介護1を指定した場合_get名称は_要介護1を返す() {
        assertThat(YokaigoJotaiKubun99.要介護1.get名称(), is(new RString("要介護1")));
    }

    @Test
    public void 要介護2を指定した場合_get名称は_要介護2を返す() {
        assertThat(YokaigoJotaiKubun99.要介護2.get名称(), is(new RString("要介護2")));
    }

    @Test
    public void 要介護3を指定した場合_get名称は_要介護3を返す() {
        assertThat(YokaigoJotaiKubun99.要介護3.get名称(), is(new RString("要介護3")));
    }

    @Test
    public void 要介護4を指定した場合_get名称は_要介護4を返す() {
        assertThat(YokaigoJotaiKubun99.要介護4.get名称(), is(new RString("要介護4")));
    }

    @Test
    public void 要介護5を指定した場合_get名称は_要介護5を返す() {
        assertThat(YokaigoJotaiKubun99.要介護5.get名称(), is(new RString("要介護5")));
    }

    @Test
    public void 再調査を指定した場合_get名称は_再調査を返す() {
        assertThat(YokaigoJotaiKubun99.再調査.get名称(), is(new RString("再調査")));
    }

    @Test
    public void 照会を指定した場合_get名称は_照会を返す() {
        assertThat(YokaigoJotaiKubun99.照会.get名称(), is(new RString("照会")));
    }

    @Test
    public void 取消を指定した場合_get名称は_取消を返す() {
        assertThat(YokaigoJotaiKubun99.取消.get名称(), is(new RString("取消")));
    }

    @Test
    public void 保留を指定した場合_get名称は_保留を返す() {
        assertThat(YokaigoJotaiKubun99.保留.get名称(), is(new RString("保留")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(YokaigoJotaiKubun99.なし.get名称(), is(new RString("なし")));
    }

}

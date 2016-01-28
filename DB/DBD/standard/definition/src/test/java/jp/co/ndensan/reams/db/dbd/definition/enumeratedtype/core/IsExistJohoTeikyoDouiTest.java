package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 情報提供への同意有無のテストクラスです。
 *
 * @author LDNS
 */
public class IsExistJohoTeikyoDouiTest extends DbdTestBase {

    @Test
    public void 引数にtrueを指定した場合_toValueは_同意するを返す() {
        assertThat(IsExistJohoTeikyoDoui.toValue(true), is(IsExistJohoTeikyoDoui.同意する));
    }

    @Test
    public void 引数にfalseを指定した場合_toValueは_同意しないを返す() {
        assertThat(IsExistJohoTeikyoDoui.toValue(false), is(IsExistJohoTeikyoDoui.同意しない));
    }

    @Test
    public void 同意するを指定した場合_getコードは_trueを返す() {
        assertThat(IsExistJohoTeikyoDoui.同意する.getコード(), is(true));
    }

    @Test
    public void 同意しないを指定した場合_getコードは_falseを返す() {
        assertThat(IsExistJohoTeikyoDoui.同意しない.getコード(), is(false));
    }

    @Test
    public void 同意するを指定した場合_get名称は_同意するを返す() {
        assertThat(IsExistJohoTeikyoDoui.同意する.get名称(), is(new RString("同意する")));
    }

    @Test
    public void 同意しないを指定した場合_get名称は_同意しないを返す() {
        assertThat(IsExistJohoTeikyoDoui.同意しない.get名称(), is(new RString("同意しない")));
    }

}

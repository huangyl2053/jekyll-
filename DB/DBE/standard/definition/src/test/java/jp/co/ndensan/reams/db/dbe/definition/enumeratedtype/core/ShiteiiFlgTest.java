package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 指定医フラグのテストクラスです。
 * 
 * @author LDNS 
 */
public class ShiteiiFlgTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShiteiiFlg.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShiteiiFlg.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_指定医になれるを返す() {
        assertThat(ShiteiiFlg.toValue(new RString("0")), is(ShiteiiFlg.指定医になれる));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_なれないを返す() {
        assertThat(ShiteiiFlg.toValue(new RString("1")), is(ShiteiiFlg.なれない));
    }

    @Test
    public void 指定医になれるを指定した場合_getコードは_0を返す() {
        assertThat(ShiteiiFlg.指定医になれる.getコード(), is(new RString("0")));
    }

    @Test
    public void なれないを指定した場合_getコードは_1を返す() {
        assertThat(ShiteiiFlg.なれない.getコード(), is(new RString("1")));
    }

    @Test
    public void 指定医になれるを指定した場合_get名称は_指定医になれるを返す() {
        assertThat(ShiteiiFlg.指定医になれる.get名称(), is(new RString("指定医になれる")));
    }

    @Test
    public void なれないを指定した場合_get名称は_なれないを返す() {
        assertThat(ShiteiiFlg.なれない.get名称(), is(new RString("なれない")));
    }

}

package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 併徴者山分け出力のテストクラスです。
 *
 * @author LDNS
 */
public class HeichoshaYamawakeShutsuryokuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HeichoshaYamawakeShutsuryoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HeichoshaYamawakeShutsuryoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_山分けしないを返す() {
        assertThat(HeichoshaYamawakeShutsuryoku.toValue(new RString("0")), is(HeichoshaYamawakeShutsuryoku.山分けしない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_山分けするを返す() {
        assertThat(HeichoshaYamawakeShutsuryoku.toValue(new RString("1")), is(HeichoshaYamawakeShutsuryoku.山分けする));
    }

    @Test
    public void 山分けしないを指定した場合_getコードは_0を返す() {
        assertThat(HeichoshaYamawakeShutsuryoku.山分けしない.getコード(), is(new RString("0")));
    }

    @Test
    public void 山分けするを指定した場合_getコードは_1を返す() {
        assertThat(HeichoshaYamawakeShutsuryoku.山分けする.getコード(), is(new RString("1")));
    }

    @Test
    public void 山分けしないを指定した場合_get名称は_山分けしないを返す() {
        assertThat(HeichoshaYamawakeShutsuryoku.山分けしない.get名称(), is(new RString("山分けしない")));
    }

    @Test
    public void 山分けするを指定した場合_get名称は_山分けするを返す() {
        assertThat(HeichoshaYamawakeShutsuryoku.山分けする.get名称(), is(new RString("山分けする")));
    }

}

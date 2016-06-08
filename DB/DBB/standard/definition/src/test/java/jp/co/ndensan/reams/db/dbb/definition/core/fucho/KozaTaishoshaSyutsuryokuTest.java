package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 口座対象者出力のテストクラスです。
 *
 * @author LDNS
 */
public class KozaTaishoshaSyutsuryokuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KozaTaishoshaSyutsuryoku.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KozaTaishoshaSyutsuryoku.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_するを返す() {
        assertThat(KozaTaishoshaSyutsuryoku.toValue(new RString("1")), is(KozaTaishoshaSyutsuryoku.する));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_しないを返す() {
        assertThat(KozaTaishoshaSyutsuryoku.toValue(new RString("2")), is(KozaTaishoshaSyutsuryoku.しない));
    }

    @Test
    public void するを指定した場合_getコードは_1を返す() {
        assertThat(KozaTaishoshaSyutsuryoku.する.getコード(), is(new RString("1")));
    }

    @Test
    public void しないを指定した場合_getコードは_2を返す() {
        assertThat(KozaTaishoshaSyutsuryoku.しない.getコード(), is(new RString("2")));
    }

    @Test
    public void するを指定した場合_get名称は_出力するを返す() {
        assertThat(KozaTaishoshaSyutsuryoku.する.get名称(), is(new RString("出力する")));
    }

    @Test
    public void しないを指定した場合_get名称は_出力しないを返す() {
        assertThat(KozaTaishoshaSyutsuryoku.しない.get名称(), is(new RString("出力しない")));
    }

    @Test
    public void するを指定した場合_get略称は_するを返す() {
        assertThat(KozaTaishoshaSyutsuryoku.する.get略称(), is(new RString("する")));
    }

    @Test
    public void しないを指定した場合_get略称は_しないを返す() {
        assertThat(KozaTaishoshaSyutsuryoku.しない.get略称(), is(new RString("しない")));
    }

}

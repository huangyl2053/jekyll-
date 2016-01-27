package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 速報取込区分のテストクラスです。
 *
 * @author LDNS
 */
public class SokuhoTorikomiKubunTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        SokuhoTorikomiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SokuhoTorikomiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_取り込まないを返す() {
        assertThat(SokuhoTorikomiKubun.toValue(new RString("0")), is(SokuhoTorikomiKubun.取り込まない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_取り込むを返す() {
        assertThat(SokuhoTorikomiKubun.toValue(new RString("1")), is(SokuhoTorikomiKubun.取り込む));
    }

    @Test
    public void 取り込まないを指定した場合_getコードは_0を返す() {
        assertThat(SokuhoTorikomiKubun.取り込まない.getコード(), is(new RString("0")));
    }

    @Test
    public void 取り込むを指定した場合_getコードは_1を返す() {
        assertThat(SokuhoTorikomiKubun.取り込む.getコード(), is(new RString("1")));
    }

    @Test
    public void 取り込まないを指定した場合_get名称は_取り込まないを返す() {
        assertThat(SokuhoTorikomiKubun.取り込まない.get名称(), is(new RString("取り込まない")));
    }

    @Test
    public void 取り込むを指定した場合_get名称は_取り込むを返す() {
        assertThat(SokuhoTorikomiKubun.取り込む.get名称(), is(new RString("取り込む")));
    }

}

package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 領収書日付欄期表示のテストクラスです。
 *
 * @author LDNS
 */
public class RyoshushoHizukeranKiHyojiTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RyoshushoHizukeranKiHyoji.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RyoshushoHizukeranKiHyoji.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_表示しないを返す() {
        assertThat(RyoshushoHizukeranKiHyoji.toValue(new RString("0")), is(RyoshushoHizukeranKiHyoji.表示しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_期表示を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.toValue(new RString("1")), is(RyoshushoHizukeranKiHyoji.期表示));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_月表示を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.toValue(new RString("2")), is(RyoshushoHizukeranKiHyoji.月表示));
    }

    @Test
    public void 表示しないを指定した場合_getコードは_0を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.表示しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 期表示を指定した場合_getコードは_1を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.期表示.getコード(), is(new RString("1")));
    }

    @Test
    public void 月表示を指定した場合_getコードは_2を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.月表示.getコード(), is(new RString("2")));
    }

    @Test
    public void 表示しないを指定した場合_get名称は_表示しないを返す() {
        assertThat(RyoshushoHizukeranKiHyoji.表示しない.get名称(), is(new RString("表示しない")));
    }

    @Test
    public void 期表示を指定した場合_get名称は_期表示を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.期表示.get名称(), is(new RString("期表示")));
    }

    @Test
    public void 月表示を指定した場合_get名称は_月表示を返す() {
        assertThat(RyoshushoHizukeranKiHyoji.月表示.get名称(), is(new RString("月表示")));
    }

}

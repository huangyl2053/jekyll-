package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 領収日付欄のテストクラスです。
 *
 * @author LDNS
 */
public class RyoshuHizukeRanTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RyoshuHizukeRan.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RyoshuHizukeRan.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_何も表示しないを返す() {
        assertThat(RyoshuHizukeRan.toValue(new RString("0")), is(RyoshuHizukeRan.何も表示しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_期で出力するを返す() {
        assertThat(RyoshuHizukeRan.toValue(new RString("1")), is(RyoshuHizukeRan.期で出力する));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_月で出力するを返す() {
        assertThat(RyoshuHizukeRan.toValue(new RString("2")), is(RyoshuHizukeRan.月で出力する));
    }

    @Test
    public void 何も表示しないを指定した場合_getコードは_0を返す() {
        assertThat(RyoshuHizukeRan.何も表示しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 期で出力するを指定した場合_getコードは_1を返す() {
        assertThat(RyoshuHizukeRan.期で出力する.getコード(), is(new RString("1")));
    }

    @Test
    public void 月で出力するを指定した場合_getコードは_2を返す() {
        assertThat(RyoshuHizukeRan.月で出力する.getコード(), is(new RString("2")));
    }

    @Test
    public void 何も表示しないを指定した場合_get名称は_何も表示しないを返す() {
        assertThat(RyoshuHizukeRan.何も表示しない.get名称(), is(new RString("何も表示しない")));
    }

    @Test
    public void 期で出力するを指定した場合_get名称は_期で出力するを返す() {
        assertThat(RyoshuHizukeRan.期で出力する.get名称(), is(new RString("期で出力する")));
    }

    @Test
    public void 月で出力するを指定した場合_get名称は_月で出力するを返す() {
        assertThat(RyoshuHizukeRan.月で出力する.get名称(), is(new RString("月で出力する")));
    }

}

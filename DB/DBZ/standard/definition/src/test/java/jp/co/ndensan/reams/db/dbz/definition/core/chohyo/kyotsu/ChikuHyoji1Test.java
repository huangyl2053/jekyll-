package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 地区表示1のテストクラスです。
 *
 * @author LDNS
 */
public class ChikuHyoji1Test extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChikuHyoji1.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChikuHyoji1.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_なしを返す() {
        assertThat(ChikuHyoji1.toValue(new RString("0")), is(ChikuHyoji1.なし));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_住所コードを返す() {
        assertThat(ChikuHyoji1.toValue(new RString("1")), is(ChikuHyoji1.住所コード));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_行政区コードを返す() {
        assertThat(ChikuHyoji1.toValue(new RString("2")), is(ChikuHyoji1.行政区コード));
    }

    @Test
    public void なしを指定した場合_getコードは_0を返す() {
        assertThat(ChikuHyoji1.なし.getコード(), is(new RString("0")));
    }

    @Test
    public void 住所コードを指定した場合_getコードは_1を返す() {
        assertThat(ChikuHyoji1.住所コード.getコード(), is(new RString("1")));
    }

    @Test
    public void 行政区コードを指定した場合_getコードは_2を返す() {
        assertThat(ChikuHyoji1.行政区コード.getコード(), is(new RString("2")));
    }

    @Test
    public void なしを指定した場合_get名称は_なしを返す() {
        assertThat(ChikuHyoji1.なし.get名称(), is(new RString("なし")));
    }

    @Test
    public void 住所コードを指定した場合_get名称は_住所コードを返す() {
        assertThat(ChikuHyoji1.住所コード.get名称(), is(new RString("住所コード")));
    }

    @Test
    public void 行政区コードを指定した場合_get名称は_行政区コードを返す() {
        assertThat(ChikuHyoji1.行政区コード.get名称(), is(new RString("行政区コード")));
    }

}

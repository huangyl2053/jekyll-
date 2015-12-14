package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 決定変更通知書打ち分けのテストクラスです。
 *
 * @author LDNS
 */
public class KetteiHenkoTsuchishoUchiwakeTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KetteiHenkoTsuchishoUchiwake.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KetteiHenkoTsuchishoUchiwake.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_発行しないを返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.toValue(new RString("0")), is(KetteiHenkoTsuchishoUchiwake.発行しない));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_決定通知書を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.toValue(new RString("1")), is(KetteiHenkoTsuchishoUchiwake.決定通知書));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_変更通知書を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.toValue(new RString("2")), is(KetteiHenkoTsuchishoUchiwake.変更通知書));
    }

    @Test
    public void 発行しないを指定した場合_getコードは_0を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.発行しない.getコード(), is(new RString("0")));
    }

    @Test
    public void 決定通知書を指定した場合_getコードは_1を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.決定通知書.getコード(), is(new RString("1")));
    }

    @Test
    public void 変更通知書を指定した場合_getコードは_2を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.変更通知書.getコード(), is(new RString("2")));
    }

    @Test
    public void 発行しないを指定した場合_get名称は_発行しないを返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.発行しない.get名称(), is(new RString("発行しない")));
    }

    @Test
    public void 決定通知書を指定した場合_get名称は_決定通知書を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.決定通知書.get名称(), is(new RString("決定通知書")));
    }

    @Test
    public void 変更通知書を指定した場合_get名称は_変更通知書を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.変更通知書.get名称(), is(new RString("変更通知書")));
    }

    @Test
    public void 発行しないを指定した場合_get略称は_発行しないを返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.発行しない.get略称(), is(new RString("発行しない")));
    }

    @Test
    public void 決定通知書を指定した場合_get略称は_決定通知書を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.決定通知書.get略称(), is(new RString("決定通知書")));
    }

    @Test
    public void 変更通知書を指定した場合_get略称は_変更通知書を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwake.変更通知書.get略称(), is(new RString("変更通知書")));
    }

}

package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 決定変更通知書打ち分け口座条件のテストクラスです。
 *
 * @author LDNS
 */
public class KetteiHenkoTsuchishoUchiwakeKozaJokenTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KetteiHenkoTsuchishoUchiwakeKozaJoken.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KetteiHenkoTsuchishoUchiwakeKozaJoken.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_現金を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.toValue(new RString("0")), is(KetteiHenkoTsuchishoUchiwakeKozaJoken.現金));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_口座を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.toValue(new RString("1")), is(KetteiHenkoTsuchishoUchiwakeKozaJoken.口座));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_全てを返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.toValue(new RString("2")), is(KetteiHenkoTsuchishoUchiwakeKozaJoken.全て));
    }

    @Test
    public void 現金を指定した場合_getコードは_0を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.現金.getコード(), is(new RString("0")));
    }

    @Test
    public void 口座を指定した場合_getコードは_1を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.口座.getコード(), is(new RString("1")));
    }

    @Test
    public void 全てを指定した場合_getコードは_2を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.全て.getコード(), is(new RString("2")));
    }

    @Test
    public void 現金を指定した場合_get名称は_現金を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.現金.get名称(), is(new RString("現金")));
    }

    @Test
    public void 口座を指定した場合_get名称は_口座を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.口座.get名称(), is(new RString("口座")));
    }

    @Test
    public void 全てを指定した場合_get名称は_全てを返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.全て.get名称(), is(new RString("全て")));
    }

    @Test
    public void 現金を指定した場合_get略称は_現金を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.現金.get略称(), is(new RString("現金")));
    }

    @Test
    public void 口座を指定した場合_get略称は_口座を返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.口座.get略称(), is(new RString("口座")));
    }

    @Test
    public void 全てを指定した場合_get略称は_全てを返す() {
        assertThat(KetteiHenkoTsuchishoUchiwakeKozaJoken.全て.get略称(), is(new RString("全て")));
    }

}

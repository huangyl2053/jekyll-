package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 調査実施場所コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class ChosaJisshiBashoCodeTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChosaJisshiBashoCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChosaJisshiBashoCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_自宅内を返す() {
        assertThat(ChosaJisshiBashoCode.toValue(new RString("1")), is(ChosaJisshiBashoCode.自宅内));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_自宅外を返す() {
        assertThat(ChosaJisshiBashoCode.toValue(new RString("2")), is(ChosaJisshiBashoCode.自宅外));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_その他を返す() {
        assertThat(ChosaJisshiBashoCode.toValue(new RString("3")), is(ChosaJisshiBashoCode.その他));
    }

    @Test
    public void 自宅内を指定した場合_getコードは_1を返す() {
        assertThat(ChosaJisshiBashoCode.自宅内.getコード(), is(new RString("1")));
    }

    @Test
    public void 自宅外を指定した場合_getコードは_2を返す() {
        assertThat(ChosaJisshiBashoCode.自宅外.getコード(), is(new RString("2")));
    }

    @Test
    public void その他を指定した場合_getコードは_3を返す() {
        assertThat(ChosaJisshiBashoCode.その他.getコード(), is(new RString("3")));
    }

    @Test
    public void 自宅内を指定した場合_get名称は_自宅内を返す() {
        assertThat(ChosaJisshiBashoCode.自宅内.get名称(), is(new RString("自宅内")));
    }

    @Test
    public void 自宅外を指定した場合_get名称は_自宅外を返す() {
        assertThat(ChosaJisshiBashoCode.自宅外.get名称(), is(new RString("自宅外")));
    }

    @Test
    public void その他を指定した場合_get名称は_その他を返す() {
        assertThat(ChosaJisshiBashoCode.その他.get名称(), is(new RString("その他")));
    }

}

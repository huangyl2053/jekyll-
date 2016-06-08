package jp.co.ndensan.reams.db.dbz.definition.core.teikeibun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特記事項定型文種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class TeikeibunShubetsuTokkiTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TeikeibunShubetsuTokki.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TeikeibunShubetsuTokki.toValue(new RString("99999"));
    }

    @Test
    public void 引数に001を指定した場合_toValueは_第１群_１_麻痺を返す() {
        assertThat(TeikeibunShubetsuTokki.toValue(new RString("001")), is(TeikeibunShubetsuTokki.第１群_１_麻痺));
    }

    @Test
    public void 引数に002を指定した場合_toValueは_第１群_２_拘縮を返す() {
        assertThat(TeikeibunShubetsuTokki.toValue(new RString("002")), is(TeikeibunShubetsuTokki.第１群_２_拘縮));
    }

    @Test
    public void 引数に003を指定した場合_toValueは_第１群_３_寝返りを返す() {
        assertThat(TeikeibunShubetsuTokki.toValue(new RString("003")), is(TeikeibunShubetsuTokki.第１群_３_寝返り));
    }

    @Test
    public void 引数に004を指定した場合_toValueは_第１群_４_起き上がりを返す() {
        assertThat(TeikeibunShubetsuTokki.toValue(new RString("004")), is(TeikeibunShubetsuTokki.第１群_４_起き上がり));
    }

    @Test
    public void 引数に070を指定した場合_toValueは_その他特記を返す() {
        assertThat(TeikeibunShubetsuTokki.toValue(new RString("070")), is(TeikeibunShubetsuTokki.その他特記));
    }

    @Test
    public void 第１群_１_麻痺を指定した場合_getコードは_001を返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_１_麻痺.getコード(), is(new RString("001")));
    }

    @Test
    public void 第１群_２_拘縮を指定した場合_getコードは_002を返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_２_拘縮.getコード(), is(new RString("002")));
    }

    @Test
    public void 第１群_３_寝返りを指定した場合_getコードは_003を返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_３_寝返り.getコード(), is(new RString("003")));
    }

    @Test
    public void 第１群_４_起き上がりを指定した場合_getコードは_004を返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_４_起き上がり.getコード(), is(new RString("004")));
    }

    @Test
    public void その他特記を指定した場合_getコードは_070を返す() {
        assertThat(TeikeibunShubetsuTokki.その他特記.getコード(), is(new RString("070")));
    }

    @Test
    public void 第１群_１_麻痺を指定した場合_get名称は_第１群_１_麻痺を返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_１_麻痺.get名称(), is(new RString("第１群_１_麻痺")));
    }

    @Test
    public void 第１群_２_拘縮を指定した場合_get名称は_第１群_２_拘縮を返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_２_拘縮.get名称(), is(new RString("第１群_２_拘縮")));
    }

    @Test
    public void 第１群_３_寝返りを指定した場合_get名称は_第１群_３_寝返りを返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_３_寝返り.get名称(), is(new RString("第１群_３_寝返り")));
    }

    @Test
    public void 第１群_４_起き上がりを指定した場合_get名称は_第１群_４_起き上がりを返す() {
        assertThat(TeikeibunShubetsuTokki.第１群_４_起き上がり.get名称(), is(new RString("第１群_４_起き上がり")));
    }

    @Test
    public void その他特記を指定した場合_get名称は_その他特記を返す() {
        assertThat(TeikeibunShubetsuTokki.その他特記.get名称(), is(new RString("その他特記")));
    }

}

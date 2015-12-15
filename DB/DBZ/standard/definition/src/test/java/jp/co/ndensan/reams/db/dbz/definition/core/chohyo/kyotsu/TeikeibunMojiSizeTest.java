package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 定型文文字サイズのテストクラスです。
 * 
 * @author LDNS 
 */
public class TeikeibunMojiSizeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TeikeibunMojiSize.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TeikeibunMojiSize.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_フォント小を返す() {
        assertThat(TeikeibunMojiSize.toValue(new RString("1")), is(TeikeibunMojiSize.フォント小));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_フォント大を返す() {
        assertThat(TeikeibunMojiSize.toValue(new RString("2")), is(TeikeibunMojiSize.フォント大));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_フォント上小下大を返す() {
        assertThat(TeikeibunMojiSize.toValue(new RString("3")), is(TeikeibunMojiSize.フォント上小下大));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_フォント上大下小を返す() {
        assertThat(TeikeibunMojiSize.toValue(new RString("4")), is(TeikeibunMojiSize.フォント上大下小));
    }

    @Test
    public void フォント小を指定した場合_getコードは_1を返す() {
        assertThat(TeikeibunMojiSize.フォント小.getコード(), is(new RString("1")));
    }

    @Test
    public void フォント大を指定した場合_getコードは_2を返す() {
        assertThat(TeikeibunMojiSize.フォント大.getコード(), is(new RString("2")));
    }

    @Test
    public void フォント上小下大を指定した場合_getコードは_3を返す() {
        assertThat(TeikeibunMojiSize.フォント上小下大.getコード(), is(new RString("3")));
    }

    @Test
    public void フォント上大下小を指定した場合_getコードは_4を返す() {
        assertThat(TeikeibunMojiSize.フォント上大下小.getコード(), is(new RString("4")));
    }

    @Test
    public void フォント小を指定した場合_get名称は_フォント小を返す() {
        assertThat(TeikeibunMojiSize.フォント小.get名称(), is(new RString("フォント小")));
    }

    @Test
    public void フォント大を指定した場合_get名称は_フォント大を返す() {
        assertThat(TeikeibunMojiSize.フォント大.get名称(), is(new RString("フォント大")));
    }

    @Test
    public void フォント上小下大を指定した場合_get名称は_フォント上小下大を返す() {
        assertThat(TeikeibunMojiSize.フォント上小下大.get名称(), is(new RString("フォント上小下大")));
    }

    @Test
    public void フォント上大下小を指定した場合_get名称は_フォント上大下小を返す() {
        assertThat(TeikeibunMojiSize.フォント上大下小.get名称(), is(new RString("フォント上大下小")));
    }

}

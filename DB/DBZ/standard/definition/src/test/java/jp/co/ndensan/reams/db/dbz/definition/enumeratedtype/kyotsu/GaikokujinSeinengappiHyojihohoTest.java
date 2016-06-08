package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 外国人生年月日表示方法のテストクラスです。
 * 
 * @author LDNS 
 */
public class GaikokujinSeinengappiHyojihohoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GaikokujinSeinengappiHyojihoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GaikokujinSeinengappiHyojihoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_和暦表示を返す() {
        assertThat(GaikokujinSeinengappiHyojihoho.toValue(new RString("1")), is(GaikokujinSeinengappiHyojihoho.和暦表示));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_西暦表示を返す() {
        assertThat(GaikokujinSeinengappiHyojihoho.toValue(new RString("2")), is(GaikokujinSeinengappiHyojihoho.西暦表示));
    }

    @Test
    public void 和暦表示を指定した場合_getコードは_1を返す() {
        assertThat(GaikokujinSeinengappiHyojihoho.和暦表示.getコード(), is(new RString("1")));
    }

    @Test
    public void 西暦表示を指定した場合_getコードは_2を返す() {
        assertThat(GaikokujinSeinengappiHyojihoho.西暦表示.getコード(), is(new RString("2")));
    }

    @Test
    public void 和暦表示を指定した場合_get名称は_和暦表示を返す() {
        assertThat(GaikokujinSeinengappiHyojihoho.和暦表示.get名称(), is(new RString("和暦表示")));
    }

    @Test
    public void 西暦表示を指定した場合_get名称は_西暦表示を返す() {
        assertThat(GaikokujinSeinengappiHyojihoho.西暦表示.get名称(), is(new RString("西暦表示")));
    }

}

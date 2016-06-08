package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 外国人氏名表示方法のテストクラスです。
 * 
 * @author LDNS 
 */
public class GaikokujinShimeiHyojihohoTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        GaikokujinShimeiHyojihoho.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        GaikokujinShimeiHyojihoho.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_通称名優先表示を返す() {
        assertThat(GaikokujinShimeiHyojihoho.toValue(new RString("1")), is(GaikokujinShimeiHyojihoho.通称名優先表示));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_正式名表示を返す() {
        assertThat(GaikokujinShimeiHyojihoho.toValue(new RString("2")), is(GaikokujinShimeiHyojihoho.正式名表示));
    }

    @Test
    public void 通称名優先表示を指定した場合_getコードは_1を返す() {
        assertThat(GaikokujinShimeiHyojihoho.通称名優先表示.getコード(), is(new RString("1")));
    }

    @Test
    public void 正式名表示を指定した場合_getコードは_2を返す() {
        assertThat(GaikokujinShimeiHyojihoho.正式名表示.getコード(), is(new RString("2")));
    }

    @Test
    public void 通称名優先表示を指定した場合_get名称は_通称名優先表示を返す() {
        assertThat(GaikokujinShimeiHyojihoho.通称名優先表示.get名称(), is(new RString("通称名優先表示")));
    }

    @Test
    public void 正式名表示を指定した場合_get名称は_正式名表示を返す() {
        assertThat(GaikokujinShimeiHyojihoho.正式名表示.get名称(), is(new RString("正式名表示")));
    }

}

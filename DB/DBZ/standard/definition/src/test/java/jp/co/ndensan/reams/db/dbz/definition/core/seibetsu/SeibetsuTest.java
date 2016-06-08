package jp.co.ndensan.reams.db.dbz.definition.core.seibetsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 性別コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class SeibetsuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        Seibetsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        Seibetsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_男を返す() {
        assertThat(Seibetsu.toValue(new RString("1")), is(Seibetsu.男));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_女を返す() {
        assertThat(Seibetsu.toValue(new RString("2")), is(Seibetsu.女));
    }

    @Test
    public void 男を指定した場合_getコードは_1を返す() {
        assertThat(Seibetsu.男.getコード(), is(new RString("1")));
    }

    @Test
    public void 女を指定した場合_getコードは_2を返す() {
        assertThat(Seibetsu.女.getコード(), is(new RString("2")));
    }

    @Test
    public void 男を指定した場合_get名称は_男を返す() {
        assertThat(Seibetsu.男.get名称(), is(new RString("男")));
    }

    @Test
    public void 女を指定した場合_get名称は_女を返す() {
        assertThat(Seibetsu.女.get名称(), is(new RString("女")));
    }

}

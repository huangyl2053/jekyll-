package jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 徴収方法期別のテストクラスです。
 *
 * @author LDNS
 */
public class ChoshuHohoKibetsuTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChoshuHohoKibetsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChoshuHohoKibetsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特別徴収を返す() {
        assertThat(ChoshuHohoKibetsu.toValue(new RString("1")), is(ChoshuHohoKibetsu.特別徴収));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_普通徴収を返す() {
        assertThat(ChoshuHohoKibetsu.toValue(new RString("2")), is(ChoshuHohoKibetsu.普通徴収));
    }

    @Test
    public void 特別徴収を指定した場合_getコードは_1を返す() {
        assertThat(ChoshuHohoKibetsu.特別徴収.getコード(), is(new RString("1")));
    }

    @Test
    public void 普通徴収を指定した場合_getコードは_2を返す() {
        assertThat(ChoshuHohoKibetsu.普通徴収.getコード(), is(new RString("2")));
    }

    @Test
    public void 特別徴収を指定した場合_get名称は_特別徴収を返す() {
        assertThat(ChoshuHohoKibetsu.特別徴収.get名称(), is(new RString("特別徴収")));
    }

    @Test
    public void 普通徴収を指定した場合_get名称は_普通徴収を返す() {
        assertThat(ChoshuHohoKibetsu.普通徴収.get名称(), is(new RString("普通徴収")));
    }

}

package jp.co.ndensan.reams.db.dbz.definition.core.teikeibun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 定型文区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class TeikeibunKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TeikeibunKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TeikeibunKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_特記事項を返す() {
        assertThat(TeikeibunKubun.toValue(new RString("0")), is(TeikeibunKubun.特記事項));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_特記事項以外を返す() {
        assertThat(TeikeibunKubun.toValue(new RString("1")), is(TeikeibunKubun.特記事項以外));
    }

    @Test
    public void 特記事項を指定した場合_getコードは_0を返す() {
        assertThat(TeikeibunKubun.特記事項.getコード(), is(new RString("0")));
    }

    @Test
    public void 特記事項以外を指定した場合_getコードは_1を返す() {
        assertThat(TeikeibunKubun.特記事項以外.getコード(), is(new RString("1")));
    }

    @Test
    public void 特記事項を指定した場合_get名称は_特記事項を返す() {
        assertThat(TeikeibunKubun.特記事項.get名称(), is(new RString("特記事項")));
    }

    @Test
    public void 特記事項以外を指定した場合_get名称は_特記事項以外を返す() {
        assertThat(TeikeibunKubun.特記事項以外.get名称(), is(new RString("特記事項以外")));
    }

}

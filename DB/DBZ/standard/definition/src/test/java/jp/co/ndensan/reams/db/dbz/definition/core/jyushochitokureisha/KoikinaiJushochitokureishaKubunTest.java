package jp.co.ndensan.reams.db.dbz.definition.core.jyushochitokureisha;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 広域内住所地特例者区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KoikinaiJushochitokureishaKubunTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KoikinaiJushochitokureishaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KoikinaiJushochitokureishaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_広域内住所地特例者を返す() {
        assertThat(KoikinaiJushochitokureishaKubun.toValue(new RString("1")), is(KoikinaiJushochitokureishaKubun.広域内住所地特例者));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_通常資格者を返す() {
        assertThat(KoikinaiJushochitokureishaKubun.toValue(new RString("2")), is(KoikinaiJushochitokureishaKubun.通常資格者));
    }

    @Test
    public void 広域内住所地特例者を指定した場合_getコードは_1を返す() {
        assertThat(KoikinaiJushochitokureishaKubun.広域内住所地特例者.getコード(), is(new RString("1")));
    }

    @Test
    public void 通常資格者を指定した場合_getコードは_2を返す() {
        assertThat(KoikinaiJushochitokureishaKubun.通常資格者.getコード(), is(new RString("2")));
    }

    @Test
    public void 広域内住所地特例者を指定した場合_get名称は_広域内住所地特例者を返す() {
        assertThat(KoikinaiJushochitokureishaKubun.広域内住所地特例者.get名称(), is(new RString("広域内住所地特例者")));
    }

    @Test
    public void 通常資格者を指定した場合_get名称は_通常資格者を返す() {
        assertThat(KoikinaiJushochitokureishaKubun.通常資格者.get名称(), is(new RString("通常資格者")));
    }

}

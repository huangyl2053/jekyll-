package jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 旧措置者区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KyuSochishaKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KyuSochishaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KyuSochishaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_空白を返す() {
        assertThat(KyuSochishaKubun.toValue(new RString("0")), is(KyuSochishaKubun.空白));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_旧措置を返す() {
        assertThat(KyuSochishaKubun.toValue(new RString("1")), is(KyuSochishaKubun.旧措置));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_負担段階を返す() {
        assertThat(KyuSochishaKubun.toValue(new RString("2")), is(KyuSochishaKubun.負担段階));
    }

    @Test
    public void 空白を指定した場合_getコードは_0を返す() {
        assertThat(KyuSochishaKubun.空白.getコード(), is(new RString("0")));
    }

    @Test
    public void 旧措置を指定した場合_getコードは_1を返す() {
        assertThat(KyuSochishaKubun.旧措置.getコード(), is(new RString("1")));
    }

    @Test
    public void 負担段階を指定した場合_getコードは_2を返す() {
        assertThat(KyuSochishaKubun.負担段階.getコード(), is(new RString("2")));
    }

    @Test
    public void 空白を指定した場合_get名称は_空白を返す() {
        assertThat(KyuSochishaKubun.空白.get名称(), is(new RString("空白")));
    }

    @Test
    public void 旧措置を指定した場合_get名称は_旧措置を返す() {
        assertThat(KyuSochishaKubun.旧措置.get名称(), is(new RString("旧措置")));
    }

    @Test
    public void 負担段階を指定した場合_get名称は_負担段階を返す() {
        assertThat(KyuSochishaKubun.負担段階.get名称(), is(new RString("負担段階")));
    }

}

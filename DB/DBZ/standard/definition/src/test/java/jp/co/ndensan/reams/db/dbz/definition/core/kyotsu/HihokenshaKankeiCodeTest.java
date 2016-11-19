package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 被保険者との関係コードのテストクラスです。
 * 
 * @author LDNS 
 */
public class HihokenshaKankeiCodeTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HihokenshaKankeiCode.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HihokenshaKankeiCode.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_審査請求人を返す() {
        assertThat(HihokenshaKankeiCode.toValue(new RString("1")), is(HihokenshaKankeiCode.本人));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_代理人を返す() {
        assertThat(HihokenshaKankeiCode.toValue(new RString("2")), is(HihokenshaKankeiCode.家族));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_総代を返す() {
        assertThat(HihokenshaKankeiCode.toValue(new RString("3")), is(HihokenshaKankeiCode.代理人));
    }

    @Test
    public void 審査請求人を指定した場合_getコードは_1を返す() {
        assertThat(HihokenshaKankeiCode.本人.getコード(), is(new RString("1")));
    }

    @Test
    public void 代理人を指定した場合_getコードは_2を返す() {
        assertThat(HihokenshaKankeiCode.家族.getコード(), is(new RString("2")));
    }

    @Test
    public void 総代を指定した場合_getコードは_3を返す() {
        assertThat(HihokenshaKankeiCode.代理人.getコード(), is(new RString("3")));
    }

    @Test
    public void 審査請求人を指定した場合_get名称は_審査請求人を返す() {
        assertThat(HihokenshaKankeiCode.本人.get名称(), is(new RString("本人")));
    }

    @Test
    public void 代理人を指定した場合_get名称は_代理人を返す() {
        assertThat(HihokenshaKankeiCode.家族.get名称(), is(new RString("家族")));
    }

    @Test
    public void 総代を指定した場合_get名称は_総代を返す() {
        assertThat(HihokenshaKankeiCode.代理人.get名称(), is(new RString("代理人")));
    }

}

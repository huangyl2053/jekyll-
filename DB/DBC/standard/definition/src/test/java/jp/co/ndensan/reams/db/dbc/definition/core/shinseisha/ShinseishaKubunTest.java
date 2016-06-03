package jp.co.ndensan.reams.db.dbc.definition.core.shinseisha;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 申請者区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ShinseishaKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ShinseishaKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ShinseishaKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_本人を返す() {
        assertThat(ShinseishaKubun.toValue(new RString("1")), is(ShinseishaKubun.本人));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_代理人を返す() {
        assertThat(ShinseishaKubun.toValue(new RString("2")), is(ShinseishaKubun.代理人));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_受領委任事業者を返す() {
        assertThat(ShinseishaKubun.toValue(new RString("3")), is(ShinseishaKubun.受領委任事業者));
    }

    @Test
    public void 本人を指定した場合_getコードは_1を返す() {
        assertThat(ShinseishaKubun.本人.getコード(), is(new RString("1")));
    }

    @Test
    public void 代理人を指定した場合_getコードは_2を返す() {
        assertThat(ShinseishaKubun.代理人.getコード(), is(new RString("2")));
    }

    @Test
    public void 受領委任事業者を指定した場合_getコードは_3を返す() {
        assertThat(ShinseishaKubun.受領委任事業者.getコード(), is(new RString("3")));
    }

    @Test
    public void 本人を指定した場合_get名称は_本人を返す() {
        assertThat(ShinseishaKubun.本人.get名称(), is(new RString("本人")));
    }

    @Test
    public void 代理人を指定した場合_get名称は_代理人を返す() {
        assertThat(ShinseishaKubun.代理人.get名称(), is(new RString("代理人")));
    }

    @Test
    public void 受領委任事業者を指定した場合_get名称は_受領委任事業者を返す() {
        assertThat(ShinseishaKubun.受領委任事業者.get名称(), is(new RString("受領委任事業者")));
    }

}

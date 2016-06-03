package jp.co.ndensan.reams.db.dbc.definition.core.kozabunrui;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 口座分類区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KozaBunruiKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KozaBunruiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KozaBunruiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_償還払い支給を返す() {
        assertThat(KozaBunruiKubun.toValue(new RString("1")), is(KozaBunruiKubun.償還払い支給));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_高額介護サービス費支給を返す() {
        assertThat(KozaBunruiKubun.toValue(new RString("2")), is(KozaBunruiKubun.高額介護サービス費支給));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_高額合算費支給を返す() {
        assertThat(KozaBunruiKubun.toValue(new RString("3")), is(KozaBunruiKubun.高額合算費支給));
    }

    @Test
    public void 償還払い支給を指定した場合_getコードは_1を返す() {
        assertThat(KozaBunruiKubun.償還払い支給.getコード(), is(new RString("1")));
    }

    @Test
    public void 高額介護サービス費支給を指定した場合_getコードは_2を返す() {
        assertThat(KozaBunruiKubun.高額介護サービス費支給.getコード(), is(new RString("2")));
    }

    @Test
    public void 高額合算費支給を指定した場合_getコードは_3を返す() {
        assertThat(KozaBunruiKubun.高額合算費支給.getコード(), is(new RString("3")));
    }

    @Test
    public void 償還払い支給を指定した場合_get名称は_償還払い支給を返す() {
        assertThat(KozaBunruiKubun.償還払い支給.get名称(), is(new RString("償還払い支給")));
    }

    @Test
    public void 高額介護サービス費支給を指定した場合_get名称は_高額介護サービス費支給を返す() {
        assertThat(KozaBunruiKubun.高額介護サービス費支給.get名称(), is(new RString("高額介護サービス費支給")));
    }

    @Test
    public void 高額合算費支給を指定した場合_get名称は_高額合算費支給を返す() {
        assertThat(KozaBunruiKubun.高額合算費支給.get名称(), is(new RString("高額合算費支給")));
    }

}

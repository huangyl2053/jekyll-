package jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 給付実績区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class KyufuJissekiKubunTest extends DbcTestBase{

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KyufuJissekiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KyufuJissekiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_現物を返す() {
        assertThat(KyufuJissekiKubun.toValue(new RString("1")), is(KyufuJissekiKubun.現物));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_償還を返す() {
        assertThat(KyufuJissekiKubun.toValue(new RString("2")), is(KyufuJissekiKubun.償還));
    }

    @Test
    public void 現物を指定した場合_getコードは_1を返す() {
        assertThat(KyufuJissekiKubun.現物.getコード(), is(new RString("1")));
    }

    @Test
    public void 償還を指定した場合_getコードは_2を返す() {
        assertThat(KyufuJissekiKubun.償還.getコード(), is(new RString("2")));
    }

    @Test
    public void 現物を指定した場合_get名称は_現物を返す() {
        assertThat(KyufuJissekiKubun.現物.get名称(), is(new RString("現物")));
    }

    @Test
    public void 償還を指定した場合_get名称は_償還を返す() {
        assertThat(KyufuJissekiKubun.償還.get名称(), is(new RString("償還")));
    }

}

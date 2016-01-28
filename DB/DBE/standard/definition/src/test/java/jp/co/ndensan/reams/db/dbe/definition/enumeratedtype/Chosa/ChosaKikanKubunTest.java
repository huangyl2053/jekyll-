package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 機関の区分のテストクラスです。
 * 
 * @author LDNS 
 */
public class ChosaKikanKubunTest extends DbeTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        ChosaKikanKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        ChosaKikanKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に0を指定した場合_toValueは_非調査機関を返す() {
        assertThat(ChosaKikanKubun.toValue(new RString("0")), is(ChosaKikanKubun.非調査機関));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_調査機関を返す() {
        assertThat(ChosaKikanKubun.toValue(new RString("1")), is(ChosaKikanKubun.調査機関));
    }

    @Test
    public void 非調査機関を指定した場合_getコードは_0を返す() {
        assertThat(ChosaKikanKubun.非調査機関.getコード(), is(new RString("0")));
    }

    @Test
    public void 調査機関を指定した場合_getコードは_1を返す() {
        assertThat(ChosaKikanKubun.調査機関.getコード(), is(new RString("1")));
    }

    @Test
    public void 非調査機関を指定した場合_get名称は_非調査機関を返す() {
        assertThat(ChosaKikanKubun.非調査機関.get名称(), is(new RString("非調査機関")));
    }

    @Test
    public void 調査機関を指定した場合_get名称は_調査機関を返す() {
        assertThat(ChosaKikanKubun.調査機関.get名称(), is(new RString("調査機関")));
    }

}

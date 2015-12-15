package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * みなし2号等対象フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsminashiNigoEtcTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_対象を返す() {
        assertThat(IsminashiNigoEtc.toValue(true), is(IsminashiNigoEtc.対象));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_対象外を返す() {
        assertThat(IsminashiNigoEtc.toValue(false), is(IsminashiNigoEtc.対象外));
    }

    @Test
    public void 対象を指定した場合_getコードは_Trueを返す() {
        assertThat(IsminashiNigoEtc.対象.getコード(), is(true));
    }

    @Test
    public void 対象外を指定した場合_getコードは_Falseを返す() {
        assertThat(IsminashiNigoEtc.対象外.getコード(), is(false));
    }

    @Test
    public void 対象を指定した場合_get名称は_対象を返す() {
        assertThat(IsminashiNigoEtc.対象.get名称(), is(new RString("対象")));
    }

    @Test
    public void 対象外を指定した場合_get名称は_対象外を返す() {
        assertThat(IsminashiNigoEtc.対象外.get名称(), is(new RString("対象外")));
    }

}

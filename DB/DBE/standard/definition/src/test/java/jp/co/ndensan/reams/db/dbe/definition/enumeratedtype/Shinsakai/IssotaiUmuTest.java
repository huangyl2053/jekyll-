package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 委員早退有無のテストクラスです。
 *
 * @author LDNS
 */
public class IssotaiUmuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_早退を返す() {
        assertThat(IssotaiUmu.toValue(true), is(IssotaiUmu.早退));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_早退なしを返す() {
        assertThat(IssotaiUmu.toValue(false), is(IssotaiUmu.早退なし));
    }

    @Test
    public void 早退を指定した場合_getコードは_Trueを返す() {
        assertThat(IssotaiUmu.早退.getコード(), is(true));
    }

    @Test
    public void 早退なしを指定した場合_getコードは_Falseを返す() {
        assertThat(IssotaiUmu.早退なし.getコード(), is(false));
    }

    @Test
    public void 早退を指定した場合_get名称は_早退を返す() {
        assertThat(IssotaiUmu.早退.get名称(), is(new RString("早退")));
    }

    @Test
    public void 早退なしを指定した場合_get名称は_早退なしを返す() {
        assertThat(IssotaiUmu.早退なし.get名称(), is(new RString("早退なし")));
    }

}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 意見書同意フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsIkenshoDoiUmuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_しないするを返す() {
        assertThat(IsIkenshoDoiUmu.toValue(true), is(IsIkenshoDoiUmu.しないする));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_するしないを返す() {
        assertThat(IsIkenshoDoiUmu.toValue(false), is(IsIkenshoDoiUmu.するしない));
    }

    @Test
    public void しないするを指定した場合_getコードは_Trueを返す() {
        assertThat(IsIkenshoDoiUmu.しないする.getコード(), is(true));
    }

    @Test
    public void するしないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsIkenshoDoiUmu.するしない.getコード(), is(false));
    }

    @Test
    public void しないするを指定した場合_get名称は_しないするを返す() {
        assertThat(IsIkenshoDoiUmu.しないする.get名称(), is(new RString("しないする")));
    }

    @Test
    public void するしないを指定した場合_get名称は_するしないを返す() {
        assertThat(IsIkenshoDoiUmu.するしない.get名称(), is(new RString("するしない")));
    }

}

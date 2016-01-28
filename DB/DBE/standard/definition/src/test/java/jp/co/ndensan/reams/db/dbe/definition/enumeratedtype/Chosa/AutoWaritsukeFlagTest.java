package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 自動割付フラグのテストクラスです。
 *
 * @author LDNS
 */
public class AutoWaritsukeFlagTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_自動割付可能を返す() {
        assertThat(AutoWaritsukeFlag.toValue(true), is(AutoWaritsukeFlag.自動割付可能));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_自動割付不可能を返す() {
        assertThat(AutoWaritsukeFlag.toValue(false), is(AutoWaritsukeFlag.自動割付不可能));
    }

    @Test
    public void 自動割付可能を指定した場合_getコードは_Trueを返す() {
        assertThat(AutoWaritsukeFlag.自動割付可能.getコード(), is(true));
    }

    @Test
    public void 自動割付不可能を指定した場合_getコードは_Falseを返す() {
        assertThat(AutoWaritsukeFlag.自動割付不可能.getコード(), is(false));
    }

    @Test
    public void 自動割付可能を指定した場合_get名称は_自動割付可能を返す() {
        assertThat(AutoWaritsukeFlag.自動割付可能.get名称(), is(new RString("自動割付可能")));
    }

    @Test
    public void 自動割付不可能を指定した場合_get名称は_自動割付不可能を返す() {
        assertThat(AutoWaritsukeFlag.自動割付不可能.get名称(), is(new RString("自動割付不可能")));
    }

}

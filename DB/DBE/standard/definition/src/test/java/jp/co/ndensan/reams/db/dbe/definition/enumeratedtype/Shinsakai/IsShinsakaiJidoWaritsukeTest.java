package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査会自動割付フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsShinsakaiJidoWaritsukeTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_自動を返す() {
        assertThat(IsShinsakaiJidoWaritsuke.toValue(true), is(IsShinsakaiJidoWaritsuke.自動));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_手動を返す() {
        assertThat(IsShinsakaiJidoWaritsuke.toValue(false), is(IsShinsakaiJidoWaritsuke.手動));
    }

    @Test
    public void 自動を指定した場合_getコードは_Trueを返す() {
        assertThat(IsShinsakaiJidoWaritsuke.自動.getコード(), is(true));
    }

    @Test
    public void 手動を指定した場合_getコードは_Falseを返す() {
        assertThat(IsShinsakaiJidoWaritsuke.手動.getコード(), is(false));
    }

    @Test
    public void 自動を指定した場合_get名称は_自動を返す() {
        assertThat(IsShinsakaiJidoWaritsuke.自動.get名称(), is(new RString("自動")));
    }

    @Test
    public void 手動を指定した場合_get名称は_手動を返す() {
        assertThat(IsShinsakaiJidoWaritsuke.手動.get名称(), is(new RString("手動")));
    }

}

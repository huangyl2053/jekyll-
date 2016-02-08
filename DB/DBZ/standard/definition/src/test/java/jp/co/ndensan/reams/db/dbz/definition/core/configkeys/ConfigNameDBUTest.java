package jp.co.ndensan.reams.db.dbz.definition.core.configkeys;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * コンフィグ名称(DBU)のテストクラスです。
 *
 * @author LDNS
 */
public class ConfigNameDBUTest extends DbzTestBase {

    @Test
    public void 保険者情報_保険者構成を指定した場合_get名称は_保険者情報_保険者構成を返す() {
        assertThat(ConfigNameDBU.保険者情報_保険者構成.get名称(), is(new RString("保険者情報_保険者構成")));
    }

    @Test
    public void 合併情報管理_合併情報区分を指定した場合_get名称は_合併情報管理_合併情報区分を返す() {
        assertThat(ConfigNameDBU.合併情報管理_合併情報区分.get名称(), is(new RString("合併情報管理_合併情報区分")));
    }

}

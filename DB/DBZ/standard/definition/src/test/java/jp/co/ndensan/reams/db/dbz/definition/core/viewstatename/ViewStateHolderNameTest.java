package jp.co.ndensan.reams.db.dbz.definition.core.viewstatename;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * ViewStateHolder名称のテストクラスです。
 *
 * @author LDNS
 */
public class ViewStateHolderNameTest extends DbzTestBase {

    @Test
    public void 国保連取込情報を指定した場合_get名称は_国保連取込情報を返す() {
        assertThat(ViewStateHolderName.国保連取込情報.get名称(), is(new RString("国保連取込情報")));
    }

}

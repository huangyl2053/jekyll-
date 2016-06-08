package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 連携エンコーディングのテストクラスです。
 *
 * @author LDNS
 */
public class RenkeiEncodingTest extends DbzTestBase {

    @Test
    public void Shift_Jisを指定した場合_get名称は_Shift_Jisを返す() {
        assertThat(RenkeiEncoding.Shift_Jis.get名称(), is(new RString("Shift-Jis")));
    }

    @Test
    public void Unicodeを指定した場合_get名称は_Unicodeを返す() {
        assertThat(RenkeiEncoding.Unicode.get名称(), is(new RString("Unicode")));
    }

    @Test
    public void UTF_7を指定した場合_get名称は_UTF_7を返す() {
        assertThat(RenkeiEncoding.UTF_7.get名称(), is(new RString("UTF-7")));
    }

    @Test
    public void UTF_8を指定した場合_get名称は_UTF_8を返す() {
        assertThat(RenkeiEncoding.UTF_8.get名称(), is(new RString("UTF-8")));
    }

}

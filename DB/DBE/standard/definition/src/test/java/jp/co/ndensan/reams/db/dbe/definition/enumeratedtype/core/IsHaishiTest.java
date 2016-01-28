package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 廃止フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsHaishiTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_廃止を返す() {
        assertThat(IsHaishi.toValue(true), is(IsHaishi.廃止));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_廃止されていないを返す() {
        assertThat(IsHaishi.toValue(false), is(IsHaishi.廃止されていない));
    }

    @Test
    public void 廃止を指定した場合_getコードは_Trueを返す() {
        assertThat(IsHaishi.廃止.getコード(), is(true));
    }

    @Test
    public void 廃止されていないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsHaishi.廃止されていない.getコード(), is(false));
    }

    @Test
    public void 廃止を指定した場合_get名称は_廃止を返す() {
        assertThat(IsHaishi.廃止.get名称(), is(new RString("廃止")));
    }

    @Test
    public void 廃止されていないを指定した場合_get名称は_廃止されていないを返す() {
        assertThat(IsHaishi.廃止されていない.get名称(), is(new RString("廃止されていない")));
    }

}

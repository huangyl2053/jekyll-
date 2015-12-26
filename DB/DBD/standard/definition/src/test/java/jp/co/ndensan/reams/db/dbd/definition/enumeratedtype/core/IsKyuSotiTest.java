package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 旧措置適用フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsKyuSotiTest extends DbdTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_旧措置適用を返す() {
        assertThat(IsKyuSoti.toValue(true), is(IsKyuSoti.旧措置適用));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_適用外を返す() {
        assertThat(IsKyuSoti.toValue(false), is(IsKyuSoti.適用外));
    }

    @Test
    public void 旧措置適用を指定した場合_getコードは_Trueを返す() {
        assertThat(IsKyuSoti.旧措置適用.getコード(), is(true));
    }

    @Test
    public void 適用外を指定した場合_getコードは_Falseを返す() {
        assertThat(IsKyuSoti.適用外.getコード(), is(false));
    }

    @Test
    public void 旧措置適用を指定した場合_get名称は_旧措置適用を返す() {
        assertThat(IsKyuSoti.旧措置適用.get名称(), is(new RString("旧措置適用")));
    }

    @Test
    public void 適用外を指定した場合_get名称は_適用外を返す() {
        assertThat(IsKyuSoti.適用外.get名称(), is(new RString("適用外")));
    }

}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 施設入所の有無のテストクラスです。
 *
 * @author LDNS
 */
public class IsExistShisetsuNyushoTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_入所しているを返す() {
        assertThat(IsExistShisetsuNyusho.toValue(true), is(IsExistShisetsuNyusho.入所している));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_入所していないを返す() {
        assertThat(IsExistShisetsuNyusho.toValue(false), is(IsExistShisetsuNyusho.入所していない));
    }

    @Test
    public void 入所しているを指定した場合_getコードは_Trueを返す() {
        assertThat(IsExistShisetsuNyusho.入所している.getコード(), is(true));
    }

    @Test
    public void 入所していないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsExistShisetsuNyusho.入所していない.getコード(), is(false));
    }

    @Test
    public void 入所しているを指定した場合_get名称は_入所しているを返す() {
        assertThat(IsExistShisetsuNyusho.入所している.get名称(), is(new RString("入所している")));
    }

    @Test
    public void 入所していないを指定した場合_get名称は_入所していないを返す() {
        assertThat(IsExistShisetsuNyusho.入所していない.get名称(), is(new RString("入所していない")));
    }

}

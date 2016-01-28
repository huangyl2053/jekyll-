package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 主たる原因疾患のテストクラスです。
 *
 * @author LDNS
 */
public class IsShutaruGeninShikkanTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_主たる原因を返す() {
        assertThat(IsShutaruGeninShikkan.toValue(true), is(IsShutaruGeninShikkan.主たる原因));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_主たる原因ではないを返す() {
        assertThat(IsShutaruGeninShikkan.toValue(false), is(IsShutaruGeninShikkan.主たる原因ではない));
    }

    @Test
    public void 主たる原因を指定した場合_getコードは_Trueを返す() {
        assertThat(IsShutaruGeninShikkan.主たる原因.getコード(), is(true));
    }

    @Test
    public void 主たる原因ではないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsShutaruGeninShikkan.主たる原因ではない.getコード(), is(false));
    }

    @Test
    public void 主たる原因を指定した場合_get名称は_主たる原因を返す() {
        assertThat(IsShutaruGeninShikkan.主たる原因.get名称(), is(new RString("主たる原因")));
    }

    @Test
    public void 主たる原因ではないを指定した場合_get名称は_主たる原因ではないを返す() {
        assertThat(IsShutaruGeninShikkan.主たる原因ではない.get名称(), is(new RString("主たる原因ではない")));
    }

}

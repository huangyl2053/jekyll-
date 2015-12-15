package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 審査継続区分のテストクラスです。
 *
 * @author LDNS
 */
public class IsShinsaKeizokuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_継続するを返す() {
        assertThat(IsShinsaKeizoku.toValue(true), is(IsShinsaKeizoku.継続する));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_継続しないを返す() {
        assertThat(IsShinsaKeizoku.toValue(false), is(IsShinsaKeizoku.継続しない));
    }

    @Test
    public void 継続するを指定した場合_getコードは_Trueを返す() {
        assertThat(IsShinsaKeizoku.継続する.getコード(), is(true));
    }

    @Test
    public void 継続しないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsShinsaKeizoku.継続しない.getコード(), is(false));
    }

    @Test
    public void 継続するを指定した場合_get名称は_継続するを返す() {
        assertThat(IsShinsaKeizoku.継続する.get名称(), is(new RString("継続する")));
    }

    @Test
    public void 継続しないを指定した場合_get名称は_継続しないを返す() {
        assertThat(IsShinsaKeizoku.継続しない.get名称(), is(new RString("継続しない")));
    }

}

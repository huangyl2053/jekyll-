package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * サービス種類の有無のテストクラスです。
 *
 * @author LDNS
 */
public class IsExistServiseShuruiTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_であるを返す() {
        assertThat(IsExistServiseShurui.toValue(true), is(IsExistServiseShurui.である));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_でないを返す() {
        assertThat(IsExistServiseShurui.toValue(false), is(IsExistServiseShurui.でない));
    }

    @Test
    public void であるを指定した場合_getコードは_Trueを返す() {
        assertThat(IsExistServiseShurui.である.getコード(), is(true));
    }

    @Test
    public void でないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsExistServiseShurui.でない.getコード(), is(false));
    }

    @Test
    public void であるを指定した場合_get名称は_であるを返す() {
        assertThat(IsExistServiseShurui.である.get名称(), is(new RString("である")));
    }

    @Test
    public void でないを指定した場合_get名称は_でないを返す() {
        assertThat(IsExistServiseShurui.でない.get名称(), is(new RString("でない")));
    }

}

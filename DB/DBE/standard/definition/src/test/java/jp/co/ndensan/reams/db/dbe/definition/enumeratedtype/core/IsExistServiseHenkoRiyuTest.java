package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * サービス変更理由の有無のテストクラスです。
 *
 * @author LDNS
 */
public class IsExistServiseHenkoRiyuTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_であるを返す() {
        assertThat(IsExistServiseHenkoRiyu.toValue(true), is(IsExistServiseHenkoRiyu.である));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_でないを返す() {
        assertThat(IsExistServiseHenkoRiyu.toValue(false), is(IsExistServiseHenkoRiyu.でない));
    }

    @Test
    public void であるを指定した場合_getコードは_Trueを返す() {
        assertThat(IsExistServiseHenkoRiyu.である.getコード(), is(true));
    }

    @Test
    public void でないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsExistServiseHenkoRiyu.でない.getコード(), is(false));
    }

    @Test
    public void であるを指定した場合_get名称は_であるを返す() {
        assertThat(IsExistServiseHenkoRiyu.である.get名称(), is(new RString("である")));
    }

    @Test
    public void でないを指定した場合_get名称は_でないを返す() {
        assertThat(IsExistServiseHenkoRiyu.でない.get名称(), is(new RString("でない")));
    }

}

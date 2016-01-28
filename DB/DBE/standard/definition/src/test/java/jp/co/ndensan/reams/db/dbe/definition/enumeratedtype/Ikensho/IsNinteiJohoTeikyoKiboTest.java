package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認定情報提供希望フラグのテストクラスです。
 *
 * @author LDNS
 */
public class IsNinteiJohoTeikyoKiboTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_希望するを返す() {
        assertThat(IsNinteiJohoTeikyoKibo.toValue(true), is(IsNinteiJohoTeikyoKibo.希望する));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_希望しないを返す() {
        assertThat(IsNinteiJohoTeikyoKibo.toValue(false), is(IsNinteiJohoTeikyoKibo.希望しない));
    }

    @Test
    public void 希望するを指定した場合_getコードは_Trueを返す() {
        assertThat(IsNinteiJohoTeikyoKibo.希望する.getコード(), is(true));
    }

    @Test
    public void 希望しないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsNinteiJohoTeikyoKibo.希望しない.getコード(), is(false));
    }

    @Test
    public void 希望するを指定した場合_get名称は_希望するを返す() {
        assertThat(IsNinteiJohoTeikyoKibo.希望する.get名称(), is(new RString("希望する")));
    }

    @Test
    public void 希望しないを指定した場合_get名称は_希望しないを返す() {
        assertThat(IsNinteiJohoTeikyoKibo.希望しない.get名称(), is(new RString("希望しない")));
    }

}

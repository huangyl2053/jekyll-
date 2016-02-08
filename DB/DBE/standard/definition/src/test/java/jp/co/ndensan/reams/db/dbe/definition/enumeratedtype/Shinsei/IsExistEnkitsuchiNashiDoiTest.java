package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 認定延期通知発行しないことに対する同意有無のテストクラスです。
 *
 * @author LDNS
 */
public class IsExistEnkitsuchiNashiDoiTest extends DbeTestBase {

    @Test
    public void 引数にTrueを指定した場合_toValueは_同意するを返す() {
        assertThat(IsExistEnkitsuchiNashiDoi.toValue(true), is(IsExistEnkitsuchiNashiDoi.同意する));
    }

    @Test
    public void 引数にFalseを指定した場合_toValueは_同意しないを返す() {
        assertThat(IsExistEnkitsuchiNashiDoi.toValue(false), is(IsExistEnkitsuchiNashiDoi.同意しない));
    }

    @Test
    public void 同意するを指定した場合_getコードは_Trueを返す() {
        assertThat(IsExistEnkitsuchiNashiDoi.同意する.getコード(), is(true));
    }

    @Test
    public void 同意しないを指定した場合_getコードは_Falseを返す() {
        assertThat(IsExistEnkitsuchiNashiDoi.同意しない.getコード(), is(false));
    }

    @Test
    public void 同意するを指定した場合_get名称は_同意するを返す() {
        assertThat(IsExistEnkitsuchiNashiDoi.同意する.get名称(), is(new RString("同意する")));
    }

    @Test
    public void 同意しないを指定した場合_get名称は_同意しないを返す() {
        assertThat(IsExistEnkitsuchiNashiDoi.同意しない.get名称(), is(new RString("同意しない")));
    }

}

package jp.co.ndensan.reams.db.dbz.definition.core.sortjun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * ソート順のテストクラスです。
 *
 * @author LDNS
 */
public class SortOrderTest extends DbzTestBase {

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        SortOrder.toValue(99999);
    }

    @Test
    public void 引数に1を指定した場合_toValueは_ASCを返す() {
        assertThat(SortOrder.toValue(1), is(SortOrder.ASC));
    }

    @Test
    public void 引数にマイナス1を指定した場合_toValueは_DESCを返す() {
        assertThat(SortOrder.toValue(-1), is(SortOrder.DESC));
    }

    @Test
    public void ASCを指定した場合_getコードは_1を返す() {
        assertThat(SortOrder.ASC.getコード(), is(1));
    }

    @Test
    public void DESCを指定した場合_getコードは_マイナス1を返す() {
        assertThat(SortOrder.DESC.getコード(), is(-1));
    }

    @Test
    public void ASCを指定した場合_get名称は_ASCを返す() {
        assertThat(SortOrder.ASC.get名称(), is(new RString("ASC")));
    }

    @Test
    public void DESCを指定した場合_get名称は_DESCを返す() {
        assertThat(SortOrder.DESC.get名称(), is(new RString("DESC")));
    }

}

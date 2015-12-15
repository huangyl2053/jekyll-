package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 検索条件区分のテストクラスです。
 *
 * @author LDNS
 */
public class SearchJokenKubunTest extends DbzTestBase {

    @Test
    public void 前方一致を指定した場合_get名称は_前方一致を返す() {
        assertThat(SearchJokenKubun.前方一致.get名称(), is(new RString("前方一致")));
    }

    @Test
    public void 完全一致を指定した場合_get名称は_完全一致を返す() {
        assertThat(SearchJokenKubun.完全一致.get名称(), is(new RString("完全一致")));
    }

}

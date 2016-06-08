package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 出納整理対象年度のテストクラスです。
 *
 * @author LDNS
 */
public class SuitoSeiriTaishoNendoTest extends DbbTestBase {

    @Test
    public void 現年度_増額減額を指定した場合_get名称は_現年度_増額減額を返す() {
        assertThat(SuitoSeiriTaishoNendo.現年度_増額減額.get名称(), is(new RString("現年度_増額減額")));
    }

    @Test
    public void 現年度_減額のみを指定した場合_get名称は_現年度_減額のみを返す() {
        assertThat(SuitoSeiriTaishoNendo.現年度_減額のみ.get名称(), is(new RString("現年度_減額のみ")));
    }

    @Test
    public void 過年度_増額減額を指定した場合_get名称は_過年度_増額減額を返す() {
        assertThat(SuitoSeiriTaishoNendo.過年度_増額減額.get名称(), is(new RString("過年度_増額減額")));
    }

}

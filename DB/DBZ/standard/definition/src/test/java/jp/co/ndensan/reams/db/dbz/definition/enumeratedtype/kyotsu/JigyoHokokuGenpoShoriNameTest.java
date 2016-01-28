package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事業報告月報処理名のテストクラスです。
 *
 * @author LDNS
 */
public class JigyoHokokuGenpoShoriNameTest extends DbzTestBase {

    @Test
    public void 事業状況報告資料_月報_作成一般状況１_１１を指定した場合_get名称は_事業状況報告資料_月報_作成一般状況１_１１を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成一般状況１_１１.get名称(), is(new RString("事業状況報告資料（月報）作成 一般状況１～１１")));
    }

    @Test
    public void 事業状況報告資料_月報_作成一般状況１２_１４現物分を指定した場合_get名称は_事業状況報告資料_月報_作成一般状況１２_１４現物分を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成一般状況１２_１４_現物分.get名称(), is(new RString("事業状況報告資料（月報）作成 一般状況１２～１４【現物分】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成一般状況１２_１４償還分_審査年月を指定した場合_get名称は_事業状況報告資料_月報_作成一般状況１２_１４償還分_審査年月を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成一般状況１２_１４_償還分_審査年月.get名称(), is(new RString("事業状況報告資料（月報）作成 一般状況１２～１４【償還分_審査年月】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成一般状況１２_１４償還分_決定年月を指定した場合_get名称は_事業状況報告資料_月報_作成一般状況１２_１４償還分_決定年月を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成一般状況１２_１４_償還分_決定年月.get名称(), is(new RString("事業状況報告資料（月報）作成 一般状況１２～１４【償還分_決定年月】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成保険給付決定状況現物分を指定した場合_get名称は_事業状況報告資料_月報_作成保険給付決定状況現物分を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成保険給付決定状況_現物分.get名称(), is(new RString("事業状況報告資料（月報）作成 保険給付決定状況【現物分】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成保険給付決定状況償還分_審査年月を指定した場合_get名称は_事業状況報告資料_月報_作成保険給付決定状況償還分_審査年月を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成保険給付決定状況_償還分_審査年月.get名称(), is(new RString("事業状況報告資料（月報）作成 保険給付決定状況【償還分_審査年月】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成保険給付決定状況償還分_決定年月を指定した場合_get名称は_事業状況報告資料_月報_作成保険給付決定状況償還分_決定年月を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成保険給付決定状況_償還分_決定年月.get名称(), is(new RString("事業状況報告資料（月報）作成 保険給付決定状況【償還分_決定年月】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成保険給付決定状況高額分を指定した場合_get名称は_事業状況報告資料_月報_作成保険給付決定状況高額分を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成保険給付決定状況_高額分.get名称(), is(new RString("事業状況報告資料（月報）作成 保険給付決定状況【高額分】")));
    }

    @Test
    public void 事業状況報告資料_月報_作成保険給付決定状況高額合算分を指定した場合_get名称は_事業状況報告資料_月報_作成保険給付決定状況高額合算分を返す() {
        assertThat(JigyoHokokuGenpoShoriName.事業状況報告資料_月報_作成保険給付決定状況_高額合算分.get名称(), is(new RString("事業状況報告資料（月報）作成 保険給付決定状況【高額合算分】")));
    }

}

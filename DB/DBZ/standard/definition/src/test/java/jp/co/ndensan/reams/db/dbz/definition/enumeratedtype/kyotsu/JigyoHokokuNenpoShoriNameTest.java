package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 事業報告年報処理名のテストクラスです。
 *
 * @author LDNS
 */
public class JigyoHokokuNenpoShoriNameTest extends DbzTestBase {

    @Test
    public void 事業状況報告資料_年報_作成一般状況１_４を指定した場合_get名称は_事業状況報告資料_年報_作成一般状況１_４を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成一般状況１_４.get名称(), is(new RString("事業状況報告資料（年報）作成 一般状況１～４")));
    }

    @Test
    public void 事業状況報告資料_年報_作成一般状況５_１１を指定した場合_get名称は_事業状況報告資料_年報_作成一般状況５_１１を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成一般状況５_１１.get名称(), is(new RString("事業状況報告資料（年報）作成 一般状況５～１１")));
    }

    @Test
    public void 事業状況報告資料_年報_作成一般状況１２_１４現物分を指定した場合_get名称は_事業状況報告資料_年報_作成一般状況１２_１４現物分を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成一般状況１２_１４現物分.get名称(), is(new RString("事業状況報告資料（年報）作成 一般状況１２～１４【現物分】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成一般状況１２_１４償還分_審査年月を指定した場合_get名称は_事業状況報告資料_年報_作成一般状況１２_１４償還分_審査年月を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成一般状況１２_１４償還分_審査年月.get名称(), is(new RString("事業状況報告資料（年報）作成 一般状況１２～１４【償還分_審査年月】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成一般状況１２_１４還分_決定年月を指定した場合_get名称は_事業状況報告資料_年報_作成一般状況１２_１４償還分_決定年月を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成一般状況１２_１４償還分_決定年月.get名称(), is(new RString("事業状況報告資料（年報）作成 一般状況１２～１４【償還分_決定年月】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成保険給付決定状況現物分を指定した場合_get名称は_事業状況報告資料_年報_作成保険給付決定状況現物分を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成保険給付決定状況_現物分.get名称(), is(new RString("事業状況報告資料（年報）作成 保険給付決定状況【現物分】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成保険給付決定状況償還分_審査年月を指定した場合_get名称は_事業状況報告資料_年報_作成保険給付決定状況償還分_審査年月を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成保険給付決定状況償還分_審査年月.get名称(), is(new RString("事業状況報告資料（年報）作成 保険給付決定状況【償還分_審査年月】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成保険給付決定状況償還分_決定年月を指定した場合_get名称は_事業状況報告資料_年報_作成保険給付決定状況償還分_決定年月を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成保険給付決定状況_償還分_決定年月.get名称(), is(new RString("事業状況報告資料（年報）作成 保険給付決定状況【償還分_決定年月】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成保険給付決定状況高額_高額合算分を指定した場合_get名称は_事業状況報告資料_年報_作成保険給付決定状況高額_高額合算分を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成保険給付決定状況_高額_高額合算分.get名称(), is(new RString("事業状況報告資料（年報）作成 保険給付決定状況【高額・高額合算分】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成保険給付決定状況市町村特別給付を指定した場合_get名称は_事業状況報告資料_年報_作成保険給付決定状況市町村特別給付を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成保険給付決定状況_市町村特別給付.get名称(), is(new RString("事業状況報告資料（年報）作成 保険給付決定状況【市町村特別給付】")));
    }

    @Test
    public void 事業状況報告資料_年報_作成保険料収納状況_保険給付支払状況を指定した場合_get名称は_事業状況報告資料_年報_作成保険料収納状況_保険給付支払状況を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成保険料収納状況_保険給付支払状況.get名称(), is(new RString("事業状況報告資料（年報）作成 保険料収納状況・保険給付支払状況")));
    }

    @Test
    public void 事業状況報告資料_年報_作成特別会計経理状況を指定した場合_get名称は_事業状況報告資料_年報_作成特別会計経理状況を返す() {
        assertThat(JigyoHokokuNenpoShoriName.事業状況報告資料_年報_作成特別会計経理状況.get名称(), is(new RString("事業状況報告資料（年報）作成 特別会計経理状況")));
    }

}

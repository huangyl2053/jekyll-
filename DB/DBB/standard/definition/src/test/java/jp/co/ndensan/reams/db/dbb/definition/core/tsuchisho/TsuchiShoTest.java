package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 通知書のテストクラスです。
 *
 * author LDNS
 */
public class TsuchiShoTest extends DbbTestBase {

    @Test
    public void 特徴開始通知書を指定した場合_get名称は_特別徴収開始通知書_仮算定を返す() {
        assertThat(TsuchiSho.特別徴収開始通知書_仮算定.get名称(), is(new RString("特別徴収開始通知書_仮算定")));
    }

    @Test
    public void
            変更兼特別徴収中止通知書を指定した場合_get名称は_仮算定額変更通知書を返す() {
        assertThat(TsuchiSho.仮算定額変更通知書.get名称(), is(new RString("仮算定額変更通知書")));
    }

    @Test
    public void
            納入通知書を指定した場合_get名称は_保険料納入通知書_仮算定を返す() {
        assertThat(TsuchiSho.保険料納入通知書_仮算定.get名称(), is(new RString("保険料納入通知書_仮算定")));
    }

    @Test
    public void
            賦課台帳を指定した場合_get名称は_賦課台帳_仮算定を返す() {
        assertThat(TsuchiSho.賦課台帳_仮算定.get名称(), is(new RString("賦課台帳_仮算定")));
    }

    @Test
    public void
            特徴開始通知書を指定した場合_get名称は_特別徴収開始通知書_本算定を返す() {
        assertThat(TsuchiSho.特別徴収開始通知書_仮算定.get名称(), is(new RString("特別徴収開始通知書_本算定")));
    }

    @Test
    public void
            決定通知書を指定した場合_get名称は_介護保険料額決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料額決定通知書.get名称(), is(new RString("介護保険料額決定通知書")));
    }

    @Test
    public void
            変更兼特別徴収中止通知書を指定した場合_get名称は_介護保険料額変更兼特別徴収中止通知書を返す() {
        assertThat(TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get名称(), is(new RString("介護保険料額変更兼特別徴収中止通知書")));
    }

    @Test
    public void
            納入通知書を指定した場合_get名称は_保険料納入通知書_本算定を返す() {
        assertThat(TsuchiSho.保険料納入通知書_本算定.get名称(), is(new RString("保険料納入通知書_本算定")));
    }

    @Test
    public void
            賦課台帳を指定した場合_get名称は_賦課台帳_本算定を返す() {
        assertThat(TsuchiSho.賦課台帳_本算定.get名称(), is(new RString("賦課台帳_本算定")));
    }

    @Test
    public void
            納入通知書を指定した場合_get名称は_保険料納入通知書_過年度を返す() {
        assertThat(TsuchiSho.保険料納入通知書_過年度.get名称(), is(new RString("保険料納入通知書_過年度")));
    }

    @Test
    public void
            決定通知書を指定した場合_get名称は_介護保険料額決定通知書_過年度を返す() {
        assertThat(TsuchiSho.介護保険料額決定通知書_過年度.get名称(), is(new RString("介護保険料額決定通知書_過年度")));
    }

    @Test
    public void
            変更兼特別徴収中止通知書を指定した場合_get名称は_介護保険料額変更兼特別徴収中止通知書_過年度を返す() {
        assertThat(TsuchiSho.介護保険料額変更兼特別徴収中止通知書_過年度.get名称(), is(new RString("介護保険料額変更兼特別徴収中止通知書_過年度")));
    }

    @Test
    public void 郵便振替納付書を指定した場合_get名称は_郵便振替納付書を返す() {
        assertThat(TsuchiSho.郵便振替納付書.get名称(), is(new RString("郵便振替納付書")));
    }

    @Test
    public void 減免決定通知書を指定した場合_get名称は_介護保険料減免決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料減免決定通知書.get名称(), is(new RString("介護保険料減免決定通知書")));
    }

    @Test
    public void 減免取消通知書を指定した場合_get名称は_介護保険料減免取消通知書を返す() {
        assertThat(TsuchiSho.介護保険料減免取消通知書.get名称(), is(new RString("介護保険料減免取消通知書")));
    }

    @Test
    public void 猶予決定通知書を指定した場合_get名称は_介護保険料徴収猶予決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料徴収猶予決定通知書.get名称(), is(new RString("介護保険料徴収猶予決定通知書")));
    }

    @Test
    public void 猶予取消通知書を指定した場合_get名称は_介護保険料徴収猶予取消通知書を返す() {
        assertThat(TsuchiSho.介護保険料徴収猶予取消通知書.get名称(), is(new RString("介護保険料徴収猶予取消通知書")));
    }

    @Test
    public void
            特徴開始通知書を指定した場合_get略称は_特徴開始通知書を返す() {
        assertThat(TsuchiSho.特別徴収開始通知書_仮算定.get略称(), is(new RString("特徴開始通知書")));
    }

    @Test
    public void
            変更兼特別徴収中止通知書を指定した場合_get略称は_変更兼特別徴収中止通知書を返す() {
        assertThat(TsuchiSho.仮算定額変更通知書.get略称(), is(new RString("変更兼特別徴収中止通知書")));
    }

    @Test
    public void
            納入通知書を指定した場合_get略称は_納入通知書を返す() {
        assertThat(TsuchiSho.保険料納入通知書_仮算定.get略称(), is(new RString("納入通知書")));
    }

    @Test
    public void
            賦課台帳を指定した場合_get略称は_賦課台帳を返す() {
        assertThat(TsuchiSho.賦課台帳_仮算定.get略称(), is(new RString("賦課台帳")));
    }

    @Test
    public void
            特別徴収開始通知書_仮算定を指定した場合_get略称は_特徴開始通知書を返す() {
        assertThat(TsuchiSho.特別徴収開始通知書_仮算定.get略称(), is(new RString("特徴開始通知書")));
    }

    @Test
    public void
            決定通知書を指定した場合_get略称は_決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料額決定通知書.get略称(), is(new RString("決定通知書")));
    }

    @Test
    public void
            介護保険料額変更兼特別徴収中止通知書を指定した場合_get略称は_変更兼特別徴収中止通知書を返す() {
        assertThat(TsuchiSho.介護保険料額変更兼特別徴収中止通知書.get略称(), is(new RString("変更兼特別徴収中止通知書")));
    }

    @Test
    public void
            保険料納入通知書_本算定を指定した場合_get略称は_納入通知書を返す() {
        assertThat(TsuchiSho.保険料納入通知書_本算定.get略称(), is(new RString("納入通知書")));
    }

    @Test
    public void
            賦課台帳_本算定を指定した場合_get略称は_賦課台帳を返す() {
        assertThat(TsuchiSho.賦課台帳_本算定.get略称(), is(new RString("賦課台帳")));
    }

    @Test
    public void
            保険料納入通知書_過年度を指定した場合_get略称は_納入通知書を返す() {
        assertThat(TsuchiSho.保険料納入通知書_過年度.get略称(), is(new RString("納入通知書")));
    }

    @Test
    public void
            介護保険料額決定通知書_過年度を指定した場合_get略称は_決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料額決定通知書_過年度.get略称(), is(new RString("決定通知書")));
    }

    @Test
    public void
            介護保険料額変更兼特別徴収中止通知書_過年度を指定した場合_get略称は_変更兼特別徴収中止通知書を返す() {
        assertThat(TsuchiSho.介護保険料額変更兼特別徴収中止通知書_過年度.get略称(), is(new RString("変更兼特別徴収中止通知書")));
    }

    @Test
    public void 郵便振替納付書を指定した場合_get略称は_郵便振替納付書を返す() {
        assertThat(TsuchiSho.郵便振替納付書.get略称(), is(new RString("郵便振替納付書")));
    }

    @Test
    public void 介護保険料減免決定通知書を指定した場合_get略称は_減免決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料減免決定通知書.get略称(), is(new RString("減免決定通知書")));
    }

    @Test
    public void 介護保険料減免取消通知書を指定した場合_get略称は_減免取消通知書を返す() {
        assertThat(TsuchiSho.介護保険料減免取消通知書.get略称(), is(new RString("減免取消通知書")));
    }

    @Test
    public void 介護保険料徴収猶予決定通知書を指定した場合_get略称は_猶予決定通知書を返す() {
        assertThat(TsuchiSho.介護保険料徴収猶予決定通知書.get略称(), is(new RString("猶予決定通知書")));
    }

    @Test
    public void 介護保険料徴収猶予取消通知書を指定した場合_get略称は_猶予取消通知書を返す() {
        assertThat(TsuchiSho.介護保険料徴収猶予取消通知書.get略称(), is(new RString("猶予取消通知書")));
    }

}

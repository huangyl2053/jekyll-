package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 処理名のテストクラスです。
 *
 * @author LDNS
 */
public class ShoriNameTest extends DbzTestBase {

    @Test
    public void 納付額データ作成を指定した場合_get名称は_納付額データ作成を返す() {
        assertThat(ShoriName.納付額データ作成.get名称(), is(new RString("納付額データ作成")));
    }

    @Test
    public void 特徴対象者情報取込を指定した場合_get名称は_特徴対象者情報取込を返す() {
        assertThat(ShoriName.特徴対象者情報取込.get名称(), is(new RString("特徴対象者情報取込")));
    }

    @Test
    public void 特徴依頼情報作成を指定した場合_get名称は_特徴依頼情報作成を返す() {
        assertThat(ShoriName.特徴依頼情報作成.get名称(), is(new RString("特徴依頼情報作成")));
    }

    @Test
    public void 特徴依頼処理結果情報取込を指定した場合_get名称は_特徴依頼処理結果情報取込を返す() {
        assertThat(ShoriName.特徴依頼処理結果情報取込.get名称(), is(new RString("特徴依頼処理結果情報取込")));
    }

    @Test
    public void 特徴結果情報取込を指定した場合_get名称は_特徴結果情報取込を返す() {
        assertThat(ShoriName.特徴結果情報取込.get名称(), is(new RString("特徴結果情報取込")));
    }

    @Test
    public void 特徴異動情報作成を指定した場合_get名称は_特徴異動情報作成を返す() {
        assertThat(ShoriName.特徴異動情報作成.get名称(), is(new RString("特徴異動情報作成")));
    }

    @Test
    public void 特徴対象者同定を指定した場合_get名称は_特徴対象者同定を返す() {
        assertThat(ShoriName.特徴対象者同定.get名称(), is(new RString("特徴対象者同定")));
    }

    @Test
    public void _無し依頼金額計算を指定した場合_get名称は_依頼金額計算を返す() {
        assertThat(ShoriName._無し依頼金額計算.get名称(), is(new RString("依頼金額計算")));
    }

    @Test
    public void 特徴仮算定賦課を指定した場合_get名称は_特徴仮算定賦課を返す() {
        assertThat(ShoriName.特徴仮算定賦課.get名称(), is(new RString("特徴仮算定賦課")));
    }

    @Test
    public void 普徴仮算定賦課を指定した場合_get名称は_普徴仮算定賦課を返す() {
        assertThat(ShoriName.普徴仮算定賦課.get名称(), is(new RString("普徴仮算定賦課")));
    }

    @Test
    public void 仮算定異動賦課を指定した場合_get名称は_仮算定異動賦課を返す() {
        assertThat(ShoriName.仮算定異動賦課.get名称(), is(new RString("仮算定異動賦課")));
    }

    @Test
    public void 特徴平準化計算_6月分を指定した場合_get名称は_特徴平準化計算_6月分を返す() {
        assertThat(ShoriName.特徴平準化計算_6月分.get名称(), is(new RString("特徴平準化計算_6月分")));
    }

    @Test
    public void 特徴平準化計算_8月分を指定した場合_get名称は_特徴平準化計算_8月分を返す() {
        assertThat(ShoriName.特徴平準化計算_8月分.get名称(), is(new RString("特徴平準化計算_8月分")));
    }

    @Test
    public void 当初所得引出を指定した場合_get名称は_当初所得引出を返す() {
        assertThat(ShoriName.当初所得引出.get名称(), is(new RString("当初所得引出")));
    }

    @Test
    public void 本算定賦課を指定した場合_get名称は_本算定賦課を返す() {
        assertThat(ShoriName.本算定賦課.get名称(), is(new RString("本算定賦課")));
    }

    @Test
    public void 異動賦課を指定した場合_get名称は_異動賦課を返す() {
        assertThat(ShoriName.異動賦課.get名称(), is(new RString("異動賦課")));
    }

    @Test
    public void 過年度賦課を指定した場合_get名称は_過年度賦課を返す() {
        assertThat(ShoriName.過年度賦課.get名称(), is(new RString("過年度賦課")));
    }

    @Test
    public void 特徴仮算定賦課確定を指定した場合_get名称は_特徴仮算定賦課確定を返す() {
        assertThat(ShoriName.特徴仮算定賦課確定.get名称(), is(new RString("特徴仮算定賦課確定")));
    }

    @Test
    public void 普徴仮算定賦課確定を指定した場合_get名称は_普徴仮算定賦課確定を返す() {
        assertThat(ShoriName.普徴仮算定賦課確定.get名称(), is(new RString("普徴仮算定賦課確定")));
    }

    @Test
    public void 仮算定異動賦課確定を指定した場合_get名称は_仮算定異動賦課確定を返す() {
        assertThat(ShoriName.仮算定異動賦課確定.get名称(), is(new RString("仮算定異動賦課確定")));
    }

    @Test
    public void 特徴平準化_6月分_確定を指定した場合_get名称は_特徴平準化_6月分_確定を返す() {
        assertThat(ShoriName.特徴平準化_6月分_確定.get名称(), is(new RString("特徴平準化_6月分_確定")));
    }

    @Test
    public void 特徴平準化_8月分_確定を指定した場合_get名称は_特徴平準化_8月分_確定を返す() {
        assertThat(ShoriName.特徴平準化_8月分_確定.get名称(), is(new RString("特徴平準化_8月分_確定")));
    }

    @Test
    public void 本算定賦課確定を指定した場合_get名称は_本算定賦課確定を返す() {
        assertThat(ShoriName.本算定賦課確定.get名称(), is(new RString("本算定賦課確定")));
    }

    @Test
    public void 異動賦課確定を指定した場合_get名称は_異動賦課確定を返す() {
        assertThat(ShoriName.異動賦課確定.get名称(), is(new RString("異動賦課確定")));
    }

    @Test
    public void 過年度賦課確定を指定した場合_get名称は_過年度賦課確定を返す() {
        assertThat(ShoriName.過年度賦課確定.get名称(), is(new RString("過年度賦課確定")));
    }

    @Test
    public void 賦課確定を指定した場合_get名称は_賦課確定を返す() {
        assertThat(ShoriName.賦課確定.get名称(), is(new RString("賦課確定")));
    }

    @Test
    public void 所得引出を指定した場合_get名称は_所得引出を返す() {
        assertThat(ShoriName.所得引出.get名称(), is(new RString("所得引出")));
    }

    @Test
    public void 調定簿作成を指定した場合_get名称は_調定簿作成を返す() {
        assertThat(ShoriName.調定簿作成.get名称(), is(new RString("調定簿作成")));
    }

    @Test
    public void 新年度管理情報作成を指定した場合_get名称は_新年度管理情報作成を返す() {
        assertThat(ShoriName.新年度管理情報作成.get名称(), is(new RString("新年度管理情報作成")));
    }

    @Test
    public void 年度切替を指定した場合_get名称は_年度切替を返す() {
        assertThat(ShoriName.年度切替.get名称(), is(new RString("年度切替")));
    }

    @Test
    public void 年齢到達予定者チェックリストを指定した場合_get名称は_年齢到達予定者チェックリストを返す() {
        assertThat(ShoriName.年齢到達予定者チェックリスト.get名称(), is(new RString("年齢到達予定者チェックリスト")));
    }

    @Test
    public void 償還払い支給不支給決定通知書一括作成_受付日を指定した場合_get名称は_償還払い支給不支給決定通知書一括作成_受付日を返す() {
        assertThat(ShoriName.償還払い支給不支給決定通知書一括作成_受付日.get名称(), is(new RString("償還払い支給不支給決定通知書一括作成_受付日")));
    }

    @Test
    public void 償還払い支給不支給決定通知書一括作成_決定日を指定した場合_get名称は_償還払い支給不支給決定通知書一括作成_決定日を返す() {
        assertThat(ShoriName.償還払い支給不支給決定通知書一括作成_決定日.get名称(), is(new RString("償還払い支給不支給決定通知書一括作成_決定日")));
    }

    @Test
    public void 償還払い支給不支給決定通知書一括作成_決定者受付年月を指定した場合_get名称は_償還払い支給不支給決定通知書一括作成_決定者受付年月を返す() {
        assertThat(ShoriName.償還払い支給不支給決定通知書一括作成_決定者受付年月.get名称(), is(new RString("償還払い支給不支給決定通知書一括作成_決定者受付年月")));
    }

    @Test
    public void 住民異動連携情報登録_他社住基用を指定した場合_get名称は_住民異動連携情報登録_他社住基用を返す() {
        assertThat(ShoriName.住民異動連携情報登録_他社住基用.get名称(), is(new RString("住民異動連携情報登録_他社住基用")));
    }

}

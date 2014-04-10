/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import jp.co.ndensan.reams.db.dbe.business.core.ChoiceItem;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.IAnswerResultItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ikensho.ShujiiIkenshoItemSubGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書の結果（意見書項目単位）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoItemForResultTest extends DbeTestBase {

    private static final int AS_NULL項目無し = 0;
    private static final int AS_意見書項目がNULL = 1;
    private static final int AS_意見書結果がNULL = 2;
    private static final boolean AS_選択項目 = true;
    private static final boolean AS_入力項目 = false;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 意見書項目がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItemForResult(AS_意見書項目がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItemForResult(AS_意見書結果がNULL);
        }
    }

    public static class is意見書結果項目 extends DbeTestBase {

        @Test
        public void 調査結果項目の時_is調査結果項目は_TRUEを返す() {
            assertThat(createShujiiIkenshoItemForResult().is意見書結果項目(), is(true));
        }
    }

    public static class get意見書項目グループ extends DbeTestBase {

        @Test
        public void 意見書項目グループの設定がある時_get意見書項目グループは_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get意見書項目グループ(), is((IShujiiIkenshoItemGroup) ShujiiIkenshoItemGroupOf2009.心身状態));
        }
    }

    public static class get意見書項目サブグループ extends DbeTestBase {

        @Test
        public void 意見書項目サブグループの設定がある時_get意見書項目サブグループは_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get意見書項目サブグループ(), is((IShujiiIkenshoItemSubGroup) ShujiiIkenshoItemSubGroupOf2009.身体状態));
        }
    }

    public static class get意見書項目グループ内番号 extends DbeTestBase {

        @Test
        public void 意見書項目グループ内番号の設定がある時_get意見書項目グループ内番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get意見書項目グループ内番号(), is(1));
        }
    }

    public static class get意見書項目サブグループ内番号 extends DbeTestBase {

        @Test
        public void 意見書項目サブグループ内番号の設定がある時_get意見書項目サブグループ内番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get意見書項目サブグループ内番号(), is(1));
        }
    }

    public static class get意見書項目番号 extends DbeTestBase {

        @Test
        public void 意見書項目番号の設定がある時_get意見書項目番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get意見書項目番号().value(), is(new RString("")));
        }
    }

    public static class get意見書項目区分 extends DbeTestBase {

        @Test
        public void 意見書項目区分の設定がある時_get意見書項目区分は_設定値を返す() {
            assertThat((ShujiiIkenshoItemKubun) createShujiiIkenshoItemForResult().get意見書項目区分(), is(ShujiiIkenshoItemKubun.利き腕));
        }
    }

    public static class get表示項目 extends DbeTestBase {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get表示名称(), is(new RString("利き腕")));
        }
    }

    public static class get回答項目 extends DbeTestBase {

        @Test
        public void 選択肢が2択の時_get回答項目は_2件の選択肢を返す() {
            assertThat(((ChoiceItem) createShujiiIkenshoItemForResult().get回答項目()).asList().size(), is(2));
        }

        @Test
        public void 選択肢の設定がある時_get回答項目は_設定値を返す() {
            assertThat(((ChoiceItem) createShujiiIkenshoItemForResult().get回答項目()).asList().get(0), is((IAnswerResultItem) ChoiceResultItem.MigiHidari.右));
        }
    }

    public static class get意見書結果 extends DbeTestBase {

        @Test
        public void 意見書結果の設定がある時_get意見書結果は_設定値を返す() {
            assertThat(createShujiiIkenshoItemForResult().get意見書結果(), is(new RString("1")));
        }
    }

    public static class get回答結果 extends DbeTestBase {

        @Test
        public void 調査項目が選択形式の時_get回答結果は_該当の選択肢を返す() {
            assertThat(createShujiiIkenshoItemForResult(AS_選択項目).get回答結果(), is((IAnswerResultItem) ChoiceResultItem.MigiHidari.右));
        }

        @Test
        public void 調査項目が選択形式の時_get回答結果は_該当の選択値を返す() {
            assertThat(createShujiiIkenshoItemForResult(AS_選択項目).get回答結果().getCode(), is(new RString("1")));
        }

        @Test
        public void 調査項目が入力形式の時_get回答結果は_入力値を返す() {
            assertThat(createShujiiIkenshoItemForResult(AS_入力項目).get回答結果().getCode(), is(new RString("自由入力")));
        }
    }

    private static ShujiiIkenshoItemForResult createShujiiIkenshoItemForResult() {
        return createShujiiIkenshoItemForResult(AS_NULL項目無し, AS_選択項目);
    }

    private static ShujiiIkenshoItemForResult createShujiiIkenshoItemForResult(int flg) {
        return createShujiiIkenshoItemForResult(flg, AS_選択項目);
    }

    private static ShujiiIkenshoItemForResult createShujiiIkenshoItemForResult(boolean choice) {
        return createShujiiIkenshoItemForResult(AS_NULL項目無し, choice);
    }

    private static ShujiiIkenshoItemForResult createShujiiIkenshoItemForResult(int flg, boolean choice) {
        return new ShujiiIkenshoItemForResult(
                flg == AS_意見書項目がNULL ? null : createShujiiIkenshoItem(choice ? ShujiiIkenshoItemKubun.利き腕 : ShujiiIkenshoItemKubun.身長),
                flg == AS_意見書結果がNULL ? null : new RString(choice ? "1" : "自由入力"));
    }

    private static ShujiiIkenshoItem createShujiiIkenshoItem(ShujiiIkenshoItemKubun itemKubun) {
        return (ShujiiIkenshoItem) ShujiiIkenshoFactory.create主治医意見書Instance(KoroshoIFKubun.V09A).get意見書項目(itemKubun);
    }
}

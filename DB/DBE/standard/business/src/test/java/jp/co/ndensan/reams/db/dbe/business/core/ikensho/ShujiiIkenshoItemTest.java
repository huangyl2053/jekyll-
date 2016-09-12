/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho;

import java.util.Arrays;
import jp.co.ndensan.reams.db.dbe.business.core.ChoiceItem;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.core.ikensho.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.ikensho.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.core.ikensho.ShujiiIkenshoItemGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.core.ikensho.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.ikensho.ShujiiIkenshoItemSubGroupOf2009;
import jp.co.ndensan.reams.db.dbe.definition.core.shujiiikenshoitemno.ShujiiIkenshoItemNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書の項目を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoItemTest extends DbeTestBase {

    private static final int AS_NULL項目無し = 0;
    private static final int AS_意見書項目グループがNULL = 1;
    private static final int AS_意見書項目サブグループがNULL = 2;
    private static final int AS_意見書項目番号がNULL = 3;
    private static final int AS_意見書項目区分がNULL = 4;
    private static final int AS_表示名称がNULL = 5;
    private static final int AS_回答項目がNULL = 6;
    private static final int AS_主要意見書項目 = 7;
    private static final int AS_通常意見書項目 = 8;

    public static class コンストラクタ extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 意見書項目グループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_意見書項目グループがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書項目サブグループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_意見書項目サブグループがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書項目番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_意見書項目番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書項目区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_意見書項目区分がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 表示名称がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_表示名称がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 回答項目がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_回答項目がNULL);
        }
    }

    public static class is意見書結果項目 extends DbeTestBase {

        @Test
        public void 意見書項目の時_is意見書結果項目は_FALSEを返す() {
            assertThat(createShujiiIkenshoItem().is意見書結果項目(), is(false));
        }
    }

    public static class get意見書項目グループ extends DbeTestBase {

        @Test
        public void 意見書項目グループの設定がある時_get意見書項目グループは_設置値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目グループ(), is((IShujiiIkenshoItemGroup) ShujiiIkenshoItemGroupOf2009.心身状態));
        }
    }

    public static class get意見書項目サブグループ extends DbeTestBase {

        @Test
        public void 意見書項目サブグループの設定がある時_get意見書項目サブグループは_設置値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目サブグループ(), is((IShujiiIkenshoItemSubGroup) ShujiiIkenshoItemSubGroupOf2009.中核症状));
        }
    }

    public static class get意見書項目グループ内番号 extends DbeTestBase {

        @Test
        public void 意見書項目グループ内番号の設定がある時_get意見書項目グループ内番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目グループ内番号(), is(1));
        }
    }

    public static class get意見書項目サブグループ内番号 extends DbeTestBase {

        @Test
        public void 意見書項目サブグループ内番号の設定がある時_get意見書項目サブグループ内番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目サブグループ内番号(), is(1));
        }
    }

    public static class get意見書項目番号 extends DbeTestBase {

        @Test
        public void 意見書項目番号の設定がある時_get意見書項目番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目番号().value(), is(new RString("3-2")));
        }
    }

    public static class get意見書項目区分 extends DbeTestBase {

        @Test
        public void 意見書項目区分の設定がある時_get意見書項目区分は_設定値を返す() {
            assertThat((ShujiiIkenshoItemKubun) createShujiiIkenshoItem().get意見書項目区分(), is(ShujiiIkenshoItemKubun.短期記憶));
        }
    }

    public static class get表示名称 extends DbeTestBase {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get表示名称(), is(new RString("短期記憶")));
        }
    }

    public static class get回答項目 extends DbeTestBase {

        @Test
        public void 選択肢が2択の時_get回答項目は_2件の選択肢を返す() {
            assertThat(((ChoiceItem) createShujiiIkenshoItem().get回答項目()).asList().size(), is(2));
        }

        @Test
        public void 選択肢の設定がある時_get回答項目は_設定値を返す() {
            assertThat(((ChoiceItem) createShujiiIkenshoItem().get回答項目()).asList().get(0).getValue(), is(new RString("問題なし")));
        }
    }

    public static class is主要意見書項目 extends DbeTestBase {

        @Test
        public void 主要意見書項目の時_is主要意見書項目は_TRUEを返す() {
            assertThat(createShujiiIkenshoItem(AS_主要意見書項目).is主要意見書項目(), is(true));
        }

        @Test
        public void 通常意見書項目の時_is主要意見書項目は_FALSEを返す() {
            assertThat(createShujiiIkenshoItem(AS_通常意見書項目).is主要意見書項目(), is(false));
        }
    }

    private static ShujiiIkenshoItem createShujiiIkenshoItem() {
        return createShujiiIkenshoItem(AS_NULL項目無し);
    }

    private static ShujiiIkenshoItem createShujiiIkenshoItem(int flg) {
        return new ShujiiIkenshoItem(
                flg == AS_意見書項目グループがNULL ? null : ShujiiIkenshoItemGroupOf2009.心身状態,
                flg == AS_意見書項目サブグループがNULL ? null : ShujiiIkenshoItemSubGroupOf2009.中核症状, 1, 1,
                flg == AS_意見書項目番号がNULL ? null : new ShujiiIkenshoItemNo(new RString("3-2")),
                flg == AS_意見書項目区分がNULL ? null : ShujiiIkenshoItemKubun.短期記憶,
                flg == AS_表示名称がNULL ? null : new RString("短期記憶"),
                flg == AS_回答項目がNULL ? null : new ChoiceItem(Arrays.asList(ChoiceResultItem.MondaiNashiAri.values())),
                flg == AS_主要意見書項目 ? true : false);
    }
}

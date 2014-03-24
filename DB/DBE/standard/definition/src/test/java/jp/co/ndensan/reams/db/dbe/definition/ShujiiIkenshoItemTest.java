/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.Choices;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIkenshoItemNo;
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
public class ShujiiIkenshoItemTest {

    private static final int AS_NULL項目無し = 0;
    private static final int AS_意見書項目グループがNULL = 1;
    private static final int AS_意見書項目サブグループがNULL = 2;
    private static final int AS_意見書項目番号がNULL = 3;
    private static final int AS_意見書項目区分がNULL = 4;
    private static final int AS_表示名称がNULL = 5;
    private static final int AS_選択肢がNULL = 6;
    private static final int AS_主要意見書項目 = 7;
    private static final int AS_通常意見書項目 = 8;

    public static class コンストラクタ {

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
        public void 選択肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createShujiiIkenshoItem(AS_選択肢がNULL);
        }
    }

    public static class get意見書項目グループ {

        @Test
        public void 意見書項目グループの設定がある時_get意見書項目グループは_設置値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目グループ(), is((IShujiiIkenshoItemGroup) ShujiiIkenshoItemGroup.Of2009.心身状態));
        }
    }

    public static class get意見書項目サブグループ {

        @Test
        public void 意見書項目サブグループの設定がある時_get意見書項目サブグループは_設置値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目サブグループ(), is((IShujiiIkenshoItemSubGroup) ShujiiIkenshoItemSubGroup.Of2009.中核症状));
        }
    }

    public static class get意見書項目グループ内番号 {

        @Test
        public void 意見書項目グループ内番号の設定がある時_get意見書項目グループ内番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目グループ内番号(), is(1));
        }
    }

    public static class get意見書項目サブグループ内番号 {

        @Test
        public void 意見書項目サブグループ内番号の設定がある時_get意見書項目サブグループ内番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目サブグループ内番号(), is(1));
        }
    }

    public static class get意見書項目番号 {

        @Test
        public void 意見書項目番号の設定がある時_get意見書項目番号は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get意見書項目番号().value(), is(new RString("3-2")));
        }
    }

    public static class get意見書項目区分 {

        @Test
        public void 意見書項目区分の設定がある時_get意見書項目区分は_設定値を返す() {
            assertThat((ShujiiIkenshoItemKubun) createShujiiIkenshoItem().get意見書項目区分(), is(ShujiiIkenshoItemKubun.短期記憶));
        }
    }

    public static class get表示名称 {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get表示名称(), is(new RString("短期記憶")));
        }
    }

    public static class get選択肢 {

        @Test
        public void 選択肢が2択の時_get選択肢は_2件の選択肢を返す() {
            assertThat(createShujiiIkenshoItem().get選択肢().asList().size(), is(2));
        }

        @Test
        public void 選択肢の設定がある時_get選択肢は_設定値を返す() {
            assertThat(createShujiiIkenshoItem().get選択肢().asList().get(0).getValue(), is(new RString("問題なし")));
        }
    }

    public static class is主要意見書項目 {

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
                flg == AS_意見書項目グループがNULL ? null : ShujiiIkenshoItemGroup.Of2009.心身状態,
                flg == AS_意見書項目サブグループがNULL ? null : ShujiiIkenshoItemSubGroup.Of2009.中核症状, 1, 1,
                flg == AS_意見書項目番号がNULL ? null : new ShujiiIkenshoItemNo(new RString("3-2")),
                flg == AS_意見書項目区分がNULL ? null : ShujiiIkenshoItemKubun.短期記憶,
                flg == AS_表示名称がNULL ? null : new RString("短期記憶"),
                flg == AS_選択肢がNULL ? null : new Choices(Choice.MondaiNashiAri.values()),
                flg == AS_主要意見書項目 ? true : false);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査項目情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaItemTest {

    private static final int AS_NULL項目無し = 0;
    private static final int AS_調査票項目分類がNULL = 1;
    private static final int AS_調査項目番号がNULL = 2;
    private static final int AS_調査票項目がNULL = 3;
    private static final int AS_表示名称がNULL = 4;
    private static final int AS_選択肢がNULL = 5;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査票項目分類がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査票項目分類がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査項目番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査票項目がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査票項目がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 表示名称がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_表示名称がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 選択肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_選択肢がNULL);
        }
    }

    public static class get調査票項目分類 {

        @Test
        public void 調査票項目分類の設定がある時_get調査票項目分類は_設置値を返す() {
            assertThat(createNinteichosaItem().get調査票項目分類(), is((IChosahyoItemGroup) ChosahyoItemGroup.Of2006.第１群));
        }
    }

    public static class get調査項目番号 {

        @Test
        public void 調査項目番号の設定がある時_get調査項目番号は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査項目番号().value(), is(new RString("101")));
        }
    }

    public static class get調査票項目 {

        @Test
        public void 調査票項目の設定がある時_get調査票項目は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査票項目(), is(ChosahyoItems.麻痺等の有無_右上肢));
        }
    }

    public static class get表示項目 {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createNinteichosaItem().get表示名称(), is(new RString("麻痺等の有無 右上肢")));
        }
    }

    public static class get選択肢List {

        @Test
        public void 選択肢が2択の時_get選択肢Listは_2件の選択肢を返す() {
            assertThat(createNinteichosaItem().get選択肢List().asList().size(), is(2));
        }

        @Test
        public void 選択肢の設定がある時_get選択肢Listは_設定値を返す() {
            assertThat(createNinteichosaItem().get選択肢List().asList().get(0).getName(), is(new RString("ない")));
        }
    }

    private static NinteichosaItem createNinteichosaItem() {
        return createNinteichosaItem(AS_NULL項目無し);
    }

    private static NinteichosaItem createNinteichosaItem(int flg) {
        return new NinteichosaItem(
                flg == AS_調査票項目分類がNULL ? null : ChosahyoItemGroup.Of2006.第１群,
                flg == AS_調査項目番号がNULL ? null : new NinteichosaItemNo(new RString("101")),
                flg == AS_調査票項目がNULL ? null : ChosahyoItems.麻痺等の有無_右上肢,
                flg == AS_表示名称がNULL ? null : new RString("麻痺等の有無 右上肢"),
                flg == AS_選択肢がNULL ? null : new Choices(Choice.NaiAru.values()));
    }
}

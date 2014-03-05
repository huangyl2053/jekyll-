/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
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
    private static final int AS_調査票項目グループがNULL = 1;
    private static final int AS_調査票項目サブグループがNULL = 2;
    private static final int AS_調査項目番号がNULL = 3;
    private static final int AS_調査票項目がNULL = 4;
    private static final int AS_表示名称がNULL = 5;
    private static final int AS_選択肢グループがNULL = 6;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査票項目グループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査票項目グループがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査票項目サブグループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査票項目サブグループがNULL);
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
        public void 選択肢グループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_選択肢グループがNULL);
        }
    }

    public static class get調査票項目グループ {

        @Test
        public void 調査票項目グループの設定がある時_get調査票項目グループは_設置値を返す() {
            assertThat(createNinteichosaItem().get調査票項目グループ(), is((IChosahyoItemGroup) ChosahyoItemGroup.Of2006.第１群));
        }
    }

    public static class get調査票項目サブグループ {

        @Test
        public void 調査票項目サブグループの設定がある時_get調査票項目サブグループは_設置値を返す() {
            assertThat(createNinteichosaItem().get調査票項目サブグループ(), is((IChosahyoItemSubGroup) ChosahyoItemSubGroup.Of2006.麻痺等の有無));
        }
    }

    public static class get調査票項目サブグループ内番号 {

        @Test
        public void 調査票項目サブグループ内番号の設定がある時_get調査票項目サブグループ内番号は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査票項目サブグループ内番号(), is(1));
        }
    }

    public static class get調査項目番号 {

        @Test
        public void 調査項目番号の設定がある時_get調査項目番号は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査項目番号().value(), is(new RString("1-1")));
        }
    }

    public static class get調査票項目 {

        @Test
        public void 調査票項目の設定がある時_get調査票項目は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査票項目(), is(ChosahyoItems.麻痺等の有無_右上肢));
        }
    }

    public static class get表示名称 {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createNinteichosaItem().get表示名称(), is(new RString("右上肢")));
        }
    }

    public static class get選択肢グループ {

        @Test
        public void 選択肢グループが2択の時_get選択肢グループは_2件の選択肢を返す() {
            assertThat(createNinteichosaItem().get選択肢グループ().asList().size(), is(2));
        }

        @Test
        public void 選択肢グループの設定がある時_get選択肢グループは_設定値を返す() {
            assertThat(createNinteichosaItem().get選択肢グループ().asList().get(0).getName(), is(new RString("ない")));
        }
    }

    private static NinteichosaItem createNinteichosaItem() {
        return createNinteichosaItem(AS_NULL項目無し);
    }

    private static NinteichosaItem createNinteichosaItem(int flg) {
        return new NinteichosaItem(
                flg == AS_調査票項目グループがNULL ? null : ChosahyoItemGroup.Of2006.第１群,
                flg == AS_調査票項目サブグループがNULL ? null : ChosahyoItemSubGroup.Of2006.麻痺等の有無, 1,
                flg == AS_調査項目番号がNULL ? null : new NinteichosaItemNo(new RString("1-1")),
                flg == AS_調査票項目がNULL ? null : ChosahyoItems.麻痺等の有無_右上肢,
                flg == AS_表示名称がNULL ? null : new RString("右上肢"),
                flg == AS_選択肢グループがNULL ? null : new Choices(Choice.NaiAru.values()));
    }
}

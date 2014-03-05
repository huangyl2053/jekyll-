/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.Choices;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IChosahyoItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査結果情報を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaItemResultTest {

    private static final int AS_NULL項目無し = 0;
    private static final int AS_調査項目がNULL = 1;
    private static final int AS_調査結果がNULL = 2;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査項目がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItemResult(AS_調査項目がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査結果がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItemResult(AS_調査結果がNULL);
        }
    }

    public static class get調査票項目グループ {

        @Test
        public void 調査票項目グループの設定がある時_get調査票項目グループは_設置値を返す() {
            assertThat(createNinteichosaItemResult().get調査票項目グループ(), is((IChosahyoItemGroup) ChosahyoItemGroup.Of2006.第１群));
        }
    }

    public static class get調査票項目サブグループ {

        @Test
        public void 調査票項目サブグループの設定がある時_get調査票項目サブグループは_設置値を返す() {
            assertThat(createNinteichosaItemResult().get調査票項目サブグループ(), is((IChosahyoItemSubGroup) ChosahyoItemSubGroup.Of2006.麻痺等の有無));
        }
    }

    public static class get調査票項目サブグループ内番号 {

        @Test
        public void 調査票項目サブグループ内番号の設定がある時_get調査票項目サブグループ内番号は_設置値を返す() {
            assertThat(createNinteichosaItemResult().get調査票項目サブグループ内番号(), is(1));
        }
    }

    public static class get調査項目番号 {

        @Test
        public void 調査項目番号の設定がある時_get調査項目番号は_設定値を返す() {
            assertThat(createNinteichosaItemResult().get調査項目番号().value(), is(new RString("1-1")));
        }
    }

    public static class get調査票項目 {

        @Test
        public void 調査票項目の設定がある時_get調査票項目は_設定値を返す() {
            assertThat(createNinteichosaItemResult().get調査票項目(), is(ChosahyoItems.麻痺等の有無_右上肢));
        }
    }

    public static class get表示項目 {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createNinteichosaItemResult().get表示名称(), is(new RString("右上肢")));
        }
    }

    public static class get選択肢グループ {

        @Test
        public void 選択肢グループが2択の時_get選択肢グループは_2件の選択肢を返す() {
            assertThat(createNinteichosaItemResult().get選択肢グループ().asList().size(), is(2));
        }

        @Test
        public void 選択肢グループの設定がある時_get選択肢グループは_設定値を返す() {
            assertThat(createNinteichosaItemResult().get選択肢グループ().asList().get(0).getName(), is(new RString("ない")));
        }
    }

    public static class get調査結果コード {

        @Test
        public void 調査結果コードの設定がある時_get調査結果コードは_設定値を返す() {
            assertThat(createNinteichosaItemResult().get調査結果コード(), is(new RString("1")));
        }
    }

    public static class get調査結果 {

        @Test
        public void 調査結果コードの設定がある時_get調査結果は_設定値を返す() {
            assertThat(createNinteichosaItemResult().get調査結果(), is((IAnsweringItem) Choice.NaiAru.ない));
        }
    }

    private static NinteichosaItemResult createNinteichosaItemResult() {
        return createNinteichosaItemResult(AS_NULL項目無し);
    }

    private static NinteichosaItemResult createNinteichosaItemResult(int flg) {
        return new NinteichosaItemResult(
                flg == AS_調査項目がNULL ? null : createNinteichosaItem(),
                flg == AS_調査結果がNULL ? null : new RString("1"));
    }

    private static NinteichosaItem createNinteichosaItem() {
        return new NinteichosaItem(
                ChosahyoItemGroup.Of2006.第１群,
                ChosahyoItemSubGroup.Of2006.麻痺等の有無, 1,
                new NinteichosaItemNo(new RString("1-1")),
                ChosahyoItems.麻痺等の有無_右上肢,
                new RString("右上肢"),
                new Choices(Choice.NaiAru.values()));
    }
}

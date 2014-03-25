/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemSubGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaItemNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査項目を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaItemTest {

    private static final int AS_NULL項目無し = 0;
    private static final int AS_調査項目グループがNULL = 1;
    private static final int AS_調査項目サブグループがNULL = 2;
    private static final int AS_調査項目番号がNULL = 3;
    private static final int AS_調査項目区分がNULL = 4;
    private static final int AS_表示名称がNULL = 5;
    private static final int AS_選択肢がNULL = 6;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査項目グループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査項目グループがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目サブグループがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査項目サブグループがNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査項目番号がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目区分がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaItem(AS_調査項目区分がNULL);
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

    public static class get調査項目グループ {

        @Test
        public void 調査項目グループの設定がある時_get調査項目グループは_設置値を返す() {
            assertThat(createNinteichosaItem().get調査項目グループ(), is((INinteichosaItemGroup) NinteichosaItemGroup.Of2009.第１群));
        }
    }

    public static class get調査項目サブグループ {

        @Test
        public void 調査項目サブグループの設定がある時_get調査項目サブグループは_設置値を返す() {
            assertThat(createNinteichosaItem().get調査項目サブグループ(), is((INinteichosaItemSubGroup) NinteichosaItemSubGroup.Of2009.麻痺等の有無));
        }
    }

    public static class get調査項目グループ内番号 {

        @Test
        public void 調査項目グループ内番号の設定がある時_get調査項目グループ内番号は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査項目グループ内番号(), is(1));
        }
    }

    public static class get調査項目サブグループ内番号 {

        @Test
        public void 調査項目サブグループ内番号の設定がある時_get調査項目サブグループ内番号は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査項目サブグループ内番号(), is(1));
        }
    }

    public static class get調査項目番号 {

        @Test
        public void 調査項目番号の設定がある時_get調査項目番号は_設定値を返す() {
            assertThat(createNinteichosaItem().get調査項目番号().value(), is(new RString("1-1")));
        }
    }

    public static class get調査項目区分 {

        @Test
        public void 調査項目区分の設定がある時_get調査項目区分は_設定値を返す() {
            assertThat((NinteichosaItemKubunOfKihon) createNinteichosaItem().get調査項目区分(), is(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢));
        }
    }

    public static class get表示名称 {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createNinteichosaItem().get表示名称(), is(new RString("右上肢")));
        }
    }

    public static class get選択肢 {

        @Test
        public void 選択肢が2択の時_get選択肢は_2件の選択肢を返す() {
            assertThat(createNinteichosaItem().get選択肢().asList().size(), is(2));
        }

        @Test
        public void 選択肢の設定がある時_get選択肢は_設定値を返す() {
            assertThat(createNinteichosaItem().get選択肢().asList().get(0).getValue(), is(new RString("ない")));
        }
    }

    private static NinteichosaItem createNinteichosaItem() {
        return createNinteichosaItem(AS_NULL項目無し);
    }

    private static NinteichosaItem createNinteichosaItem(int flg) {
        return new NinteichosaItem(
                flg == AS_調査項目グループがNULL ? null : NinteichosaItemGroup.Of2009.第１群,
                flg == AS_調査項目サブグループがNULL ? null : NinteichosaItemSubGroup.Of2009.麻痺等の有無, 1, 1,
                flg == AS_調査項目番号がNULL ? null : new NinteichosaItemNo(new RString("1-1")),
                flg == AS_調査項目区分がNULL ? null : NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢,
                flg == AS_表示名称がNULL ? null : new RString("右上肢"),
                flg == AS_選択肢がNULL ? null : new Choices(Choice.NaiAru.values()));
    }
}

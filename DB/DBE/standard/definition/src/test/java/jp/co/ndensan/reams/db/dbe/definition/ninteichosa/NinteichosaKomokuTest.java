/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaBunrui;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ISentakushi;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi;
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
public class NinteichosaKomokuTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 調査分類がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaKomoku(1);
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaKomoku(2);
        }

        @Test(expected = NullPointerException.class)
        public void 調査項目がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaKomoku(3);
        }

        @Test(expected = NullPointerException.class)
        public void 表示名称がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaKomoku(4);
        }

        @Test(expected = NullPointerException.class)
        public void 選択肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteichosaKomoku(5);
        }
    }

    public static class get調査分類 {

        @Test
        public void 調査分類の設定がある時_get調査分類は_設置値を返す() {
            assertThat(createNinteichosaKomoku(0).get調査分類(), is(ChosaBunrui.第１群));
        }
    }

    public static class get調査項目番号 {

        @Test
        public void 調査項目番号の設定がある時_get調査項目番号は_設定値を返す() {
            assertThat(createNinteichosaKomoku(0).get調査項目番号(), is(new RString("101")));
        }
    }

    public static class get調査項目 {

        @Test
        public void 調査項目の設定がある時_get調査項目は_設定値を返す() {
            assertThat(createNinteichosaKomoku(0).get調査項目(), is(ChosaKomoku.麻痺等の有無_右上肢));
        }
    }

    public static class get表示項目 {

        @Test
        public void 表示名称の設定がある時_get表示名称は_設定値を返す() {
            assertThat(createNinteichosaKomoku(0).get表示名称(), is(new RString("麻痺等の有無 右上肢")));
        }
    }

    public static class get選択肢List {

        @Test
        public void 選択肢が2択の時_get選択肢Listは_2件の選択肢を返す() {
            assertThat(createNinteichosaKomoku(0).get選択肢List().size(), is(2));
        }

        @Test
        public void 選択肢の設定がある時_get選択肢Listは_設定値を返す() {
            assertThat(createNinteichosaKomoku(0).get選択肢List().get(0).getName(), is(new RString("ない")));
        }
    }

    public static class get選択肢 {

        @Test
        public void 調査結果コードの指定がある時_get選択肢_getCodeは_選択肢のコードを返す() {
            assertThat(createNinteichosaKomoku(0).get選択肢(new RString("2")).getCode(), is(new RString("2")));
        }

        @Test
        public void 調査結果コードの指定がある時_get選択肢_getCodeは_選択肢の名称を返す() {
            assertThat(createNinteichosaKomoku(0).get選択肢(new RString("2")).getName(), is(new RString("ある")));
        }

        @Test
        public void 調査結果コードの指定がある時_get選択肢_getCodeは_選択肢の列挙型を返す() {
            assertThat((Sentakushi.NaiAru) createNinteichosaKomoku(0).get選択肢(new RString("2")), is(Sentakushi.NaiAru.ある));
        }
    }

    private static INinteichosaKomoku createNinteichosaKomoku(int nullFlg) {
        return new NinteichosaKomoku(
                nullFlg == 1 ? null : ChosaBunrui.第１群,
                nullFlg == 2 ? null : new RString("101"),
                nullFlg == 3 ? null : ChosaKomoku.麻痺等の有無_右上肢,
                nullFlg == 4 ? null : new RString("麻痺等の有無 右上肢"),
                nullFlg == 5 ? null : Arrays.asList((ISentakushi[]) Sentakushi.NaiAru.values()));
    }
}

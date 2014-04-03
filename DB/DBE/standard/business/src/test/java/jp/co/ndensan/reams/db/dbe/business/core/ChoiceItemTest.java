/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChoiceResultItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.IAnswerResultItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 回答項目（選択項目）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChoiceItemTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 選択肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChoiceItem(null);
        }
    }

    public static class toValue {

        @Test
        public void 選択肢に_ないある_が設定されている時_toValueは_コード1指定で_ない_を返す() {
            assertThat(new ChoiceItem(ChoiceResultItem.NaiAru.values()).toValue(new RString("1")), is((IAnswerResultItem) ChoiceResultItem.NaiAru.ない));
        }

        @Test
        public void 選択肢に_ないある_が設定されている時_toValueは_コード2指定で_ある_を返す() {
            assertThat(new ChoiceItem(ChoiceResultItem.NaiAru.values()).toValue(new RString("2")), is((IAnswerResultItem) ChoiceResultItem.NaiAru.ある));
        }

        @Test
        public void 選択肢の設定がない時_toValueは_NULLを返す() {
            assertThat(new ChoiceItem(createChoice(1)).toValue(new RString("999")), nullValue());
        }
    }

    public static class isWapperFor {

        @Test
        public void 選択項目を指定した時_isWapperForは_TRUEを返す() {
            assertThat(new ChoiceItem(createChoice(1)).isWapperFor(ChoiceItem.class), is(true));
        }

        @Test
        public void 入力項目を指定した時_isWapperForは_FALSEを返す() {
            assertThat(new ChoiceItem(createChoice(1)).isWapperFor(InputItem.class), is(false));
        }
    }

    public static class unwrap {

        @Test
        public void 選択項目を指定した時_unwrapは_選択項目のインスタンスを返す() {
            assertThat(new ChoiceItem(createChoice(1)).unwrap(ChoiceItem.class), instanceOf(ChoiceItem.class));
        }
    }

    public static class asList {

        @Test
        public void 選択肢が0件の時_asListは_0件のリストを返す() {
            assertThat(new ChoiceItem(createChoice(0)).asList().size(), is(0));
        }

        @Test
        public void 選択肢が1件の時_asListは_1件のリストを返す() {
            assertThat(new ChoiceItem(createChoice(1)).asList().size(), is(1));
        }

        @Test
        public void 選択肢が2件の時_asListは_2件のリストを返す() {
            assertThat(new ChoiceItem(createChoice(2)).asList().size(), is(2));
        }
    }

    private static IAnswerResultItem[] createChoice(int size) {
        IAnswerResultItem choice[] = new IAnswerResultItem[size];
        for (int i = 0; i < size; i++) {
            choice[i] = ChoiceResultItem.NaiAru.ある;
        }
        return choice;
    }
}

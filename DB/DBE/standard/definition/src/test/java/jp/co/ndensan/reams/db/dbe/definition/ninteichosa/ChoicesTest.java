/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa;

import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.IAnsweringItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査の調査項目に対する選択肢のリストを扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChoicesTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 選択肢がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new Choices(null);
        }
    }

    public static class toValue {

        @Test
        public void 選択肢の設定がある時_toValueは_該当の選択肢を返す() {
            assertThat(new Choices(createChoice(1)).toValue(new RString("2")), is((IAnsweringItem) Choice.NaiAru.ある));
        }

        @Test
        public void 選択肢の設定がない時_toValueは_NULLを返す() {
            assertThat(new Choices(createChoice(1)).toValue(new RString("999")), nullValue());
        }
    }

    public static class asList {

        @Test
        public void 選択肢が0件の時_asListは_0件のリストを返す() {
            assertThat(new Choices(createChoice(0)).asList().size(), is(0));
        }

        @Test
        public void 選択肢が1件の時_asListは_1件のリストを返す() {
            assertThat(new Choices(createChoice(1)).asList().size(), is(1));
        }

        @Test
        public void 選択肢が2件の時_asListは_2件のリストを返す() {
            assertThat(new Choices(createChoice(2)).asList().size(), is(2));
        }
    }

    private static IAnsweringItem[] createChoice(int size) {
        IAnsweringItem choice[] = new IAnsweringItem[size];
        for (int i = 0; i < size; i++) {
            choice[i] = Choice.NaiAru.ある;
        }
        return choice;
    }
}

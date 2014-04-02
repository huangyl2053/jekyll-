/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 回答項目（入力項目）を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class InputItemTest {

    public static class toValue {

        @Test
        public void 入力値の指定がある時_toValueは_入力値を返す() {
            assertThat(new InputItem().toValue(new RString("AAA")).getValue(), is(new RString("AAA")));
        }
    }

    public static class isWapperFor {

        @Test
        public void 入力項目を指定した時_isWapperForは_TRUEを返す() {
            assertThat(new InputItem().isWapperFor(InputItem.class), is(true));
        }

        @Test
        public void 選択項目を指定した時_isWapperForは_FALSEを返す() {
            assertThat(new InputItem().isWapperFor(ChoiceItem.class), is(false));
        }
    }

    public static class unwrap {

        @Test
        public void 入力項目を指定した時_unwrapは_入力項目のインスタンスを返す() {
            assertThat(new InputItem().unwrap(InputItem.class), instanceOf(InputItem.class));
        }
    }
}

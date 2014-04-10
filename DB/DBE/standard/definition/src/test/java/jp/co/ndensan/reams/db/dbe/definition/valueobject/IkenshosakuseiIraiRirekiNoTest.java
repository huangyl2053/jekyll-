/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * 意見書作成依頼履歴番号を表すクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class IkenshosakuseiIraiRirekiNoTest extends DbeTestBase {

    public static class equals extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_equalsは_TRUEを返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).equals(new IkenshosakuseiIraiRirekiNo(1234)), is(true));
        }

        @Test
        public void 引数と値が一致しない時_equalsは_FALSEを返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).equals(new IkenshosakuseiIraiRirekiNo(5678)), is(false));
        }

        @Test
        public void 引数がNULLの時_equalsは_FALSEを返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).equals(null), is(false));
        }

        @Test
        public void 引数が異なる型の時_equalsは_FALSEを返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).equals(FlexibleDate.MIN), is(false));
        }
    }

    public static class hashCode extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_hashCodeは_同一の値を返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).hashCode(), is(new IkenshosakuseiIraiRirekiNo(1234).hashCode()));
        }

        @Test
        public void 引数と値が一致しない時_hashCodeは_異なる値を返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).hashCode(), not(new IkenshosakuseiIraiRirekiNo(5678).hashCode()));
        }
    }

    public static class compareTo extends DbeTestBase {

        @Test
        public void 引数と値が一致する時_compareToは_0を返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).compareTo(new IkenshosakuseiIraiRirekiNo(1234)) == 0, is(true));
        }

        @Test
        public void 引数より小さい時_compareToは_0より小さい値を返す() {
            assertThat(new IkenshosakuseiIraiRirekiNo(1234).compareTo(new IkenshosakuseiIraiRirekiNo(2222)) < 0, is(true));
        }

        @Test
        public void 引数より大きい時_compareToは_0より大きい値を返す() {
            assertThat(0 < new IkenshosakuseiIraiRirekiNo(1234).compareTo(new IkenshosakuseiIraiRirekiNo(1111)), is(true));
        }
    }
}

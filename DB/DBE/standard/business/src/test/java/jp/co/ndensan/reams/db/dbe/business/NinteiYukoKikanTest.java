/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 認定有効期間を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteiYukoKikanTest {

    private static final int AS_有効期間月数がNULL = 1;
    private static final int AS_有効開始年月日がNULL = 2;
    private static final int AS_有効終了年月日がNULL = 3;
    private static final int AS_有効期間がNULL = 4;
    private static final NinteiYukoKikanTsukisu 有効期間月数 = new NinteiYukoKikanTsukisu(5);
    private static final FlexibleDate 有効開始年月日 = new FlexibleDate("20140101");
    private static final FlexibleDate 有効終了年月日 = new FlexibleDate("20140401");

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 有効期間月数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiYukoKikan(AS_有効期間月数がNULL);
        }

        @Test(expected = NullPointerException.class)
        public void 有効期間がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            createNinteiYukoKikan(AS_有効期間がNULL);
        }

        @Test
        public void 有効開始年月日がNULLの時_コンストラクタは_有効終了年月日から有効期間月数を引いた年月日を設定する() {
            assertThat(createNinteiYukoKikan(AS_有効開始年月日がNULL).get有効期間().getFrom(), is(有効終了年月日.minusMonth(有効期間月数.value())));
        }

        @Test
        public void 有効終了年月日がNULLの時_コンストラクタは_有効開始年月日に有効期間月数を足した年月日を設定する() {
            assertThat(createNinteiYukoKikan(AS_有効終了年月日がNULL).get有効期間().getTo(), is(有効開始年月日.plusMonth(有効期間月数.value())));
        }
    }

    private static NinteiYukoKikan createNinteiYukoKikan(int flg) {
        return new NinteiYukoKikan(
                flg == AS_有効期間月数がNULL ? null : 有効期間月数,
                flg == AS_有効開始年月日がNULL || flg == AS_有効期間がNULL ? null : 有効開始年月日,
                flg == AS_有効終了年月日がNULL || flg == AS_有効期間がNULL ? null : 有効終了年月日);
    }
}

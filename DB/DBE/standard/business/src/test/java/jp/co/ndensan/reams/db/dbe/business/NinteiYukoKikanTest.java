/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
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
public class NinteiYukoKikanTest extends DbeTestBase {

    private static final FlexibleDate 有効開始年月日 = new FlexibleDate("20140101");
    private static final NinteiYukoKikanTsukisu 有効期間月数 = new NinteiYukoKikanTsukisu(5);
    private static final FlexibleDate 有効終了年月日 = new FlexibleDate("20140601");

    public static class コンストラクタ_有効開始年月日_有効期間月数_指定 extends DbeTestBase {

        @Test
        public void 有効開始年月日と有効期間月数を指定した時_コンストラクタは_有効開始年月日に有効期間月数を足した年月日を有効終了年月日に設定する() {
            assertThat(new NinteiYukoKikan(有効開始年月日, 有効期間月数).get有効期間().getTo(), is(有効終了年月日));
        }
    }

    public static class コンストラクタ_有効開始年月日_有効期間月数_有効終了年月日_指定 extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 有効開始年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteiYukoKikan(null, 有効期間月数, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効期間月数がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteiYukoKikan(有効開始年月日, null, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効終了年月日がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteiYukoKikan(有効開始年月日, 有効期間月数, null);
        }
    }

    public static class コンストラクタ_有効期間月数_有効終了年月日_指定 extends DbeTestBase {

        @Test
        public void 有効期間月数と有効終了年月日を指定した時_コンストラクタは_有効終了年月日から有効期間月数を引いた年月日を有効開始年月日に設定する() {
            assertThat(new NinteiYukoKikan(有効期間月数, 有効終了年月日).get有効期間().getFrom(), is(有効開始年月日));
        }
    }
}

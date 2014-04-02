/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.IHihokenshaNoGettable;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

/**
 * HihokenshaNoComparatorのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaNoComparatorTest extends DbzTestBase {

    private static KaigoHihokenshaNo n0000000001 = new KaigoHihokenshaNo(new RString("0000000001"));
    private static KaigoHihokenshaNo n0000000002 = new KaigoHihokenshaNo(new RString("0000000002"));
    private static KaigoHihokenshaNo n0000000003 = new KaigoHihokenshaNo(new RString("0000000003"));
    private static KaigoHihokenshaNo n0000000004 = new KaigoHihokenshaNo(new RString("0000000004"));

    /**
     * HihokenshaNoComparatorTest用のIHihokenshaNoGettable単純実装クラスです。
     */
    private static class Sample implements IHihokenshaNoGettable {

        private final KaigoHihokenshaNo hihokenshaNo;

        public Sample(KaigoHihokenshaNo hihokenshaNo) {
            this.hihokenshaNo = hihokenshaNo;
        }

        @Override
        public KaigoHihokenshaNo get被保険者番号() {
            return this.hihokenshaNo;
        }
    }

    public static class ASC extends DbzTestBase {

        List<Sample> sampleList;
        HihokenshaNoComparator sut;

        @Before
        public void setUp() {
            sampleList = createSampleList();
            sut = HihokenshaNoComparator.ASC;
            Collections.sort(sampleList, sut);
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の先頭要素は_もっとも小さな値を返す() {
            assertThat(sampleList.get(0).get被保険者番号(), is(n0000000001));
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の2番目の要素は_2番目に小さな値を返す() {
            assertThat(sampleList.get(1).get被保険者番号(), is(n0000000002));
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の3番目の要素は_3番目に小さな値を返す() {
            assertThat(sampleList.get(2).get被保険者番号(), is(n0000000003));
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の最後の要素は_もっともに大きな値を返す() {
            int lastIndex = sampleList.size() - 1;
            assertThat(sampleList.get(lastIndex).get被保険者番号(), is(n0000000004));
        }
    }

    public static class DESC extends DbzTestBase {

        List<Sample> sampleList;
        HihokenshaNoComparator sut;

        @Before
        public void setUp() {
            sampleList = createSampleList();
            sut = HihokenshaNoComparator.DESC;
            Collections.sort(sampleList, sut);
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の先頭要素は_もっともに大きな値を返す() {
            assertThat(sampleList.get(0).get被保険者番号(), is(n0000000004));
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の2番目の要素は_2番目に大きな値を返す() {
            assertThat(sampleList.get(1).get被保険者番号(), is(n0000000003));
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の3番目の要素は_3番目に大きな値を返す() {
            assertThat(sampleList.get(2).get被保険者番号(), is(n0000000002));
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の最後の要素は_もっとも小さな値を返す() {
            int lastIndex = sampleList.size() - 1;
            assertThat(sampleList.get(lastIndex).get被保険者番号(), is(n0000000001));
        }
    }

    private static List<Sample> createSampleList() {
        List<Sample> smapleList = new ArrayList<>();
        smapleList.add(new Sample(n0000000003));
        smapleList.add(new Sample(n0000000004));
        smapleList.add(new Sample(n0000000001));
        smapleList.add(new Sample(n0000000002));
        return smapleList;
    }
}

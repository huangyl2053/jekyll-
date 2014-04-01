/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.IShikibetsuCodeGettable;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SortOrder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

/**
 * ShikibetsuCodeComparatorのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ShikibetsuCodeComparatorTest extends DbzTestBase {

    private static ShikibetsuCode n0000000001 = new ShikibetsuCode("0000000001");
    private static ShikibetsuCode n0000000002 = new ShikibetsuCode("0000000002");
    private static ShikibetsuCode n0000000003 = new ShikibetsuCode("0000000003");
    private static ShikibetsuCode n0000000004 = new ShikibetsuCode("0000000004");

    /**
     * ShikibetsuCodeComparatorTest用のIShikibetsuCodeGettable単純実装クラスです。
     */
    private static class Sample implements IShikibetsuCodeGettable {

        private final ShikibetsuCode shikibetsuCode;

        public Sample(ShikibetsuCode shikibetsuCode) {
            this.shikibetsuCode = shikibetsuCode;
        }

        @Override
        public ShikibetsuCode get識別コード() {
            return this.shikibetsuCode;
        }
    }

    public static class ASC extends DbzTestBase {

        List<Sample> sampleList;
        ShikibetsuCodeComparator<Sample> sut;

        @Before
        public void setUp() {
            sampleList = createSampleList();
            sut = new ShikibetsuCodeComparator<>(SortOrder.ASC);
            Collections.sort(sampleList, sut);
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の先頭要素は_もっとも小さな値を返す() {
            assertThat(sampleList.get(0).get識別コード(), is(n0000000001));
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の2番目の要素は_2番目に小さな値を返す() {
            assertThat(sampleList.get(1).get識別コード(), is(n0000000002));
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の3番目の要素は_3番目に小さな値を返す() {
            assertThat(sampleList.get(2).get識別コード(), is(n0000000003));
        }

        @Test
        public void ASCを引数に作成したsutによりsortしたとき_結果の最後の要素は_もっともに大きな値を返す() {
            int lastIndex = sampleList.size() - 1;
            assertThat(sampleList.get(lastIndex).get識別コード(), is(n0000000004));
        }
    }

    public static class DESC extends DbzTestBase {

        List<Sample> sampleList;
        ShikibetsuCodeComparator<Sample> sut;

        @Before
        public void setUp() {
            sampleList = createSampleList();
            sut = new ShikibetsuCodeComparator<>(SortOrder.DESC);
            Collections.sort(sampleList, sut);
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の先頭要素は_もっともに大きな値を返す() {
            assertThat(sampleList.get(0).get識別コード(), is(n0000000004));
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の2番目の要素は_2番目に大きな値を返す() {
            assertThat(sampleList.get(1).get識別コード(), is(n0000000003));
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の3番目の要素は_3番目に大きな値を返す() {
            assertThat(sampleList.get(2).get識別コード(), is(n0000000002));
        }

        @Test
        public void DESCを引数に作成したsutによりsortしたとき_結果の最後の要素は_もっとも小さな値を返す() {
            int lastIndex = sampleList.size() - 1;
            assertThat(sampleList.get(lastIndex).get識別コード(), is(n0000000001));
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

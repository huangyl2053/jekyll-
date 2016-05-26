/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hanyolisthihokenshadaicho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Before;

/**
 * {@link ShikakShutokuHanteiComparator}のテストです。
 */
@RunWith(Enclosed.class)
public class ShikakShutokuHanteiComparatorTest extends DbaTestBase {

    private static ShikakShutokuHantei o1 = new ShikakShutokuHantei();
    private static ShikakShutokuHantei o2 = new ShikakShutokuHantei();
    private static ShikakShutokuHantei o3 = new ShikakShutokuHantei();
    private static ShikakShutokuHantei o4 = new ShikakShutokuHantei();

    public static class TestClass extends DbaTestBase {

        List<ShikakShutokuHantei> sampleList;
        ShikakShutokuHanteiComparator sut;

        @Before
        public void setUp() {
            sampleList = createSampleList();
            sut = new ShikakShutokuHanteiComparator();
            Collections.sort(sampleList, sut);
        }

        @Test
        public void sortしたとき_結果の先頭要素は_最大の日付を返す() {
            assertThat(sampleList.get(0).getTekiyoYMD(), is(new FlexibleDate("20030401")));
        }

        @Test
        public void sortしたとき_結果の2番目の要素は_2番目に大さな日付を返す() {
            assertThat(sampleList.get(1).getTekiyoYMD(), is(new FlexibleDate("20000401")));
        }

        @Test
        public void sortしたとき_結果の3番目の要素は_3番目に大さな日付を返す() {
            assertThat(sampleList.get(2).getTekiyoYMD(), is(new FlexibleDate("")));
        }

        @Test
        public void sortしたとき_結果の最後の要素は_もっともに小さな日付を返す() {
            int lastIndex = sampleList.size() - 1;
            assertThat(sampleList.get(lastIndex).getTekiyoYMD(), is(nullValue()));
        }
    }

    private static List<ShikakShutokuHantei> createSampleList() {
        List<ShikakShutokuHantei> smapleList = new ArrayList<>();
        o1.setCodeShubetsu("0007");
        o1.setJiyuCode(Code.EMPTY);
        o1.setTekiyoYMD(new FlexibleDate("20000401"));
        o1.setTodokedeYMD(new FlexibleDate("20000402"));
        o2.setCodeShubetsu("0013");
        o2.setJiyuCode(Code.EMPTY);
        o2.setTekiyoYMD(null);
        o2.setTodokedeYMD(null);
        o3.setCodeShubetsu("0014");
        o3.setJiyuCode(Code.EMPTY);
        o3.setTekiyoYMD(new FlexibleDate(""));
        o3.setTodokedeYMD(new FlexibleDate(""));
        o4.setCodeShubetsu("0015");
        o4.setJiyuCode(Code.EMPTY);
        o4.setTekiyoYMD(new FlexibleDate("20030401"));
        o4.setTodokedeYMD(new FlexibleDate("20030402"));

        smapleList.add(o1);
        smapleList.add(o2);
        smapleList.add(o3);
        smapleList.add(o4);
        return smapleList;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 契約番号を表すクラスのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class KeiyakuNoTest extends DbcTestBase {

    private static KeiyakuNo sut;

    public static class ConstructorTest {

        @Test(expected = NullPointerException.class)
        public void 引数がnullの時_NullPointerExceptionが発生する() {
            sut = new KeiyakuNo(null);
        }
    }

    public static class EqualsTest {

        @Test
        public void 比較対象と値が一致しない時_falseを返す() {
            sut = createKeiyakuNo("1234567890");
            KeiyakuNo testData = createKeiyakuNo("0000000000");

            assertThat(sut.equals(testData), is(false));
        }

        @Test
        public void 比較対象と値が一致した時_trueを返す() {
            sut = createKeiyakuNo("1234567890");
            KeiyakuNo testData = createKeiyakuNo("1234567890");

            assertThat(sut.equals(testData), is(true));
        }
    }

    public static class HashCodeTest {

        @Test
        public void 同一の値で生成されたインスタンス同士は_同一の値を返す() {
            sut = createKeiyakuNo("1234567890");
            KeiyakuNo testData = createKeiyakuNo("1234567890");

            assertThat(sut.hashCode(), is(testData.hashCode()));
        }

        @Test
        public void 異なる値で生成されたインスタンス同士は_異なる値を返す() {
            sut = createKeiyakuNo("1234567890");
            KeiyakuNo testData = createKeiyakuNo("0000000000");

            assertThat(sut.hashCode(), not(testData.hashCode()));
        }
    }

    public static class CompareToTest {

        KeiyakuNo testData;

        @Test
        public void 比較対象と値が一致する時_0を返す() {
            sut = createKeiyakuNo("1234567890");
            testData = createKeiyakuNo("1234567890");

            assertThat(sut.compareTo(testData), is(0));
        }

        @Test
        public void 自身より小さい値と比較した時_0より大きい値を返す() {
            sut = createKeiyakuNo("1234567890");
            testData = createKeiyakuNo("0000000000");

            assertThat(sut.compareTo(testData) > 0, is(true));
        }

        @Test
        public void 自身より大きい値と比較した時_0より小さい値を返す() {
            sut = createKeiyakuNo("1234567890");
            testData = createKeiyakuNo("9999999999");

            assertThat(sut.compareTo(testData) < 0, is(true));
        }
    }

    private static KeiyakuNo createKeiyakuNo(String no) {
        return new KeiyakuNo(new RString(no));
    }
}

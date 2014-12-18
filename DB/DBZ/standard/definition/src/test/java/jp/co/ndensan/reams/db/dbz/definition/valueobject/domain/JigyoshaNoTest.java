/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 受領委任契約事業者番号を表すテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JigyoshaNoTest extends DbzTestBase {

    private static JigyoshaNo sut;

    public static class EqualsTest {

        @Test
        public void 比較対象がnullの時_falseを返す() {
            sut = createJigyoshaNo("1234567890");
            assertThat(sut.equals(null), is(false));
        }

        @Test
        public void 比較対象がJigyoshaNoのインスタンスでない時_falseを返す() {
            sut = createJigyoshaNo("1234567890");
            RString testData = new RString("testData");

            assertThat(sut.equals(testData), is(false));
        }

        @Test
        public void 比較対象と値が一致しない時_falseを返す() {
            sut = createJigyoshaNo("1234567890");
            JigyoshaNo testData = createJigyoshaNo("0000000000");

            assertThat(sut.equals(testData), is(false));
        }

        @Test
        public void 比較対象と値が一致した時_trueを返す() {
            sut = createJigyoshaNo("1234567890");
            JigyoshaNo testData = createJigyoshaNo("1234567890");

            assertThat(sut.equals(testData), is(true));
        }
    }

    public static class HashCodeTest {

        @Test
        public void 同一の値で生成されたインスタンス同士は_同一の値を返す() {
            sut = createJigyoshaNo("1234567890");
            JigyoshaNo testData = createJigyoshaNo("1234567890");

            assertThat(sut.hashCode(), is(testData.hashCode()));
        }
    }

    public static class CompareToTest {

        JigyoshaNo testData;

        @Test
        public void 比較対象と値が一致する時_0を返す() {
            sut = createJigyoshaNo("1234567890");
            testData = createJigyoshaNo("1234567890");

            assertThat(sut.compareTo(testData), is(0));
        }

        @Test
        public void 自身より小さい値と比較した時_0より大きい値を返す() {
            sut = createJigyoshaNo("1234567890");
            testData = createJigyoshaNo("0000000000");

            assertThat(sut.compareTo(testData) > 0, is(true));
        }

        @Test
        public void 自身より大きい値と比較した時_0より小さい値を返す() {
            sut = createJigyoshaNo("1234567890");
            testData = createJigyoshaNo("9999999999");

            assertThat(sut.compareTo(testData) < 0, is(true));
        }
    }

    public static class isEmpty extends DbzTestBase {

        @Test
        public void EMPTYのisEmptyは_trueを返す() {
            JigyoshaNo sut = JigyoshaNo.EMPTY;
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void EMPTYと同じ値を持たないインスタンスのisEmptyは_falseを返す() {
            JigyoshaNo sut = new JigyoshaNo("100");
            assertThat(sut.value(), is(not(JigyoshaNo.EMPTY.value())));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    private static JigyoshaNo createJigyoshaNo(String no) {
        return new JigyoshaNo(new RString(no));
    }
}

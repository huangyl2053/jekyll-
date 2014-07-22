/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 施設コードを表すクラスのテストです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuCodeTest extends DbzTestBase {

    private static ShisetsuCode sut;

    public static class constructor {

        @Test(expected = NullPointerException.class)
        public void 引数がnullの時_NullPointerExceptionが発生する() {
            sut = new ShisetsuCode(null);
        }
    }

    public static class equals {

        @Test
        public void 比較対象と値が一致しない時_falseを返す() {
            sut = createShisetsuCode("1234567890");
            ShisetsuCode testData = createShisetsuCode("0000000000");

            assertThat(sut.equals(testData), is(false));
        }

        @Test
        public void 比較対象と値が一致した時_trueを返す() {
            sut = createShisetsuCode("1234567890");
            ShisetsuCode testData = createShisetsuCode("1234567890");

            assertThat(sut.equals(testData), is(true));
        }
    }

    public static class hashCode {

        @Test
        public void 同一の値で生成されたインスタンス同士は_同一の値を返す() {
            sut = createShisetsuCode("1234567890");
            ShisetsuCode testData = createShisetsuCode("1234567890");

            assertThat(sut.hashCode(), is(testData.hashCode()));
        }

        @Test
        public void 異なる値で生成されたインスタンス同士は_異なる値を返す() {
            sut = createShisetsuCode("1234567890");
            ShisetsuCode testData = createShisetsuCode("0000000000");

            assertThat(sut.hashCode(), not(testData.hashCode()));
        }
    }

    public static class compareTo {

        ShisetsuCode testData;

        @Test
        public void 比較対象と値が一致する時_0を返す() {
            sut = createShisetsuCode("1234567890");
            testData = createShisetsuCode("1234567890");

            assertThat(sut.compareTo(testData), is(0));
        }

        @Test
        public void 自身より小さい値と比較した時_0より大きい値を返す() {
            sut = createShisetsuCode("1234567890");
            testData = createShisetsuCode("0000000000");

            assertThat(sut.compareTo(testData) > 0, is(true));
        }

        @Test
        public void 自身より大きい値と比較した時_0より小さい値を返す() {
            sut = createShisetsuCode("1234567890");
            testData = createShisetsuCode("9999999999");

            assertThat(sut.compareTo(testData) < 0, is(true));
        }
    }

    private static ShisetsuCode createShisetsuCode(String no) {
        return new ShisetsuCode(new RString(no));
    }
}

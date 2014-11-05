/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject.domain;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * サービスコードを表すクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ServiceCodeTest extends DbzTestBase {

    private static ServiceCode sut;

    public static class value {

        @Test
        public void 保持しているサービスコードをRString型で取得できる() {
            String sampleServiceCode = "114845";
            sut = createServiceCode(sampleServiceCode);
            assertThat(sut.value(), is(new RString(sampleServiceCode)));
        }
    }

    public static class CompareTo {

        ServiceCode testData;

        @Test
        public void 比較対象と値が一致する時_0を返す() {
            sut = createServiceCode("1234567890");
            testData = createServiceCode("1234567890");

            assertThat(sut.compareTo(testData), is(0));
        }

        @Test
        public void 自身より小さい値と比較した時_0より大きい値を返す() {
            sut = createServiceCode("1234567890");
            testData = createServiceCode("0000000000");

            assertThat(sut.compareTo(testData) > 0, is(true));
        }

        @Test
        public void 自身より大きい値と比較した時_0より小さい値を返す() {
            sut = createServiceCode("1234567890");
            testData = createServiceCode("9999999999");

            assertThat(sut.compareTo(testData) < 0, is(true));
        }
    }

    public static class Equals {

        @Test
        public void 比較対象と値が一致しない時_falseを返す() {
            sut = createServiceCode("1234567890");
            ServiceCode testData = createServiceCode("0000000000");

            assertThat(sut.equals(testData), is(false));
        }

        @Test
        public void 比較対象と値が一致した時_trueを返す() {
            sut = createServiceCode("1234567890");
            ServiceCode testData = createServiceCode("1234567890");

            assertThat(sut.equals(testData), is(true));
        }
    }

    public static class HashCode {

        @Test
        public void 同一の値で生成されたインスタンス同士は_同一の値を返す() {
            sut = createServiceCode("1234567890");
            ServiceCode testData = createServiceCode("1234567890");

            assertThat(sut.hashCode(), is(testData.hashCode()));
        }
    }

    private static ServiceCode createServiceCode(String code) {
        return new ServiceCode(new RString(code));
    }
}

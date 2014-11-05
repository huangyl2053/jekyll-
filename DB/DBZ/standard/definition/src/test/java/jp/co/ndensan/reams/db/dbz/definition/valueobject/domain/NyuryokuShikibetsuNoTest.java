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
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 入力識別番号のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NyuryokuShikibetsuNoTest extends DbzTestBase {

    private static NyuryokuShikibetsuNo sut1;
    private static NyuryokuShikibetsuNo sut2;

    public static class constructorのテスト extends DbzTestBase {

        @Test
        public void 引数にnullでない値が渡されたとき_インスタンスが生成される() {
            sut1 = new NyuryokuShikibetsuNo(new RString("0123"));
            assertThat(sut1, isA(NyuryokuShikibetsuNo.class));
        }
    }

    public static class hashCodeのテスト extends DbzTestBase {

        @Before
        public void setUp() {
            sut1 = new NyuryokuShikibetsuNo(new RString("0123"));
        }

        @Test
        public void 同値の値を持つ入力識別番号は_hashCodeの値が一致する() {
            sut2 = new NyuryokuShikibetsuNo(new RString("0123"));
            assertThat(sut1.hashCode(), is(sut2.hashCode()));
        }
    }

    public static class equalsのテスト extends DbzTestBase {

        @Before
        public void setUp() {
            sut1 = new NyuryokuShikibetsuNo(new RString("0123"));
        }

        @Test
        public void null値と比較した場合_falseが返る() {
            assertThat(sut1.equals(null), is(false));
        }

        @Test
        public void 異なる型のオブジェクトと比較した場合_falseが返る() {
            assertThat(sut1.equals(new RString("0123")), is(false));
        }

        @Test
        public void 異なる値を持つ入力識別番号と比較した場合_falseが返る() {
            sut2 = new NyuryokuShikibetsuNo(new RString("0124"));
            assertThat(sut1.equals(sut2), is(false));
        }

        @Test
        public void 同値を持つ入力識別番号と比較した場合_trueが返る() {
            sut2 = new NyuryokuShikibetsuNo(new RString("0123"));
            assertThat(sut1.equals(sut2), is(true));
        }
    }

    public static class compareToのテスト extends DbzTestBase {

        @Before
        public void setUp() {
            sut1 = new NyuryokuShikibetsuNo(new RString("0123"));
        }

        @Test
        public void 自身より大きい値と比較した場合_0より小さい値が返る() {
            sut2 = new NyuryokuShikibetsuNo(new RString("0124"));
            assertThat(sut1.compareTo(sut2) < 0, is(true));
        }

        @Test
        public void 同値と比較した場合_0が返る() {
            sut2 = new NyuryokuShikibetsuNo(new RString("0123"));
            assertThat(sut1.compareTo(sut2) == 0, is(true));
        }

        @Test
        public void 自身より小さい値と比較した場合_0より大きい値が返る() {
            sut2 = new NyuryokuShikibetsuNo(new RString("0122"));
            assertThat(sut1.compareTo(sut2) > 0, is(true));
        }
    }

    public static class isEmpty extends DbzTestBase {

        @Test
        public void EMPTYのisEmptyは_trueを返す() {
            NyuryokuShikibetsuNo sut = NyuryokuShikibetsuNo.EMPTY;
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void EMPTYとequalsでtrueを返さないインスタンスのisEmptyは_falseを返す() {
            NyuryokuShikibetsuNo sut = new NyuryokuShikibetsuNo("100");
            assertThat(sut.equals(NyuryokuShikibetsuNo.EMPTY), is(false));
            assertThat(sut.isEmpty(), is(false));
        }
    }
}

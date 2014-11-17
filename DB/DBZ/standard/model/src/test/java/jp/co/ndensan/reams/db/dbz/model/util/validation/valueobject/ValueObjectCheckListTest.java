/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import java.util.Iterator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * ValueObjectCheckListのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ValueObjectCheckListTest extends DbzTestBase {

    public ValueObjectCheckListTest() {
    }

    public static class checks extends DbzTestBase {

        private ValueObjectCheckList sut;
        private IValueObjectCheckable<RString> check1;
        private IValueObjectCheckable<RString> check2;

        @Before
        public void setUp() {
            check1 = mock(IValueObjectCheckable.class);
            check2 = mock(IValueObjectCheckable.class);
        }

        @Test(expected = NullPointerException.class)
        public void checksは_引数がnullの時_NullPointerExceptionをスローする() {
            sut.checks((IValueObjectCheckable<Object>[]) null);
        }

        @Test
        public void checksは_引数が1つの時_ValueObjectCheckListのインスタンスを生成する() {
            assertThat(sut.checks(check1), isA(ValueObjectCheckList.class));
        }

        @Test
        public void checksは_引数が2つの時_ValueObjectCheckListのインスタンスを生成する() {
            assertThat(sut.checks(check1, check2), isA(ValueObjectCheckList.class));
        }

        @Test(expected = IllegalArgumentException.class)
        public void checksは_引数にnullを含むの時_IllegalArgumentExceptionをスローする() {
            sut.checks(check1, (IValueObjectCheckable<RString>) null);
        }
    }

    public static class iterator extends DbzTestBase {

        private ValueObjectCheckList sut;
        private IValueObjectCheckable<RString> check1;
        private IValueObjectCheckable<RString> check2;

        @Before
        public void setUp() {
            check1 = mock(IValueObjectCheckable.class);
            check2 = mock(IValueObjectCheckable.class);
        }

        @Test
        public void iteratorは_Iteratorのインスタンスを返す() {
            assertThat(sut.checks(check1, check2).iterator(), isA(Iterator.class));
        }
    }

    public static class size extends DbzTestBase {

        private ValueObjectCheckList sut;
        private IValueObjectCheckable<RString> check1;
        private IValueObjectCheckable<RString> check2;

        @Before
        public void setUp() {
            check1 = mock(IValueObjectCheckable.class);
            check2 = mock(IValueObjectCheckable.class);
        }

        @Test
        public void sizeは_引数が1つの時_1を返す() {
            assertThat(sut.checks(check1).size(), is(1));
        }

        @Test
        public void sizeは_引数が2つの時_2を返す() {
            assertThat(sut.checks(check1, check2).size(), is(2));
        }
    }
}

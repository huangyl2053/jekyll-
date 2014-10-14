/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * みなし2号者Listのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaListTest {

    private static Minashi2GoshaList sut;

    public static class Constructor extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new Minashi2GoshaList(null);
            fail();
        }
    }

    public static class Size extends DbeTestBase {

        @Test
        public void コンストラクタの引数に_3件の要素を持つListを渡した場合_3が返る() {
            sut = new Minashi2GoshaList(createList(3));
            assertThat(sut.size(), is(3));
        }
    }

    public static class IsEmpty extends DbeTestBase {

        @Test
        public void コンストラクタの引数に_3件の要素を持つListを渡した場合_falseが返る() {
            sut = new Minashi2GoshaList(createList(3));
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタの引数に_空のListを渡した場合_true() {
            sut = new Minashi2GoshaList(createList(0));
            assertThat(sut.isEmpty(), is(true));
        }
    }

    private static List<Minashi2Gosha> createList(int size) {
        List<Minashi2Gosha> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(mock(Minashi2Gosha.class));
        }
        return list;
    }

}

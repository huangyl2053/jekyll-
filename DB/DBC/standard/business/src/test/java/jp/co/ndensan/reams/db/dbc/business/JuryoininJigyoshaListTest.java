/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 *
 * 受領委任事業者リストのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JuryoininJigyoshaListTest extends TestBase {

    private static JuryoininJigyoshaList sut;

    public static class Test_constructor {

        @Test(expected = NullPointerException.class)
        public void 受領委任事業者Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new JuryoininJigyoshaList(null);
        }
    }

    public static class Test_isEmpty {

        @Test
        public void 受領委任事業者ListがEmptyの時_trueが返る() {
            sut = new JuryoininJigyoshaList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 受領委任事業者ListがEmptyでない時_falseが返る() {
            sut = new JuryoininJigyoshaList(createMockList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class Test_size extends DbeTestBase {

        @Test
        public void 受領委任事業者Listが3件の情報を持っている時_3が返る() {
            sut = new JuryoininJigyoshaList(createMockList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<JuryoininJigyosha> createMockList(int 件数) {
        List<JuryoininJigyosha> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(mock(JuryoininJigyosha.class));
        }
        return list;
    }
}

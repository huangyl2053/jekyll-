/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.core.JogaiShinsakaiIin.JogaiShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.core.JogaiShinsakaiIin.JogaiShinsakaiIin;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 除外対象審査会委員リストのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JogaiShinsakaiIinListTest {

    private static JogaiShinsakaiIinList sut;

    public static class コンストラクタのテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new JogaiShinsakaiIinList(null);
            fail();
        }

        @Test

        public void 引数に3件の要素を持つリストが渡されたとき_インスタンスが生成される() {
            sut = createListMock(3);
            assertThat(sut, is(instanceOf(
                    JogaiShinsakaiIinList.class)));
        }
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Test
        public void リストが空の場合_trueが返る() {
            sut = createListMock(0);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void リストが空で無い場合_falseが返る() {
            sut = createListMock(5);
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void リストの要素が3つの場合_3を返す() {
            sut = createListMock(3);
            assertThat(sut.size(), is(3));
        }
    }

    private static JogaiShinsakaiIinList createListMock(int 件数) {
        List<JogaiShinsakaiIin> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            JogaiShinsakaiIin iin = mock(JogaiShinsakaiIin.class);
            list.add(iin);
        }
        return new JogaiShinsakaiIinList(list);
    }
}

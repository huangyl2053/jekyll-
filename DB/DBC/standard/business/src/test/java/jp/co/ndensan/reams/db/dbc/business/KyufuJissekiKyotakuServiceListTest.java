/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 給付実績居宅サービスListのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyufuJissekiKyotakuServiceListTest {

    private static KyufuJissekiKyotakuServiceList sut;

    public static class constructorのテスト extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuServiceList(null);
            fail();
        }

        public void 引数に要素が渡されたとき_インスタンスが生成される() {
            sut = new KyufuJissekiKyotakuServiceList(createList(3));
            assertThat(sut, is(instanceOf(KyufuJissekiKyotakuServiceList.class)));
        }
    }

    public static class sizeのテスト extends DbcTestBase {

        @Test
        public void 要素を3件持つListの場合_3を返す() {
            sut = new KyufuJissekiKyotakuServiceList(createList(3));
            assertThat(sut.size(), is(3));
        }
    }

    public static class isEmptyのテスト extends DbcTestBase {

        @Test
        public void 要素を0件持つListの場合_true() {
            sut = new KyufuJissekiKyotakuServiceList(createList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 要素を3件持つListの場合_falseを返す() {
            sut = new KyufuJissekiKyotakuServiceList(createList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    private static List<KyufuJissekiKyotakuService> createList(int 件数) {
        List<KyufuJissekiKyotakuService> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            KyufuJissekiKyotakuService mock = mock(KyufuJissekiKyotakuService.class);
            list.add(mock);
        }
        return list;
    }

}

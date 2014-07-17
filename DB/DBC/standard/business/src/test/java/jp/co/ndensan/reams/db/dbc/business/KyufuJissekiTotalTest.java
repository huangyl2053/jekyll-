/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 給付実績の月別集計を保持するクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiTotalTest extends DbcTestBase {

    public static class ConstructorTest extends DbcTestBase {

        private static KyufuJissekiTotal sut;

        private static KyufuJissekiServiceCollection サービス種類集計リスト;
        private static KyufuJissekiServiceShukeiCollection 特定サービス種類集計リスト;
        private static ServiceTeikyoYM サービス提供年月;

        @Before
        public void setUp() {
            サービス種類集計リスト = mock(KyufuJissekiServiceCollection.class);
            特定サービス種類集計リスト = mock(KyufuJissekiServiceShukeiCollection.class);
            サービス提供年月 = mock(ServiceTeikyoYM.class);
        }

        @Test(expected = NullPointerException.class)
        public void サービス種類集計リストがnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiTotal(null, 特定サービス種類集計リスト, サービス提供年月);
        }

        @Test(expected = NullPointerException.class)
        public void 特定サービス種類集計リストがnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiTotal(サービス種類集計リスト, null, サービス提供年月);
        }

        @Test(expected = NullPointerException.class)
        public void サービス提供年月がnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiTotal(サービス種類集計リスト, 特定サービス種類集計リスト, null);
        }
    }
}

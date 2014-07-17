/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiShukeiGokeiTaisho;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 給付実績の特定のサービス種類の給付実績集計額のCollectionのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceShukeiCollectionTest {

    private static KyufuJissekiServiceShukeiCollection sut;

    public static class コンストラクタのテスト extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiServiceShukeiCollection(null);
        }
    }

    public static class get給付実績集計のテスト extends DbcTestBase {

        public void setUp() {
        }

        @Test
        public void 合計対象_居宅サービス合計を指定したとき_居宅サービス合計の_合計単位を返す() {
            sut = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());
            assertThat(sut.get給付実績特定サービス集計(KyufuJissekiShukeiGokeiTaisho.居宅サービス合計).get合計単位(), is(new Decimal("100")));
        }

        @Test
        public void 合計対象_施設サービス合計を指定したとき_施設サービス合計の_合計単位を返す() {
            sut = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());
            assertThat(sut.get給付実績特定サービス集計(KyufuJissekiShukeiGokeiTaisho.施設サービス合計).get合計単位(), is(new Decimal("200")));
        }

        @Test
        public void 合計対象_地域密着型サービス合計を指定したとき_地域密着型サービス合計の_合計単位を返す() {
            sut = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());
            assertThat(sut.get給付実績特定サービス集計(KyufuJissekiShukeiGokeiTaisho.地域密着型サービス合計).get合計単位(), is(new Decimal("300")));
        }

        @Test
        public void 合計対象にnullを指定したとき_存在しないためnullを返す() {
            sut = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());
            assertThat(sut.get給付実績特定サービス集計(null), nullValue());
        }
    }

    public static class isEmptyのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_isEmptyはfalseを返す() {
            sut = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_isEmptyはtrueを返す() {
            sut = new KyufuJissekiServiceShukeiCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class sizeのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_sizeは3を返す() {
            sut = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());
            assertThat(sut.size(), is(3));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KyufuJissekiServiceShukeiCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static List<KyufuJissekiServiceShukei> create給付実績サービス種類集計List() {
        List<KyufuJissekiServiceShukei> list = new ArrayList<>();
        list.add(create給付実績特定サービス(KyufuJissekiShukeiGokeiTaisho.居宅サービス合計, new Decimal("100")));
        list.add(create給付実績特定サービス(KyufuJissekiShukeiGokeiTaisho.施設サービス合計, new Decimal("200")));
        list.add(create給付実績特定サービス(KyufuJissekiShukeiGokeiTaisho.地域密着型サービス合計, new Decimal("300")));
        return list;
    }

    private static KyufuJissekiServiceShukei create給付実績特定サービス(
            KyufuJissekiShukeiGokeiTaisho 合計対象,
            Decimal 合計単位) {
        KyufuJissekiKeyInfo 給付実績キー情報 = mock(KyufuJissekiKeyInfo.class);

        KyufuJissekiServiceShukei kyufuJissekiShukei = new KyufuJissekiServiceShukei(
                合計対象,
                合計単位,
                給付実績キー情報);

        return kyufuJissekiShukei;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 福祉用具購入費リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiYoguHanbaihiCollectionTest extends DbcTestBase {

    private static KyufuJissekiYoguHanbaihiCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績福祉用具購入費リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiYoguHanbaihiCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績福祉用具購入費リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiYoguHanbaihiCollection(createKyufuJissekiYoguHanbaihiList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績福祉用具購入費リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiYoguHanbaihiCollection(createKyufuJissekiYoguHanbaihiList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績福祉用具購入費リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiYoguHanbaihiCollection(createKyufuJissekiYoguHanbaihiList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績福祉用具購入費リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiYoguHanbaihiCollection(createKyufuJissekiYoguHanbaihiList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiYoguHanbaihi> createKyufuJissekiYoguHanbaihiList(int size) {
        List<KyufuJissekiYoguHanbaihi> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiYoguHanbaihi());
        }
        return list;
    }

    private static KyufuJissekiYoguHanbaihi createKyufuJissekiYoguHanbaihi() {
        return new KyufuJissekiYoguHanbaihi(
                new RString("サービス"),
                new FlexibleDate("20140101"),
                new RString("商品名"),
                new RString("種目"),
                new RString("製造事業者名"),
                new RString("販売事業者名"),
                new Decimal(1000),
                new FlexibleYearMonth("201402"),
                new RString("摘要"));
    }
}

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
 * 住宅改修費情報リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiJutakuKaishuhiCollectionTest extends DbcTestBase {

    private static KyufuJissekiJutakuKaishuhiCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績住宅改修費情報リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiJutakuKaishuhiCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績住宅改修費情報リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiJutakuKaishuhiCollection(createKyufuJissekiJutakuKaishuhiList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績住宅改修費情報リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiJutakuKaishuhiCollection(createKyufuJissekiJutakuKaishuhiList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績住宅改修費情報リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiJutakuKaishuhiCollection(createKyufuJissekiJutakuKaishuhiList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績住宅改修費情報リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiJutakuKaishuhiCollection(createKyufuJissekiJutakuKaishuhiList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiJutakuKaishuhi> createKyufuJissekiJutakuKaishuhiList(int size) {
        List<KyufuJissekiJutakuKaishuhi> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiJutakuKaishuhi());
        }
        return list;
    }

    private static KyufuJissekiJutakuKaishuhi createKyufuJissekiJutakuKaishuhi() {
        return new KyufuJissekiJutakuKaishuhi(
                new RString("サービス"),
                new FlexibleDate("20140101"),
                new RString("事業者名"),
                new RString("改修先住所"),
                new Decimal(1000),
                new FlexibleYearMonth("201402"));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 給付実績の特定入所者費情報リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiTokuteiNyushohiCollectionTest extends DbcTestBase {

    private static KyufuJissekiTokuteiNyushohiCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績の特定入所者費情報リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiTokuteiNyushohiCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績の特定入所者費情報リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiTokuteiNyushohiCollection(createKyufuJissekiTokuteiNyushohiList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績の特定入所者費情報リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiTokuteiNyushohiCollection(createKyufuJissekiTokuteiNyushohiList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績の特定入所者費情報リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiTokuteiNyushohiCollection(createKyufuJissekiTokuteiNyushohiList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績の特定入所者費情報リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiTokuteiNyushohiCollection(createKyufuJissekiTokuteiNyushohiList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiTokuteiNyushohi> createKyufuJissekiTokuteiNyushohiList(int size) {
        List<KyufuJissekiTokuteiNyushohi> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiTokuteiNyushohi());
        }
        return list;
    }

    private static KyufuJissekiTokuteiNyushohi createKyufuJissekiTokuteiNyushohi() {
        return new KyufuJissekiTokuteiNyushohi(
                new RString("サービス"), new Decimal(100),
                new RString("後"), new RString("明細"),
                new Decimal(110),
                new Integer(10), new Decimal(120), new Decimal(130), new Decimal(140),
                new Integer(11), new Decimal(150), new Decimal(160), new Decimal(170),
                new Integer(12), new Decimal(180), new Decimal(190), new Decimal(200),
                new Integer(13), new Decimal(210), new Decimal(220), new Decimal(230),
                new Integer(14), new Integer(15), new FlexibleYearMonth("201401"));
    }
}

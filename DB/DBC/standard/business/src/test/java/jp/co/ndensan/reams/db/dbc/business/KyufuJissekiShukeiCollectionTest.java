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
 * 給付実績の集計情報リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiShukeiCollectionTest extends DbcTestBase {

    private static KyufuJissekiShukeiCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績集計リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiShukeiCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績集計リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiShukeiCollection(createKyufuJissekiShukeiList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績集計リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiShukeiCollection(createKyufuJissekiShukeiList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績集計リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiShukeiCollection(createKyufuJissekiShukeiList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績集計リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiShukeiCollection(createKyufuJissekiShukeiList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiShukei> createKyufuJissekiShukeiList(int size) {
        List<KyufuJissekiShukei> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiShukei());
        }
        return list;
    }

    private static KyufuJissekiShukei createKyufuJissekiShukei() {
        return new KyufuJissekiShukei(
                new RString("種類"), 0, new Decimal(1), new Decimal(2), new Decimal(3), 4, new RString("保険"),
                new RString("決定"), 6, new Decimal("7"), new Decimal("8"), new Decimal("9"), new Decimal("10"),
                new Decimal("11"), new Decimal("12"), new Decimal("13"), 14, 15, new FlexibleYearMonth("201401"));
    }
}

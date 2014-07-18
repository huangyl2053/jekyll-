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
 * 給付実績の明細情報リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiMeisaiCollectionTest extends DbcTestBase {

    private static KyufuJissekiMeisaiCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績明細リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiMeisaiCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績明細リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiMeisaiCollection(createKyufuJissekiMeisaiList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績明細リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiMeisaiCollection(createKyufuJissekiMeisaiList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績明細リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiMeisaiCollection(createKyufuJissekiMeisaiList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績明細リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiMeisaiCollection(createKyufuJissekiMeisaiList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiMeisai> createKyufuJissekiMeisaiList(int size) {
        List<KyufuJissekiMeisai> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiMeisai());
        }
        return list;
    }

    private static KyufuJissekiMeisai createKyufuJissekiMeisai() {
        return new KyufuJissekiMeisai(
                new RString("サービス"), new RString("適要"), new RString("決定"),
                new Decimal(1), 2, 3, 4, 5, new Decimal(6), 7, 8, 9, 10, 11, new FlexibleYearMonth("201401"));
    }
}

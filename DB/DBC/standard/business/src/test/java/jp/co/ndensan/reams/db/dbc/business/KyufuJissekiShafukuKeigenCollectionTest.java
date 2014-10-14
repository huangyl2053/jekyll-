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
 * 給付実績社会福祉法人軽減額リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiShafukuKeigenCollectionTest extends DbcTestBase {

    private static KyufuJissekiShafukuKeigenCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績社会福祉法人軽減額リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiShafukuKeigenCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績社会福祉法人軽減額リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiShafukuKeigenCollection(createKyufuJissekiShafukuKeigenList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績社会福祉法人軽減額リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiShafukuKeigenCollection(createKyufuJissekiShafukuKeigenList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績社会福祉法人軽減額リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiShafukuKeigenCollection(createKyufuJissekiShafukuKeigenList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績社会福祉法人軽減額リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiShafukuKeigenCollection(createKyufuJissekiShafukuKeigenList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiShafukuKeigen> createKyufuJissekiShafukuKeigenList(int size) {
        List<KyufuJissekiShafukuKeigen> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiShafukuKeigen());
        }
        return list;
    }

    private static KyufuJissekiShafukuKeigen createKyufuJissekiShafukuKeigen() {
        return new KyufuJissekiShafukuKeigen(
                new RString("軽減率"), new RString("種類"), new RString("前後"),
                new Decimal(0), new Decimal(1), new Decimal(2), new RString("備考"),
                3, 4, new FlexibleYearMonth("201401"));
    }
}

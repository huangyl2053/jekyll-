/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 給付実績の基本情報(合計)リストを保持するコレクションクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuJissekiKihonGokeiCollectionTest extends DbcTestBase {

    private static KyufuJissekiKihonGokeiCollection sut;

    public static class コンストラクタ extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void 給付実績の基本情報_合計_リストがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new KyufuJissekiKihonGokeiCollection(null);
        }
    }

    public static class isEmpty extends DbcTestBase {

        @Test
        public void 給付実績の基本情報_合計_リストが0件の時_isEmptyは_TRUEを返す() {
            sut = new KyufuJissekiKihonGokeiCollection(createKyufuJissekiKihonGokeiList(0));
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 給付実績の基本情報_合計_リストが0件以外の時_isEmptyは_FALSEを返す() {
            sut = new KyufuJissekiKihonGokeiCollection(createKyufuJissekiKihonGokeiList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbcTestBase {

        @Test
        public void 給付実績の基本情報_合計_リストが0件の時_sizeは_0を返す() {
            sut = new KyufuJissekiKihonGokeiCollection(createKyufuJissekiKihonGokeiList(0));
            assertThat(sut.size(), is(0));
        }

        @Test
        public void 給付実績の基本情報_合計_リストが3件の時_sizeは_3を返す() {
            sut = new KyufuJissekiKihonGokeiCollection(createKyufuJissekiKihonGokeiList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<KyufuJissekiKihonGokei> createKyufuJissekiKihonGokeiList(int size) {
        List<KyufuJissekiKihonGokei> list = new ArrayList<>();
        for (int count = 0; count < size; count++) {
            list.add(createKyufuJissekiKihonGokei());
        }
        return list;
    }

    private static KyufuJissekiKihonGokei createKyufuJissekiKihonGokei() {
        return new KyufuJissekiKihonGokei(
                new RString("保険公費"), new RString("前後"),
                new Decimal(0), new Decimal(1), new Decimal(2), new Decimal(3), new Decimal(4), new Decimal(5));
    }
}

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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 給付実績の月別集計のCollectionのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiTotalCollectionTest extends DbcTestBase {

    private static KyufuJissekiTotalCollection sut;

    public static class コンストラクタのテスト extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiTotalCollection(null);
        }
    }

    public static class get給付実績月別集計のテスト extends DbcTestBase {

        public void setUp() {
        }

        @Test
        public void サービス提供年月_2014年1月を指定したとき_2014年1月の_月別集計を返す() {
            sut = new KyufuJissekiTotalCollection(create給付実績月別集計List());
            assertThat(sut.get給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201401"))).getサービス提供年月().value(),
                    is(new ServiceTeikyoYM(new FlexibleYearMonth("201401")).value()));
        }

        @Test
        public void サービス提供年月_2014年3月を指定したとき_2014年3月の_月別集計を返す() {
            sut = new KyufuJissekiTotalCollection(create給付実績月別集計List());
            assertThat(sut.get給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201403"))).getサービス提供年月().value(),
                    is(new ServiceTeikyoYM(new FlexibleYearMonth("201403")).value()));
        }

        @Test
        public void サービス提供年月_2014年4月を指定したとき_存在しないためnullを返す() {
            sut = new KyufuJissekiTotalCollection(create給付実績月別集計List());
            assertThat(sut.get給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201404"))), nullValue());
        }

    }

    public static class isEmptyのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_isEmptyはfalseを返す() {
            sut = new KyufuJissekiTotalCollection(create給付実績月別集計List());
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_isEmptyはtrueを返す() {
            sut = new KyufuJissekiTotalCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class sizeのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_sizeは3を返す() {
            sut = new KyufuJissekiTotalCollection(create給付実績月別集計List());
            assertThat(sut.size(), is(3));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KyufuJissekiTotalCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static List<KyufuJissekiTotal> create給付実績月別集計List() {
        List<KyufuJissekiTotal> list = new ArrayList<>();
        list.add(create給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201401"))));
        list.add(create給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201402"))));
        list.add(create給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201403"))));
        return list;
    }

    private static KyufuJissekiTotal create給付実績月別集計(
            ServiceTeikyoYM サービス提供年月) {
        KyufuJissekiServiceCollection サービス種類集計リスト = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
        KyufuJissekiServiceShukeiCollection 特定サービス種類集計リスト = new KyufuJissekiServiceShukeiCollection(create給付実績サービス種類集計List());

        KyufuJissekiTotal kyufuJissekiTotal = new KyufuJissekiTotal(
                サービス種類集計リスト,
                特定サービス種類集計リスト,
                サービス提供年月);

        return kyufuJissekiTotal;
    }

    private static List<KyufuJissekiService> create給付実績サービス集計List() {
        List<KyufuJissekiService> list = new ArrayList<>();
        list.add(create給付実績サービス("11", new Decimal("10"), new Decimal("11"), new Decimal("12")));
        list.add(create給付実績サービス("12", new Decimal("20"), new Decimal("21"), new Decimal("22")));
        list.add(create給付実績サービス("13", new Decimal("30"), new Decimal("31"), new Decimal("32")));
        list.add(create給付実績サービス("14", new Decimal("40"), new Decimal("41"), new Decimal("42")));
        return list;
    }

    private static KyufuJissekiService create給付実績サービス(
            String サービス種類コード,
            Decimal 利用者負担額合計,
            Decimal 単位数合計,
            Decimal 保険請求分請求額合計) {
        RString 名称 = new RString("名称");
        RString 略称 = new RString("略称");

        ServiceShurui サービス種類 = new ServiceShurui(new Code(サービス種類コード), 名称, 略称);
        KyufuJissekiKeyInfo 給付実績キー情報 = mock(KyufuJissekiKeyInfo.class);

        KyufuJissekiService kyufujissekiService = new KyufuJissekiService(
                サービス種類,
                利用者負担額合計,
                単位数合計,
                保険請求分請求額合計,
                給付実績キー情報);

        return kyufujissekiService;
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

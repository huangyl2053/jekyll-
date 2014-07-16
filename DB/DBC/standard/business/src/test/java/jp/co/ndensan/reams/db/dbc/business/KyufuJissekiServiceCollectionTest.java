/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 給付実績のサービス種類ごとの集計情報のCollectionのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceCollectionTest extends DbcTestBase {

    private static KyufuJissekiServiceCollection sut;

    public static class コンストラクタのテスト extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiServiceCollection(null);
        }
    }

    public static class get給付実績サービスのテスト extends DbcTestBase {

        public void setUp() {
        }

        @Test
        public void サービス種類_11を指定したとき_サービス種類11の_利用者負担額合計を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get給付実績サービス(new ServiceShurui(new Code("11"), new RString("名称"), new RString("略称"))).get利用者負担額合計(), is(new Decimal("10")));
        }

        @Test
        public void サービス種類_11を指定したとき_サービス種類11の_単位数合計を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get給付実績サービス(new ServiceShurui(new Code("11"), new RString("名称"), new RString("略称"))).get単位数合計(), is(new Decimal("11")));
        }

        @Test
        public void サービス種類_11を指定したとき_サービス種類11の_保険請求分請求額合計を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get給付実績サービス(new ServiceShurui(new Code("11"), new RString("名称"), new RString("略称"))).get保険請求分請求額合計(), is(new Decimal("12")));
        }

        @Test
        public void サービス種類_11を指定したとき_サービス種類11の_合計金額を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get給付実績サービス(new ServiceShurui(new Code("11"), new RString("名称"), new RString("略称"))).get合計金額(), is(new Decimal("33")));
        }

        @Test
        public void サービス種類_12を指定したとき_サービス種類12の_集計情報を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get給付実績サービス(new ServiceShurui(new Code("12"), new RString("名称"), new RString("略称"))).get利用者負担額合計(), is(new Decimal("20")));
        }
    }

    public static class isEmptyのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ4のリストを渡されたとき_isEmptyはfalseを返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_isEmptyはtrueを返す() {
            sut = new KyufuJissekiServiceCollection(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class sizeのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ4のリストを渡されたとき_sizeは4を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.size(), is(4));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KyufuJissekiServiceCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
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

}

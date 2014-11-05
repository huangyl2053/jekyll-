/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategory;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ひと月分の給付実績種類明細情報のリストを保持するコレクションクラスのテストです。
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

    public static class get単位数合計Byサービス種類のテスト extends DbcTestBase {

        public void setUp() {
        }

        @Test
        public void サービス種類_11を指定したとき_サービス種類11の_単位数合計の集計値を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get単位数合計Byサービス種類(new ServiceShuruiCode(new RString("11"))),
                    is(new Decimal("11").add(new Decimal("21"))));
        }

        @Test
        public void サービス種類_12を指定したとき_サービス種類12の_単位数合計の集計値を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get単位数合計Byサービス種類(new ServiceShuruiCode(new RString("12"))),
                    is(new Decimal("31").add(new Decimal("41"))));
        }

        @Test
        public void サービス種類_99を指定したとき_存在しないため0を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get単位数合計Byサービス種類(new ServiceShuruiCode(new RString("99"))), is(new Decimal("0")));
        }
    }

    public static class get単位数合計Byサービスカテゴリのテスト extends DbcTestBase {

        public void setUp() {
        }

        @Test
        public void サービスカテゴリ_居宅サービスを指定したとき_居宅サービスの_単位数合計の集計値を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get単位数合計Byサービスカテゴリ(ServiceCategory.居宅サービス),
                    is(new Decimal("11").add(new Decimal("21")).add(new Decimal("31")).add(new Decimal("41"))));
        }

        @Test
        public void サービスカテゴリ_施設サービスを指定したとき_居宅サービスの_単位数合計の集計値を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.get単位数合計Byサービスカテゴリ(ServiceCategory.施設サービス),
                    is(new Decimal("51").add(new Decimal("61"))));
        }

    }

    public static class isEmptyのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ6のリストを渡されたとき_isEmptyはfalseを返す() {
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
        public void コンストラクタから長さ6のリストを渡されたとき_sizeは6を返す() {
            sut = new KyufuJissekiServiceCollection(create給付実績サービス集計List());
            assertThat(sut.size(), is(6));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KyufuJissekiServiceCollection(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static List<KyufuJissekiService> create給付実績サービス集計List() {
        List<KyufuJissekiService> list = new ArrayList<>();
        list.add(create給付実績サービス("11", "11", new Decimal("10"), new Decimal("11"), new Decimal("12"), new Decimal("13")));
        list.add(create給付実績サービス("11", "12", new Decimal("20"), new Decimal("21"), new Decimal("22"), new Decimal("13")));
        list.add(create給付実績サービス("12", "13", new Decimal("30"), new Decimal("31"), new Decimal("32"), new Decimal("13")));
        list.add(create給付実績サービス("12", "14", new Decimal("40"), new Decimal("41"), new Decimal("42"), new Decimal("13")));
        list.add(create給付実績サービス("51", "11", new Decimal("50"), new Decimal("51"), new Decimal("52"), new Decimal("13")));
        list.add(create給付実績サービス("52", "12", new Decimal("60"), new Decimal("61"), new Decimal("62"), new Decimal("13")));
        return list;
    }

    private static KyufuJissekiService create給付実績サービス(
            String サービス種類コード,
            String 事業者No,
            Decimal 利用者負担額合計,
            Decimal 単位数合計,
            Decimal 保険請求分請求額合計,
            Decimal サービス単位数合計) {

        JigyoshaNo 事業者番号 = new JigyoshaNo(new RString(事業者No));
        KyufuJissekiKeyInfo 給付実績キー情報 = create給付実績キー情報(サービス種類コード);

        KyufuJissekiService kyufujissekiService = new KyufuJissekiService(
                事業者番号,
                利用者負担額合計,
                単位数合計,
                保険請求分請求額合計,
                サービス単位数合計,
                給付実績キー情報);

        return kyufujissekiService;
    }

    private static KyufuJissekiKeyInfo create給付実績キー情報(String サービス種類コード) {
        KyufuJissekiKeyInfo ret;
        KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(new RString("0123456789"));
        ServiceTeikyoYM サービス提供期間開始 = new ServiceTeikyoYM(new FlexibleYearMonth("201401"));
        ServiceTeikyoYM サービス提供期間終了 = new ServiceTeikyoYM(new FlexibleYearMonth("201412"));
        Range<ServiceTeikyoYM> サービス提供期間 = new Range(サービス提供期間開始, サービス提供期間終了);
        InputShikibetsuNo 入力識別番号 = new InputShikibetsuNo(new Code("入力識別番号"), new RString("名称"), new RString("略称"));
        ServiceShuruiCode サービス種類 = new ServiceShuruiCode(new RString(サービス種類コード));
        ServiceTeikyoYM サービス提供年月 = new ServiceTeikyoYM(new FlexibleYearMonth("201407"));
        ret = new KyufuJissekiKeyInfo(被保番号,
                サービス提供期間,
                入力識別番号,
                サービス種類,
                サービス提供年月);
        return ret;
    }
}

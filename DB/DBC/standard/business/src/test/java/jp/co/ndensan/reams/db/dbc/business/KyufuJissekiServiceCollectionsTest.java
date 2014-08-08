/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 給付実績月別集計のコレクションクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceCollectionsTest extends DbcTestBase {

    private static KyufuJissekiServiceCollections sut;

    public static class コンストラクタのテスト extends DbcTestBase {

        @Test(expected = NullPointerException.class)
        public void nullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiServiceCollections(null);
        }
    }

    public static class get給付実績月別集計のテスト extends DbcTestBase {

        public void setUp() {
        }

        @Test
        public void サービス提供年月で2014年07月を指定したとき_該当する給付実績月別集計を返す() {
            sut = new KyufuJissekiServiceCollections(create給付実績月別集計List());
            assertThat(sut.get給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201407"))).getサービス提供年月(),
                    is(new ServiceTeikyoYM(new FlexibleYearMonth("201407"))));
        }

        @Test
        public void サービス提供年月で2014年09月を指定したとき_存在しないためnullを返す() {
            sut = new KyufuJissekiServiceCollections(create給付実績月別集計List());
            assertThat(sut.get給付実績月別集計(new ServiceTeikyoYM(new FlexibleYearMonth("201409"))),
                    nullValue());
        }

    }

    public static class isEmptyのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_isEmptyはfalseを返す() {
            sut = new KyufuJissekiServiceCollections(create給付実績月別集計List());
            assertThat(sut.isEmpty(), is(false));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_isEmptyはtrueを返す() {
            sut = new KyufuJissekiServiceCollections(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class sizeのテスト extends DbcTestBase {

        @Test
        public void コンストラクタから長さ3のリストを渡されたとき_sizeは3を返す() {
            sut = new KyufuJissekiServiceCollections(create給付実績月別集計List());
            assertThat(sut.size(), is(3));
        }

        @Test
        public void コンストラクタから空のリストを渡されたとき_sizeは0を返す() {
            sut = new KyufuJissekiServiceCollections(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }
    }

    private static List<KyufuJissekiServiceCollection> create給付実績月別集計List() {
        List<KyufuJissekiServiceCollection> list = new ArrayList<>();
        list.add(create給付実績月別集計List("201406"));
        list.add(create給付実績月別集計List("201407"));
        list.add(create給付実績月別集計List("201408"));
        return list;
    }

    private static KyufuJissekiServiceCollection create給付実績月別集計List(
            String 提供年月) {

        KyufuJissekiServiceCollection kyufuJissekiServiceCollection = new KyufuJissekiServiceCollection(
                create給付実績サービス集計List(提供年月));

        return kyufuJissekiServiceCollection;
    }

    private static List<KyufuJissekiService> create給付実績サービス集計List(String 提供年月) {
        List<KyufuJissekiService> list = new ArrayList<>();
        list.add(create給付実績サービス("11", "11", new Decimal("10"), new Decimal("11"), new Decimal("12"), new Decimal("13"), 提供年月));
        return list;
    }

    private static KyufuJissekiService create給付実績サービス(
            String サービス種類コード,
            String 事業者No,
            Decimal 利用者負担額合計,
            Decimal 単位数合計,
            Decimal 保険請求分請求額合計,
            Decimal サービス単位数合計,
            String 提供年月) {

        JigyoshaNo 事業者番号 = new JigyoshaNo(new RString(事業者No));
        KyufuJissekiKeyInfo 給付実績キー情報 = create給付実績キー情報(サービス種類コード, 提供年月);

        KyufuJissekiService kyufujissekiService = new KyufuJissekiService(
                事業者番号,
                利用者負担額合計,
                単位数合計,
                保険請求分請求額合計,
                サービス単位数合計,
                給付実績キー情報);

        return kyufujissekiService;
    }

    private static KyufuJissekiKeyInfo create給付実績キー情報(String サービス種類コード, String 提供年月) {
        KyufuJissekiKeyInfo ret;
        KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(new RString("0123456789"));
        ServiceTeikyoYM サービス提供期間開始 = new ServiceTeikyoYM(new FlexibleYearMonth("201401"));
        ServiceTeikyoYM サービス提供期間終了 = new ServiceTeikyoYM(new FlexibleYearMonth("201412"));
        Range<ServiceTeikyoYM> サービス提供期間 = new Range(サービス提供期間開始, サービス提供期間終了);
        InputShikibetsuNo 入力識別番号 = new InputShikibetsuNo(new Code("入力識別番号"), new RString("名称"), new RString("略称"));
        ServiceShuruiCode サービス種類 = new ServiceShuruiCode(new RString(サービス種類コード));
        ServiceTeikyoYM サービス提供年月 = new ServiceTeikyoYM(new FlexibleYearMonth(提供年月));
        ret = new KyufuJissekiKeyInfo(被保番号,
                サービス提供期間,
                入力識別番号,
                サービス種類,
                サービス提供年月);
        return ret;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * サービス種類ごとの給付実績集計額を保持するクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceTest extends DbcTestBase {

    public static class ConstructorTest extends DbcTestBase {

        private static KyufuJissekiService sut;

        private static JigyoshaNo 事業者番号;
        private static Decimal 利用者負担額合計;
        private static Decimal 単位数合計;
        private static Decimal 保険請求分請求額合計;
        private static Decimal サービス単位数合計;
        private static KyufuJissekiKeyInfo 給付実績キー情報;

        @Before
        public void setUp() {
            事業者番号 = mock(JigyoshaNo.class);
            利用者負担額合計 = mock(Decimal.class);
            単位数合計 = mock(Decimal.class);
            保険請求分請求額合計 = mock(Decimal.class);
            サービス単位数合計 = mock(Decimal.class);
            給付実績キー情報 = mock(KyufuJissekiKeyInfo.class);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiService(null, 利用者負担額合計, 単位数合計, 保険請求分請求額合計, サービス単位数合計, 給付実績キー情報);
        }

        @Test(expected = NullPointerException.class)
        public void 給付実績キー情報がnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiService(事業者番号, 利用者負担額合計, 単位数合計, 保険請求分請求額合計, サービス単位数合計, null);
        }
    }

    public static class getメソッドのテスト extends DbcTestBase {

        private static KyufuJissekiService sut;

        private static JigyoshaNo 事業者番号;
        private static Decimal 利用者負担額合計;
        private static Decimal 単位数合計;
        private static Decimal 保険請求分請求額合計;
        private static Decimal サービス単位数合計;
        private static KyufuJissekiKeyInfo 給付実績キー情報;

        @Before
        public void setUp() {
            事業者番号 = new JigyoshaNo(new RString("001"));
            利用者負担額合計 = new Decimal("100");
            単位数合計 = new Decimal("150");
            保険請求分請求額合計 = new Decimal("200");
            サービス単位数合計 = new Decimal("300");
            給付実績キー情報 = create給付実績キー情報();
        }

        @Test
        public void get利用者負担額合計で_利用者負担額合計を返す() {
            sut = new KyufuJissekiService(事業者番号, 利用者負担額合計, 単位数合計, 保険請求分請求額合計, サービス単位数合計, 給付実績キー情報);
            assertThat(sut.get利用者負担額合計(), is(new Decimal("100")));
        }

        @Test
        public void get単位数合計で_単位数合計を返す() {
            sut = new KyufuJissekiService(事業者番号, 利用者負担額合計, 単位数合計, 保険請求分請求額合計, サービス単位数合計, 給付実績キー情報);
            assertThat(sut.get単位数合計(), is(new Decimal("150")));
        }

        @Test
        public void get保険請求分請求額合計で_保険請求分請求額合計を返す() {
            sut = new KyufuJissekiService(事業者番号, 利用者負担額合計, 単位数合計, 保険請求分請求額合計, サービス単位数合計, 給付実績キー情報);
            assertThat(sut.get保険請求分請求額合計(), is(new Decimal("200")));
        }

        @Test
        public void get給付実績キー情報で_給付実績キー情報を返す() {
            sut = new KyufuJissekiService(事業者番号, 利用者負担額合計, 単位数合計, 保険請求分請求額合計, サービス単位数合計, 給付実績キー情報);
            assertThat(sut.get給付実績キー情報().getサービス提供年月(), is(new ServiceTeikyoYM(new FlexibleYearMonth("201407"))));
        }
    }

    private static ServiceShuruiCode createサービス種類() {
        return new ServiceShuruiCode(new RString("11"));
    }

    private static KyufuJissekiKeyInfo create給付実績キー情報() {
        KyufuJissekiKeyInfo ret;
        KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(new RString("0123456789"));
        ServiceTeikyoYM サービス提供期間開始 = new ServiceTeikyoYM(new FlexibleYearMonth("201401"));
        ServiceTeikyoYM サービス提供期間終了 = new ServiceTeikyoYM(new FlexibleYearMonth("201412"));
        Range<ServiceTeikyoYM> サービス提供期間 = new Range(サービス提供期間開始, サービス提供期間終了);
        InputShikibetsuNo 入力識別番号 = new InputShikibetsuNo(new Code("入力識別番号"), new RString("名称"), new RString("略称"));
        ServiceShuruiCode サービス種類 = createサービス種類();
        ServiceTeikyoYM サービス提供年月 = new ServiceTeikyoYM(new FlexibleYearMonth("201407"));
        ret = new KyufuJissekiKeyInfo(被保番号,
                サービス提供期間,
                入力識別番号,
                サービス種類,
                サービス提供年月);
        return ret;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 給付実績居宅サービスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class KyufuJissekiKyotakuServiceTest {

    public static class constructorのテスト extends DbcTestBase {

        private KyufuJissekiKyotakuService sut;
        private KokanShikibetsuNo 交換情報識別コード;
        private NyuryokuShikibetsuNo 入力識別コード;
        private RString レコード種別コード;
        private ShoKisaiHokenshaNo 証記載保険者番号;
        private KaigoHihokenshaNo 被保険者番号;
        private FlexibleYearMonth サービス適用年月;
        private JigyoshaNo 事業者番号;
        private RString 通し番号;
        private RString 指定基準該当等事業者区分コード;
        private FlexibleDate 居宅サービス作成依頼年月日;
        private RString サービス計画費明細行番号;
        private Decimal 単位数単価;
        private ServiceCode サービスコード;
        private KyotakuServiceSeikyuKingakuJoho 請求金額情報;
        private RString 担当介護支援専門員番号;
        private RString 摘要;
        private KyotakuServiceSeikyuKingakuJoho 後請求金額情報;
        private int 再審査回数;
        private int 過誤回数;
        private FlexibleYearMonth 審査年月;
        private RString 整理番号;
        private FlexibleYearMonth 取込年月;

        @Before
        public void setUp() {

            交換情報識別コード = new KokanShikibetsuNo(new RString("0123"));
            入力識別コード = new NyuryokuShikibetsuNo(new RString("0123"));
            レコード種別コード = new RString("01");
            証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("012345"));
            被保険者番号 = new KaigoHihokenshaNo(new RString("0123456789"));
            サービス適用年月 = new FlexibleYearMonth("201101");
            事業者番号 = new JigyoshaNo(new RString("01234567"));
            通し番号 = new RString("0101000001");
            指定基準該当等事業者区分コード = new RString("1");
            居宅サービス作成依頼年月日 = new FlexibleDate("20110101");
            サービス計画費明細行番号 = new RString("");
            単位数単価 = new Decimal("1234");
            サービスコード = new ServiceCode(new RString(""));
            請求金額情報 = new KyotakuServiceSeikyuKingakuJoho(1, 2, 3, 4, 5);
            担当介護支援専門員番号 = new RString("87654321");
            摘要 = new RString("てきようてきよう");
            後請求金額情報 = new KyotakuServiceSeikyuKingakuJoho(1, 2, 3, 4, 5);
            再審査回数 = 4;
            過誤回数 = 3;
            審査年月 = new FlexibleYearMonth("201101");
            整理番号 = new RString("0000000001");
            取込年月 = new FlexibleYearMonth("201101");
        }

        @Test(expected = NullPointerException.class)
        public void 交換情報識別コードがnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(null, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 入力識別コードがnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, null, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void レコード種別コードがnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, null, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 証記載保険者番号がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, null,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    null, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void サービス適用年月がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, null, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, null, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 通し番号がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, null, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 指定基準該当等事業者区分コードがnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, null, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 居宅サービス作成依頼年月日がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, null,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void サービス計画費明細行番号がnullのとき_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    null, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 再審査回数が0より小さいとき_IllegalArgumentExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    -1, 過誤回数, 審査年月, 整理番号, 取込年月);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 過誤回数が0より小さいとき_IllegalArgumentExceptionが発生する() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, 単位数単価, サービスコード, 請求金額情報, 担当介護支援専門員番号, 摘要, 後請求金額情報,
                    再審査回数, -1, 審査年月, 整理番号, 取込年月);
            fail();
        }

        public void 必須項目全てがnullではなく_再審査回数と過誤回数が0以上であるとき_インスタンスが生成される() {
            sut = new KyufuJissekiKyotakuService(交換情報識別コード, 入力識別コード, レコード種別コード, 証記載保険者番号,
                    被保険者番号, サービス適用年月, 事業者番号, 通し番号, 指定基準該当等事業者区分コード, 居宅サービス作成依頼年月日,
                    サービス計画費明細行番号, null, null, null, null, null, null,
                    再審査回数, 過誤回数, null, null, null);
            assertThat(sut, is(instanceOf(KyufuJissekiKyotakuService.class)));
        }
    }
}

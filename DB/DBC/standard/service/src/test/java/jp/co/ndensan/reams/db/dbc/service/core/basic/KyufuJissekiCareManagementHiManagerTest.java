/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3031KyufuJissekiCareManagementHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3031KyufuJissekiCareManagementHiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3031KyufuJissekiCareManagementHiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KyufuJissekiCareManagementHiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KyufuJissekiCareManagementHiManagerTest {

    private static DbT3031KyufuJissekiCareManagementHiDac dac;
    private static KyufuJissekiCareManagementHiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3031KyufuJissekiCareManagementHiDac.class);
        sut = new KyufuJissekiCareManagementHiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績ケアマネジメント費 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(null, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, null, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, null, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, null, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, null, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型6にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, null, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型7にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, null, 主キー8, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型8にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, null, 主キー9, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型9にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, null, 主キー10, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型10にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, null, 主キー11);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型11にnullを指定した場合_NullPointerExceptionが発生する() {
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(KokanShikibetsuNo.class), any(NyuryokuShikibetsuNo.class), any(RString.class), any(HokenshaNo.class),
                    any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class), any(RString.class),
                    any(FlexibleDate.class), any(RString.class), any(RString.class))).thenReturn(null);
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            KyufuJissekiCareManagementHi result = sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            when(dac.selectByKey(any(KokanShikibetsuNo.class), any(NyuryokuShikibetsuNo.class), any(RString.class), any(HokenshaNo.class),
                    any(HihokenshaNo.class), any(FlexibleYearMonth.class), any(JigyoshaNo.class), any(RString.class),
                    any(FlexibleDate.class), any(RString.class), any(RString.class))).thenReturn(entity);
            KokanShikibetsuNo 主キー1 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号;
            NyuryokuShikibetsuNo 主キー2 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_入力識別番号;
            RString 主キー3 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_レコード種別コード;
            HokenshaNo 主キー4 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_証記載保険者番号;
            HihokenshaNo 主キー5 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_被保険者番号;
            FlexibleYearMonth 主キー6 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス提供年月;
            JigyoshaNo 主キー7 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_事業所番号;
            RString 主キー8 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_指定_基準該当事業所区分コード;
            FlexibleDate 主キー9 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_居宅サービス計画作成依頼届出年月日;
            RString 主キー10 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_通し番号;
            RString 主キー11 = DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_サービス計画費明細行番号;
            KyufuJissekiCareManagementHi result = sut.get給付実績ケアマネジメント費(主キー1, 主キー2, 主キー3, 主キー4, 主キー5, 主キー6, 主キー7, 主キー8, 主キー9, 主キー10, 主キー11);

            assertThat(result.get交換情報識別番号().value(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get給付実績ケアマネジメント費一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KyufuJissekiCareManagementHi> result = sut.get給付実績ケアマネジメント費一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3031KyufuJissekiCareManagementHiEntity> entityList = Arrays.asList(DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KyufuJissekiCareManagementHi> result = sut.get給付実績ケアマネジメント費一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get交換情報識別番号().value(), is(DbT3031KyufuJissekiCareManagementHiEntityGenerator.DEFAULT_交換情報識別番号.value()));
        }
    }

    public static class save給付実績ケアマネジメント費 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3031KyufuJissekiCareManagementHiEntity.class))).thenReturn(1);

            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3031KyufuJissekiCareManagementHiEntity.class))).thenReturn(0);

            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3031KyufuJissekiCareManagementHiEntity.class))).thenReturn(1);

            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            entity.initializeMd5();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);
            給付実績ケアマネジメント費 = 給付実績ケアマネジメント費.createBuilderForEdit().setサービス計画費明細行番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3031KyufuJissekiCareManagementHiEntity.class))).thenReturn(0);

            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            entity.initializeMd5();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);
            給付実績ケアマネジメント費 = 給付実績ケアマネジメント費.createBuilderForEdit().setサービス計画費明細行番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3031KyufuJissekiCareManagementHiEntity.class))).thenReturn(1);

            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            entity.initializeMd5();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);
            給付実績ケアマネジメント費 = 給付実績ケアマネジメント費.deleted();

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3031KyufuJissekiCareManagementHiEntity.class))).thenReturn(0);

            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            entity.initializeMd5();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);
            給付実績ケアマネジメント費 = 給付実績ケアマネジメント費.deleted();

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3031KyufuJissekiCareManagementHiEntity entity = DbT3031KyufuJissekiCareManagementHiEntityGenerator.createDbT3031KyufuJissekiCareManagementHiEntity();
            entity.initializeMd5();
            KyufuJissekiCareManagementHi 給付実績ケアマネジメント費 = new KyufuJissekiCareManagementHi(entity);

            assertThat(sut.save給付実績ケアマネジメント費(給付実績ケアマネジメント費), is(false));
        }
    }
}

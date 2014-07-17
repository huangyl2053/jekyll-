/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuJissekiShukeiGokeiTaisho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 特定のサービス種類の給付実績集計額を保持するクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceShukeiTest {

    public static class ConstructorTest extends DbcTestBase {

        private static KyufuJissekiServiceShukei sut;

        private static KyufuJissekiShukeiGokeiTaisho 給付実績合計対象;
        private static Decimal 合計単位;
        private static KyufuJissekiKeyInfo 給付実績キー情報;

        @Before
        public void setUp() {
            給付実績合計対象 = KyufuJissekiShukeiGokeiTaisho.居宅サービス合計;
            合計単位 = mock(Decimal.class);
            給付実績キー情報 = create給付実績キー情報();
        }

        @Test(expected = NullPointerException.class)
        public void 給付実績合計対象がnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiServiceShukei(null, 合計単位, 給付実績キー情報);
        }

        @Test(expected = NullPointerException.class)
        public void 合計単位がnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiServiceShukei(給付実績合計対象, null, 給付実績キー情報);
        }

        @Test(expected = NullPointerException.class)
        public void 給付実績キー情報がnullの時_NullPointerExceptionが発生する() {
            sut = new KyufuJissekiServiceShukei(給付実績合計対象, 合計単位, null);
        }
    }

    private static ServiceShurui createサービス種類() {
        return new ServiceShurui(new Code("11"), new RString("名称"), new RString("略称"));
    }

    private static KyufuJissekiKeyInfo create給付実績キー情報() {
        KyufuJissekiKeyInfo ret;
        KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(new RString("0123456789"));
        ServiceTeikyoYM サービス提供期間開始 = new ServiceTeikyoYM(new FlexibleYearMonth("201401"));
        ServiceTeikyoYM サービス提供期間終了 = new ServiceTeikyoYM(new FlexibleYearMonth("201412"));
        Range<ServiceTeikyoYM> サービス提供期間 = new Range(サービス提供期間開始, サービス提供期間終了);
        InputShikibetsuNo 入力識別番号 = new InputShikibetsuNo(new Code("入力識別番号"), new RString("名称"), new RString("略称"));
        ServiceShurui サービス種類 = createサービス種類();
        ServiceTeikyoYM サービス提供年月 = new ServiceTeikyoYM(new FlexibleYearMonth("201407"));
        ret = new KyufuJissekiKeyInfo(被保番号,
                サービス提供期間,
                入力識別番号,
                サービス種類,
                サービス提供年月);
        return ret;
    }
}

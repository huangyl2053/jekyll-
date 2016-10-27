/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kakohorenjyohosakuseicommon;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連情報作成共通処理（証記載保険者番号取得）Parameterクラスです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KakohorenJyohoSakuseiCommonParameter implements IMyBatisParameter {

    private final FlexibleYearMonth サービス提供年月;
    private final boolean usesサービス提供年月;
    private final FlexibleDate 合併年月日;
    private final RString 地域番号;

    private KakohorenJyohoSakuseiCommonParameter(FlexibleYearMonth サービス提供年月,
            boolean usesサービス提供年月,
            FlexibleDate 合併年月日,
            RString 地域番号) {
        this.サービス提供年月 = サービス提供年月;
        this.usesサービス提供年月 = usesサービス提供年月;
        this.合併年月日 = 合併年月日;
        this.地域番号 = 地域番号;
    }

    /**
     * サービス提供年月より、被保険者一時TBL情報を検索します。
     *
     * @param サービス提供年月 FlexibleYearMonth
     * @return KakohorenJyohoSakuseiCommonParameter
     */
    public static KakohorenJyohoSakuseiCommonParameter createParamByサービス提供年月(FlexibleYearMonth サービス提供年月) {
        return new KakohorenJyohoSakuseiCommonParameter(サービス提供年月, サービス提供年月 != null, null, RString.EMPTY);
    }

    /**
     * 合併年月日、地域番号より、被保険者一時TBL情報を検索します。
     *
     * @param 合併年月日 FlexibleDate
     * @param 地域番号 RString
     * @return KakohorenJyohoSakuseiCommonParameter
     */
    public static KakohorenJyohoSakuseiCommonParameter createParamByサービス提供年月(FlexibleDate 合併年月日, RString 地域番号) {
        return new KakohorenJyohoSakuseiCommonParameter(null, false, 合併年月日, 地域番号);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.kakohorenjyohosakusei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kakohorenjyohosakuseicommon.KakohorenJyohoSakuseiCommonParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * HihokenshaTempUpdateProcessパラメータです。
 *
 * @reamsid_L DBC-2840-031 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaTempUpdateProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth サービス提供年月;
    private FlexibleDate 合併年月日;
    private RString 地域番号;

    /**
     * コンストラクタです。
     */
    public HihokenshaTempUpdateProcessParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param サービス提供年月 FlexibleYearMonth
     * @param 合併年月日 FlexibleDate
     * @param 地域番号 RString
     */
    public HihokenshaTempUpdateProcessParameter(FlexibleYearMonth サービス提供年月,
            FlexibleDate 合併年月日,
            RString 地域番号) {
        this.サービス提供年月 = サービス提供年月;
        this.合併年月日 = 合併年月日;
        this.地域番号 = 地域番号;
    }

    /**
     * MYBATISパラメータを取得します。
     *
     * @return MYBATISパラメータ
     */
    public KakohorenJyohoSakuseiCommonParameter toMybatisParamterByサービス提供年月() {
        return KakohorenJyohoSakuseiCommonParameter.createParamByサービス提供年月(サービス提供年月);
    }

    /**
     * MYBATISパラメータを取得します。
     *
     * @return MYBATISパラメータ
     */
    public KakohorenJyohoSakuseiCommonParameter toMybatisParamterBy合併年月日() {
        return KakohorenJyohoSakuseiCommonParameter.createParamByサービス提供年月(合併年月日, 地域番号);
    }
}

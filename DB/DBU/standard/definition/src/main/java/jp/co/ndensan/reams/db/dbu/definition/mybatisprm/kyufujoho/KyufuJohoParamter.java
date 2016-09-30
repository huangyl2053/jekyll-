/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_給付情報のParamterです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyufuJohoParamter {

    private final RString 被保険者番号;
    private final RString サービス提供年月;
    private final List<RString> serviceBunrruicodelist;

    private KyufuJohoParamter(
            RString 被保険者番号,
            RString サービス提供年月,
            List<RString> serviceBunrruicodelist) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.serviceBunrruicodelist = serviceBunrruicodelist;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param serviceBunrruicodelist サービス分類コード
     * @return JyuMiKoNyuJyoHoParameter
     */
    public static KyufuJohoParamter createParameter(
            RString 被保険者番号,
            RString サービス提供年月,
            List<RString> serviceBunrruicodelist) {
        return new KyufuJohoParamter(
                被保険者番号, サービス提供年月, serviceBunrruicodelist);
    }
}

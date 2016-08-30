/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kyufujoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_給付情報の購入金額Paramterです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KounyukingakuParamter {

    private final RString 被保険者番号;
    private final RString 開始年月;
    private final RString 終了年月;
    private final RString 支給不支給;

    private KounyukingakuParamter(
            RString 被保険者番号,
            RString 開始年月,
            RString 終了年月,
            RString 支給不支給) {
        this.被保険者番号 = 被保険者番号;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.支給不支給 = 支給不支給;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 被保険者番号 被保険者番号
     * @param 開始年月 開始年月
     * @param 終了年月 終了年月
     * @param 支給不支給 支給不支給
     * @return JyuMiKoNyuJyoHoParameter
     */
    public static KounyukingakuParamter createParameter(
            RString 被保険者番号,
            RString 開始年月,
            RString 終了年月,
            RString 支給不支給) {
        return new KounyukingakuParamter(
                被保険者番号, 開始年月, 終了年月, 支給不支給);
    }

}

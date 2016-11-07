/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 今までの支払結果情報取得パラメータ
 *
 * @reamsid_L DBC-1020-040 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShibaraiKekkaParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString サービス提供年月;
    private final RString 福祉用具販売費;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 福祉用具販売費 福祉用具販売費
     */
    private ShibaraiKekkaParameter(
            HihokenshaNo 被保険者番号,
            RString サービス提供年月,
            RString 福祉用具販売費) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.福祉用具販売費 = 福祉用具販売費;
    }

    /**
     * 今までの支払結果情報取得パラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 福祉用具販売費 福祉用具販売費
     * @return ShibaraiKekkaParameter
     */
    public static ShibaraiKekkaParameter createParameter(
            HihokenshaNo 被保険者番号,
            RString サービス提供年月,
            RString 福祉用具販売費) {
        return new ShibaraiKekkaParameter(被保険者番号, サービス提供年月, 福祉用具販売費);
    }
}

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
 * @author GC 張鋭
 */
@lombok.Getter
public class ShibaraiKekkaParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString サービス提供年月の年度;
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
            RString サービス提供年月の年度,
            RString 福祉用具販売費) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月の年度 = サービス提供年月の年度;
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
            RString サービス提供年月の年度,
            RString 福祉用具販売費) {
        return new ShibaraiKekkaParameter(被保険者番号, サービス提供年月の年度, 福祉用具販売費);
    }
}

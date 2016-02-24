/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishujizenshinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費支払結果取得パラメータ
 *
 */
@lombok.Getter
public final class JutakuKaishuHiParameter {

    HihokenshaNo 被保険者番号;
    FlexibleYearMonth サービス提供年月;
    FlexibleYearMonth 開始サービス提供年月;
    RString 住宅住所;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 住宅住所 住宅住所
     */
    private JutakuKaishuHiParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            FlexibleYearMonth 開始サービス提供年月,
            RString 住宅住所) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.開始サービス提供年月 = 開始サービス提供年月;
        this.住宅住所 = 住宅住所;
    }

    /**
     * 住宅改修費支払結果取得パラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 開始サービス提供年月 開始サービス提供年月
     * @param 住宅住所 住宅住所
     * @return JutakuKaishuHiParameter
     */
    public static JutakuKaishuHiParameter createParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            FlexibleYearMonth 開始サービス提供年月,
            RString 住宅住所) {
        return new JutakuKaishuHiParameter(被保険者番号, サービス提供年月, 開始サービス提供年月, 住宅住所);
    }
}

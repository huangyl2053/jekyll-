/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.niteicyosaichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBE2250001_認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NiTeiCyoSaiChiRanParameter {

    private final RString 通常;
    private final RString 延期;
    private final RString イメージ区分;
    private final FlexibleDate 認定申請年月日開始;
    private final boolean 認定申請年月日開始From;
    private final FlexibleDate 認定申請年月日終了;
    private final boolean 認定申請年月日開始To;
    private final FlexibleDate 依頼日開始;
    private final boolean 依頼日開始From;
    private final boolean 依頼日開始To;
    private final FlexibleDate 依頼日終了;
    private final Decimal 最大表示件数;

    private NiTeiCyoSaiChiRanParameter(
            RString 通常,
            RString 延期,
            RString イメージ区分,
            FlexibleDate 認定申請年月日開始,
            FlexibleDate 認定申請年月日終了,
            FlexibleDate 依頼日開始,
            FlexibleDate 依頼日終了,
            Decimal 最大表示件数,
            boolean 認定申請年月日開始From,
            boolean 認定申請年月日開始To,
            boolean 依頼日開始From,
            boolean 依頼日開始To) {
        this.通常 = 通常;
        this.延期 = 延期;
        this.イメージ区分 = イメージ区分;
        this.認定申請年月日開始 = 認定申請年月日開始;
        this.認定申請年月日終了 = 認定申請年月日終了;
        this.依頼日開始 = 依頼日開始;
        this.依頼日終了 = 依頼日終了;
        this.最大表示件数 = 最大表示件数;
        this.認定申請年月日開始From = 認定申請年月日開始From;
        this.認定申請年月日開始To = 認定申請年月日開始To;
        this.依頼日開始From = 依頼日開始From;
        this.依頼日開始To = 依頼日開始To;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param イメージ区分 RString
     * @param 認定申請年月日開始 FlexibleDate
     * @param 認定申請年月日終了 FlexibleDate
     * @param 依頼日開始 FlexibleDate
     * @param 依頼日終了 FlexibleDate
     * @param 最大表示件数 Decimal
     * @return NiTeiCyoSaiChiRanParameter
     */
    public static NiTeiCyoSaiChiRanParameter createParameter(
            RString 通常,
            RString 延期,
            RString イメージ区分,
            FlexibleDate 認定申請年月日開始,
            FlexibleDate 認定申請年月日終了,
            FlexibleDate 依頼日開始,
            FlexibleDate 依頼日終了,
            Decimal 最大表示件数) {
        return new NiTeiCyoSaiChiRanParameter(
                通常,
                延期,
                イメージ区分,
                認定申請年月日開始,
                認定申請年月日終了,
                依頼日開始,
                依頼日終了,
                最大表示件数,
                認定申請年月日開始 != null && !認定申請年月日開始.isEmpty(),
                認定申請年月日終了 != null && !認定申請年月日終了.isEmpty(),
                依頼日開始 != null && !依頼日開始.isEmpty(),
                依頼日終了 != null && !依頼日終了.isEmpty());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ichijipanteisyori;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBE3010001_一次判定処理クラスです。
 *
 * @reamsid_L DBE-1470-010 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IChiJiPanTeiSyoRiParameter {

    private final RString 通常;
    private final RString 延期;
    private final RString イメージ区分;
    private final FlexibleDate 認定申請年月日開始;
    private final boolean 認定申請年月日開始From;
    private final FlexibleDate 認定申請年月日終了;
    private final boolean 認定申請年月日開始To;
    private final Decimal 最大表示件数;
    private final boolean メニュー_遷移;
    private final boolean 完了処理一次判定_遷移;
    private final List<RString> 申請書管理番号List;

    private IChiJiPanTeiSyoRiParameter(
            RString 通常,
            RString 延期,
            RString イメージ区分,
            FlexibleDate 認定申請年月日開始,
            FlexibleDate 認定申請年月日終了,
            Decimal 最大表示件数,
            boolean 認定申請年月日開始From,
            boolean 認定申請年月日開始To,
            boolean メニュー_遷移,
            boolean 完了処理一次判定_遷移,
            List<RString> 申請書管理番号List) {
        this.通常 = 通常;
        this.延期 = 延期;
        this.イメージ区分 = イメージ区分;
        this.認定申請年月日開始 = 認定申請年月日開始;
        this.認定申請年月日終了 = 認定申請年月日終了;
        this.最大表示件数 = 最大表示件数;
        this.認定申請年月日開始From = 認定申請年月日開始From;
        this.認定申請年月日開始To = 認定申請年月日開始To;
        this.メニュー_遷移 = メニュー_遷移;
        this.完了処理一次判定_遷移 = 完了処理一次判定_遷移;
        this.申請書管理番号List = 申請書管理番号List;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 通常 RString
     * @param 延期 RString
     * @param イメージ区分 RString
     * @param 認定申請年月日開始 FlexibleDate
     * @param 認定申請年月日終了 FlexibleDate
     * @param 最大表示件数 Decimal
     * @param メニュー RString
     * @param 申請書管理番号List List<RString>
     * @return NiTeiCyoSaiChiRanParameter
     */
    public static IChiJiPanTeiSyoRiParameter createParameter(
            RString 通常,
            RString 延期,
            RString イメージ区分,
            FlexibleDate 認定申請年月日開始,
            FlexibleDate 認定申請年月日終了,
            Decimal 最大表示件数,
            RString メニュー,
            List<RString> 申請書管理番号List) {
        return new IChiJiPanTeiSyoRiParameter(
                通常,
                延期,
                イメージ区分,
                認定申請年月日開始,
                認定申請年月日終了,
                最大表示件数,
                new RString("DBEMN41001").equals(メニュー) && 認定申請年月日開始 != null && !認定申請年月日開始.isEmpty(),
                new RString("DBEMN41001").equals(メニュー) && 認定申請年月日終了 != null && !認定申請年月日終了.isEmpty(),
                new RString("DBEMN41001").equals(メニュー),
                new RString("DBEMNA1006").equals(メニュー),
                申請書管理番号List);
    }
}

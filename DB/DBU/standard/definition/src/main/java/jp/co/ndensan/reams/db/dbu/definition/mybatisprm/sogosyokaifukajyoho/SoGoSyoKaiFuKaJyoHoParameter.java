/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.sogosyokaifukajyoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 総合照会_賦課情報のParameterクラスです。
 *
 * @reamsid_L DBU-4100-050 houtianpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class SoGoSyoKaiFuKaJyoHoParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final int 履歴番号;

    private SoGoSyoKaiFuKaJyoHoParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 int
     * @return SoGoSyoKaiFuKaJyoHoParameter
     */
    public static SoGoSyoKaiFuKaJyoHoParameter createParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        return new SoGoSyoKaiFuKaJyoHoParameter(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号);
    }
}

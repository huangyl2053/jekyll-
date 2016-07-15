/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 計算対象者抽出・通知書番号発番のパラメタ
 *
 * @reamsid_L DBB-0730-020 lijunjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KeisanTaishoshaParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final FlexibleDate 資格基準日;
    private final FlexibleDate 賦課年度_修正後;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 資格基準日 FlexibleDate
     * @param 賦課年度_修正後 FlexibleDate
     */
    private KeisanTaishoshaParameter(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            FlexibleDate 資格基準日,
            FlexibleDate 賦課年度_修正後) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.資格基準日 = 資格基準日;
        this.賦課年度_修正後 = 賦課年度_修正後;
    }

    /**
     * パラメタcreateSelectByKeyParam
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 資格基準日 FlexibleDate
     * @param 賦課年度_修正後 FlexibleDate
     * @return KeisanTaishoshaParameter
     */
    public static KeisanTaishoshaParameter createSelectByKeyParam(FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            FlexibleDate 資格基準日,
            FlexibleDate 賦課年度_修正後) {
        return new KeisanTaishoshaParameter(調定年度, 賦課年度, 資格基準日, 賦課年度_修正後);
    }
}

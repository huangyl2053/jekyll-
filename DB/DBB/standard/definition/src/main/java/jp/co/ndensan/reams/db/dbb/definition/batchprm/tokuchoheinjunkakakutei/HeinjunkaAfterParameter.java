/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 平準化後の賦課の情報 パラメータ作成
 *
 * @reamsid_L DBB-0830-050 xuhao
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HeinjunkaAfterParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final YMDHMS 調定日時;

    private HeinjunkaAfterParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
    }

    /**
     * パラメータ作成
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 YMDHMS
     * @return
     */
    public static HeinjunkaAfterParameter createParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            YMDHMS 調定日時) {
        return new HeinjunkaAfterParameter(調定年度, 賦課年度, 調定日時);
    }

}

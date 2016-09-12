/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化確定一覧parameter
 *
 * @reamsid_L DBB-0830-050 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunkaKakuteiItirannParameter {

    private RString 調定日;
    private FlexibleYear 調定年度;

    /**
     * パラメータ作成
     *
     * @param 調定日 RDate
     * @param 調定年度 FlexibleYear
     */
    public TokuchoHeinjunkaKakuteiItirannParameter(RString 調定日, FlexibleYear 調定年度) {
        this.調定日 = 調定日;
        this.調定年度 = 調定年度;
    }

}

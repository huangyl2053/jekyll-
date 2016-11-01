/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 収納滞納状況把握情報の取得_Process処理パラメタークラスです．
 *
 * @reamsid_L DBD-3610-030 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoTainoJokyoHaakuProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param 基準日 基準日
     */
    public ShunoTainoJokyoHaakuProcessParameter(FlexibleDate 基準日) {
        this.基準日 = 基準日;
    }
}

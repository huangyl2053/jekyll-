/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 本算定通知書一括発行（過年度）のパラメータクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoFukaJohoFlgTrueProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private RString 回目;

    /**
     * コンストラクタ。
     *
     * @param 調定年度 FlexibleYear
     * @param 回目 RString
     */
    public IdoFukaJohoFlgTrueProcessParameter(FlexibleYear 調定年度, RString 回目) {
        this.調定年度 = 調定年度;
        this.回目 = 回目;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 賦課計算_継続processParameter
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class CreateFukaJohoKeizokuProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private YMDHMS 調定日時;

    /**
     * コンストラクタ
     *
     * @param 調定年度 FlexibleYear
     * @param 調定日時 YMDHMS
     */
    public CreateFukaJohoKeizokuProcessParameter(FlexibleYear 調定年度, YMDHMS 調定日時) {
        this.調定年度 = 調定年度;
        this.調定日時 = 調定日時;
    }
}

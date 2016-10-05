/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴仮算定賦課のprocessParameter
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokuchoKarisanteiFukaProcessParameter implements IBatchProcessParameter {

    private FlexibleYear 調定年度;
    private YMDHMS 調定日時;
    private FlexibleYear 賦課年度;
    private RString 出力順ID;

}

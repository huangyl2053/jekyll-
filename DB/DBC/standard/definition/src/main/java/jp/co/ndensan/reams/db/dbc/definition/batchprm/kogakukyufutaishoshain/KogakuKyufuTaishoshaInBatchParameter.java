/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakukyufutaishoshain;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費給付対象者取込みのバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuTaishoshaInBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "処理年月", name = "処理年月")
    private FlexibleYearMonth 処理年月;

    @BatchParameter(key = "再処理区分", name = "再処理区分")
    private RString 再処理区分;

    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private Long 出力順ID;

}

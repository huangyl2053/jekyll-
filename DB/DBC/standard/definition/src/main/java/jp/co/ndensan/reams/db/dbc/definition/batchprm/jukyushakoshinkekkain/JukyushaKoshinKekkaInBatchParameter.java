/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.jukyushakoshinkekkain;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者情報更新結果情報取込のバッチ用パラメータクラスです。
 *
 * @reamsid_L DBC-2730-010 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKoshinKekkaInBatchParameter extends BatchParameterBase {

    @BatchParameter(key = "処理年月", name = "処理年月")
    private FlexibleYearMonth 処理年月;

    @BatchParameter(key = "再処理区分", name = "再処理区分")
    private RString 再処理区分;

    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private Long 出力順ID;

}

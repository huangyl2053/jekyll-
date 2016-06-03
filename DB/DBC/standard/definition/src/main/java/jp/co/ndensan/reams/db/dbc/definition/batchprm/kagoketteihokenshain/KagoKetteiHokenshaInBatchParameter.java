/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.kagoketteihokenshain;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤決定通知書情報取込（保険者分）のバッチ用パラメータクラスです
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInBatchParameter extends BatchParameterBase {

    private static final String KEY_SHORI_YM = "shoriYM";
    private static final String KEY_SHUTURYOKUJUNN = "shuturyokuJunn";

    @BatchParameter(key = KEY_SHORI_YM, name = "処理年月")
    private FlexibleYearMonth shoriYM;
    @BatchParameter(key = KEY_SHUTURYOKUJUNN, name = "出力順ID")
    private Long shuturyokuJunn;

}

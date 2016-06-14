/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBBBT35004_特徴平準化確定parameter
 *
 * @reamsid_L DBB-0830-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeinjunkaKakuteiBatchParameter extends BatchParameterBase {

    private Map<RString, Decimal> 差額Map;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private YMDHMS 調定日時;
    private Code 遷移区分;

}

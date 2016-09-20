/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB012002;

import java.util.Map;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特徴平準化確定画面で入力されたデータより、バッチ用パラメータクラスを作成する。
 *
 * @reamsid_L DBB-0830-020 wangkanglei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBB012002_TokuchoHeinjunkaKakuteiParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;
    private Map<RString, Decimal> 差額Map;
    private FlexibleYear 賦課年度;
    private FlexibleYear 調定年度;
    private YMDHMS 調定日時;
    private RString 遷移区分;
}

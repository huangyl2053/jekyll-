/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.kaigofukatokuchoheijunka8;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴8月分）通知書一括発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBB-0860-040 yebangqiang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoFukaTokuchoHeijunka8FlowParameter extends BatchParameterBase {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 増額平準化方法;
    private RString 減額平準化方法;
    private RString 出力順ID;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.kaigofukatokuchoheijunka8;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
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

    private static final long serialVersionUID = 1L;

    private static final String KEY_調定年度 = "調定年度";
    private static final String KEY_賦課年度 = "賦課年度";
    private static final String KEY_増額平準化方法 = "増額平準化方法";
    private static final String KEY_減額平準化方法 = "減額平準化方法";
    private static final String KEY_出力順ID = "出力順ID";

    @BatchParameter(key = KEY_調定年度, name = "調定年度")
    private FlexibleYear 調定年度;
    @BatchParameter(key = KEY_賦課年度, name = "賦課年度")
    private FlexibleYear 賦課年度;
    @BatchParameter(key = KEY_増額平準化方法, name = "増額平準化方法")
    private RString 増額平準化方法;
    @BatchParameter(key = KEY_減額平準化方法, name = "減額平準化方法")
    private RString 減額平準化方法;
    @BatchParameter(key = KEY_出力順ID, name = "出力順ID")
    private RString 出力順ID;

}

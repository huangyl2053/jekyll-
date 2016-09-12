/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller;

import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.BranchPrintTshuchisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 「バッチ特徴平準化（特徴6月分）通知書一括発行を実行するか」を判定するクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class DBBWF35001 {

    /**
     * バッチ起動画面で通知書発行が指示された場合、104を実行します。
     *
     * @param flowVersion flowVersion
     * @return 判断結果
     */
    public BranchPrintTshuchisho branchPrintTshuchisho(int flowVersion) {
        FlowParameters params = FlowParameterAccessor.get();
        if (params.get(new RString("通知書一括発行"), Boolean.class)) {
            return BranchPrintTshuchisho.発行処理する;
        }
        return BranchPrintTshuchisho.発行処理しない;
    }

}

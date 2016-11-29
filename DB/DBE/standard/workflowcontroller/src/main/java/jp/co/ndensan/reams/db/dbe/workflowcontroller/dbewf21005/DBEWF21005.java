/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.workflowcontroller.dbewf21005;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameterAccessor;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.BranchBatch;

/**
 *
 * @author n8407
 */
public class DBEWF21005 {
    
     private static final RString batch1 = new RString("Batch1");
     private static final RString batch2 = new RString("Batch2");
     private static final RString batch3 = new RString("Batch3");
     
    /**
     * バッチ起動画面で通知書発行が指示された場合、相応のtaskIdを実行します。
     *
     * @param flowVersion flowVersion
     * @return 判断結果
     */
    public BranchBatch key(int flowVersion) {

        FlowParameters params = FlowParameterAccessor.get();
        RString key = params.get(new RString("key"), RString.class);
        if (batch1.equals(key)) {
            return BranchBatch.Batch1;
        } else if (batch2.equals(key)) {
            return BranchBatch.Batch2;
        } else if (batch3.equals(key)) {
            return BranchBatch.Batch3;
        }
        return BranchBatch.Batch1;
    }
    
}

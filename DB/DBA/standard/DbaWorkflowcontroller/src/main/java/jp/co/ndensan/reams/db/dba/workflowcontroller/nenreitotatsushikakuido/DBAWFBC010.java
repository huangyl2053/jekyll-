/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.workflowcontroller.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsushikakuido.NenreitotatsuShikakuIdoBatchFlowParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 65歳年齢到達資格異動のワークフロー
 *
 * @author n8389
 */
public class DBAWFBC010 {

    /**
     * 65歳年齢到達資格異動のワークフロー
     *
     * @param flowparam
     * @return nenreitotatsuShikakuIdoParameter
     */
    public NenreitotatsuShikakuIdoBatchFlowParameter createBPForNenreitotatsuShikakuId(FlowParameters flowparam) {
        NenreitotatsuShikakuIdoBatchFlowParameter nenreitotatsuShikakuIdoParameter = new NenreitotatsuShikakuIdoBatchFlowParameter();

        // 開始日
        nenreitotatsuShikakuIdoParameter.setKaishiYMD(flowparam.get(new RString("tableName"), FlexibleDate.class));
        // 終了日
        nenreitotatsuShikakuIdoParameter.setShuryoYMD(flowparam.get(new RString("tableName"), FlexibleDate.class));

        return nenreitotatsuShikakuIdoParameter;
    }
}

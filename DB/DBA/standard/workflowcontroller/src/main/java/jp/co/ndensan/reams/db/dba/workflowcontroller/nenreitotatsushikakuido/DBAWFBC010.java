/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.workflowcontroller.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.batchprm.nenreitotatsushikakuido.NenreitotatsuShikakuIdoBatchFlowParameter;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 65歳年齢到達資格異動バッチパラメータ生成する処理クラス
 *
 * @author n8389
 */
public class DBAWFBC010 {

    /**
     * 65歳年齢到達資格異動バッチパラメータ生成する処理メソッド
     *
     * @param flowparam フローパラメータ
     * @return nenreitotatsuShikakuIdoParameter バッチパラメータクラス
     */
    public NenreitotatsuShikakuIdoBatchFlowParameter createBPForNenreitotatsuShikakuIdo(FlowParameters flowparam) {
        NenreitotatsuShikakuIdoBatchFlowParameter nenreitotatsuShikakuIdoParameter = new NenreitotatsuShikakuIdoBatchFlowParameter();

        return nenreitotatsuShikakuIdoParameter;
    }
}

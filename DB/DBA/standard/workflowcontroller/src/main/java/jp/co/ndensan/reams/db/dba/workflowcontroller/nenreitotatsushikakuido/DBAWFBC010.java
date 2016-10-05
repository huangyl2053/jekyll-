/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.workflowcontroller.nenreitotatsushikakuido;

import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA010010.DBA010010_NenreitotatsuShikakuIdoParameter;
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
     * @return paramter バッチパラメータクラス
     */
    public DBA010010_NenreitotatsuShikakuIdoParameter createBPForNenreitotatsuShikakuIdo(FlowParameters flowparam) {
        DBA010010_NenreitotatsuShikakuIdoParameter parameter = new DBA010010_NenreitotatsuShikakuIdoParameter();

        return parameter;
    }
}

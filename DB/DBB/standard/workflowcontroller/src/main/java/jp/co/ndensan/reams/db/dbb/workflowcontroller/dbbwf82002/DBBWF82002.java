/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller.dbbwf82002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB213001.DBB213001_TokuchoSofuJohoRenkeiParameter;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * バッチ設計特徴送付情報連携のフローするクラスです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class DBBWF82002 {

    /**
     * ワークフローparameterからバッチparameterに変換します。
     *
     * @param flowParameter FlowParameters
     * @return parameter
     */
    public DBB213001_TokuchoSofuJohoRenkeiParameter toBatchParameter(FlowParameters flowParameter) {
        DBB213001_TokuchoSofuJohoRenkeiParameter parameter
                = new DBB213001_TokuchoSofuJohoRenkeiParameter();
        return parameter;
    }

}

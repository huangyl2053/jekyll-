/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller.dbbwf84004;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB233001.DBB233001_TokuchoSeidokanIFRenkeiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 特徴制度間Ｉ／Ｆ連携のフローするクラスです。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public class DBBWF84004 {

    /**
     * ワークフローparameterからバッチparameterに変換します。
     *
     * @param flowParameter FlowParameters
     * @return parameter
     */
    public DBB233001_TokuchoSeidokanIFRenkeiParameter toBatchParameter(FlowParameters flowParameter) {
        DBB233001_TokuchoSeidokanIFRenkeiParameter parameter
                = new DBB233001_TokuchoSeidokanIFRenkeiParameter(RString.EMPTY);
        return parameter;
    }

}

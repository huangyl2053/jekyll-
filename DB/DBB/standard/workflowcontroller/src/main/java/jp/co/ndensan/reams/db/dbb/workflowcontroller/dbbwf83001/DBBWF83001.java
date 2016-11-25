/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.workflowcontroller.dbbwf83001;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB241001.DBB241001_TokuchoHaishinDataTorikomiParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * バッチ設計_DBB241001_特徴配信データ取り込みのフローするクラスです。
 *
 * @reamsid_L DBB-4270-020 chenyadong
 */
public class DBBWF83001 {

    /**
     * ワークフローparameterからバッチparameterに変換します。
     *
     * @param flowParameter FlowParameters
     * @return parameter
     */
    public DBB241001_TokuchoHaishinDataTorikomiParameter toBatchParameter(FlowParameters flowParameter) {
        DBB241001_TokuchoHaishinDataTorikomiParameter parameter
                = new DBB241001_TokuchoHaishinDataTorikomiParameter(RString.EMPTY);
        return parameter;
    }
}

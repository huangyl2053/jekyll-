/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.workflowcontroller.kenkokaruterenkeidatasakusei;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180065.DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 健康かるて連携データ作成のスケジュールクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class DBCWFKZ001 {

    /**
     * ワークフローparameterからバッチparameterに変換します。
     *
     * @param flowParameter FlowParameters
     * @return parameter
     */
    public DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter toBatchParameter(FlowParameters flowParameter) {
        DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter parameter
                = new DBC180065_KenkoKaruteRenkeiDataSakuseiControlParameter();
        return parameter;
    }

}

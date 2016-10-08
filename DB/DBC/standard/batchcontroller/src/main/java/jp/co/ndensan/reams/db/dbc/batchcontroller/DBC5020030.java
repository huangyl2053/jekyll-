/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180060.DBC180060_KenkoKaruteRenkeiDataSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.workflow.parameter.FlowParameters;

/**
 * 健康かるて連携データ作成のスケジュールクラスです。
 *
 * @reamsid_L DBU-5530-030 wangxiaodong
 */
public class DBC5020030 {

    /**
     * ワークフローparameterからバッチparameterに変換します。
     *
     * @param flowParameter FlowParameters
     * @return parameter
     */
    public DBC180060_KenkoKaruteRenkeiDataSakuseiParameter toBatchParameter(FlowParameters flowParameter) {
        DBC180060_KenkoKaruteRenkeiDataSakuseiParameter parameter
                = new DBC180060_KenkoKaruteRenkeiDataSakuseiParameter();
        return parameter;
    }
}

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc020010;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010.ConvertGappeinaiJutokushaShinKyuNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010.GetJuminShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010.GetSetaiinHaakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010.SetaiinHaakuNyuryokuTempCreatProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.setaiinHaakuNyuryoku.SetaiinHaakuNyuryokuBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.setaiinHaakuNyuryoku.SetaiinHaakuNyuryokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 世帯員把握のバッチフロークラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
public class SetaiinHaakuNyuryokuFlow extends BatchFlowBase<SetaiinHaakuNyuryokuBatchParameter> {

    private static final String CREAT_PROCESS = "creatTmpProcess";
    private static final String 世帯員住民の把握 = "getSetaiinHaaku";
    private static final String 合併内住特者番号変換処理 = "convertGappeinaiJutokushaShinKyuNo";
    private static final String 各住民の所得情報の取得 = "getJuminShotokuJoho";
    private SetaiinHaakuNyuryokuBatchParameter parameter;
    private SetaiinHaakuNyuryokuProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get管理識別区分() == null) {
            return;
        }
        executeStep(CREAT_PROCESS);
        executeStep(世帯員住民の把握);
        executeStep(合併内住特者番号変換処理);
        executeStep(各住民の所得情報の取得);
    }

    /**
     * 世帯員把握入力一時テーブル作成するメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(CREAT_PROCESS)
    protected IBatchFlowCommand creatTmpProcess() {
        return simpleBatch(SetaiinHaakuNyuryokuTempCreatProcess.class).define();
    }

    /**
     * 世帯員住民の把握のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(世帯員住民の把握)
    protected IBatchFlowCommand getSetaiinHaaku() {
        processParameter = new SetaiinHaakuNyuryokuProcessParameter(parameter.get管理識別区分());
        return simpleBatch(GetSetaiinHaakuProcess.class).arguments(processParameter).define();
    }

    /**
     * 合併内住特者番号変換処理のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(合併内住特者番号変換処理)
    protected IBatchFlowCommand convertGappeinaiJutokushaShinKyuNo() {
        return simpleBatch(ConvertGappeinaiJutokushaShinKyuNoProcess.class).define();
    }

    /**
     * 各住民の所得情報の取得のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(各住民の所得情報の取得)
    protected IBatchFlowCommand getJuminShotokuJoho() {
        return simpleBatch(GetJuminShotokuJohoProcess.class).define();
    }
}

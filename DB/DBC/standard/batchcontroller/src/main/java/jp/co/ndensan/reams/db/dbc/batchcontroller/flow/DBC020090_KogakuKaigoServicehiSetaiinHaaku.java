    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020090.ConvertGappeinaiJutokushaShinKyuNoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020090.GetJuminShotokuJohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020090.GetSetaiinHaakuProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020090.DBC020090_KogakuKaigoServicehiSetaiinHaakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.setaiinhaakunyuryoku.SetaiinHaakuNyuryokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 世帯員把握のバッチフロークラスです。
 *
 * @reamsid_L DBC-2010-050 tianshuai
 */
public class DBC020090_KogakuKaigoServicehiSetaiinHaaku extends BatchFlowBase<DBC020090_KogakuKaigoServicehiSetaiinHaakuParameter> {

    private static final String 世帯員住民の把握 = "getSetaiinHaaku";
    private static final String 合併内住特者番号変換処理 = "convertGappeinaiJutokushaShinKyuNo";
    private static final String 各住民の所得情報の取得 = "getJuminShotokuJoho";
    private DBC020090_KogakuKaigoServicehiSetaiinHaakuParameter parameter;
    private SetaiinHaakuNyuryokuProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        parameter = getParameter();
        if (parameter == null || parameter.get管理識別区分() == null) {
            return;
        }
        executeStep(世帯員住民の把握);
        executeStep(合併内住特者番号変換処理);
        executeStep(各住民の所得情報の取得);
    }

    /**
     * 世帯員住民の把握のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(世帯員住民の把握)
    protected IBatchFlowCommand getSetaiinHaaku() {
        processParameter = new SetaiinHaakuNyuryokuProcessParameter(parameter.get管理識別区分(), parameter.getメニューID());
        return simpleBatch(GetSetaiinHaakuProcess.class).arguments(processParameter).define();
    }

    /**
     * 合併内住特者番号変換処理のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(合併内住特者番号変換処理)
    protected IBatchFlowCommand convertGappeinaiJutokushaShinKyuNo() {
        processParameter = new SetaiinHaakuNyuryokuProcessParameter(parameter.get管理識別区分(), parameter.getメニューID());
        return simpleBatch(ConvertGappeinaiJutokushaShinKyuNoProcess.class).arguments(processParameter).define();
    }

    /**
     * 各住民の所得情報の取得のメソッドです。
     *
     * @return 帳票出力パラメータ
     */
    @Step(各住民の所得情報の取得)
    protected IBatchFlowCommand getJuminShotokuJoho() {
        processParameter = new SetaiinHaakuNyuryokuProcessParameter(parameter.get管理識別区分(), parameter.getメニューID());
        return simpleBatch(GetJuminShotokuJohoProcess.class).arguments(processParameter).define();
    }
}

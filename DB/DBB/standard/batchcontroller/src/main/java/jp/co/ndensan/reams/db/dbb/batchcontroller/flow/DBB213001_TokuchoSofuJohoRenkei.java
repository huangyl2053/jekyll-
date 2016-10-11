/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB213001.CreateCheckFileProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB213001.CreateRenkeiFileProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB213001.DBB213001_TokuchoSofuJohoRenkeiParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchosofujohorenkei.TokuchoSofuJohoRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosofujohorenkei.FlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴送付情報連携のフローです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class DBB213001_TokuchoSofuJohoRenkei extends BatchFlowBase<DBB213001_TokuchoSofuJohoRenkeiParameter> {

    private static final String 連携用出力ファイル作成 = "creatRenkeiFile";
    private static final String チェックファイル作成 = "creatCheckFile";
    private TokuchoSofuJohoRenkeiProcessParameter processParameter;
    private FlowEntity returnEntity;

    @Override
    protected void defineFlow() {
        processParameter = new TokuchoSofuJohoRenkeiProcessParameter();
        executeStep(連携用出力ファイル作成);
        returnEntity = getResult(FlowEntity.class, new RString(連携用出力ファイル作成),
                CreateRenkeiFileProcess.PARAMETER_OUT_RETURNENTITY);
        processParameter.setファイルOutputMap(returnEntity.getファイル());
        processParameter.setレコード件数OutputMap(returnEntity.getレコード件数());
        executeStep(チェックファイル作成);
    }

    @Step(連携用出力ファイル作成)
    IBatchFlowCommand creatRenkeiFile() {
        return loopBatch(CreateRenkeiFileProcess.class).define();
    }

    @Step(チェックファイル作成)
    IBatchFlowCommand creatCheckFile() {
        return loopBatch(CreateCheckFileProcess.class).arguments(processParameter).define();
    }

}

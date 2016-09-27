/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB213001.CreateCheckFileProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB213001.TokuchoSofuJohoRenkeiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB213001.DBB213001_TokuchoSofuJohoRenkeiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 特徴送付情報連携のフローです。
 *
 * @reamsid_L DBB-1790-040 yuanzhenxia
 */
public class DBB213001_TokuchoSofuJohoRenkei extends BatchFlowBase<DBB213001_TokuchoSofuJohoRenkeiParameter> {

    private static final String 連携用出力ファイル作成 = "creatRenkeiFile";
    private static final String チェックファイル作成 = "creatCheckFile";

    @Override
    protected void defineFlow() {
        executeStep(連携用出力ファイル作成);
        executeStep(チェックファイル作成);
    }

    @Step(連携用出力ファイル作成)
    IBatchFlowCommand creatRenkeiFile() {
        return loopBatch(TokuchoSofuJohoRenkeiProcess.class).define();
    }

    @Step(チェックファイル作成)
    IBatchFlowCommand creatCheckFile() {
        return loopBatch(CreateCheckFileProcess.class).define();
    }

}

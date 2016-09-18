/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc160010.KeikakuTodokedeJokyoIchiranProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160010.DBC160010_KeikakuTodokedeJokyoIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.keikakutodokedejokyo.KeikakuTodokedeJokyoProcessParam;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 計画届出状況リストのバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
public class DBC160010_KeikakuTodokedeJokyoIchiran
        extends BatchFlowBase<DBC160010_KeikakuTodokedeJokyoIchiranParameter> {

    private static final String JIGYO_ICHIRANHYO = "jigyo_ichiranhyo";
    private KeikakuTodokedeJokyoProcessParam processParameter;

    @Override
    protected void defineFlow() {
        createParameter();
        executeStep(JIGYO_ICHIRANHYO);
    }

    @Step(JIGYO_ICHIRANHYO)
    IBatchFlowCommand executeJigyoIchiranhyo() {
        return loopBatch(KeikakuTodokedeJokyoIchiranProcess.class).arguments(processParameter).define();
    }

    private void createParameter() {
        processParameter = getParameter().toProcessParameter();
    }
}

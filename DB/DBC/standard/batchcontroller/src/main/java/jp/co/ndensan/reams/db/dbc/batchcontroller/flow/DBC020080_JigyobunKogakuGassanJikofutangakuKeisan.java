/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080.InitJissekiCheckProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020080.DBC020080_JigyobunKogakuGassanJikofutangakuKeisanParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN62006_自己負担額計算（一括）のバッチフロークラスです。
 *
 * @reamsid_L DBC-2060-030 liuyang
 */
public class DBC020080_JigyobunKogakuGassanJikofutangakuKeisan
        extends BatchFlowBase<DBC020080_JigyobunKogakuGassanJikofutangakuKeisanParameter> {
//TODO Processの名称を修正

    private static final String PROCESS1 = "Process1";
    private static final String INITCHECKPROCESS = "InitJissekiCheckProcess";

    private static final String PROCESS2 = "Process2";
    private static final String PROCESS3 = "Process3";
    private static final String PROCESS4 = "Process4";
    private static final String BACKUP_TO_FILE = "BackupToFile";
    private static RString importTableNamePermanent;
    private static final RString BACKUPTABLE1 = new RString("DbT3068KogakuGassanShinseisho");
    private static final RString BACKUPTABLE2 = new RString("DbT3070KogakuGassanJikoFutanGaku");

    @Override
    protected void initialize() {
    }

    @Override
    protected void defineFlow() {
        importTableNamePermanent = BACKUPTABLE1;
        executeStep(BACKUP_TO_FILE);
        importTableNamePermanent = BACKUPTABLE2;
        executeStep(BACKUP_TO_FILE);
//        TODO executeStep Process1とInitJissekiCheckProcess
        boolean isデータがあり = getResult(Boolean.class, new RString(INITCHECKPROCESS), InitJissekiCheckProcess.OUTPUTNAME);
//        if (!isデータがあり) {
//            return;
//        }
//        TODO executeStep Process2_2~2_6
//        TODO executeStep Process3,4
    }

    @Step(BACKUP_TO_FILE)
    IBatchFlowCommand backupToFile() {
        return backupToFile(importTableNamePermanent).define();
    }
}

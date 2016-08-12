/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.batchcontroller.flow.dbx001001;

import jp.co.ndensan.reams.db.dbx.batchcontroller.step.dbx001001.ChoshuhohoKoshinProcess;
import jp.co.ndensan.reams.db.dbx.batchcontroller.step.dbx001001.TokuchoTembikiProcess;
import jp.co.ndensan.reams.db.dbx.definition.batchprm.dbx001001.DBX001001_TokuchoTembikiChoshuhohoKoshinParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 特徴天引き停止徴収方法更新のバッチフロークラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
public class DBX001001_TokuchoTembikiChoshuhohoKoshinFlow
        extends BatchFlowBase<DBX001001_TokuchoTembikiChoshuhohoKoshinParameter> {

    private static final String HIHOKENJA_SHUTOKU = "tokuchoTembikiProcess";
    private static final String CHOSHUHOHOKOSHIN = "choshuhohoKoshinProcess";

    @Override
    protected void defineFlow() {
        executeStep(HIHOKENJA_SHUTOKU);
        executeStep(CHOSHUHOHOKOSHIN);
    }

    @Step(HIHOKENJA_SHUTOKU)
    IBatchFlowCommand tokuchoTembikiProcess() {
        RString 日付関連調定年度 = BusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        return loopBatch(TokuchoTembikiProcess.class).arguments(
                getParameter().toProcessParameter(日付関連調定年度)).define();
    }

    @Step(CHOSHUHOHOKOSHIN)
    IBatchFlowCommand choshuhohoKoshinProcess() {
        RString 日付関連調定年度 = BusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        return loopBatch(ChoshuhohoKoshinProcess.class).arguments(
                getParameter().toProcessParameter(日付関連調定年度)).define();
    }
}

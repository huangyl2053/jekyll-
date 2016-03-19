/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC120080;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120010.SharedFileCopy;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120080.KogakuKyufuKetteiDbUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120080.KogakuKyufuKetteiEntityProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120080.KogakuKyufuKetteiInBatchRegistTempSaveProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.KogakuKyufuKetteiInBatchRegistGetEditInfoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.ｋogakuｋyufuｋetteiIn.KogakuKyufuKetteiInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費決定情報取込みのバッチ
 */
public class DBC120080_KogakuKyufuKetteiIn extends BatchFlowBase<KogakuKyufuKetteiInBatchParameter> {

    // バッチ処理クラス
    private static final String SHAREDFILE_COPY = "sharedFileCopy";
    private static final String TEMP_SAVE_PROCESS = "kogakukyufuketteiInBatchRegistTempSaveProcess";
    private static final String GET_EDIT_INFO = "kogakukyufuketteiInBatchRegistGetEditInfoProcess";
    private static final String DB_UPDATE = "dbUpdateProcess";
    private static final String DB_KOGA_ENTITY = "dbKogaEntityProcess";

    private final RString sharedFileKey = new RString("351高額サービス費決定情報取込み");
    private RString runFilePath;
    private List<RString> fileNameList;

    @Override
    protected void defineFlow() {

        executeStep(SHAREDFILE_COPY);

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(SHAREDFILE_COPY),
                SharedFileCopy.PARAMETER_OUT_FILEPATHLIST);
        fileNameList = new ArrayList<>();
        for (RString filename : filePathList.keySet()) {
            fileNameList.add(filename);
        }
        for (RString filepath : filePathList.values()) {
            runFilePath = filepath;
            executeStep(TEMP_SAVE_PROCESS);
        }
        executeStep(GET_EDIT_INFO);
        executeStep(DB_UPDATE);
        executeStep(DB_KOGA_ENTITY);
    }

    @Step(SHAREDFILE_COPY)
    IBatchFlowCommand sharedFileCopy() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(SharedFileCopy.PARAMETER_IN_FILEPATH, new RString("/nfshome/D209007/sharedFiles/DB/"));
        processParameter.put(SharedFileCopy.PARAMETER_IN_SHAREDNAME, sharedFileKey);
        processParameter.put(SharedFileCopy.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);

        return simpleBatch(SharedFileCopy.class)
                .arguments(processParameter)
                .define();
    }

    @Step(TEMP_SAVE_PROCESS)
    IBatchFlowCommand kogakuKyufuKetteiInBatchRegistTempSaveProcess() {

        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KogakuKyufuKetteiInBatchRegistTempSaveProcess.PARAMETER_FILEPATH, runFilePath);

        return loopBatch(KogakuKyufuKetteiInBatchRegistTempSaveProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(GET_EDIT_INFO)
    IBatchFlowCommand kogakuKyufuKetteiInBatchRegistGetEditInfoProcess() {
        return loopBatch(KogakuKyufuKetteiInBatchRegistGetEditInfoProcess.class).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand dbUpdateProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KogakuKyufuKetteiDbUpdateProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        parameter.put(KogakuKyufuKetteiDbUpdateProcess.PARAMETER_FILENAME, fileNameList);
        return simpleBatch(KogakuKyufuKetteiDbUpdateProcess.class).arguments(parameter).define();
    }

    @Step(DB_KOGA_ENTITY)
    IBatchFlowCommand dbKogaEntityProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KogakuKyufuKetteiEntityProcess.PARAMETER_出力順ID, getParameter().getShutsuryokujun());
        return simpleBatch(KogakuKyufuKetteiEntityProcess.class).define();
    }

}

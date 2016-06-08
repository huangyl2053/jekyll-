/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC120200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120010.SharedFileCopyProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120200.KouhifutanshaDataEditProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120200.KouhifutanshaDbUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120200.KouhifutanshaTempTableInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120200.KouhifutanshaWriteReportProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.saishinsai.DBC120200_SaishinsaKetteiKohifutanshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（公費負担者分）のバッチ処理フロー
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
public class DBC120200_SaishinsaKetteiKohifutanshaIn
        extends BatchFlowBase<DBC120200_SaishinsaKetteiKohifutanshaInBatchParameter> {

    private static final String CSV_FILE_CHECK = "csvFileCheckProcess";
    private static final String TEMP_TABLE_INSERT = "tempTableInsertProcess";
    private static final String TEMP_TABLE_UPDATE = "tempTableUpdateProcess";
    private static final String DB_UPDATE = "dbUpdateProcess";
    private static final String WRITE_REPORT = "writeReportProcess";

    private final RString sharedFileKey = new RString("652");
    private RString runFilePath;
    private List<RString> fileNameList;

    @Override
    protected void defineFlow() {
        executeStep(CSV_FILE_CHECK);

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(CSV_FILE_CHECK),
                SharedFileCopyProcess.PARAMETER_OUT_FILEPATHLIST);
        fileNameList = new ArrayList<>();
        for (RString filename : filePathList.keySet()) {
            fileNameList.add(filename);
        }
        for (RString filepath : filePathList.values()) {
            runFilePath = filepath;
            executeStep(TEMP_TABLE_INSERT);
        }
        executeStep(TEMP_TABLE_UPDATE);
        executeStep(DB_UPDATE);
    }

    @Step(CSV_FILE_CHECK)
    IBatchFlowCommand csvFileCheckProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(SharedFileCopyProcess.PARAMETER_IN_FILEPATH, new RString("/nfshome/D209007/sharedFiles/DB/"));
        processParameter.put(SharedFileCopyProcess.PARAMETER_IN_SHAREDNAME, sharedFileKey);
        processParameter.put(SharedFileCopyProcess.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);

        return simpleBatch(SharedFileCopyProcess.class).arguments(processParameter).define();
    }

    @Step(TEMP_TABLE_INSERT)
    IBatchFlowCommand tempTableInsertProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KouhifutanshaTempTableInsertProcess.PARAMETER_FILEPATH, runFilePath);
        return loopBatch(KouhifutanshaTempTableInsertProcess.class).arguments(parameter).define();
    }

    @Step(TEMP_TABLE_UPDATE)
    IBatchFlowCommand tempTableUpdateProcess() {
        return simpleBatch(KouhifutanshaDataEditProcess.class).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand dbUpdateProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KouhifutanshaDbUpdateProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        parameter.put(KouhifutanshaDbUpdateProcess.PARAMETER_FILENAME, fileNameList);
        return simpleBatch(KouhifutanshaDbUpdateProcess.class).arguments(parameter).define();
    }

    @Step(WRITE_REPORT)
    IBatchFlowCommand writeReportProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KouhifutanshaWriteReportProcess.PARAMETER_IN_SHORIYM, getParameter().getShoriYM());
        parameter.put(KouhifutanshaWriteReportProcess.PARAMETER_IN_SHUTSURYOKUJUNID,
                getParameter().getShutsuryokujunId());
        return loopBatch(KouhifutanshaWriteReportProcess.class).arguments(parameter).define();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC120170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120010.SharedFileCopy;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaDbUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaTempTableInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaTempTableUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120170.KohifutanshaWriteReportProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kagoketteikohifutanshain.DBC120170_KagoKetteiKohifutanshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤決定通知書情報取込（公費負担者分）のバッチ処理フロー
 */
public class DBC120170_KagoKetteiKohifutanshaIn
        extends BatchFlowBase<DBC120170_KagoKetteiKohifutanshaInBatchParameter> {

    private static final String CSV_FILE_CHECK = "csvFileCheckProcess";
    private static final String TEMP_TABLE_INSERT = "tempTableInsertProcess";
    private static final String TEMP_TABLE_UPDATE = "tempTableUpdateProcess";
    private static final String DB_UPDATE = "dbUpdateProcess";
    private static final String WRITE_REPORT = "writeReportProcess";

    private final RString sharedFileKey = new RString("651");
    private RString runFilePath;
    private List<RString> fileNameList;

    @Override
    protected void defineFlow() {
        executeStep(CSV_FILE_CHECK);

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(CSV_FILE_CHECK),
                SharedFileCopy.PARAMETER_OUT_FILEPATHLIST);
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
        executeStep(WRITE_REPORT);
    }

    @Step(CSV_FILE_CHECK)
    IBatchFlowCommand csvFileCheckProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(SharedFileCopy.PARAMETER_IN_FILEPATH, new RString("/nfshome/D209007/sharedFiles/DB/"));
        processParameter.put(SharedFileCopy.PARAMETER_IN_SHAREDNAME, sharedFileKey);
        processParameter.put(SharedFileCopy.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);

        return simpleBatch(SharedFileCopy.class).arguments(processParameter).define();
    }

    @Step(TEMP_TABLE_INSERT)
    IBatchFlowCommand tempTableInsertProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KohifutanshaTempTableInsertProcess.PARAMETER_FILEPATH, runFilePath);
        return loopBatch(KohifutanshaTempTableInsertProcess.class).arguments(parameter).define();
    }

    @Step(TEMP_TABLE_UPDATE)
    IBatchFlowCommand tempTableUpdateProcess() {
        return loopBatch(KohifutanshaTempTableUpdateProcess.class).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand dbUpdateProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KohifutanshaDbUpdateProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        parameter.put(KohifutanshaDbUpdateProcess.PARAMETER_FILENAME, fileNameList);
        return simpleBatch(KohifutanshaDbUpdateProcess.class).arguments(parameter).define();
    }

    @Step(WRITE_REPORT)
    IBatchFlowCommand writeReportProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(KohifutanshaWriteReportProcess.PARAMETER_IN_SHORIYM, getParameter().getShoriYM());
        parameter.put(KohifutanshaWriteReportProcess.PARAMETER_IN_SHUTSURYOKUJUNID,
                getParameter().getShutsuryokujunId());
        return loopBatch(KohifutanshaWriteReportProcess.class).arguments(parameter).define();
    }
}

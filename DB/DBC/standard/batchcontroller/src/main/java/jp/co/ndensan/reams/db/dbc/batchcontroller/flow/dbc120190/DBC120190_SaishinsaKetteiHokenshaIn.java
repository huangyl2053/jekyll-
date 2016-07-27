/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120190;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190.CopyToLocalProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190.SaishinsaDbUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190.SaishinsaInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190.SaishinsaTempUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120190.SaishinsaWriteReportProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.saishinsaketteihokenshain.SaishinsaKetteiHokenshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（保険者分）のバッチ処理フロー
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class DBC120190_SaishinsaKetteiHokenshaIn extends BatchFlowBase<SaishinsaKetteiHokenshaInBatchParameter> {

    private static final String CSV_FILE_CHECK = "csvFileCheckProcess";
    private static final String TEMP_TABLE_INSERT = "tempTableInsertProcess";
    private static final String TEMP_TABLE_UPDATE = "tempTableUpdateProcess";
    private static final String DB_UPDATE = "dbUpdateProcess";
    private static final String WRITE_REPORT = "writeReportProcess";
    private final RString sharedFileKey = new RString("172");
    private RString runFilePath;
    private List<RString> fileNameList;

    @Override
    protected void defineFlow() {
        executeStep(CSV_FILE_CHECK);

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(CSV_FILE_CHECK),
                CopyToLocalProcess.PARAMETER_OUT_FILEPATHLIST);
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
        processParameter.put(CopyToLocalProcess.PARAMETER_IN_FILEPATH, new RString("/nfshome/D209007/sharedFiles/DB/"));
        processParameter.put(CopyToLocalProcess.PARAMETER_IN_SHAREDNAME, sharedFileKey);
        processParameter.put(CopyToLocalProcess.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);

        return simpleBatch(CopyToLocalProcess.class).arguments(processParameter).define();
    }

    @Step(TEMP_TABLE_INSERT)
    IBatchFlowCommand tempTableInsertProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(SaishinsaInsertProcess.PARAMETER_FILEPATH, runFilePath);
        return loopBatch(SaishinsaInsertProcess.class).arguments(parameter).define();
    }

    @Step(TEMP_TABLE_UPDATE)
    IBatchFlowCommand tempTableUpdateProcess() {
        return simpleBatch(SaishinsaTempUpdateProcess.class).define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand dbUpdateProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(SaishinsaDbUpdateProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        parameter.put(SaishinsaDbUpdateProcess.PARAMETER_FILENAME, fileNameList);
        return simpleBatch(SaishinsaDbUpdateProcess.class).arguments(parameter).define();
    }

    @Step(WRITE_REPORT)
    IBatchFlowCommand writeReportProcess() {
        Map<RString, Object> parameter = new HashMap<>();
        parameter.put(SaishinsaWriteReportProcess.PARAMETER_IN_SHORIYM, getParameter().getShoriYM());
        parameter.put(SaishinsaWriteReportProcess.PARAMETER_IN_SHUTSURYOKUJUNID,
                getParameter().getShutsuryokujunId());
        return loopBatch(SaishinsaWriteReportProcess.class).arguments(parameter).define();
    }

}

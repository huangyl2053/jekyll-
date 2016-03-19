/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.DBC120090;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120010.SharedFileCopy;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090.RegistTempSaveProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090.TempTableEditProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120090.TempTableUpdateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanshikyuketteiin.DBC120090_ShokanShikyuKetteiInBacthParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanshikyuketteiin.ShokanShikyuKetteiInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給決定情報取込のバッチです。
 */
public class DBC120090_ShokanShikyuKetteiInFlow extends BatchFlowBase<DBC120090_ShokanShikyuKetteiInBacthParameter> {

    private static final String CSVFILE_COPY = "csvFileCopy";
    private static final String TEMP_SAVE_PROCESS = "registTempSaveProcess";
    private static final String TEMP_TABLE_EDIT = "tempTableEditProcess";
    private static final String DB_UPDATE = "tempTableUpdateProcess";
    private static final String WRITE_REPORT = "writeReportProcess";

    private final RString csvFileKey = new RString("221");
    private RString runFilePath;
    private List<RString> fileNameList;

    @Override
    protected void defineFlow() {
        executeStep(CSVFILE_COPY);

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(CSVFILE_COPY),
                SharedFileCopy.PARAMETER_OUT_FILEPATHLIST);
        fileNameList = new ArrayList<>();
        for (RString filename : filePathList.keySet()) {
            fileNameList.add(filename);
        }
        for (RString filepath : filePathList.values()) {
            runFilePath = filepath;
            executeStep(TEMP_SAVE_PROCESS);
        }
        executeStep(TEMP_TABLE_EDIT);
        executeStep(DB_UPDATE);
        executeStep(WRITE_REPORT);
    }

    @Step(CSVFILE_COPY)
    IBatchFlowCommand csvFileCopy() {
        ShokanShikyuKetteiInProcessParameter parameter = getParameter().toDBC120090_ShokanShikyuKetteiInProcessParameter();
        parameter.setFilePath(new RString("/nfshome/D209007/csvFiles/DB/"));
        parameter.setSharedName(csvFileKey);
        parameter.setIcchijoken(IcchiJoken.前方一致);

        return simpleBatch(SharedFileCopy.class).arguments(parameter).define();
    }

    @Step(TEMP_SAVE_PROCESS)
    IBatchFlowCommand registTempSaveProcess() {
        ShokanShikyuKetteiInProcessParameter parameter = getParameter().toDBC120090_ShokanShikyuKetteiInProcessParameter();
        parameter.setSaveFilePath(runFilePath);
        return loopBatch(RegistTempSaveProcess.class)
                .arguments(parameter)
                .define();
    }

    @Step(TEMP_TABLE_EDIT)
    IBatchFlowCommand shokanBaraiShikyuKetteiJohoTempTableEditProcess() {
        return loopBatch(TempTableEditProcess.class)
                .define();
    }

    @Step(DB_UPDATE)
    IBatchFlowCommand tempTableUpdateProcess() {
        ShokanShikyuKetteiInProcessParameter parameter = getParameter().toDBC120090_ShokanShikyuKetteiInProcessParameter();
        parameter.setFileNameList(fileNameList);
        return simpleBatch(TempTableUpdateProcess.class)
                .arguments(parameter)
                .define();
    }

    @Step(WRITE_REPORT)
    IBatchFlowCommand writeReportProcess() {
        ShokanShikyuKetteiInProcessParameter parameter = getParameter().toDBC120090_ShokanShikyuKetteiInProcessParameter();
        return loopBatch(RegistTempSaveProcess.class)
                .arguments(parameter)
                .define();
    }
}

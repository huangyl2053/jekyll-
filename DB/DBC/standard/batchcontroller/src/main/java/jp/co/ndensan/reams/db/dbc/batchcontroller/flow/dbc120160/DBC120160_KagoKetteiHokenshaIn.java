/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120160;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170.KohifutanshaDoIchiranhyoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120160.KagoKetteiHokenshaInSharedFileCopy;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120160.KagoKetteiHokenshaInTempSaveProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120160.KagoKetteiHokenshaInUpdataDBProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120160.KagoKetteiHokenshaInUpdataTempTableProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kagoketteihokenshain.KagoKetteiHokenshaInBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤決定通知書情報取込（保険者分）バッチ
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public class DBC120160_KagoKetteiHokenshaIn
        extends BatchFlowBase<KagoKetteiHokenshaInBatchParameter> {

    private static final String SHAREDFILE_COPY = "KagoKetteiHokenshaInSharedFileCopy";
    private static final String TEMP_SAVE_PROCESS = "KagoKetteiHokenshaInTempSaveProcess";
    private static final String UPDATA_TEMPTABLE_PROCESS = "KagoKetteiHokenshaInUpdataDBProcess";
    private static final String UPDATA_DB_PROCESS = "KagoKetteiHokenshaInUpdataTempTableProcess";
    private static final String WRITE_REPORT = "KagoKetteiHokenshaInWriteReportProcess";

    private final RString filePath = new RString("/home/D209007/shared/sharedFiles");
    private final RString sharedFileKey = new RString("171");
    private RString runFilePath;
    private List<RString> csvFileName;
    private static final RString 帳票ID = new RString("DBC200050_KagoKetteitsuchishoTorikomiIchiranHokenshaBun");

    @Override
    protected void defineFlow() {
        executeStep(SHAREDFILE_COPY);

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(SHAREDFILE_COPY),
                KagoKetteiHokenshaInSharedFileCopy.PARAMETER_OUT_FILEPATHLIST);

        csvFileName = new ArrayList<>();
        for (RString filename : filePathList.keySet()) {
            csvFileName.add(filename);
        }
        for (RString filepath : filePathList.values()) {
            runFilePath = filepath;
            executeStep(TEMP_SAVE_PROCESS);
        }
        executeStep(UPDATA_TEMPTABLE_PROCESS);
        executeStep(UPDATA_DB_PROCESS);
        executeStep(WRITE_REPORT);
    }

    @Step(SHAREDFILE_COPY)
    IBatchFlowCommand csvFileCheckProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KagoKetteiHokenshaInSharedFileCopy.PARAMETER_IN_FILEPATH, filePath);
        processParameter.put(KagoKetteiHokenshaInSharedFileCopy.PARAMETER_IN_SHAREDNAME, sharedFileKey);
        return simpleBatch(KagoKetteiHokenshaInSharedFileCopy.class).arguments(processParameter).define();
    }

    @Step(TEMP_SAVE_PROCESS)
    IBatchFlowCommand tempSaveProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KagoKetteiHokenshaInTempSaveProcess.PARAMETER_FILEPATH, runFilePath);
        return loopBatch(KagoKetteiHokenshaInTempSaveProcess.class).arguments(processParameter).define();
    }

    @Step(UPDATA_TEMPTABLE_PROCESS)
    IBatchFlowCommand updataTempTableProcess() {
        return loopBatch(KagoKetteiHokenshaInUpdataTempTableProcess.class).define();
    }

    @Step(UPDATA_DB_PROCESS)
    IBatchFlowCommand updataDBProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KagoKetteiHokenshaInUpdataDBProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        processParameter.put(KagoKetteiHokenshaInUpdataDBProcess.PARAMETER_CSVFILENAME, csvFileName);
        return simpleBatch(KagoKetteiHokenshaInUpdataDBProcess.class).arguments(processParameter).define();
    }

    @Step(WRITE_REPORT)
    IBatchFlowCommand writeReportProcess() {
        KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter
                = new KohifutanshaDoIchiranhyoSakuseiProcessParameter();
        parameter.setサブ業務コード(SubGyomuCode.DBC介護給付);
        parameter.set帳票ID(new ReportId(帳票ID));
        parameter.set出力順ID(getParameter().getShuturyokuJunn());
        parameter.set処理年月(getParameter().getShoriYM());
        parameter.setシステム日付(RDateTime.now());
        return simpleBatch(KohifutanshaDoIchiranhyoSakuseiProcess.class).arguments(parameter).
                define();
    }
}

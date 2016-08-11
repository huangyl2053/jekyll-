///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc120100;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120010.SharedFileCopyProcess;
//import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120100.ShokanFushikyuDbUpdateProcess;
//import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120100.ShokanFushikyuTableInsertProcess;
//import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120100.ShokanFushikyuWriteReportProcess;
//import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanfushikyuketteiin.DBC120100_ShokanFushikyuKetteiInBatchParameter;
//import jp.co.ndensan.reams.db.dbc.definition.core.IcchiJoken;
//import jp.co.ndensan.reams.uz.uza.batch.Step;
//import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
//import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//
///**
// * バッチ設計_DBCMNF2002-222_償還払不支給決定情報取込
// *
// * @reamsid_L DBC-2590-010 xuhao
// */
//public class DBC120100_ShokanFushikyuKetteiIn extends BatchFlowBase<DBC120100_ShokanFushikyuKetteiInBatchParameter> {
//
//    private static final String CSVFILE_COPY = "csvFileCopy";
//    private static final String TEMP_TABLE_INSERT = "tempTableInsertProcess";
//    private static final String TEMP_TABLE_UPDATE = "tempTableUpdateProcess";
//    private static final String DB_UPDATE = "dbUpdateProcess";
//    private static final String WRITE_REPORT = "writeReportProcess";
//
//    private final RString sharedFileKey = new RString("222");
////    private RString runFilePath;
//    private List<RString> fileNameList;
//
//    @Override
//    protected void defineFlow() {
//        executeStep(CSVFILE_COPY);
//
//        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(CSVFILE_COPY),
//                SharedFileCopyProcess.PARAMETER_OUT_FILEPATHLIST);
//        fileNameList = new ArrayList<>();
//        for (RString filename : filePathList.keySet()) {
//            fileNameList.add(filename);
//        }
////        for (RString filepath : filePathList.values()) {
////            runFilePath = filepath;
////            executeStep(TEMP_TABLE_INSERT);
////        }
//        executeStep(TEMP_TABLE_UPDATE);
//        executeStep(DB_UPDATE);
//        executeStep(WRITE_REPORT);
//    }
//
//    @Step(CSVFILE_COPY)
//    IBatchFlowCommand csvFileCopy() {
//        Map<RString, Object> processParameter = new HashMap<>();
//        processParameter.put(SharedFileCopyProcess.PARAMETER_IN_FILEPATH, new RString("/home/D209007/shared/DB120100/"));
//        processParameter.put(SharedFileCopyProcess.PARAMETER_IN_SHAREDNAME, sharedFileKey);
//        processParameter.put(SharedFileCopyProcess.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);
//        return simpleBatch(SharedFileCopyProcess.class).arguments(processParameter).define();
//    }
//
//    @Step(TEMP_TABLE_INSERT)
//    IBatchFlowCommand tempTableInsertProcess() {
//        Map<RString, Object> parameter = new HashMap<>();
////        parameter.put(KohifutanshaTempTableInsertProcess.PARAMETER_FILEPATH, runFilePath);
//        return loopBatch(ShokanFushikyuTableInsertProcess.class).arguments(parameter).define();
//    }
//
//    @Step(TEMP_TABLE_UPDATE)
//    IBatchFlowCommand tempTableUpdateProcess() {
//        return loopBatch(ShokanFushikyuTableUpdateProcess.class).define();
//    }
//
//    @Step(DB_UPDATE)
//    IBatchFlowCommand dbUpdateProcess() {
//        Map<RString, Object> parameter = new HashMap<>();
//        parameter.put(ShokanFushikyuDbUpdateProcess.PARAMETER_SHORIYM, getParameter().getShoriYearMonth());
//        parameter.put(ShokanFushikyuDbUpdateProcess.PARAMETER_FILENAME, fileNameList);
//        return simpleBatch(ShokanFushikyuDbUpdateProcess.class).arguments(parameter).define();
//    }
//
//    @Step(WRITE_REPORT)
//    IBatchFlowCommand writeReportProcess() {
//        Map<RString, Object> parameter = new HashMap<>();
//        parameter.put(ShokanFushikyuWriteReportProcess.PARAMETER_IN_SHUTSURYOKUJUNID,
//                getParameter().getShutsuryokujun());
//        return loopBatch(ShokanFushikyuWriteReportProcess.class).arguments(parameter).define();
//    }
//}

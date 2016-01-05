/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.idochecklist;

import jp.co.ndensan.reams.db.dba.definition.batchprm.idochecklist.IdoCheckListBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;

/**
 * 異動チェックリストのバッチフロークラスです
 */
public class IdoCheckListFlow extends BatchFlowBase<IdoCheckListBatchParameter> {

    @Override
    protected void defineFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private static final String GET_HIHOKENSHA_DAICHOU_LIST = "getHihokenshaDaichouList";
//    private static final String GET_JUSHOCHI_TOKUREI_LIST = "getJushochiTokureiList";
//    private static final String GET_TEKIYO_JOGAISHA_DAICHOU_LIST = "getTekiyoJogaishaDaichouList";
//    private static final String GET_SEIKATSUHOGO_LIST = "getSeikatsuHogoList";
//    private static final String GET_ROREI_FUKUSHI_NENKIN_LIST = "getRoreiFukushiNenkinList";
//    private List<IdoInfoEntity> idoInfoEntityList;
//
//    @Override
//    protected void initialize() {
//        idoInfoEntityList = new ArrayList<>();
//    }
//
//    @Override
//    protected void defineFlow() {
//        executeStep(GET_HIHOKENSHA_DAICHOU_LIST);
//        executeStep(GET_JUSHOCHI_TOKUREI_LIST);
//        executeStep(GET_TEKIYO_JOGAISHA_DAICHOU_LIST);
//        executeStep(GET_SEIKATSUHOGO_LIST);
//        executeStep(GET_ROREI_FUKUSHI_NENKIN_LIST);
//    }
//
//    private Map<RString, Object> setParam(List<IdoInfoEntity> idoInfoEntityList) {
//        Map<RString, Object> processParameter = new HashMap<>();
//        processParameter.put(new RString("parameter"), getParameter().toIdoCheckListGetDataProcessParameter());
//        processParameter.put(new RString("idoinfolist"), idoInfoEntityList);
//        return processParameter;
//    }
//
//    @Step(GET_HIHOKENSHA_DAICHOU_LIST)
//    private IBatchFlowCommand getHihokenshaDaichouListProcess() {
//        return simpleBatch(ReportParamProcess.class).arguments(setParam(idoInfoEntityList)).define();
//    }
//
//    @Step(GET_JUSHOCHI_TOKUREI_LIST)
//    private IBatchFlowCommand getJushochiTokureiListProcess() {
//        return loopBatch(UpdaShoriDateKanriProcess.class).arguments(getParameter().toIdoCheckListGetDataProcessParameter()).define();
//    }
}

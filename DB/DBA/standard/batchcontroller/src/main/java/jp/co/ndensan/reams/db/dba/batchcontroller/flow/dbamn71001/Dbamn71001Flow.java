/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow.dbamn71001;

import java.util.List;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.dbamn71001.HihokenshaDaichoUpdateProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.dbamn71001.ParameterSetProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.dbamn71001.ShikakuIdoTaishoshaShutokuProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.dbamn71001.Dbamn71001BatchFlowParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001.HihokenshaDaichoUpdateProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001.ParameterSetProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dbamn71001.ShikakuIdoTaishoshaShutokuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ６５歳年齢到達資格異動_バッチフロークラスです。
 */
public class Dbamn71001Flow extends BatchFlowBase<Dbamn71001BatchFlowParameter> {
    
    private static final String バッチ内で抽出条件の生成 = "get開始日And終了日";
    private static final String 資格異動対象者情報取得 = "getShikakuIdoTaishosha";
    private static final String 被保険者台帳管理の更新 = "updHihokenshaDaicho";


    @Override
    protected void defineFlow() {
        
        if (getParameter() == null || getParameter().getKaishiYMD().isEmpty() || getParameter().getShuryoYMD().isEmpty()) {
            executeStep(バッチ内で抽出条件の生成);
        }
        executeStep(資格異動対象者情報取得);
        executeStep(被保険者台帳管理の更新);
    }

    
    /**
     * バッチ内で抽出条件の生成を行います。
     * @return バッチコマンド
     */
    @Step(バッチ内で抽出条件の生成)
    protected IBatchFlowCommand get開始日And終了日() {
        return simpleBatch(ParameterSetProcess.class)
                .arguments(new ParameterSetProcessParameter())
                .define();
    }
    
   /**
     * 資格異動対象者情報の取得を行います。
     * @return バッチコマンド
     */
    @Step(資格異動対象者情報取得)
    protected IBatchFlowCommand getShikakuIdoTaishosha() {
        
        ShikakuIdoTaishoshaShutokuProcessParameter parameter;
        if (getParameter() == null || getParameter().getKaishiYMD().isEmpty() || getParameter().getShuryoYMD().isEmpty()) {
            parameter = setBatchParameter();
        } else {
            parameter = getParameter().toShikakuIdoTaishoshaShutokuProcessParameter();
        }
        return simpleBatch(ShikakuIdoTaishoshaShutokuProcess.class)
                    .arguments(parameter)
                    .define();
    }
    
   /**
     * 認定調査督促対象者一覧表CSVの作成を行います。
     * @return バッチコマンド
     */
    @Step(被保険者台帳管理の更新)
    protected IBatchFlowCommand updHihokenshaDaicho() {
        
        return simpleBatch(HihokenshaDaichoUpdateProcess.class)
                .arguments(createUpdateParameter())
                .define();
    }
    
    private ShikakuIdoTaishoshaShutokuProcessParameter setBatchParameter() {
        ShikakuIdoTaishoshaShutokuProcessParameter param = new ShikakuIdoTaishoshaShutokuProcessParameter();
        param.set開始日(getResult(FlexibleDate.class, new RString(バッチ内で抽出条件の生成), ParameterSetProcess.KAISHI_YMD));
        param.set終了日(getResult(FlexibleDate.class, new RString(バッチ内で抽出条件の生成), ParameterSetProcess.SHURYO_YMD));
        
        return param;
    }
    
    private HihokenshaDaichoUpdateProcessParameter createUpdateParameter() {
 
        HihokenshaDaichoUpdateProcessParameter parameter = new HihokenshaDaichoUpdateProcessParameter();
        List<HihokenshaDaichoUpdateProcessParameter> itemList = 
                getResult(List.class, new RString(資格異動対象者情報取得), ShikakuIdoTaishoshaShutokuProcess.SHIKAKU_IDO_TAISHOSHA_LIST);
        parameter.setShikakuIdoTaishoshaEntityList(itemList);
        parameter.setFlowParam(getParameter());
 
        return parameter;
    }

}

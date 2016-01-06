/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.dbe223001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001.NinteiChosaTokusokujoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001.UpadteDataProcess;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.dbe223001.Dbe223001FlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.UpdateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促状発行のバッチフロークラスです。
 */
public class Dbe223001Flow extends BatchFlowBase<Dbe223001FlowParameter> {

    private static final String 要介護認定調査督促状の作成 = "ninteiChosaTokusokujoReport";
    private static final String 認定調査督促対象者一覧表の作成 = "ninteiChosaTokusokuTaishoshaIchiranhyoReport";
    private static final String 認定調査督促対象者一覧表CSVの作成 = "ninteiChosaTokusokuTaishoshaIchiranhyoCsv";
    private static final String 認定調査督促対象者一覧表の更新 = "updateData";
    private static final String 要介護認定調査督促状_選択された = "1";
    private static final String 認定調査督促対象者一覧表_選択された = "1";
    private static final String CSV出力_選択された = "1";


    @Override
    protected void defineFlow() {
       
        if (要介護認定調査督促状_選択された.equals(getParameter().getTemp_要介護認定調査督促状().toString())) {
            executeStep(要介護認定調査督促状の作成);
        }
        if (認定調査督促対象者一覧表_選択された.equals(getParameter().getTemp_認定調査督促対象者一覧表().toString())) {
            executeStep(認定調査督促対象者一覧表の作成);
        }
        if (CSV出力_選択された.equals(getParameter().getTemp_CSV出力().toString())) {
            executeStep(認定調査督促対象者一覧表CSVの作成);
        }
        executeStep(認定調査督促対象者一覧表の更新);
    }
    
    /**
     * 要介護認定調査督促状の作成を行います。
     * @return バッチコマンド
     */
    @Step(要介護認定調査督促状の作成)
    protected IBatchFlowCommand ninteiChosaTokusokujoReport() {
        return loopBatch(NinteiChosaTokusokujoReportProcess.class)  //TODO QA #73040 複数件の帳票を出力
                .arguments(getParameter().toNinteiChosaTokusokujoProcessParameter())
                .define();
    }
    
    /**
     * 認定調査督促対象者一覧表の作成を行います。
     * @return バッチコマンド
     */
    @Step(認定調査督促対象者一覧表の作成)
    protected IBatchFlowCommand ninteiChosaTokusokuTaishoshaIchiranhyoReport() {
        return loopBatch(NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess.class)
                .arguments(getParameter().toNinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter())
                .define();
    }

    /**
     * 認定調査督促対象者一覧表CSVの作成を行います。
     * @return バッチコマンド
     */
    @Step(認定調査督促対象者一覧表CSVの作成)
    protected IBatchFlowCommand ninteiChosaTokusokuTaishoshaIchiranhyoCsv() {
        
        return simpleBatch(NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcess.class)
                .arguments(createCsvParameter())
                .define();
    }
    
    /**
     * 認定調査督促対象者一覧表の更新を行います。
     * @return バッチコマンド
     */
    @Step(認定調査督促対象者一覧表の更新)  //TODO QA #73040 排他キー
    protected IBatchFlowCommand updateData() {
        return simpleBatch(UpadteDataProcess.class)
                .arguments(createUpdateParameter())
                .define();
    }
    
    private NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter createCsvParameter() {
 
        NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter parameter = new NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter();
        List<NinteiChosaTokusokuTaishoshaIchiranhyoItem> itemList = 
                getResult(List.class, new RString(認定調査督促対象者一覧表の作成), NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess.OUT_DATA_LIST);
        parameter.setNinteiChosaTokusokuTaishoshaIchiranhyoItemList(itemList);
 
        return parameter;
    }
    
    private UpdateProcessParameter createUpdateParameter() {
        UpdateProcessParameter updateProcessParameter = new UpdateProcessParameter();
        List<RString> noList = getResult(List.class, new RString(要介護認定調査督促状の作成), NinteiChosaTokusokujoReportProcess.OUT_SHINSEISHO_KANRINO_LIST);
        
        updateProcessParameter.set申請書管理番号List(noList);
        updateProcessParameter.setTemp_督促日(new RString(getParameter().getTemp_督促日().toString()));
        updateProcessParameter.setTemp_督促メモ(new RString(String.valueOf(getParameter().getTemp_督促方法())));
        updateProcessParameter.setTemp_督促方法(new RString(String.valueOf(getParameter().getTemp_督促方法())));
        
        return updateProcessParameter;
    }

}

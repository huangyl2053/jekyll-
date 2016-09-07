/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.ninteichosatokusokujyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosatokusokujyo.NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosatokusokujyo.NinteiChosaTokusokujoReportProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosatokusokujyo.NinteichosaIraiJohoUpdateProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosatokusokujyo.NinteichosaTokusokujyoFlowParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosatokusokujyo.NinteichosaIraiJohoUpdateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促状発行のバッチフロークラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteichosaTokusokujyoFlow extends BatchFlowBase<NinteichosaTokusokujyoFlowParameter> {

    private static final String 要介護認定調査督促状の作成 = "ninteiChosaTokusokujoReport";
    private static final String 認定調査督促対象者一覧表の作成 = "ninteiChosaTokusokuTaishoshaIchiranhyoReport";
    private static final String 認定調査督促対象者一覧表の更新 = "updateData";
    private static final String 要介護認定調査督促状_選択された = "1";
    private static final String 認定調査督促対象者一覧表_選択された = "1";

    @Override
    protected void defineFlow() {

        List<RString> 申請書管理番号 = new ArrayList<>();
        if (要介護認定調査督促状_選択された.equals(getParameter().getTemp_要介護認定調査督促状().toString())) {
            executeStep(要介護認定調査督促状の作成);
            申請書管理番号 = getResult(List.class, new RString(要介護認定調査督促状の作成), NinteiChosaTokusokujoReportProcess.OUT_SHINSEISHO_KANRINO_LIST);
        }
        if (認定調査督促対象者一覧表_選択された.equals(getParameter().getTemp_認定調査督促対象者一覧表().toString())) {
            executeStep(認定調査督促対象者一覧表の作成);
        }
        if (申請書管理番号 != null && !申請書管理番号.isEmpty()) {
            executeStep(認定調査督促対象者一覧表の更新);
        }
    }

    /**
     * 要介護認定調査督促状の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(要介護認定調査督促状の作成)
    protected IBatchFlowCommand ninteiChosaTokusokujoReport() {
        return loopBatch(NinteiChosaTokusokujoReportProcess.class)
                .arguments(getParameter().toNinteiChosaTokusokujoProcessParameter())
                .define();
    }

    /**
     * 認定調査督促対象者一覧表の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査督促対象者一覧表の作成)
    protected IBatchFlowCommand ninteiChosaTokusokuTaishoshaIchiranhyoReport() {
        return loopBatch(NinteiChosaTokusokuTaishoshaIchiranhyoReportProcess.class)
                .arguments(getParameter().toNinteiChosaTokusokuTaishoshaIchiranhyoProcessParameter())
                .define();
    }

    /**
     * 認定調査督促対象者一覧表の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定調査督促対象者一覧表の更新)
    protected IBatchFlowCommand updateData() {
        return loopBatch(NinteichosaIraiJohoUpdateProcess.class)
                .arguments(createUpdateParameter())
                .define();
    }

    private NinteichosaIraiJohoUpdateProcessParameter createUpdateParameter() {
        NinteichosaIraiJohoUpdateProcessParameter updateProcessParameter = new NinteichosaIraiJohoUpdateProcessParameter();
        List<RString> noList = new ArrayList<>();
        if (要介護認定調査督促状_選択された.equals(getParameter().getTemp_要介護認定調査督促状().toString())) {
            noList = getResult(List.class, new RString(要介護認定調査督促状の作成), NinteiChosaTokusokujoReportProcess.OUT_SHINSEISHO_KANRINO_LIST);
        }
        updateProcessParameter.set申請書管理番号(noList);
        updateProcessParameter.setTemp_督促日(new RString(getParameter().getTemp_督促日().toString()));
        updateProcessParameter.setTemp_督促メモ(new RString(String.valueOf(getParameter().getTemp_督促メモ())));
        updateProcessParameter.setTemp_督促方法(new RString(String.valueOf(getParameter().getTemp_督促方法())));

        return updateProcessParameter;
    }

}

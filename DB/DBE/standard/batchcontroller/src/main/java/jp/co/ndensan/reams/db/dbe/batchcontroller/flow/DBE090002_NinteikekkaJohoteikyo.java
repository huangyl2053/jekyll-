/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.IchijiHanteiKekkaPrintProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.IsshikiPrintProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.NinteiChosahyoPrintProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.ShujiiIkenshoPrintProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.SonotaShiryoPrintProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.TokkiJikoPrintProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE090002.UpdateDataProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE090002.DBE090002_NinteikekkaJohoteikyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.yokaigoninteijohoteikyo.YokaigoBatchProcessParamter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報提供票のバッチフロークラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
public class DBE090002_NinteikekkaJohoteikyo extends BatchFlowBase<DBE090002_NinteikekkaJohoteikyoParameter> {

    private static final String 一式出力 = "isshikiPrint";
    private static final String 認定調査票出力 = "ninteiChosahyoPrint";
    private static final String 特記事項出力 = "tokkiJikoPrint";
    private static final String 主治医意見書出力 = "shujiiIkenshoPrint";
    private static final String その他資料出力 = "sonotaShiryoPrint";
    private static final String 一次判定結果出力 = "ichijiHanteiKekkaPrint";
    private static final String 要介護認定申請情報更新 = "updateData";

    private final RString 出力方法_一式 = new RString("0");

    private YokaigoBatchProcessParamter processParameter;

    @Override
    protected void prepareConfigData() {
        FlexibleDate 特記事項判定日
                = new FlexibleDate(DbBusinessConfig.get(ConfigNameDBE.特記事項判定日, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        RString 総合事業開始区分 = DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 情報提供資料の特記事項編集パターン
                = DbBusinessConfig.get(ConfigNameDBE.情報提供資料の特記事項編集パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 特記事項符号印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.特記事項符号印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 正常選択肢印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.今回基本調査項目結果の正常選択肢印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 前回との結果比較印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.前回との結果比較印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        RString 前回正常選択肢印刷有無
                = DbBusinessConfig.get(ConfigNameDBE.今回前回比較で変化有で前回正常選択肢表示印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        processParameter = getParameter().toYokaigoBatchProcessParamter(特記事項判定日, 総合事業開始区分,
                情報提供資料の特記事項編集パターン, 特記事項符号印刷有無, 正常選択肢印刷有無,
                前回との結果比較印刷有無, 前回正常選択肢印刷有無);
    }

    @Override
    protected void defineFlow() {
        if (出力方法_一式.equals(getParameter().get出力方法())) {
            executeStep(一式出力);
        } else {
            if (getParameter().is認定調査票出力()) {
                executeStep(認定調査票出力);
            }
            if (getParameter().is特記事項出力()) {
                executeStep(特記事項出力);
            }
            if (getParameter().is主治医意見書出力()) {
                executeStep(主治医意見書出力);
            }
            if (getParameter().isその他資料出力()) {
                executeStep(その他資料出力);
            }
            if (getParameter().is一次判定結果出力()) {
                executeStep(一次判定結果出力);
            }
        }
        executeStep(要介護認定申請情報更新);
    }

    @Step(一式出力)
    protected IBatchFlowCommand isshikiPrint() {
        return loopBatch(IsshikiPrintProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(認定調査票出力)
    protected IBatchFlowCommand ninteiChosahyoPrint() {
        return loopBatch(NinteiChosahyoPrintProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(特記事項出力)
    protected IBatchFlowCommand tokkiJikoPrint() {
        return loopBatch(TokkiJikoPrintProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(主治医意見書出力)
    protected IBatchFlowCommand shujiiIkenshoPrint() {
        return loopBatch(ShujiiIkenshoPrintProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(その他資料出力)
    protected IBatchFlowCommand sonotaShiryoPrint() {
        return loopBatch(SonotaShiryoPrintProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(一次判定結果出力)
    protected IBatchFlowCommand ichijiHanteiKekkaPrint() {
        return loopBatch(IchijiHanteiKekkaPrintProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(要介護認定申請情報更新)
    protected IBatchFlowCommand updateData() {
        return loopBatch(UpdateDataProcess.class)
                .arguments(processParameter)
                .define();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.enkitsuchisho;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.enkitsuchisho.EnkiTsuchishoJyohoReportProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoReportProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5220001.NinteiEnkiTsuchishoHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 延期通知書出力のバッチフロークラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public class EnkiTsuchishoFlow extends BatchFlowBase<NinteiEnkiTsuchishoHakkoParameter> {

    private static final String 画面モードが検索モード = "1";
    private static final String 画面モードが通知書モード = "2";
    private static final String 延期通知書発行一覧表の作成 = "enkiTsuchishohakenIchiranhyoJyohoReport";
    private static final String 延期通知書情報の作成 = "enkiTsuchishoJyohoReport";

    @Override
    protected void defineFlow() {
        if (画面モードが検索モード.equals(getParameter().get画面モード().toString())) {
            executeStep(延期通知書発行一覧表の作成);
        }
        if (画面モードが通知書モード.equals(getParameter().get画面モード().toString())) {
            executeStep(延期通知書情報の作成);
        }
    }

    /**
     * 要介護認定延期通知書発行一覧表情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(延期通知書発行一覧表の作成)
    protected IBatchFlowCommand enkiTsuchishohakenIchiranhyoJyohoReport() {
        return loopBatch(EnkiTsuchishohakenIchiranhyoJyohoReportProcess.class)
                .arguments(getParameter().toEnkiTsuchishohakenIchiranhyoJyohoProcessParameter())
                .define();
    }

    /**
     * 延期通知書情報の取得、要介護認定申請情報テーブルの更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(延期通知書情報の作成)
    protected IBatchFlowCommand enkiTsuchishoJyohoReport() {
        return loopBatch(EnkiTsuchishoJyohoReportProcess.class)
                .arguments(getParameter().toEnkiTsuchishohakenIchiranhyoJyohoProcessParameter())
                .define();
    }

//    @Step(バッチ出力条件リストの出力)
//    protected IBatchFlowCommand batchShutsuryokuJyokenRisuto() {
//        return loopBatch()
//                .arguments(getParameter().toEnkiTsuchishohakenIchiranhyoJyohoProcessParameter())
//                .define();
//    }
}

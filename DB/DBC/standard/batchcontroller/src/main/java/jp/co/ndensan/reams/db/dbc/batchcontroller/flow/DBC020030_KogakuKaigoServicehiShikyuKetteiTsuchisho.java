/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030.InsertKogakuKaigoKetteiTsuchishoInfoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030.KogakuKaigoServicehiDoChohyoHakkoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030.KogakuShikyuFushikyuKetteiTsuchiHakkoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030.UpdateKogakuShikyuHanteiKekkaProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020060.JigyoKogakuShoriKekkaKakuninListSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 高額サービス費支給（不支給）決定通知書作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchisho
        extends BatchFlowBase<DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter> {

    private static final String 高額サービス一時テーブルの登録 = "insertKogakuKaigoKetteiTsuchishoInfoTempProcess";
    private static final String 高額サービス一時テーブルの設定 = "updateKogakuKaigoKetteiTsuchishoInfoTempProcess";
    private static final String 高額介護サービス費支給判定結果の更新 = "updateKogakuShikyuHanteiKekkaProcess";
    private static final String 帳票発行 = "doChohyoHakko";
    private static final String 帳票発行_一覧表 = "doIchiranChohyoHakko";
    private static final String 処理結果確認リスト発行処理 = "doListSakuseiProcess";
    private static final int INDEX_0 = 0;
    private static final int INDEX_6 = 6;

    @Override
    protected void defineFlow() {
        executeStep(高額サービス一時テーブルの登録);
        executeStep(高額サービス一時テーブルの設定);
        executeStep(高額介護サービス費支給判定結果の更新);
        executeStep(帳票発行);
        executeStep(帳票発行_一覧表);
        executeStep(処理結果確認リスト発行処理);
    }

    /**
     * 高額サービス一時テーブルの登録メソッドです
     *
     * @return バッチコマンド
     */
    @Step(高額サービス一時テーブルの登録)
    protected IBatchFlowCommand insertKogakuKaigoKetteiTsuchishoInfoTempProcess() {
        return loopBatch(InsertKogakuKaigoKetteiTsuchishoInfoTempProcess.class).arguments(creatParameter()).define();
    }

    /**
     * 高額サービス一時テーブルの設定メソッドです
     *
     * @return バッチコマンド
     */
    @Step(高額介護サービス費支給判定結果の更新)
    protected IBatchFlowCommand updateKogakuShikyuHanteiKekkaProcess() {
        return loopBatch(UpdateKogakuShikyuHanteiKekkaProcess.class).arguments(creatParameter()).define();
    }

    /**
     * 帳票発行です。
     *
     * @return KogakuKaigoServicehiDoChohyoHakkoProcess
     */
    @Step(帳票発行)
    protected IBatchFlowCommand doChohyoHakko() {
        return loopBatch(KogakuKaigoServicehiDoChohyoHakkoProcess.class).arguments(creatParameter()).define();
    }

    /**
     * 帳票発行_一覧表です。
     *
     * @return KogakuShikyuFushikyuKetteiTsuchiHakkoSakuseiProcess
     */
    @Step(帳票発行_一覧表)
    protected IBatchFlowCommand doIchiranChohyoHakko() {
        return loopBatch(KogakuShikyuFushikyuKetteiTsuchiHakkoSakuseiProcess.class).arguments(creatParameter()).define();
    }

    /**
     * 処理結果確認リスト発行処理です。
     *
     * @return JigyoKogakuShoriKekkaKakuninListSakuseiProcess
     */
    @Step(処理結果確認リスト発行処理)
    protected IBatchFlowCommand doListSakuseiProcess() {
        return loopBatch(JigyoKogakuShoriKekkaKakuninListSakuseiProcess.class).define();
    }

    private KogakuKaigoServiceProcessParameter creatParameter() {
        DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter parameter = getParameter();
        FlexibleYearMonth 決定者受付年月;
        if (parameter.get決定者受付年月() == null || parameter.get決定者受付年月().toDateString().isEmpty()) {
            決定者受付年月 = new FlexibleYearMonth(RString.EMPTY);
        } else {
            決定者受付年月 = new FlexibleYearMonth(parameter.get決定者受付年月().toDateString().substring(INDEX_0, INDEX_6));
        }
        return new KogakuKaigoServiceProcessParameter(parameter.get抽出モード(), parameter.get抽出条件日付From(),
                parameter.get抽出条件日付To(), 決定者受付年月,
                parameter.get印書(), parameter.get高額自動償還(), parameter.get発行日(),
                parameter.get文書番号(), parameter.getテスト出力フラグ(), parameter.get決定日一括更新区分(), parameter.get決定日(),
                parameter.get利用者向け決定通知書フラグ(), parameter.get受領委任者向け決定通知書フラグ(),
                parameter.get振込予定日(), parameter.get支払場所(), parameter.get支払期間From(), parameter.get支払期間To(),
                parameter.get開始時間(), parameter.get終了時間(), parameter.get出力順ID());
    }
}

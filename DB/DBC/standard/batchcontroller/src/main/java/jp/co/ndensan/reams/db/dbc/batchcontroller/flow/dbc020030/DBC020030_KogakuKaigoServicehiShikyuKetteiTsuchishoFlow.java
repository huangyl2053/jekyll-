/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc020030;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020030.InsertKogakuKaigoKetteiTsuchishoInfoTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehishikyuketteitsuchisho.KogakuKaigoServiceProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 高額サービス費支給（不支給）決定通知書作成のバッチフロークラスです。
 *
 * @reamsid_L DBC-2000-030 xicongwang
 */
public class DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoFlow
        extends BatchFlowBase<DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter> {

    private static final String 高額サービス一時テーブルの登録 = "insertKogakuKaigoKetteiTsuchishoInfoTempProcess";

    @Override
    protected void defineFlow() {
        executeStep(高額サービス一時テーブルの登録);
    }

    /**
     * 高額サービス一時テーブルの登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(高額サービス一時テーブルの登録)
    protected IBatchFlowCommand insertKogakuKaigoKetteiTsuchishoInfoTempProcess() {
        return loopBatch(InsertKogakuKaigoKetteiTsuchishoInfoTempProcess.class).arguments(creatParameter()).define();
    }

    private KogakuKaigoServiceProcessParameter creatParameter() {
        DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter parameter = getParameter();
        return new KogakuKaigoServiceProcessParameter(parameter.get抽出モード(), parameter.get抽出条件日付From(),
                parameter.get抽出条件日付To(), parameter.get決定者受付年月(),
                parameter.get印書(), parameter.get高額自動償還(), parameter.get発行日(), parameter.get支払い予定日(),
                parameter.get文書番号(), parameter.getテスト出力フラグ(), parameter.get決定日一括更新区分(), parameter.get決定日(),
                parameter.get利用者向け決定通知書フラグ(), parameter.get受領委任者向け決定通知書フラグ(),
                parameter.get振込予定日(), parameter.get支払場所(), parameter.get支払期間From(), parameter.get支払期間To(),
                parameter.get開始時間(), parameter.get終了時間(), parameter.get出力順ID());
    }
}

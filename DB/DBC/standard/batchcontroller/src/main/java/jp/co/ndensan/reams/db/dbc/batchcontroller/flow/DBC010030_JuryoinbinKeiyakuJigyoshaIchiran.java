/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC010030.JuryoIninJigyoshaIchiranProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC010030.DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.juryoininjigyoshaichiran.JuryoIninJigyoshaIchiranGetIdProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約事業者一覧のバッチ処理フロー
 *
 * @reamsid_L DBC-2110-030 liuxiaoyu
 */
public class DBC010030_JuryoinbinKeiyakuJigyoshaIchiran extends BatchFlowBase<DBC010030_JuryoinbinKeiyakuJigyoshaIchiranParameter> {

    private static final String 受領委任契約事業者一覧表を作成 = "doIchiranhyoSakusei";

    @Override
    protected void defineFlow() {
        executeStep(受領委任契約事業者一覧表を作成);
    }

    /**
     * 受領委任契約事業者一覧表を作成です。
     *
     * @return バッチコマンド
     *
     */
    @Step(受領委任契約事業者一覧表を作成)
    protected IBatchFlowCommand doIchiranhyoSakusei() {
        JuryoIninJigyoshaIchiranGetIdProcessParameter parameter
                = new JuryoIninJigyoshaIchiranGetIdProcessParameter();
        if (RString.isNullOrEmpty(getParameter().get契約事業者番号FROM())) {
            parameter.set契約事業者番号FROM(RString.EMPTY);
        } else {
            parameter.set契約事業者番号FROM(getParameter().get契約事業者番号FROM());
        }
        if (RString.isNullOrEmpty(getParameter().get契約事業者番号TO())) {
            parameter.set契約事業者番号TO(RString.EMPTY);
        } else {
            parameter.set契約事業者番号TO(getParameter().get契約事業者番号TO());
        }
        if (getParameter().get契約日FROM() == null) {
            parameter.set契約日FROM(FlexibleDate.EMPTY);
        } else {
            parameter.set契約日FROM(getParameter().get契約日FROM());
        }
        if (getParameter().get契約日TO() == null) {
            parameter.set契約日TO(FlexibleDate.EMPTY);
        } else {
            parameter.set契約日TO(getParameter().get契約日TO());
        }
        parameter.set契約種別(getParameter().get契約種別());
        parameter.set契約期間終了事業者(getParameter().get契約期間終了事業者());
        if (!RString.isNullOrEmpty(getParameter().get改頁出力順ID())) {
            parameter.set帳票出力順ID(Long.parseLong(getParameter().get改頁出力順ID().toString()));
        }
        parameter.set市町村コード(getParameter().get市町村コード());
        parameter.set処理日時(RDateTime.now());
        return loopBatch(JuryoIninJigyoshaIchiranProcess.class).arguments(parameter).define();
    }
}

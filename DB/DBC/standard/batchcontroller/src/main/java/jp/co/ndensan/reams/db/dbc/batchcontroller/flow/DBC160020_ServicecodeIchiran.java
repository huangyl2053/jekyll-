/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC160020.ServicecodeIchiranProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC160020.DBC160020_ServicecodeIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodeichiran.ServicecodeIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * サービスコード一覧表ののバッチ処理フローです。
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
public class DBC160020_ServicecodeIchiran extends BatchFlowBase<DBC160020_ServicecodeIchiranParameter> {

    private static final String サービスコード一覧表 = "ServicecodeIchiranProcess";
    private RDateTime システム日時;

    @Override
    protected void defineFlow() {
        システム日時 = RDateTime.now();
        executeStep(サービスコード一覧表);

    }

    /**
     * サービスコード一覧表を作成です。
     *
     * @return バッチコマンド
     *
     */
    @Step(サービスコード一覧表)
    protected IBatchFlowCommand servicecodeIchiranProcess() {
        return loopBatch(ServicecodeIchiranProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private ServicecodeIchiranProcessParameter getProcessParameter() {
        ServicecodeIchiranProcessParameter param = new ServicecodeIchiranProcessParameter();
        param.set基準年月(getParameter().get基準年月());
        param.set処理日時(システム日時);
        param.set抽出条件区分(getParameter().get抽出条件区分());
        param.setサービス分類s(getParameter().getサービス分類s());
        if (getParameter().getサービス種類コード() != null && !getParameter().getサービス種類コード().isEmpty()) {
            param.setサービス種類コード(new ServiceShuruiCode(getParameter().getサービス種類コード()));
        }
        param.setサービス項目コード(getParameter().getサービス項目コード());
        param.set帳票で出力(getParameter().is帳票で出力());
        param.setＣＳＶファイルで出力(getParameter().isＣＳＶファイルで出力());
        param.set項目名付加(getParameter().is項目名付加());
        param.set連番付加(getParameter().is連番付加());
        param.set日付編集(getParameter().is日付編集());
        return param;
    }
}

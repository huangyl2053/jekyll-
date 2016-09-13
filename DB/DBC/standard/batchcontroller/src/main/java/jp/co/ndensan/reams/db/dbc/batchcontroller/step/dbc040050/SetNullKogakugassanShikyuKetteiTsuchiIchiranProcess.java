/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc040050;

import jp.co.ndensan.reams.db.dbc.business.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanshikyuketteitsuchisho.KogakugassanShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200040.GassanShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額合算支給不支給決定者一覧表を作成クラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
public class SetNullKogakugassanShikyuKetteiTsuchiIchiranProcess extends SimpleBatchProcessBase {

    private KogakugassanShikyuKetteitsuchishoProcessParameter processParameter;

    SubGyomuCode サブ業務コード = SubGyomuCode.DBC介護給付;
    ReportId 帳票分類ID = new ReportId("DBC100053_GassanKetteiTsuchisho");

    private BatchReportWriter<GassanShikyuFushikyuKetteishaIchiranSource> batchReportWriter_一覧表;
    private ReportSourceWriter<GassanShikyuFushikyuKetteishaIchiranSource> reportSourceWriter_一覧表;

    @Override
    protected void beforeExecute() {
        batchReportWriter_一覧表 = BatchReportFactory.createBatchReportWriter(
                ReportIdDBC.DBC200040.getReportId().value(), SubGyomuCode.DBC介護給付).create();
        reportSourceWriter_一覧表 = new ReportSourceWriter<>(batchReportWriter_一覧表);
    }

    @Override
    protected void process() {
        GassanShikyuFushikyuKetteishaIchiranReport 一覧表report = new GassanShikyuFushikyuKetteishaIchiranReport(null,
                processParameter.get処理日時(), false, null, null);
        一覧表report.writeBy(reportSourceWriter_一覧表);
        batchReportWriter_一覧表.close();
    }

}

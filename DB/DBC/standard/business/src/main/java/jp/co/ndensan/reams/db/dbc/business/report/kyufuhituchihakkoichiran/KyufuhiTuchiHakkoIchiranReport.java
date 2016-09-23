/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufuhituchihakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufuhituchihakoichiran.KyufuhiTuchiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufuhituchihakkoichiran.KyufuhiTuchiHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBC200044_給付費通知発行一覧表のReportです。
 *
 * @reamsid_L DBC-2280-080 lizhuoxuan
 */
public class KyufuhiTuchiHakkoIchiranReport extends Report<KyufuhiTuchiHakkoIchiranReportSource> {

    private final KyufuhiTuchiHakkoIchiranEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity 給付費通知発行一覧表のITEM
     */
    public KyufuhiTuchiHakkoIchiranReport(
            KyufuhiTuchiHakkoIchiranEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護保険給付費通知書を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<KyufuhiTuchiHakkoIchiranReportSource> reportSourceWriter) {
        IKyufuhiTuchiHakkoIchiranEditor editor = new KyufuhiTuchiHakkoIchiranEditor(entity);
        IKyufuhiTuchiHakkoIchiranBuilder builder = new KyufuhiTuchiHakkoIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}

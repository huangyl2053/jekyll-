/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601006;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsahoshuichiran.ShinsaHoshuIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran.ShinsaHoshuIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran.ShinsaHoshuIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 審査会委員報酬一覧表の帳票作成プロセスクラスです。
 * 
 * @author n8417（鄒　春雨）
 */
public class ShinsaHoshuIchiranReportProcess extends ShinsaHoshuIchiranProcess {
    
    @BatchWriter
    private BatchReportWriter<ShinsaHoshuIchiranReportSource> batchWriter;
    private ReportSourceWriter<ShinsaHoshuIchiranReportSource> reportWriter;

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE601005.getReportId().value()).create();
        reportWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void output(ShinsaHoshuIchiranEntity 審査報酬一覧Entity) {
        ShinsaHoshuIchiranReport report = new ShinsaHoshuIchiranReport(審査報酬一覧Entity);
        report.writeBy(reportWriter);
    }

    @Override
    protected void afterExecute() {
        帳票出力条件リストの出力();
    }

    private void 帳票出力条件リストの出力() {
        Association 導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 審査会開催年月 = new RStringBuilder("【対象年月】");
        審査会開催年月.append(getFormatted年月(paramter.get審査会開催年月()));
        出力条件.add(審査会開催年月.toRString());
        
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE601005.getReportId().value(),
                導入団体.getLasdecCode_().value(), 
                導入団体.get市町村名(), 
                new RString(JobContextHolder.getJobId()),
                ReportIdDBE.DBE601005.getReportName(), 
                new RString(reportWriter.pageCount().value()), 
                なし, 
                なし, 
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }
    
}

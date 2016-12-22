/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE601004;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshushokai.IkenHoshuIchiranChange;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshohoshushokai.IkenHoshuIchiranReport;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshushokai.IkenshoHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.ikenhoshuichiran.IkenHoshuIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 意見書作成報酬一覧表の帳票作成プロセスクラスです。
 * 
 * @author n8417（鄒　春雨）
 */
public class IkenshosakuseiHoshuReportProcess extends IkenshosakuseiHoshuProcess {

    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(IkenHoshuIchiranReportSource.ReportSourceFields.iryokikanNo.name())));
    private int count = 0;
    private RString 医療機関番号 = RString.EMPTY;

    @BatchWriter
    private BatchReportWriter<IkenHoshuIchiranReportSource> batchWriter;
    private ReportSourceWriter<IkenHoshuIchiranReportSource> reportSourceWriter;

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<IkenHoshuIchiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }
    
    @Override
    protected void output(IkenshoHoshuShokaiRelateEntity relateEntity) {
        if (!医療機関番号.equals(relateEntity.get主治医医療機関コード())) {
            count = 1;
        } else {
            count = count + 1;
        }
        医療機関番号 = relateEntity.get主治医医療機関コード();
        IkenHoshuIchiranReport report = new IkenHoshuIchiranReport(
                IkenHoshuIchiranChange.createIkenHoshuIchiranData(relateEntity, paramter),
                IkenHoshuIchiranChange.createGokeiDate(relateEntity, count, reportSourceWriter.pageCount().value()));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        帳票出力条件リストの出力();
    }

    private void 帳票出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 作成依頼日From = new RStringBuilder("【作成依頼日（From）】");
        作成依頼日From.append(dateFormat(paramter.get作成依頼日期間開始()));
        RStringBuilder 作成依頼日To = new RStringBuilder("【作成依頼日（To）】");
        作成依頼日To.append(dateFormat(paramter.get作成依頼日期間終了()));
        出力条件.add(作成依頼日From.toRString());
        出力条件.add(作成依頼日To.toRString());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                REPORT_ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                REPORT_NAME,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        OutputJokenhyoFactory.createInstance(item).print();
    }
    
}

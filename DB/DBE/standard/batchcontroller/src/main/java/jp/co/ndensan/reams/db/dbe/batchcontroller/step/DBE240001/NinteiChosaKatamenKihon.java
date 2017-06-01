/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReport;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 認定調査票_OCR片面の帳票出力処理クラスです。
 */
public class NinteiChosaKatamenKihon extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書tmp");
    private ReportId 帳票;
    private NinteiChosaProcessParamter processParamter;
    private NinteiChosaBusiness business;
    @BatchWriter
    private BatchReportWriter<ChosahyoKihonchosaKatamenReportSource> batchReportWriter;
    private ReportSourceWriter<ChosahyoKihonchosaKatamenReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        business = new NinteiChosaBusiness(processParamter);
        帳票 = new ReportId(DbBusinessConfig.get(
                ConfigNameDBE.認定調査票_概況基本_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, processParamter.getShichosonCode()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaMybitisParamter());
    }

    @Override
    protected void createWriter() {
        if (ReportIdDBZ.DBE221012.getReportId().equals(帳票)) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票.value())
                    .addBreak(new BreakerCatalog<ChosahyoKihonchosaKatamenReportSource>().new SimpleLayoutBreaker(

                        new RString("layoutIndex")) {
            @Override
                        public ReportLineRecord<ChosahyoKihonchosaKatamenReportSource> occuredBreak(
                                ReportLineRecord<ChosahyoKihonchosaKatamenReportSource> currentRecord,
                                ReportLineRecord<ChosahyoKihonchosaKatamenReportSource> nextRecord, ReportDynamicChart dynamicChart) {
                                    int layout = currentRecord.getSource().layoutIndex;
                                    currentRecord.setFormGroupIndex(layout);
                                    if (nextRecord != null && nextRecord.getSource() != null) {
                                        layout = nextRecord.getSource().layoutIndex;
                                        nextRecord.setFormGroupIndex(layout);
                                    }
                                    return currentRecord;
                                }
                    }).setStartFormGroup(2).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票.value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        ChosahyoKihonchosaKatamenReport report;
        if (ReportIdDBZ.DBE221012.getReportId().equals(帳票)) {
            report = ChosahyoKihonchosaKatamenReport.createFrom(business.setChosahyoKihonchosaKatamenItem(entity), 2);
        } else {
            report = ChosahyoKihonchosaKatamenReport.createFrom(business.setChosahyoKihonchosaKatamenItem(entity));
        }
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("要介護認定調査票（基本調査）"),
                new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();

    }
}

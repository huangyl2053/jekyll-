/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.NinteiChosaBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.NinteiChosaProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ChosahyoSaiCheckhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoRyoumenReport;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintParameter;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 認定調査差異チェック表_両面左の帳票出力処理クラスです。
 */
public class NinteiChosaSaiCheckhyoRyomenLeft extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書tmp");
    private static final ReportIdDBZ 帳票 = ReportIdDBZ.DBE292003;
    private NinteiChosaProcessParamter processParamter;
    private NinteiChosaBusiness business;
    @BatchWriter
    private BatchReportWriter<SaiChekkuhyoReportSource> batchReportWriter;
    private ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        business = new NinteiChosaBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票.getReportId().value())
                .addBreak(new BreakerCatalog<SaiChekkuhyoReportSource>().new SimpleLayoutBreaker(
                    SaiChekkuhyoReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<SaiChekkuhyoReportSource> occuredBreak(ReportLineRecord<SaiChekkuhyoReportSource> currentRecord,
                            ReportLineRecord<SaiChekkuhyoReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                        int layout = currentRecord.getSource().layout.index();
                        currentRecord.setFormGroupIndex(layout);
                        if (nextRecord != null && nextRecord.getSource() != null) {
                            layout = nextRecord.getSource().layout.index();
                            nextRecord.setFormGroupIndex(layout);
                        }
                        return currentRecord;
                    }
                }).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        ChosaIraishoAndChosahyoAndIkenshoPrintParameter parameter
                = ChosaIraishoAndChosahyoAndIkenshoPrintParameter.createParameter(entity.get申請書管理番号());
        List<ChosaIraishoAndChosahyoAndIkenshoPrintBusiness> businessList = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance()
                .get認定調査票差異チェック票(parameter).records();
        ChosahyoSaiCheckhyoRelateEntity checkEntity = business.set認定調査票差異チェック票List(entity, businessList);
        SaiChekkuhyoRyoumenReport report = SaiChekkuhyoRyoumenReport.createFrom(business.setDBE292001Item(checkEntity, businessList.get(0).get厚労省IF識別コード()));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票.getReportId().value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票.getReportName(),
                new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();

    }
}

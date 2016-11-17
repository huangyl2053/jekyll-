/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.HomonChosaIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyotokki.GaikyotokkiA4Report;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「DBE221051_要介護認定調査票（概況特記）」の処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class GaikyochosaProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBZ.DBE221051.getReportId();
    private HomonChosaIraishoProcessParamter processParamter;
    private HomonChosaIraishoBusiness business;

    @BatchWriter
    private BatchReportWriter<GaikyotokkiA4ReportSource> batchReportWriter;
    private ReportSourceWriter<GaikyotokkiA4ReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        business = new HomonChosaIraishoBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        GaikyotokkiA4Report report = new GaikyotokkiA4Report(new HomonChosaIraishoBusiness(processParamter).setReportEntity(entity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBZ.DBE221051.getReportName(),
                new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

}

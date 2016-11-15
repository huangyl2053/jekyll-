/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.HomonChosaIraishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ChosahyoSaiCheckhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票「前回認定調査結果との比較表」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class ChosahyoSaiCheckhyoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get認定調査結果");
    private static final ReportId 帳票ID = ReportIdDBE.DBE293001.getReportId();
    private HomonChosaIraishoBusiness business;
    private List<ChosahyoSaiCheckhyoRelateEntity> checkEntityList;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private HomonChosaIraishoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<ChosahyoSaiCheckhyoReportSource> batchReportWriter;
    private ReportSourceWriter<ChosahyoSaiCheckhyoReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        business = new HomonChosaIraishoBusiness(processParamter);
        checkEntityList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        dbT5201EntityWriter = new BatchPermanentTableWriter(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        business.setcheckEntityList(entity);
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = iHomonChosaIraishoMapper.get認定調査依頼情報(entity);
        if (dbT5201Entity != null) {
            dbT5201EntityWriter.update(business.update認定調査依頼情報(entity, dbT5201Entity));
        }
    }

    @Override
    protected void afterExecute() {
        for (ChosahyoSaiCheckhyoRelateEntity checkEntity : checkEntityList) {
            ChosahyoSaiCheckhyoReport report = ChosahyoSaiCheckhyoReport.createFrom(business.setItem(checkEntity));
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBE.DBE293001.getReportName(),
                new RString(String.valueOf(reportSourceWriter.pageCount().value())),
                new RString("無し"),
                new RString("－"),
                business.set出力条件());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}

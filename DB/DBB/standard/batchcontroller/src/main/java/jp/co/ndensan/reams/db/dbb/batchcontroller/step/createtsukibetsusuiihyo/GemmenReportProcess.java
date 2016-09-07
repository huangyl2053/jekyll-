/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.createtsukibetsusuiihyo.ReportDateHensyu;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tsukibetsusuiihyo.TsukibetsuSuiihyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HokenryoDankaiSettings;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 月別推移表作成帳票用Processクラスです。
 *
 * @reamsid_L DBB-0760-030 lishengli
 */
public class GemmenReportProcess extends BatchProcessBase<GemmenJyoho> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get減免帳票データの取得");
    private static final ReportId 帳票ID = ReportIdDBB.DBB300002.getReportId();
    private List<GemmenJyoho> gemmenJyohoList;
    private List<RString> 表記List;
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    @BatchWriter
    private BatchReportWriter<TsukibetsuSuiihyoReportSource> batchReportWriter;
    private ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        HokenryoDankaiSettings hokenryoDankaiSettings = new HokenryoDankaiSettings();
        HokenryoDankaiList hokenryoDankaiList = hokenryoDankaiSettings.get保険料段階ListIn(processPrm.getChoteiNendo());
        表記List = hokenryoDankaiList.to表記List();
        gemmenJyohoList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(GemmenJyoho item) {
        gemmenJyohoList.add(item);
    }

    @Override
    protected void afterExecute() {
        TsukibetsuSuiihyoReport report2 = new TsukibetsuSuiihyoReport(getTsukibetsuSuiihyoEntity(gemmenJyohoList));
        report2.writeBy(reportSourceWriter);
    }

    private TsukibetsuSuiihyoEntity getTsukibetsuSuiihyoEntity(List<GemmenJyoho> list) {
        ReportDateHensyu reportDateHensyu = new ReportDateHensyu();
        return reportDateHensyu.getGemmen_TsukibetsuSuiihyoEntity(list,
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getEra(),
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().substring(2),
                new RString("減免"),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue(), 表記List);
    }
}

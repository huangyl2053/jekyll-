/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.createtsukibetsusuiihyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.createtsukibetsusuiihyo.ReportDateHensyu;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoBodyItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoBodyTitleItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoHeaderItem;
import jp.co.ndensan.reams.db.dbb.business.report.tsukibetsusuiihyo.TsukibetsuSuiihyoReport;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.createtsukibetsusuiihyo.CreateTsukibetsuSuiihyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.GemmenJyoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.createtsukibetsusuiihyo.ReportDate;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tsukibetsusuiihyo.TsukibetsuSuiihyoReportSource;
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

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.createtsukibetsusuiihyo.ICreateTsukibetsuSuiihyoMapper.get減免帳票データの取得");
    private static final ReportId 帳票ID = ReportIdDBB.DBB300002.getReportId();
    private List<GemmenJyoho> gemmenJyohoList;
    private CreateTsukibetsuSuiihyoProcessParameter processPrm;
    private CreateTsukibetsuSuiihyoMyBatisParameter mybatisPrm;
    @BatchWriter
    private BatchReportWriter<TsukibetsuSuiihyoReportSource> batchReportWriter;
    private ReportSourceWriter<TsukibetsuSuiihyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mybatisPrm = processPrm.toCreateTsukibetsuSuiihyoMyBatisParameter();
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
        List<ReportDate> reportDateList = getReportGemmenDate(gemmenJyohoList);

        TsukibetsuSuiihyoReport report2 = TsukibetsuSuiihyoReport.createFrom(setHeadItem(new RString("減免")),
                setBodyTitleItem(reportDateList), setbodyItemList(reportDateList));
        report2.writeBy(reportSourceWriter);
    }

    private List<ReportDate> getReportGemmenDate(List<GemmenJyoho> list) {
        ReportDateHensyu reportDateHensyu = new ReportDateHensyu();
        return reportDateHensyu.getReportGemmenDateList(list);
    }

    private TsukibetsuSuiihyoHeaderItem setHeadItem(RString choshuHouhouTitle) {
        return new TsukibetsuSuiihyoHeaderItem(
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).getEra(),
                mybatisPrm.getChoteiNendo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).toDateString().substring(2),
                AssociationFinderFactory.createInstance().getAssociation().getLasdecCode_().getColumnValue(),
                AssociationFinderFactory.createInstance().getAssociation().get市町村名(),
                choshuHouhouTitle);
    }

    private List<TsukibetsuSuiihyoBodyTitleItem> setBodyTitleItem(List<ReportDate> reportDateList) {
        List<TsukibetsuSuiihyoBodyTitleItem> list = new ArrayList<>();
        for (ReportDate reportDate : reportDateList) {
            TsukibetsuSuiihyoBodyTitleItem bodyTitleItem = new TsukibetsuSuiihyoBodyTitleItem(reportDate.getListTitle_1());
            list.add(bodyTitleItem);
        }
        return list;
    }

    private List<TsukibetsuSuiihyoBodyItem> setbodyItemList(List<ReportDate> reportDateList) {
        List<TsukibetsuSuiihyoBodyItem> list = new ArrayList<>();
        for (ReportDate reportDate : reportDateList) {
            TsukibetsuSuiihyoBodyItem bodyItem = new TsukibetsuSuiihyoBodyItem(reportDate.getList_1(),
                    reportDate.getList_2(), reportDate.getList_3(), reportDate.getList_4(), reportDate.getList_5(), reportDate.getList_6(),
                    reportDate.getList_7(), reportDate.getList_8(), reportDate.getList_9(), reportDate.getList_10(), reportDate.getList_11(),
                    reportDate.getList_12(), reportDate.getList_13(), reportDate.getList_14(), reportDate.getList_15(), reportDate.getList_16());
            list.add(bodyItem);
        }
        return list;
    }
}

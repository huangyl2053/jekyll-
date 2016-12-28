/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE514001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 介護認定審査会スケジュール表_バッチフ処理クラスです
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class KaigoNinteiShinsakaiScheduleProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedule."
            + "IKaigoNinteiShinsakaiScheduleMapper.get出力明細一覧");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE514001.getReportId();
    private KaigoNinteiShinsakaiScheduleBusiness business;
    private KaigoNinteiShinsakaiScheduleProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ShinsakaisukejuruhyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaisukejuruhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        business = new KaigoNinteiShinsakaiScheduleBusiness(processParamter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toKaigoNinteiShinsakaiScheduleMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(KaigoNinteiShinsakaiScheduleRelateEntity entity) {
        ShinsakaisukejuruhyoReport report
                = ShinsakaisukejuruhyoReport.createFrom(business.setHeaderItem(), business.setBodyItem(entity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        RString 帳票ID = REPORT_ID.value();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        RString 帳票名 = ReportIdDBE.DBE514001.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("-");
        List<RString> 出力条件 = create出力条件();
        OutputJokenhyoFactory.createInstance(
                new ReportOutputJokenhyoItem(帳票ID, 導入団体コード, 市町村名, ジョブ番号, 帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件))
                .print();
    }

    private List<RString> create出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append("【介護認定審査会開催予定期間】");
        builder.append(ConvertDate(processParamter.getShinsakaiKaisaiKikanFrom()))
                .append(" ～ ").append(ConvertDate(processParamter.getShinsakaiKaisaiKikanTo()));
        出力条件.add(builder.toRString());
        return 出力条件;
    }

    private RString ConvertDate(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (!FlexibleDate.canConvert(date)) {
            return date;
        }
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.NONE).toDateString();
    }
}

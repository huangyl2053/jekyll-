/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.kaigoninteishinsakaischedule;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.KaigoNinteiShinsakaiScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kaigoninteishinsakaischedule.MonthRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.UnyoKeitaiKubun.広域連合;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護認定審査会スケジュール表_年間の処理クラスです
 *
 * @reamsid_L DBE-0130-090 duanzhanli
 */
public class NenkanReportProcess extends BatchProcessBase<KaigoNinteiShinsakaiScheduleRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kaigoninteishinsakaischedule."
            + "IKaigoNinteiShinsakaiScheduleMapper.get年間");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE514001.getReportId();
    private static final RString 文字列0 = new RString("0");

    private int count = 1;
    private List<ShinsakaisukejuruhyoBodyItem> bodyItemList;
    private KaigoNinteiShinsakaiScheduleProcessParamter processParamter;
    @BatchWriter
    private BatchReportWriter<ShinsakaisukejuruhyoReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaisukejuruhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        bodyItemList = new ArrayList<>();
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
        bodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        MonthRelateEntity monthEntity = new MonthRelateEntity();
        monthEntity.setJanuary(get曜日(Month.JANUARY.getValue()));
        monthEntity.setFebruary(get曜日(Month.FEBRUARY.getValue()));
        monthEntity.setMarch(get曜日(Month.MARCH.getValue()));
        monthEntity.setApril(get曜日(Month.APRIL.getValue()));
        monthEntity.setMay(get曜日(Month.MAY.getValue()));
        monthEntity.setJune(get曜日(Month.JUNE.getValue()));
        monthEntity.setJuly(get曜日(Month.JULY.getValue()));
        monthEntity.setAugust(get曜日(Month.AUGUST.getValue()));
        monthEntity.setSeptember(get曜日(Month.SEPTEMBER.getValue()));
        monthEntity.setOctober(get曜日(Month.OCTOBER.getValue()));
        monthEntity.setNovember(get曜日(Month.NOVEMBER.getValue()));
        monthEntity.setDecember(get曜日(Month.DECEMBER.getValue()));
        if (bodyItemList != null && !bodyItemList.isEmpty()) {
            ShinsakaisukejuruhyoHeadItem headItem = new ShinsakaisukejuruhyoHeadItem();
            headItem.set年度(RDate.getNowDate().wareki().eraType(EraType.KANJI).getYear());
            headItem.set広域連合(BusinessConfig.get(広域連合, SubGyomuCode.DBE認定支援));
            ShinsakaisukejuruhyoReport report = ShinsakaisukejuruhyoReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
        }
    }

    private List<RString> get曜日(int 月) {
        List<RString> 曜日 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(processParamter.getNendo());
        builder.append((new RString(String.valueOf(月))).padLeft(文字列0, 2));
        int lastDay = (new FlexibleYearMonth(builder.toString())).getLastDay();
        for (int i = 1; i <= lastDay; i++) {
            RStringBuilder dateBuilder = new RStringBuilder();
            dateBuilder.append(builder);
            dateBuilder.append((new RString(String.valueOf(i))).padLeft(文字列0, 2));
            FlexibleDate flexibleDate = new FlexibleDate(dateBuilder.toRString());
            曜日.add(new RString(flexibleDate.getDayOfWeek().getShortTerm().toString()));
        }
        return 曜日;
    }

    private ShinsakaisukejuruhyoBodyItem setBodyItem(KaigoNinteiShinsakaiScheduleRelateEntity entity) {
        ShinsakaisukejuruhyoBodyItem bodyItem = new ShinsakaisukejuruhyoBodyItem();
        bodyItem.set項番(count++);
        bodyItem.set審査会番号(entity.getShinsakai());
        bodyItem.set開催日(entity.getKaisaiYMD());
        bodyItem.set開催時間(entity.getTime());
        bodyItem.set合議体(entity.getGogitai());
        bodyItem.set会場(entity.getKaijyo());
        bodyItem.set住所(entity.getKaijyoJusho());
        bodyItem.set電話番号(entity.getKaijyoTelNo());
        return bodyItem;
    }
}

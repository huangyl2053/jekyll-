/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosairaiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 認定調査依頼一覧表PrinterServiceクラスです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
public class ChosaIraiIchiranhyoPrintService {

    /**
     * 認定調査依頼一覧表を印刷します。
     *
     * @param bodyItems 認定調査依頼一覧表ボディのITEM
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosaIraiIchiranhyoBodyItem> bodyItems) {
        ChosaIraiIchiranhyoProperty property = new ChosaIraiIchiranhyoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ChosaIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                List<ChosaIraiIchiranhyoBodyItem> itemList = new ArrayList<>();
                for (ChosaIraiIchiranhyoBodyItem bodyItem : bodyItems) {
                    bodyItem = new ChosaIraiIchiranhyoBodyItem(
                            ninshoshaSourceBuilder.buildSource().hakkoYMD,
                            ninshoshaSourceBuilder.buildSource().denshiKoin,
                            ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei,
                            ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei2,
                            ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei1,
                            ninshoshaSourceBuilder.buildSource().ninshoshaShimeiKakenai,
                            ninshoshaSourceBuilder.buildSource().ninshoshaShimeiKakeru,
                            ninshoshaSourceBuilder.buildSource().koinMojiretsu,
                            ninshoshaSourceBuilder.buildSource().koinShoryaku,
                            bodyItem.getYubinNo1(),
                            bodyItem.getJushoText(),
                            bodyItem.getKikanNameText(),
                            bodyItem.getShimeiText(),
                            bodyItem.getMeishoFuyo(),
                            bodyItem.getJigyoshaNo(),
                            bodyItem.getTsuchibun1(),
                            bodyItem.getTsuchibun2(),
                            bodyItem.getListIchiranhyo_1(),
                            bodyItem.getListIchiranhyo_2(),
                            bodyItem.getListIchiranhyo_3(),
                            bodyItem.getListIchiranhyo_4(),
                            bodyItem.getListIchiranhyo_5(),
                            bodyItem.getListIchiranhyo_6(),
                            bodyItem.getListIchiranhyo_7(),
                            bodyItem.getListIchiranhyo_8(),
                            bodyItem.getListIchiranhyo_9(),
                            bodyItem.getListIchiranhyo_10(),
                            bodyItem.getListIchiranhyo_11(),
                            bodyItem.getListIchiranhyo_12());
                    itemList.add(bodyItem);
                }
                for (ChosaIraiIchiranhyoReport report : toReports(new ChosaIraiIchiranhyoReportJoho(itemList))) {
                    ReportSourceWriter<ChosaIraiIchiranhyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ChosaIraiIchiranhyoReport> toReports(ChosaIraiIchiranhyoReportJoho reportJoho) {
        List<ChosaIraiIchiranhyoReport> list = new ArrayList<>();
        list.add(ChosaIraiIchiranhyoReport.createFrom(
                reportJoho.getBodyItemList()));
        return list;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}

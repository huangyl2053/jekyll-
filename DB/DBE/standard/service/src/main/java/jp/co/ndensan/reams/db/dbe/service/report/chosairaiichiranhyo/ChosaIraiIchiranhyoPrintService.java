/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosairaiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
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
 *
 * 認定調査依頼一覧表PrinterServiceです。
 */
public class ChosaIraiIchiranhyoPrintService {

    /**
     * 認定調査依頼一覧表を印刷します。
     *
     * @param headItem 認定調査依頼一覧表ヘッダのITEM
     * @param bodyItems 認定調査依頼一覧表ボディのITEM
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosaIraiIchiranhyoHeadItem headItem, List<ChosaIraiIchiranhyoBodyItem> bodyItems) {
        ChosaIraiIchiranhyoProperty property = new ChosaIraiIchiranhyoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ChosaIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                headItem = new ChosaIraiIchiranhyoHeadItem(
                        headItem.getPrintTimeStamp(),
                        headItem.getShomeiHakkoYMD(),
                        headItem.getYubinNo(),
                        headItem.getShuchoMei(),
                        headItem.getJigyoshaJusho(),
                        ninshoshaSourceBuilder.buildSource().denshiKoin,
                        ninshoshaSourceBuilder.buildSource().koinShoryaku,
                        headItem.getJigyoshaName(),
                        headItem.getJigyoshaNo(),
                        headItem.getTsuchibun());
                for (ChosaIraiIchiranhyoReport report : toReports(new ChosaIraiIchiranhyoReportJoho(headItem, bodyItems))) {
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
                reportJoho.getHeadItem(),
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.chosairaisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
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
 * 要介護認定調査依頼書PrinterServiceクラスです。
 */
public class ChosaIraishoPrintService {

    /**
     * 要介護認定調査依頼書を印刷します。
     *
     * @param headItem 要介護認定調査依頼書ヘッダのITEMです。
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(ChosaIraishoHeadItem headItem) {
        ChosaIraishoProperty property = new ChosaIraishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ChosaIraishoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());

                headItem = new ChosaIraishoHeadItem(
                        headItem.getShomeiHakkoYMD(),
                        ninshoshaSourceBuilder.buildSource().denshiKoin,
                        headItem.getShichosonMei(),
                        headItem.getShuchoMei(),
                        ninshoshaSourceBuilder.buildSource().koinShoryaku,
                        headItem.getBunshoNo(),
                        ninshoshaSourceBuilder.buildSource().hakkoYMD,
                        headItem.getHihokenshaNo1(),
                        headItem.getHihokenshaNo2(),
                        headItem.getHihokenshaNo3(),
                        headItem.getHihokenshaNo4(),
                        headItem.getHihokenshaNo5(),
                        headItem.getHihokenshaNo6(),
                        headItem.getHihokenshaNo7(),
                        headItem.getHihokenshaNo8(),
                        headItem.getHihokenshaNo9(),
                        headItem.getHihokenshaNo10(),
                        headItem.getHihokenshaNameKana(),
                        headItem.getBirthGengoMeiji(),
                        headItem.getBirthGengoTaisho(),
                        headItem.getBirthGengoShowa(),
                        headItem.getBirthYMD(),
                        headItem.getHihokenshaName(),
                        headItem.getSeibetsuMan(),
                        headItem.getSeibetsuWoman(),
                        headItem.getYubinNo(),
                        headItem.getJusho(),
                        headItem.getTelNo(),
                        headItem.getHomonChosasakiYubinNo(),
                        headItem.getHomonChosasakiJusho1(),
                        headItem.getHomonChosasakiJusho2(),
                        headItem.getHomonChosasakiJusho3(),
                        headItem.getHomonChosasakiTelNo(),
                        headItem.getShinseiYMD(),
                        headItem.getTeishutsuKigen(),
                        headItem.getTsuchibun1(),
                        headItem.getTsuchibun2(),
                        headItem.getTsuchibun3(),
                        headItem.getTsuchibun4(),
                        headItem.getTsuchibun5(),
                        headItem.getTsuchibun6(),
                        headItem.getTsuchibun7(),
                        headItem.getTsuchibun8(),
                        headItem.getTsuchibun9(),
                        headItem.getTsuchibun10(),
                        headItem.getTsuchibun11(),
                        headItem.getTsuchibun12(),
                        headItem.getTsuchibun13(),
                        headItem.getTsuchibun14(),
                        headItem.getTsuchibun15(),
                        headItem.getTsuchibun16(),
                        headItem.getTsuchibun17(),
                        headItem.getTsuchibun18(),
                        headItem.getTsuchibun19(),
                        headItem.getRemban());
                for (ChosaIraishoReport report : toReports(new ChosaIraishoReportJoho(headItem))) {
                    ReportSourceWriter<ChosaIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ChosaIraishoReport> toReports(ChosaIraishoReportJoho reportJoho) {
        List<ChosaIraishoReport> list = new ArrayList<>();
        list.add(ChosaIraishoReport.createFrom(
                reportJoho.getHeadItem()));
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

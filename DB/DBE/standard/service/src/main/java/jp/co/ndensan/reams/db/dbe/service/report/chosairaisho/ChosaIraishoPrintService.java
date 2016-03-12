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
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
     * @param headItemlist 要介護認定調査依頼書ヘッダのITEMリストです。
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ChosaIraishoHeadItem> headItemlist) {
        ChosaIraishoProperty property = new ChosaIraishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ChosaIraishoReportSource> assembler = createAssembler(property, reportManager)) {
                FlexibleDate hakkoYMD = FlexibleDate.getNowDate();
                if (!headItemlist.isEmpty()) {
                    hakkoYMD = new FlexibleDate(headItemlist.get(0).getHakkoYMD1());
                }

                ReportSourceWriter<ChosaIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(),
                        hakkoYMD, reportSourceWriter);
                RString bunshoNo = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220001.getReportId(), hakkoYMD);
                for (ChosaIraishoHeadItem headItem : headItemlist) {
                    headItem = new ChosaIraishoHeadItem(
                            ninshoshaSource.hakkoYMD,
                            ninshoshaSource.denshiKoin,
                            ninshoshaSource.ninshoshaYakushokuMei,
                            ninshoshaSource.ninshoshaYakushokuMei2,
                            ninshoshaSource.ninshoshaYakushokuMei1,
                            ninshoshaSource.koinMojiretsu,
                            ninshoshaSource.ninshoshaShimeiKakeru,
                            ninshoshaSource.ninshoshaShimeiKakenai,
                            ninshoshaSource.koinShoryaku,
                            bunshoNo,
                            headItem.getYubinNo1(),
                            headItem.getJushoText(),
                            headItem.getKikanNameText(),
                            headItem.getShimeiText(),
                            headItem.getMeishoFuyo(),
                            headItem.getCustomerBarCode(),
                            headItem.getSonota(),
                            headItem.getAtenaRenban(),
                            headItem.getTsuchibun1(),
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
                            headItem.getTsuchibun2(),
                            headItem.getRemban());
                    for (ChosaIraishoReport report : toReports(new ChosaIraishoReportJoho(headItem))) {

                        report.writeBy(reportSourceWriter);
                    }
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.dbbrp00007.nonyutsuchishohonsanteibook;

import jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 帳票「帳票設計_DBBRP00007_10_保険料納入通知書（本算定）【ブックタイプ】」のプリントサービスです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class NonyuTsuchishoHonsanteiBookService {

    /**
     * 帳票（「口振依頼あり通知書(DBB100055_NonyuTsuchishoBookFuriKaeAriCover)」と<br>
     * 「納付書(DBB100020_HokenryoNonyuTsuchishoBookNofusho)」）を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource ninshoshaSource
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print全てページDBB100055(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, NinshoshaSource ninshoshaSource,
            ReportManager reportManager) {
        FuriKaeAriCoverToNofushoProperty property = new FuriKaeAriCoverToNofushoProperty();

        FuriKaeAriCoverToNofushoReport report = toReportsFor全てページDBB100055(本算定納入通知書情報, ninshoshaSource);
        ReportAssembler<FuriKaeAriCoverToNofushoReportSource> assembler = createAssembler(property, reportManager);
        ReportSourceWriter<FuriKaeAriCoverToNofushoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        report.writeBy(reportSourceWriter);
    }

    private static FuriKaeAriCoverToNofushoReport toReportsFor全てページDBB100055(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            NinshoshaSource ninshoshaSource) {
        return new FuriKaeAriCoverToNofushoReport(本算定納入通知書情報, ninshoshaSource);
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}

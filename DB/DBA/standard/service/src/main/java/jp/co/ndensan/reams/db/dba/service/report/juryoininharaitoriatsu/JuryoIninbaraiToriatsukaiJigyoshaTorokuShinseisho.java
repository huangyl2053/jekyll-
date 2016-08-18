/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.juryoininharaitoriatsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem;
import jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishProerty;
import jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport;
import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
 * 介護保険受領委任払い取扱事業者登録申請書のPrintクラスです。
 *
 * @reamsid_L DBA-0540-080 dongyabin
 */
public class JuryoIninbaraiToriatsukaiJigyoshaTorokuShinseisho {

    /**
     * 介護保険受領委任払い取扱事業者登録申請書Print処理です。
     *
     * @return 介護保険受領委任払い取扱事業者登録申請書作成_帳票
     */
    public SourceDataCollection createJuryoIninbaraiToriatsukaiJigyoshaTorokuShinseishoChohyo() {
        JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishProerty proerty = new JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource> assembler
                    = createAssembler(proerty, reportManager)) {
                ReportSourceWriter<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                        null, reportSourceWriter.getImageFolderPath());
                for (JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport report
                        : toReports(ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport> toReports(RString ninshoshaYakushokuMei) {
        List<JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport> list = new ArrayList<>();
        RStringBuilder 認証者 = new RStringBuilder();
        if (!RString.isNullOrEmpty(ninshoshaYakushokuMei)) {
            認証者.append(ninshoshaYakushokuMei);
            認証者.append(new RString("長様"));
        }
        JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem item = new JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem(認証者.toRString());
        list.add(JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishReport.createReport(item));
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

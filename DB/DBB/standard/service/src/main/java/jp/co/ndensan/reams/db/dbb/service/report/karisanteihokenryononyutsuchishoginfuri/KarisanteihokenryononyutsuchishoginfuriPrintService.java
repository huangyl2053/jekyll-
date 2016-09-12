/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karisanteihokenryononyutsuchishoginfuri;

import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport;
import jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishoginfuri.KarisanteiHokenryoNonyuTsuchishoGinfuriSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 帳票設計_DBBRP00007_3_保険料納入通知書（仮算定）【銀振タイプ】のプリントサービスです。
 *
 * @reamsid_L DBB-9110-030 wangjie2
 */
public class KarisanteihokenryononyutsuchishoginfuriPrintService {

    private final ReportId 帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");
    private final RString 帳票IDの先頭_DBB100018 = new RString("DBB100018");
    private final RString 帳票IDの先頭_DBB100019 = new RString("DBB100019");

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        RString 帳票IDRString = RString.EMPTY;
        if (仮算定納入通知書情報 != null && 仮算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 仮算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100018)) {
            print全てページDBB100018(仮算定納入通知書情報);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100019)) {
            print全てページDBB100019(仮算定納入通知書情報);
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100018(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiHokenryoNonyuTsuchishoGinfuriProperty property = new KarisanteiHokenryoNonyuTsuchishoGinfuriProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiHokenryoNonyuTsuchishoGinfuriReport report
                        = new KarisanteiHokenryoNonyuTsuchishoGinfuriReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    private SourceDataCollection print全てページDBB100019(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報) {
        KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty property = new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> assembler = createAssembler(property, reportManager)) {
                ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> reportSourceWriter = new ReportSourceWriter(assembler);

                NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
                KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport report
                        = new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport(仮算定納入通知書情報, ninshoshaSource);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
    }

    /**
     * 帳票を出力します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        RString 帳票IDRString = RString.EMPTY;
        if (仮算定納入通知書情報 != null && 仮算定納入通知書情報.get帳票ID() != null) {
            帳票IDRString = 仮算定納入通知書情報.get帳票ID().getColumnValue();
        }
        if (帳票IDRString.startsWith(帳票IDの先頭_DBB100018)) {
            print全てページDBB100018(仮算定納入通知書情報, reportManager);
        } else if (帳票IDRString.startsWith(帳票IDの先頭_DBB100019)) {
            print全てページDBB100019(仮算定納入通知書情報, reportManager);
        }
    }

    private void print全てページDBB100018(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiHokenryoNonyuTsuchishoGinfuriProperty property = new KarisanteiHokenryoNonyuTsuchishoGinfuriProperty();
        try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHokenryoNonyuTsuchishoGinfuriReport report
                    = new KarisanteiHokenryoNonyuTsuchishoGinfuriReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
    }

    private void print全てページDBB100019(KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報, ReportManager reportManager) {
        KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty property = new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoProperty();
        try (ReportAssembler<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID, 仮算定納入通知書情報.get発行日(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport report
                    = new KarisanteiHokenryoNonyuTsuchishoGinfuriRenchoReport(仮算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
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

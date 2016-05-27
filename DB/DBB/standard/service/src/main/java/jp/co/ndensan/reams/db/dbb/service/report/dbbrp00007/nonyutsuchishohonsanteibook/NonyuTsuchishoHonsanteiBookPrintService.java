/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.dbbrp00007.nonyutsuchishohonsanteibook;

import jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishobookfurikaeari.NonyuTsuchishoBookFuriKaeAriProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishobookfurikaeari.NonyuTsuchishoBookFuriKaeAriReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.HenshuHaniKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
 * 帳票「帳票設計_DBBRP00007_10_保険料納入通知書（本算定）【ブックタイプ】」のプリントサービスです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class NonyuTsuchishoHonsanteiBookPrintService {

    private static final ReportId 帳票分類ID = new ReportId("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString REPORT_DBB100055 = new RString("DBB100055");
//    private static final RString REPORT_DBB100056 = new RString("DBB100056");
//    private static final RString REPORT_DBB100057 = new RString("DBB100057");
//    private static final RString REPORT_DBB100058 = new RString("DBB100058");

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {

        RString 帳票ID = 本算定納入通知書情報.get帳票ID().getColumnValue();
        RString 編集範囲区分 = 本算定納入通知書情報.get編集範囲区分().getコード();

        if (編集範囲区分.equals(HenshuHaniKubun.全てのレイアウト.getコード()) && 帳票ID.startsWith(REPORT_DBB100055)) {
//            if (帳票ID.startsWith(REPORT_DBB100055)) {
            return print全てページDBB100055(本算定納入通知書情報);

//            }
//            else if (帳票ID.startsWith(REPORT_DBB100057)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100056)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100058)) {
//
//            }
        }

//        else if (編集範囲区分.equals(HenshuHaniKubun.Coverのみ.getコード())) {
//            if (帳票ID.startsWith(REPORT_DBB100055)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100057)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100056)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100058)) {
//
//            }
//        } else if (編集範囲区分.equals(HenshuHaniKubun.Detailのみ.getコード())) {
//            if (帳票ID.startsWith(REPORT_DBB100055) || 帳票ID.startsWith(REPORT_DBB100056)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100057) || 帳票ID.startsWith(REPORT_DBB100058)) {
//
//            }
//        }
        return null;
    }

    /**
     * 帳票を出力します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param reportManager 帳票発行処理の制御機能
     * @return SourceDataCollection SourceDataCollection
     */
    public SourceDataCollection print(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {

        RString 帳票ID = 本算定納入通知書情報.get帳票ID().getColumnValue();
        RString 編集範囲区分 = 本算定納入通知書情報.get編集範囲区分().getコード();

        if (編集範囲区分.equals(HenshuHaniKubun.全てのレイアウト.getコード()) && 帳票ID.startsWith(REPORT_DBB100055)) {
//            if (帳票ID.startsWith(REPORT_DBB100055)) {
            return print全てページDBB100055(本算定納入通知書情報, reportManager);

//            }
//            else if (帳票ID.startsWith(REPORT_DBB100057)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100056)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100058)) {
//
//            }
//        } else if (編集範囲区分.equals(HenshuHaniKubun.Coverのみ.getコード())) {
//            if (帳票ID.startsWith(REPORT_DBB100055)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100057)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100056)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100058)) {
//
//            }
//        } else if (編集範囲区分.equals(HenshuHaniKubun.Detailのみ.getコード())) {
//            if (帳票ID.startsWith(REPORT_DBB100055) || 帳票ID.startsWith(REPORT_DBB100056)) {
//
//            } else if (帳票ID.startsWith(REPORT_DBB100057) || 帳票ID.startsWith(REPORT_DBB100058)) {
//
//            }
        }
        return null;
    }

    private SourceDataCollection print全てページDBB100055(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print全てページDBB100055(本算定納入通知書情報, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    private SourceDataCollection print全てページDBB100055(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報, ReportManager reportManager) {

        NonyuTsuchishoBookFuriKaeAriProperty property = new NonyuTsuchishoBookFuriKaeAriProperty();
        try (ReportAssembler<FuriKaeAriCoverToNofushoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<FuriKaeAriCoverToNofushoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);

            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID,
                    new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
            NonyuTsuchishoBookFuriKaeAriReport report = new NonyuTsuchishoBookFuriKaeAriReport(本算定納入通知書情報, ninshoshaSource);
            report.writeBy(reportSourceWriter);
        }
        return reportManager.publish();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
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
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 PrintServiceクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranPrintService {

    /**
     * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）(単一帳票出力用)
     *
     * @param 発行対象者 KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者,
            RString 市町村番号,
            RString 市町村名,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(発行対象者, 市町村番号, 市町村名, 出力順リスト, 改頁リスト, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）(複数帳票出力用)。
     *
     * @param 発行対象者 KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity
     * @param 市町村番号 RString
     * @param 市町村名 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param reportManager ReportManager
     */
    public void print(
            KijunShunyugakuTekiyoShinseishoHakkoIchiranEntity 発行対象者,
            RString 市町村番号,
            RString 市町村名,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            ReportManager reportManager) {
        KijunShunyugakuTekiyoShinseishoHakkoIchiranProperty property = new KijunShunyugakuTekiyoShinseishoHakkoIchiranProperty();

        try (ReportAssembler<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KijunShunyugakuTekiyoShinseishoHakkoIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);

            new KijunShunyugakuTekiyoShinseishoHakkoIchiranReport(発行対象者, 市町村番号, 市町村名, 出力順リスト, 改頁リスト).writeBy(reportSourceWriter);
        }
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

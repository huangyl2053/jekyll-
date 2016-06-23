/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyodoshorijukyushateiseirenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushateiseirenrakuhyo.KyodoShoriJukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 帳票設計_DBCMN81004_共同処理用受給者訂正連絡票（紙媒体）PrintServiceのインターフェースクラスです。
 *
 * @reamsid_L DBC-1951-060 chenaoqi
 */
public class KyodoShoriJukyushaTeiseiRenrakuhyoPrintService {

    /**
     * 共同処理用受給者訂正連絡票（紙媒体）(単一帳票出力用)
     *
     * @param targets KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity targets) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            if (targets != null) {
                print(targets, reportManager);
            }
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printメソッドします。
     *
     * @param targets KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity
     * @param reportManager ReportManager
     */
    public void print(KyodoShoriJukyushaTeiseiRenrakuhyoResultEntity targets, ReportManager reportManager) {
        KyodoShoriJukyushaTeiseiRenrakuhyoProperty property = new KyodoShoriJukyushaTeiseiRenrakuhyoProperty();
        try (ReportAssembler<KyodoShoriJukyushaTeiseiRenrakuhyoSource> assembler = createAssembler(property, reportManager)) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            SearchResult<KoikiZenShichosonJoho> 市町村情報 = finder.koseiShichosonJoho();
            List<KoikiZenShichosonJoho> 市町村情報List = new ArrayList<>();
            if (市町村情報 != null) {
                市町村情報List = 市町村情報.records();
            }
            ReportSourceWriter<KyodoShoriJukyushaTeiseiRenrakuhyoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new KyodoShoriJukyushaTeiseiRenrakuhyoReport(targets, 市町村情報List).writeBy(reportSourceWriter);
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

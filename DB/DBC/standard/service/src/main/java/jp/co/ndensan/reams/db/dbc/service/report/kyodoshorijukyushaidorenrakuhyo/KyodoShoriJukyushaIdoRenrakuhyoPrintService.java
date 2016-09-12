/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyodoshorijukyushaidorenrakuhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodoshoriyojukyushaidorenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kyodoshoriyojukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyodoshoriyojukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kyodoshorijukyushaidorenrakuhyo.KyodoShoriJukyushaIdoRenrakuhyoSource;
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
 * 帳票設計_DBCMN81003_共同処理用受給者異動連絡票（紙媒体）PrintServiceのインターフェースクラスです。
 *
 * @reamsid_L DBC-1950-050 chenaoqi
 */
public class KyodoShoriJukyushaIdoRenrakuhyoPrintService {

    /**
     * 共同処理用受給者異動連絡票（紙媒体）(単一帳票出力用)
     *
     * @param targets KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity targets) {
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
     * @param targets KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity
     * @param reportManager ReportManager
     */
    public void print(KyodoshoriyoJukyushaIdoRenrakuhyoResultEntity targets, ReportManager reportManager) {
        KyodoShoriJukyushaIdoRenrakuhyoProperty property = new KyodoShoriJukyushaIdoRenrakuhyoProperty();
        try (ReportAssembler<KyodoShoriJukyushaIdoRenrakuhyoSource> assembler = createAssembler(property, reportManager)) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            SearchResult<KoikiZenShichosonJoho> 市町村情報 = finder.koseiShichosonJoho();
            List<KoikiZenShichosonJoho> 市町村情報List = new ArrayList<>();
            if (市町村情報 != null) {
                市町村情報List = 市町村情報.records();
            }
            ReportSourceWriter<KyodoShoriJukyushaIdoRenrakuhyoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new KyodoShoriJukyushaIdoRenrakuhyoReport(targets, 市町村情報List).writeBy(reportSourceWriter);
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

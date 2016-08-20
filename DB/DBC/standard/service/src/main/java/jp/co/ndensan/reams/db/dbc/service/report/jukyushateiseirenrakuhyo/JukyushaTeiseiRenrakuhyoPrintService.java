/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jukyushateiseirenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.jukyushateiseirenrakuhyo.JukyushaTeiseiRenrakuhyoSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
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
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）PrintServiceクラスです。
 *
 * @reamsid_L DBC-2101-060 lijian
 */
public class JukyushaTeiseiRenrakuhyoPrintService {

    /**
     * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）(単一帳票出力用)
     *
     * @param 出力用受給者訂正情報Entity JukyushaIdoRenrakuhyoTorokuEntity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(出力用受給者訂正情報Entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBCMN81002_受給者訂正連絡票（紙媒体）(複数帳票出力用)。
     *
     * @param 出力用受給者訂正情報Entity JukyushaIdoRenrakuhyoTorokuEntity
     * @param reportManager ReportManager
     */
    public void print(
            JukyushaIdoRenrakuhyoTorokuEntity 出力用受給者訂正情報Entity,
            ReportManager reportManager) {
        JukyushaTeiseiRenrakuhyoProperty property = new JukyushaTeiseiRenrakuhyoProperty();

        try (ReportAssembler<JukyushaTeiseiRenrakuhyoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JukyushaTeiseiRenrakuhyoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();

            SearchResult<KoikiZenShichosonJoho> list = finder.koseiShichosonJoho();
            RString 市町村名称 = RString.EMPTY;
            if (list != null && !list.records().isEmpty()) {
                市町村名称 = list.records().get(0).get市町村名称();

            }
            new JukyushaTeiseiRenrakuhyoReport(出力用受給者訂正情報Entity, 市町村名称).writeBy(reportSourceWriter);
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

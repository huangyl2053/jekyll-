/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.jukyushaidorenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyotoroku.JukyushaIdoRenrakuhyoTorokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jukyushaidorenrakuhyo.JukyushaIdoRenrakuhyoSource;
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
 * 帳票設計_DBCMN81001_受給者異動連絡票（紙媒体) PrintSevice
 *
 * @reamsid_L DBC-2100-040 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoPrintSevice {

    /**
     * サービス提供票別表(単一帳票出力用)
     *
     * @param entity entity
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(JukyushaIdoRenrakuhyoTorokuEntity entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            SearchResult<KoikiZenShichosonJoho> list = finder.koseiShichosonJoho();
            RString 市町村名称 = list.records().get(0).get市町村名称();
            print(reportManager, entity, 市町村名称);
            collection = reportManager.publish();
        }
        return collection;
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

    private void print(ReportManager reportManager, JukyushaIdoRenrakuhyoTorokuEntity entity, RString 市町村名称) {
        JukyushaIdoRenrakuhyoProperty property = new JukyushaIdoRenrakuhyoProperty();
        try (ReportAssembler<JukyushaIdoRenrakuhyoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JukyushaIdoRenrakuhyoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new JukyushaIdoRenrakuhyoReport(entity, 市町村名称).writeBy(reportSourceWriter);
        }
    }
}

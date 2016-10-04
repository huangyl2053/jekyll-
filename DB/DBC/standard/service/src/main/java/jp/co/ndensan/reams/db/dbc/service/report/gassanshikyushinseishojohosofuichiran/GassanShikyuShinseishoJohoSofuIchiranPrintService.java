/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.gassanshikyushinseishojohosofuichiran;

import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060.KogakugassanShikyushinseishoOutFileEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanshikyushinseishojohosofuichiran.GassanShikyuShinseishoJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表 のPrintServiceクラスです。
 *
 * @reamsId_L DBC-2630-040 zhengshenlei
 */
public class GassanShikyuShinseishoJohoSofuIchiranPrintService {

    /**
     * 帳票設計_DBC200027_高額合算支給申請書情報送付一覧表(単一帳票出力用)
     *
     * @param 送付一覧表データ KogakugassanShikyushinseishoOutFileEntity
     * @param システム日時 YMDHMS
     * @param 処理年月 FlexibleYearMonth
     * @param 連番 int
     * @param flag boolean
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KogakugassanShikyushinseishoOutFileEntity 送付一覧表データ,
            YMDHMS システム日時,
            FlexibleYearMonth 処理年月,
            int 連番,
            boolean flag) {
        if (送付一覧表データ == null) {
            return new SourceDataCollection();
        }
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(送付一覧表データ, システム日時, 処理年月, 連番, flag, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200027_高額合算支給額計算結果連絡票情報取込一覧表(複数帳票出力用)。
     *
     * @param 送付一覧表データ 送付一覧表データ
     * @param システム日時 YMDHMS
     * @param 処理年月 FlexibleYearMonth
     * @param 連番 int
     * @param flag boolean
     * @param reportManager ReportManager
     */
    public void print(
            KogakugassanShikyushinseishoOutFileEntity 送付一覧表データ,
            YMDHMS システム日時,
            FlexibleYearMonth 処理年月,
            int 連番,
            boolean flag,
            ReportManager reportManager) {
        GassanShikyuShinseishoJohoSofuIchiranProperty property = new GassanShikyuShinseishoJohoSofuIchiranProperty();
        try (ReportAssembler<GassanShikyuShinseishoJohoSofuIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<GassanShikyuShinseishoJohoSofuIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new GassanShikyuShinseishoJohoSofuIchiranReport(送付一覧表データ, システム日時, 処理年月, 連番, flag).writeBy(reportSourceWriter);
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

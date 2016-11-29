/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuidojohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran.TokuChoYidoIchiranEntity;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.report.source.tokubetsuchoshuidojohoichiran.TokubetsuChoshuIdojohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表 PrintService クラスです。
 *
 * @reamsid_L DBB-1840-080 liuxiaoyu
 */
public class TokubetsuChoshuIdojohoIchiranPrintService {

    /**
     * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表(単一帳票出力用)
     *
     * @param 特徴異動情報 TokuChoYidoIchiranEntity
     * @param 作成日時 RDateTime
     * @param 賦課年度 FlexibleYear
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     *
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            TokuChoYidoIchiranEntity 特徴異動情報,
            RDateTime 作成日時,
            FlexibleYear 賦課年度,
            RString 保険者番号,
            RString 保険者名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト) {
        if (特徴異動情報 == null) {
            return new SourceDataCollection();
        }
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(特徴異動情報, 作成日時, 賦課年度, 保険者番号, 保険者名称, 出力順リスト, 改頁リスト, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBBPR82001_3_特別徴収異動情報一覧表(複数帳票出力用)。
     *
     * @param 特徴異動情報 TokuChoYidoIchiranEntity
     * @param 作成日時 RDateTime
     * @param 賦課年度 FlexibleYear
     * @param 保険者番号 RString
     * @param 保険者名称 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param reportManager ReportManager
     */
    public void print(
            TokuChoYidoIchiranEntity 特徴異動情報,
            RDateTime 作成日時,
            FlexibleYear 賦課年度,
            RString 保険者番号,
            RString 保険者名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            ReportManager reportManager) {
        TokubetsuChoshuIdojohoIchiranProperty property = new TokubetsuChoshuIdojohoIchiranProperty();
        try (ReportAssembler<TokubetsuChoshuIdojohoIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuIdojohoIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuIdojohoIchiranReport(特徴異動情報, null, 作成日時, 賦課年度, 保険者番号, 保険者名称, 出力順リスト, 改頁リスト).writeBy(reportSourceWriter);
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

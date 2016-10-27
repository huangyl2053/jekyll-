/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufujisekijohosofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyuufujisekikoshinnkekka.KyuufuJisekiKoshinnKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufujisekijohosofuichiran.KyufuJisekiJohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * 帳票設計_DBC200053_給付実績情報送付一覧表　PrintServiceクラスです。
 *
 * @reamsid_L DBC-2460-030 lijian
 */
public class KyufuJisekiJohoSofuIchiranPrintService {

    /**
     * 帳票設計_DBC200053_給付実績情報送付一覧表 (単一帳票出力用)
     *
     * @param 給付実績更新結果一覧表データ KyuufuJisekiKoshinnKekkaEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     * @param 連番 int
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            KyuufuJisekiKoshinnKekkaEntity 給付実績更新結果一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            boolean 合計フラグ,
            Decimal 合計件数,
            int 連番) {

        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(給付実績更新結果一覧表データ, 出力順リスト, 改頁リスト, 処理年月, 作成日時, 合計フラグ, 合計件数, 連番, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200053_給付実績情報送付一覧表 (複数帳票出力用)
     *
     * @param 給付実績更新結果一覧表データ KyuufuJisekiKoshinnKekkaEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     * @param 連番 int
     * @param reportManager ReportManager
     */
    public void print(
            KyuufuJisekiKoshinnKekkaEntity 給付実績更新結果一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            boolean 合計フラグ,
            Decimal 合計件数,
            int 連番,
            ReportManager reportManager) {
        KyufuJisekiJohoSofuIchiranProperty property = new KyufuJisekiJohoSofuIchiranProperty();

        try (ReportAssembler<KyufuJisekiJohoSofuIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KyufuJisekiJohoSofuIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new KyufuJisekiJohoSofuIchiranReport(
                    給付実績更新結果一覧表データ,
                    出力順リスト,
                    改頁リスト, 処理年月,
                    作成日時,
                    合計フラグ,
                    合計件数,
                    連番).writeBy(reportSourceWriter);
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

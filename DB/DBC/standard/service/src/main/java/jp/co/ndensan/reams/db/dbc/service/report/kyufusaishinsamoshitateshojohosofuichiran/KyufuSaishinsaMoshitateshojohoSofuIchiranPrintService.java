/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kyufusaishinsamoshitateshojohosofuichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranReport;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateIchiranhyoTaisyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kyufusaishinsamoshitateshojohosofuichiran.KyufuSaishinsaMoshitateshojohoSofuIchiranSource;
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
 * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 PrintServiceクラスです。
 *
 * @reamsid_L DBC-2540-040 lijian
 */
public class KyufuSaishinsaMoshitateshojohoSofuIchiranPrintService {

    /**
     * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 (単一帳票出力用)
     *
     * @param 送付一覧表データ SaishinsaMoshitateIchiranhyoTaisyoEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番,
            boolean 合計フラグ,
            Decimal 合計件数) {

        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(送付一覧表データ, 出力順リスト, 改頁リスト, 処理年月, 作成日時, 連番, 合計フラグ, 合計件数, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBC200047_給付再審査申立書情報送付一覧表 (単一帳票出力用)
     *
     * @param 送付一覧表データ SaishinsaMoshitateIchiranhyoTaisyoEntity
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param 処理年月 FlexibleYearMonth
     * @param 作成日時 RDateTime
     * @param 連番 int
     * @param 合計フラグ boolean
     * @param 合計件数 Decimal
     * @param reportManager ReportManager
     */
    public void print(
            SaishinsaMoshitateIchiranhyoTaisyoEntity 送付一覧表データ,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時,
            int 連番,
            boolean 合計フラグ,
            Decimal 合計件数,
            ReportManager reportManager) {
        KyufuSaishinsaMoshitateshojohoSofuIchiranProperty property = new KyufuSaishinsaMoshitateshojohoSofuIchiranProperty();

        try (ReportAssembler<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KyufuSaishinsaMoshitateshojohoSofuIchiranSource> reportSourceWriter = new ReportSourceWriter(assembler);
            new KyufuSaishinsaMoshitateshojohoSofuIchiranReport(
                    送付一覧表データ,
                    出力順リスト,
                    改頁リスト, 処理年月,
                    作成日時,
                    連番,
                    合計フラグ,
                    合計件数).writeBy(reportSourceWriter);
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

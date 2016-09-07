/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.kaigohokenryogaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuProperty;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表
 *
 * @reamsid_L DBB-0780-080 yangchenbing
 */
public class KaigoHokenryogakuPrintService {

    private static final ReportId 決定変更通知書_帳票分類ID = new ReportId("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * 介護保険料額変更通知書発行一覧表(単一帳票出力用)
     *
     * @param 編集後本算定通知書共通情報List List<EditedHonSanteiTsuchiShoKyotsu>
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param タイトル RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List, RDateTime 帳票作成日時,
            RString 出力順ID, RString タイトル) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printタイプ(編集後本算定通知書共通情報List, 帳票作成日時, 出力順ID, reportManager, タイトル);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * printメソッド
     *
     * @param 編集後本算定通知書共通情報List List<EditedHonSanteiTsuchiShoKyotsu>
     * @param 帳票作成日時 RDateTime
     * @param 出力順ID RString
     * @param reportManager ReportManager
     * @param タイトル RString
     */
    public void printタイプ(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報List, RDateTime 帳票作成日時,
            RString 出力順ID, ReportManager reportManager, RString タイトル) {
        IOutputOrder 並び順 = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, 決定変更通知書_帳票分類ID, Long.parseLong(出力順ID.toString()));
        }
        KaigoHokenryogakuProperty property = new KaigoHokenryogakuProperty();
        try (ReportAssembler<KaigoHokenryogakuSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KaigoHokenryogakuSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
            Decimal 連番 = Decimal.ONE;
            if (編集後本算定通知書共通情報List != null && !編集後本算定通知書共通情報List.isEmpty()) {
                for (EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 : 編集後本算定通知書共通情報List) {
                    List<RString> 並び順List = get出力順(並び順);
                    KaigoHokenryogakuReport report = new KaigoHokenryogakuReport(編集後本算定通知書共通情報,
                            帳票作成日時, 地方公共団体, 並び順List, 連番, タイトル);
                    report.writeBy(reportSourceWriter);
                    連番 = 連番.add(Decimal.ONE);
                }
            }
        }
    }

    private List<RString> get出力順(IOutputOrder 並び順) {
        List<RString> 並び順List = new ArrayList<>();
        int i = 0;
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                if (i == INDEX_0) {
                    並び順List.add(item.get項目名());
                } else if (i == INDEX_1) {
                    並び順List.add(item.get項目名());
                } else if (i == INDEX_2) {
                    並び順List.add(item.get項目名());
                } else if (i == INDEX_3) {
                    並び順List.add(item.get項目名());
                } else if (i == INDEX_4) {
                    並び順List.add(item.get項目名());
                }
                i = i + 1;
            }
        }
        return 並び順List;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.karinonyutsuchishohakkoichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 保険料納入通知書（仮算定）発行一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0710-050 yebangqiang
 */
public class KariNonyuTsuchishoHakkoIchiranPrintService {

    private static final ReportId 納入通知書仮算定_帳票分類ID = new ReportId("DBB100014_KarisanteiHokenryoNonyuTsuchishoDaihyo");

    /**
     * 保険料納入通知書（仮算定）発行一覧表(単一帳票出力用)
     *
     * @param 仮算定納入通知書情報EntityList List<KariSanteiNonyuTsuchiShoJoho>
     * @param 出力順ID RString
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<KariSanteiNonyuTsuchiShoJoho> 仮算定納入通知書情報EntityList,
            RString 出力順ID, YMDHMS 帳票作成日時, int 出力期) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(仮算定納入通知書情報EntityList, 出力順ID, 帳票作成日時, 出力期, reportManager);
            collection = reportManager.publish();
        }
        return collection;

    }

    /**
     * printメソッド
     *
     * @param entityList List<KariSanteiNonyuTsuchiShoJoho>
     * @param 出力順ID RString
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @param reportManager ReportManager
     */
    public void print(List<KariSanteiNonyuTsuchiShoJoho> entityList, RString 出力順ID, YMDHMS 帳票作成日時,
            int 出力期, ReportManager reportManager) {
        KariNonyuTsuchishoHakkoIchiranProperty property = new KariNonyuTsuchishoHakkoIchiranProperty();
        List<RString> 並び順List = get出力順(出力順ID);
        try (ReportAssembler<KariNonyuTsuchishoHakkoIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<KariNonyuTsuchishoHakkoIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            KariNonyuTsuchishoHakkoIchiranReport report = new KariNonyuTsuchishoHakkoIchiranReport(
                    entityList, 並び順List, 帳票作成日時, 出力期, association);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * printメソッド
     *
     * @param entityList List<KariSanteiNonyuTsuchiShoJoho>
     * @param 出力順ID RString
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<KariSanteiNonyuTsuchiShoJoho> entityList, RString 出力順ID, YMDHMS 帳票作成日時,
            int 出力期) {
        KariNonyuTsuchishoHakkoIchiranProperty property = new KariNonyuTsuchishoHakkoIchiranProperty();
        List<RString> 並び順List = get出力順(出力順ID);
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return new Printer<KariNonyuTsuchishoHakkoIchiranSource>().spool(property,
                new KariNonyuTsuchishoHakkoIchiranReport(entityList, 並び順List, 帳票作成日時, 出力期, association));
    }

    private List<RString> get出力順(RString 出力順ID) {
        IOutputOrder 並び順 = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, 納入通知書仮算定_帳票分類ID, Long.parseLong(出力順ID.toString()));
        }
        List<RString> 並び順List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                並び順List.add(item.get項目名());
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

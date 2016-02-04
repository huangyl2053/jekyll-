/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.keidoshafukushiyogutoriatsukaikakuninshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item;
import jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2Proerty;
import jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report;
import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho2.KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2Printクラスです。
 *
 */
public class KeidoshaFukushiyoguToriatsukaiKakuninShinseisho2 {

    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書2_帳票作成
     */
    public SourceDataCollection createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo2(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        KeidoshaFukushiYoguTaiyoKakuninShinseisho2Proerty proerty = new KeidoshaFukushiYoguTaiyoKakuninShinseisho2Proerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource> assembler = createAssembler(proerty, reportManager)) {

                for (KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report report : toReports()) {
                    ReportSourceWriter<KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report> toReports() {
        List<KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report> list = new ArrayList<>();
        //TODO 文言の取得 QA:648
        //TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        //TsuchiBun = tsuchisho.get通知書定形文検索(SubGyomuCode.DBA介護資格, ReportId.EMPTY, KamokuCode.EMPTY, 1, FlexibleDate.MAX);
        KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item
                = new KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item(
                        new RString("内容文１"),
                        new RString("内容文2"),
                        new RString("内容文3"),
                        RString.EMPTY
                );
        list.add(KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report.createReport(item));
        return list;
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

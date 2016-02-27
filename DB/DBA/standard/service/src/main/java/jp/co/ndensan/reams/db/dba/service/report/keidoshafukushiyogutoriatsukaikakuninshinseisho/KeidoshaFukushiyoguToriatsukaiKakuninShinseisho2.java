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
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

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
                    ReportSourceWriter<KeidoshaFukushiYoguTaiyoKakuninShinseisho2ReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report> toReports() {
        List<KeidoshaFukushiYoguTaiyoKakuninShinseisho2Report> list = new ArrayList<>();
        KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item item
                = new KeidoshaFukushiYoguTaiyoKakuninShinseisho2Item(
                        get帳票文言(INDEX_3),
                        get帳票文言(INDEX_4),
                        get帳票文言(INDEX_5),
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

    private static RString get帳票文言(int 項目番号) {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBC介護給付,
                new ReportId("DBC800021_KeidoshaFukushiYoguTaiyoKakuninShinseisho2"),
                KamokuCode.EMPTY,
                1,
                項目番号,
                new FlexibleDate(RDate.getNowDate().toDateString()));
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            return tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
        }
        return RString.EMPTY;
    }

}

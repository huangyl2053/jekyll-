/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.keidoshafukushiyogutoriatsukaikakuninshinseisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書Printクラスです。
 *
 */
public class KeidoshaFukushiyoguToriatsukaiKakuninShinseisho {

    /**
     * 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 軽度者に対する福祉用具貸与の取り扱いの特例に関する確認申請書_帳票作成
     */
    public SourceDataCollection createKeidoshaFukushiyoguToriatsukaiKakuninShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        KeidoshaFukushiYoguTaiyoKakuninShinseishoProerty proerty = new KeidoshaFukushiYoguTaiyoKakuninShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                //TODO 帳票ID←DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho未設定
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        null, RString.EMPTY);
                for (KeidoshaFukushiYoguTaiyoKakuninShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<KeidoshaFukushiYoguTaiyoKakuninShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<KeidoshaFukushiYoguTaiyoKakuninShinseishoReport> toReports(HihokenshaKihonBusiness entity, RString ninshoshaYakushokuMei) {
        List<KeidoshaFukushiYoguTaiyoKakuninShinseishoReport> list = new ArrayList<>();
        //TODO 文言の取得 QA:648
        //TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        //TsuchiBun = tsuchisho.get通知書定形文検索(SubGyomuCode.DBA介護資格, ReportId.EMPTY, KamokuCode.EMPTY, 1, FlexibleDate.MAX);
        KeidoshaFukushiYoguTaiyoKakuninShinseishoItem item
                = new KeidoshaFukushiYoguTaiyoKakuninShinseishoItem(
                        new RString("確認文"),
                        entity.get住所(),
                        entity.get被保険者氏名(),
                        entity.get被保険者番号().value(),
                        new RString("依頼文"),
                        RString.EMPTY,
                        ninshoshaYakushokuMei
                );
        list.add(KeidoshaFukushiYoguTaiyoKakuninShinseishoReport.createReport(item));
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

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }
}

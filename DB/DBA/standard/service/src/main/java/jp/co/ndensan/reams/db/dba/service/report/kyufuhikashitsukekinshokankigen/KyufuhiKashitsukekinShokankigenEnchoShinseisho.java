/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.kyufuhikashitsukekinshokankigen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen.KyufuhiKashitsukekinShokankigenEnchoShinseishoItem;
import jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen.KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.kyufuhikashitsukekinshokankigen.KyufuhiKashitsukekinShokankigenEnchoShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;
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
 * 護保険給付費貸付金償還期限延長申請書Printクラスです。
 *
 */
public class KyufuhiKashitsukekinShokankigenEnchoShinseisho {

    /**
     * 護保険給付費貸付金償還期限延長申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 護保険給付費貸付金償還期限延長申請書_帳票作成
     */
    public SourceDataCollection createKyufuhiKashitsukekinShokankigenEnchoShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty proerty = new KyufuhiKashitsukekinShokankigenEnchoShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                //TODO 帳票ID←DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho未設定
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        null, RString.EMPTY);
                for (KyufuhiKashitsukekinShokankigenEnchoShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {
                    ReportSourceWriter<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> reportSourceWriter
                            = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<KyufuhiKashitsukekinShokankigenEnchoShinseishoReport> toReports(
            HihokenshaKihonBusiness entity, RString ninshoshaYakushokuMei) {
        List<KyufuhiKashitsukekinShokankigenEnchoShinseishoReport> list = new ArrayList<>();
        //TODO 文言の取得 QA:648
        //TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        //TsuchiBun = tsuchisho.get通知書定形文検索(SubGyomuCode.DBA介護資格, ReportId.EMPTY, KamokuCode.EMPTY, 1, FlexibleDate.MAX);
        //TODO 借受年月日と貸付番号の取得 QA:648
        RString 貸付番号 = new RString("123132");

        KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item
                = new KyufuhiKashitsukekinShokankigenEnchoShinseishoItem(new RString("定型文言"),
                        entity.get被保険者番号().value(),
                        entity.getフリガナ(),
                        entity.get被保険者氏名(),
                        貸付番号,
                        ninshoshaYakushokuMei
                );
        list.add(KyufuhiKashitsukekinShokankigenEnchoShinseishoReport.createReport(item));
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

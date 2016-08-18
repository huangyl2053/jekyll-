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
import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dba.entity.report.keidoshafukushiyogutaiyokakuninshinseisho.KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.db.dba.entity.report.kyufuhikashitsukekinshokankigen.KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kyufuhikashitsukekinkettei.IKyufuhiKashitsukeKinKetteiMapper;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kyufuhikashitsukekinshakuyoshojuri.IKyufuhiKashitsukekinShakuyoshoJuriMapper;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
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
 * @reamsid_L DBA-0540-440 lijia
 *
 */
public class KyufuhiKashitsukekinShokankigenEnchoShinseisho {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShokankigenEnchoShinseisho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyufuhiKashitsukekinShokankigenEnchoShinseisho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyufuhiKashitsukekinShokankigenEnchoShinseisho}のインスタンス
     */
    public static KyufuhiKashitsukekinShokankigenEnchoShinseisho createInstance() {
        return InstanceProvider.create(KyufuhiKashitsukekinShokankigenEnchoShinseisho.class);
    }

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
                ReportSourceWriter<KyufuKashitsukekinShokanKigenEnchoShinseishoReportSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険,
                        NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), null, reportSourceWriter.getImageFolderPath());
                for (KyufuhiKashitsukekinShokankigenEnchoShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei, 被保険者番号)) {
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<KyufuhiKashitsukekinShokankigenEnchoShinseishoReport> toReports(
            HihokenshaKihonBusiness entity, RString ninshoshaYakushokuMei, HihokenshaNo 被保険者番号) {
        List<KyufuhiKashitsukekinShokankigenEnchoShinseishoReport> list = new ArrayList<>();
        KyufuhiKashitsukekinShokankigenEnchoShinseishoItem item
                = new KyufuhiKashitsukekinShokankigenEnchoShinseishoItem(
                        get帳票文言(被保険者番号),
                        entity.get被保険者番号().value(),
                        entity.getフリガナ(),
                        entity.get被保険者氏名(),
                        get貸付番号(被保険者番号),
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

    private RString get帳票文言(HihokenshaNo 被保険者番号) {
        TsuchishoTeikeibunManager tsuchisho = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchisho.get通知書定形文検索(
                SubGyomuCode.DBC介護給付,
                new ReportId("DBC800019_KyufuKashitsukekinShokanKigenEnchoShinseisho"),
                KamokuCode.EMPTY,
                1,
                1,
                new FlexibleDate(RDate.getNowDate().toDateString()));
        if (tsuchishoTeikeibunInfo != null && tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity() != null) {
            RString 帳票文言 = tsuchishoTeikeibunInfo.getUrT0126TsuchishoTeikeibunEntity().getSentence();
            RString 借受年月日 = get借受年月日(被保険者番号).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).toDateString();
            return 帳票文言.replace(new RString("’＠＠＠＠’"), 借受年月日);
        }
        return RString.EMPTY;
    }

    private RString get貸付番号(HihokenshaNo 被保険者番号) {
        IKyufuhiKashitsukeKinKetteiMapper mapper = mapperProvider.create(IKyufuhiKashitsukeKinKetteiMapper.class);
        KyufuhiKashitsukeKinKetteiEntity entity = mapper.getKashitsukeKanriNo(被保険者番号);
        if (entity != null) {
            return entity.getKashitsukeKanriNo();
        }
        return RString.EMPTY;
    }

    private FlexibleDate get借受年月日(HihokenshaNo 被保険者番号) {
        IKyufuhiKashitsukekinShakuyoshoJuriMapper mapper = mapperProvider.create(IKyufuhiKashitsukekinShakuyoshoJuriMapper.class);
        KyufuhiKashitsukekinShakuyoshoJuriEntity entity = mapper.getKariukeYMD(被保険者番号);
        if (entity != null) {
            return entity.getKariukeYMD();
        }
        return FlexibleDate.EMPTY;
    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }
}

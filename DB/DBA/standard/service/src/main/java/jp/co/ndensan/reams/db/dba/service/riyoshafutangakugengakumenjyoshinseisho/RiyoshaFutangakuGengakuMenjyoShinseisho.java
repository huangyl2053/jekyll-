/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.riyoshafutangakugengakumenjyoshinseisho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dba.business.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseishoProerty;
import jp.co.ndensan.reams.db.dba.business.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseishoReport;
import jp.co.ndensan.reams.db.dba.entity.report.riyoshafutangakugengakumenjyoshinseisho.RiyoshaFutangakuGengakuMenjyoShinseishoReportSource;
import jp.co.ndensan.reams.db.dba.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.ShikibetsuTaishoSearchEntityHolder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.persistence.db.basic.UaFt200FindShikibetsuTaishoFunctionDac;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護保険利用者負担額減額・免除申請書Printerです。
 */
public class RiyoshaFutangakuGengakuMenjyoShinseisho {

    private static final RString 生年月日不詳区分 = new RString("FALSE");
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private static final RString タイトル = new RString("（特別療養老人ホームの要介護旧措置入所者に関する認定申請）");

    /**
     * コンストラクタです。
     */
    RiyoshaFutangakuGengakuMenjyoShinseisho() {
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param 受給者台帳Dac 受給者台帳Dac
     */
    RiyoshaFutangakuGengakuMenjyoShinseisho(DbT4001JukyushaDaichoDac 受給者台帳Dac) {
        this.受給者台帳Dac = 受給者台帳Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutangakuGengakuMenjyoShinseisho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RiyoshaFutangakuGengakuMenjyoShinseisho}のインスタンス
     */
    public static RiyoshaFutangakuGengakuMenjyoShinseisho createInstance() {
        return InstanceProvider.create(RiyoshaFutangakuGengakuMenjyoShinseisho.class);
    }

    /**
     * 介護保険利用者負担額減額・免除申請書Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険利用者負担額減額・免除申請書_帳票
     */
    public SourceDataCollection createKaigoHokenRiyoshaFutangakuGengakuMenjyoShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RiyoshaFutangakuGengakuMenjyoShinseishoProerty proerty = new RiyoshaFutangakuGengakuMenjyoShinseishoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> assembler = createAssembler(proerty, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                List<UaFt200FindShikibetsuTaishoEntity> psmJoho = getPsmJoho(識別コード);
                RString title = this.getタイトル(被保険者番号, psmJoho);
                for (RiyoshaFutangakuGengakuMenjyoShinseishoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号),
                        // TODO CompNinshoshaの出力項目 技術点NO.46
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei, title)) {
                    ReportSourceWriter<RiyoshaFutangakuGengakuMenjyoShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<RiyoshaFutangakuGengakuMenjyoShinseishoReport> toReports(HihokenshaKihonBusiness business,
            RString ninshoshaYakushokuMei,
            RString title) {
        List<RiyoshaFutangakuGengakuMenjyoShinseishoReport> list = new ArrayList<>();
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            set生年月日_日本人(business);
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = set生年月日(business);
        }
        RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem item = new RiyoshaFutangakuGengakuMenjyoShinseishoBodyItem(ninshoshaYakushokuMei,
                title,
                business.getフリガナ(),
                business.get被保険者氏名(),
                business.get保険者番号().isEmpty() ? RString.EMPTY : business.get保険者番号().getColumnValue(),
                business.get被保険者番号().isEmpty() ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                生年月日,
                // TODO 内部QA：643 (「IKojin.get性別.getshortJapaneseを使って名称を取得する」不明)
                business.get性別(),
                business.get郵便番号(),
                business.get住所(),
                business.get電話番号(),
                RString.EMPTY);
        list.add(RiyoshaFutangakuGengakuMenjyoShinseishoReport.createReport(item));
        return list;
    }

    private static RString set生年月日_日本人(HihokenshaKihonBusiness business) {
        if (business.get生年月日() != null && business.get生年月日().isEmpty()) {
            return business.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private static RString set生年月日(HihokenshaKihonBusiness business) {
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法);
        RString 生年月日 = RString.EMPTY;
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = (business.get生年月日() == null || business.get生年月日().isEmpty()) ? RString.EMPTY : business.get生年月日()
                    .seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = set生年月日_和暦表示(business);
        }
        return 生年月日;
    }

    private static RString set生年月日_和暦表示(HihokenshaKihonBusiness business) {
        RString 生年月日 = RString.EMPTY;
        if (business.get生年月日不詳区分().equals(生年月日不詳区分)) {
            生年月日 = (business.get生年月日() == null || business.get生年月日().isEmpty()) ? RString.EMPTY : business.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return 生年月日;
    }

    private static List<UaFt200FindShikibetsuTaishoEntity> getPsmJoho(ShikibetsuCode 識別コード) {
        UaFt200FindShikibetsuTaishoFunctionDac dac = InstanceProvider.create(
                UaFt200FindShikibetsuTaishoFunctionDac.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険,
                        KensakuYusenKubun.住登外優先));
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        key.set識別コード(識別コード);
        IPsmCriteria psm = ShikibetsuTaishoSearchEntityHolder.getCriteria(key.build());
        return dac.select(psm);
    }

    private RString getタイトル(HihokenshaNo 被保険者番号, List<UaFt200FindShikibetsuTaishoEntity> entityList) {
        requireNonNull(entityList, UrSystemErrorMessages.値がnull.getReplacedMessage("entityList"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        RString title = RString.EMPTY;
        IShikibetsuTaisho shikibetsuTaisho = ShikibetsuTaishoFactory.createKojin(entityList.get(0));
        DbT4001JukyushaDaichoEntity 受給者台帳情報 = 受給者台帳Dac.select受給者台帳情報(shikibetsuTaisho.get現全国地方公共団体コード(),
                被保険者番号,
                // TODO 内部QA：693 (「DBD介護受給Enum．有効無効区分．有効」不明)
                Code.EMPTY);
        if (受給者台帳情報 != null && 受給者台帳情報.getKyuSochishaFlag()) {
            title = タイトル;
        }
        return title;
    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        HihokenshaKihonBusiness list = shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
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

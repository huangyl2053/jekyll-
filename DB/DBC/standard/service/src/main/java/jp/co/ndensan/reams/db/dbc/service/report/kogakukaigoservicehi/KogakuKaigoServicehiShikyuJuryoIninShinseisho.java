/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.kogakukaigoservicehi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoProperty;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakukaigoservicehi.KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
 * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書のPrintServiceです。
 *
 * @reamsid_L DBA-0540-600 lishengli
 */
public class KogakuKaigoServicehiShikyuJuryoIninShinseisho {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final RString ハイフン = new RString("-");
    private static final RString 外国人 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法,
            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    private static final int INDEX_3 = 3;
    private static RString 生年月日;
    private final DbT3055KogakuKyufuTaishoshaGokeiDac dac;

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3055KogakuKyufuTaishoshaGokeiDac}
     */
    KogakuKaigoServicehiShikyuJuryoIninShinseisho(
            DbT3055KogakuKyufuTaishoshaGokeiDac dac) {
        this.dac = dac;
    }

    /**
     * コンストラクタです。
     */
    public KogakuKaigoServicehiShikyuJuryoIninShinseisho() {
        this.dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
    }

    /**
     * 介護保険高額介護（予防）サービス費支給（受領委任払）申請書を印刷します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection createKogakuKaigoServicehiShikyuJuryoIninShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoProperty property
                = new KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource> assembler
                    = createAssembler(property, reportManager)) {
                ReportSourceWriter<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReportSource> reportSourceWriter
                        = new ReportSourceWriter(assembler);
                Ninshosha nishosha = NinshoshaFinderFactory.createInstance().get帳票認証者(
                        GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
                Association association = AssociationFinderFactory.createInstance().getAssociation();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(
                        nishosha, association, reportSourceWriter.getImageFolderPath(), RDate.getNowDate());
                for (KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport report : toReports(get被保険者基本情報取得(識別コード, 被保険者番号),
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei)) {

                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport> toReports(
            HihokenshaKihonBusiness business, RString ninshoshaYakushokuMei) {
        List<KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport> list = new ArrayList<>();
        if (JuminShubetsu.日本人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(business.get住民種別コード())) {
            生年月日 = パターン12(business.get生年月日());
        } else if (JuminShubetsu.外国人.getCode().equals(business.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(business.get住民種別コード())) {
            生年月日 = get生年月日_外国人(business);
        }
        RString 郵便番号 = business.get郵便番号();
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            郵便番号 = set郵便番号(business.get郵便番号());
        } else {
            郵便番号 = RString.EMPTY;
        }
        RString サービス提供年月 = getサービス提供年月(business.get被保険者番号());
        KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem item = new KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoItem(
                サービス提供年月,
                RString.EMPTY,
                business.get保険者番号() == null ? RString.EMPTY : business.get保険者番号().value(),
                business.getフリガナ(),
                business.get被保険者氏名(),
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().value(),
                生年月日,
                Gender.toValue(business.get性別()).getCommonName(),
                business.get電話番号(),
                郵便番号,
                business.get住所(),
                RString.EMPTY,
                ninshoshaYakushokuMei
        );
        list.add(KogakuKaigoServicehiShikyuShinseiShoJuryoIninHaraiyoReport.createFrom(item));
        return list;
    }

    private static RString set郵便番号(RString 郵便番号) {
        RStringBuilder yubinNoSb = new RStringBuilder();
        if (INDEX_3 <= 郵便番号.length()) {
            yubinNoSb.append(郵便番号.substring(0, INDEX_3));
            yubinNoSb.append(ハイフン);
            yubinNoSb.append(郵便番号.substring(INDEX_3));
        } else {
            yubinNoSb.append(郵便番号);
        }
        return yubinNoSb.toRString();
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

    private static HihokenshaKihonBusiness get被保険者基本情報取得(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
    }

    private static RString get生年月日_外国人(HihokenshaKihonBusiness business) {
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人)) {
            生年月日 = パターン37(business.get生年月日());
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人)) {
            if (生年月日不詳区分_FALG.equals(business.get生年月日不詳区分())) {
                生年月日 = パターン12(business.get生年月日());
            } else {
                生年月日 = RString.EMPTY;
            }
        }
        return 生年月日;
    }

    private static RString パターン12(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private static RString パターン37(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString getサービス提供年月(HihokenshaNo 被保険者番号) {
        RString サービス提供年月 = RString.EMPTY;
        List<DbT3055KogakuKyufuTaishoshaGokeiEntity> entityList = dac.get高額介護サービス費給付対象者合計の最新データ(被保険者番号);
        if (!entityList.isEmpty()) {
            RStringBuilder sb = new RStringBuilder();
            sb.append(entityList.get(0).getServiceTeikyoYM().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).getYear());
            sb.append(entityList.get(0).getServiceTeikyoYM().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).getMonth());
            サービス提供年月 = sb.toRString();
        }
        return サービス提供年月;
    }
}

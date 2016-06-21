/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.daisanshakoiniyoruhigaitodokechohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoItem;
import jp.co.ndensan.reams.db.dbc.business.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoProerty;
import jp.co.ndensan.reams.db.dbc.business.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReport;
import jp.co.ndensan.reams.db.dbc.entity.report.daisanshakouihigaitodokekaigohokenyo.DaisanshaKouiHigaitodokeKaigoHokenyoReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.tokuteifutangendogakushinseisho.HihokenshaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7068ChohyoBunruiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7068ChohyoBunruiKanriDac;
import jp.co.ndensan.reams.db.dbz.service.core.tokuteifutangendogakushinseisho.TokuteifutanGendogakuShinseisho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
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
 * 第三者行為による被害届（介護保険用）Printerです。
 *
 * @reamsid_L DBA-0540-380 suguangjun
 */
public class DaisanshaKoiniyoruHigaitodokeChohyo {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private final DbT7068ChohyoBunruiKanriDac dbT7068dac;
    private final DbT4001JukyushaDaichoDac dbT4001dac;

    /**
     * コンストラクタです。
     */
    DaisanshaKoiniyoruHigaitodokeChohyo() {
        this.dbT7068dac = InstanceProvider.create(DbT7068ChohyoBunruiKanriDac.class);
        this.dbT4001dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT7068dac DbT7068ChohyoBunruiKanriDac
     * @param dbT4001dac DbT4001JukyushaDaichoDac
     */
    DaisanshaKoiniyoruHigaitodokeChohyo(DbT7068ChohyoBunruiKanriDac dbT7068dac, DbT4001JukyushaDaichoDac dbT4001dac) {
        this.dbT7068dac = dbT7068dac;
        this.dbT4001dac = dbT4001dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link DaisanshaKoiniyoruHigaitodokeChohyo}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link DaisanshaKoiniyoruHigaitodokeChohyo}のインスタンス
     */
    public static DaisanshaKoiniyoruHigaitodokeChohyo createInstance() {
        return InstanceProvider.create(DaisanshaKoiniyoruHigaitodokeChohyo.class);
    }

    /**
     * 第三者行為による被害届（介護保険用）Printします。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 第三者行為による被害届（介護保険用）_帳票
     */
    public SourceDataCollection createDaisanshaKoiniyoruHigaitodokeChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        DaisanshaKouiHigaitodokeKaigoHokenyoProerty proerty = new DaisanshaKouiHigaitodokeKaigoHokenyoProerty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> assembler = createAssembler(proerty, reportManager)) {
                for (DaisanshaKouiHigaitodokeKaigoHokenyoReport report : toReports(get被保険者基本情報(識別コード, 被保険者番号))) {
                    ReportSourceWriter<DaisanshaKouiHigaitodokeKaigoHokenyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private List<DaisanshaKouiHigaitodokeKaigoHokenyoReport> toReports(HihokenshaKihonBusiness business) {
        List<DaisanshaKouiHigaitodokeKaigoHokenyoReport> list = new ArrayList<>();
        RString birthYMD = RString.EMPTY;
        RString 住民種別コード = business.get住民種別コード();
        FlexibleDate 生年月日 = business.get生年月日();
        if (生年月日 != null && !生年月日.isEmpty()) {
            if (JuminShubetsu.日本人.getCode().equals(住民種別コード)
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
                birthYMD = set生年月日_日本人(生年月日);
            } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード)
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
                birthYMD = set生年月日(生年月日, business.get生年月日不詳区分());
            }
        }
        DaisanshaKouiHigaitodokeKaigoHokenyoItem item = new DaisanshaKouiHigaitodokeKaigoHokenyoItem(
                get役職名(),
                get認定有効期間及び要介護状態区分(business).get(0),
                get認定有効期間及び要介護状態区分(business).get(1),
                birthYMD,
                business.get被保険者氏名(),
                business.getフリガナ(),
                business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号().getColumnValue(),
                business.get保険者番号() == null ? RString.EMPTY : business.get保険者番号().getColumnValue(),
                RString.EMPTY,
                get認定有効期間及び要介護状態区分(business).get(2));
        list.add(DaisanshaKouiHigaitodokeKaigoHokenyoReport.createReport(item));
        return list;
    }

    private static RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set生年月日(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            return 生年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            return set生年月日_和暦表示(生年月日, 生年月日不詳区分);
        }
        return RString.EMPTY;
    }

    private RString set生年月日_和暦表示(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        if (生年月日不詳区分_FALG.equals(生年月日不詳区分)) {
            return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private List<RString> get認定有効期間及び要介護状態区分(HihokenshaKihonBusiness business) {
        List<DbT4001JukyushaDaichoEntity> entityList = dbT4001dac.select受給者台帳情報(business.get被保険者番号(), new Code(YukoMukoKubun.有効.getコード()),
                new Code(ShinseiJokyoKubun.認定完了.getコード()));
        List<RString> 受給者情報 = new ArrayList();
        if (!entityList.isEmpty()) {
            受給者情報.add(flexableDateTORString(entityList.get(0).getNinteiYukoKikanKaishiYMD()));
            受給者情報.add(flexableDateTORString(entityList.get(0).getNinteiYukoKikanShuryoYMD()));
            受給者情報.add(YokaigoJotaiKubun99.toValue(codeToRString(entityList.get(0).getYokaigoJotaiKubunCode())).get名称());
        } else {
            受給者情報.add(RString.EMPTY);
            受給者情報.add(RString.EMPTY);
            受給者情報.add(RString.EMPTY);
        }
        return 受給者情報;
    }

    private RString flexableDateTORString(FlexibleDate date) {
        return date == null ? RString.EMPTY : new RString(date.toString());
    }

    private RString codeToRString(Code code) {
        return code == null ? RString.EMPTY : code.getColumnValue();
    }

    private RString get役職名() {
        DbT7068ChohyoBunruiKanriEntity entity = dbT7068dac.selectByKey(SubGyomuCode.DBC介護給付,
                new ReportId("DBC800020_DaisanshaKouiHigaitodokeKaigoHokenyo"));
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        if (entity != null) {
            INinshoshaManager manager = NinshoshaFinderFactory.createInstance();
            Ninshosha ninshosha = manager.get帳票認証者(GyomuCode.DB介護保険, entity.getChohyoBunruiID().getColumnValue());
            return ninshosha != null ? ninshosha.get市町村付与名称(association) : RString.EMPTY;
        }
        return RString.EMPTY;
    }

    private HihokenshaKihonBusiness get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        TokuteifutanGendogakuShinseisho shinjoho = InstanceProvider.create(TokuteifutanGendogakuShinseisho.class);
        return shinjoho.getHihokenshaKihonJoho(被保険者番号, 識別コード);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.iryohikojokakuninsinsei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.IryohiKojo;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.Chohyokoyujoho;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.OmutsusiyoSyomeishoEntity;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.ShugiiIkenshoKakuninshoEntity;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100030.ShujiiIkenshoKakuninshoProperty;
import jp.co.ndensan.reams.db.dbd.definition.core.iryohikojo.NichijoSeikatsuJiritsudo;
import jp.co.ndensan.reams.db.dbd.definition.core.meishofuyo.MeishoFuyoTypeEnum;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.iryohikojokakuninsinsei.ShikibetsuTaishoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4401IryohiKojoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei.SogoJigyouTaisyouSyaJyohoJoho;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100030.ShujiiIkenshoKakuninshoReportSource;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4401IryohiKojoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.iryohikojokakuninsinsei.IIryoHiKojoKakuninSinseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.JushoHenshuChoikiHenshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.jusho.JushoEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditor;
import jp.co.ndensan.reams.ua.uax.business.report.parts.util.atesaki.ReportAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyoseikuInjiKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoKannaiEditPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.JushoPrefix;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.MeishoFuyoType;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計医療費控除確認申請
 *
 * @reamsid_L DBD-5770-030 x_zhaowen
 */
public class IryoHiKojoKakuninSinsei {

    private static final RString 表示する = new RString("1");
    private static final RString 性別男 = new RString("1");
    private static final RString 選択する = new RString("○");
    private static final RString R_STRING1 = new RString("1");
    private static final RString R_STRING0 = new RString("0");
    private static final RString あり = new RString("あり");
    private static final RString なし = new RString("なし");
    private static final int サーティ = 30;
    private static final int シックスティ = 60;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac 帳票制御共通Dac;
    private final DbT4401IryohiKojoDac dac;
    private final DbV4001JukyushaDaichoAliveDac dbV4001JukyushaDaichoAliveDac;

    /**
     * コンストラクタです。
     */
    public IryoHiKojoKakuninSinsei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.帳票制御共通Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.dac = InstanceProvider.create(DbT4401IryohiKojoDac.class);
        this.dbV4001JukyushaDaichoAliveDac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
    }

    /**
     * Intanceを作成します。
     *
     * @return IryoHiKojoKakuninSinsei
     */
    public static IryoHiKojoKakuninSinsei createIntance() {
        return InstanceProvider.create(IryoHiKojoKakuninSinsei.class);
    }

    /**
     * 受給者判定
     *
     * @param 被保険者番号 HihokenshaNo
     * @return boolean
     */
    public boolean checkuJukyusha(HihokenshaNo 被保険者番号) {
        List<DbV4001JukyushaDaichoEntity> dbV4001JukyushaDaichoEntityList = dbV4001JukyushaDaichoAliveDac.selectBy被保険者番号AND有効無効区分(被保険者番号, new RString("1"));
        Integer レコード数 = 0;
        if (dbV4001JukyushaDaichoEntityList != null) {
            レコード数 = dbV4001JukyushaDaichoEntityList.size();
        }
        return レコード数 > 0;
    }

    /**
     * 受給者台帳取得
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年 対象年
     * @return 受給者台帳情報
     */
    public SogoJigyouTaisyouSyaJyohoJoho getJukyusha(RString 被保険者番号, RString 対象年) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);
        SogoJigyouTaisyouSyaJyohoJoho 受給者台帳情報 = mapper.select受給者台帳情報(被保険者番号, 対象年);
        if (受給者台帳情報 == null) {
            受給者台帳情報 = new SogoJigyouTaisyouSyaJyohoJoho();
        }
        return 受給者台帳情報;
    }

    /**
     * 医療費控除取得
     *
     * @param 被保険者番号 被保険者番号
     * @return 医療費控除情報
     */
    public List<IryohiKojo> getIryohikojyo(HihokenshaNo 被保険者番号) {
        List<IryohiKojo> 医療費控除情報 = new ArrayList<>();
        List<DbT4401IryohiKojoEntity> result = dac.select医療費控除(被保険者番号);
        if (result != null) {
            for (DbT4401IryohiKojoEntity entity : result) {
                IryohiKojo 医療費控除 = new IryohiKojo(entity);
                医療費控除情報.add(医療費控除);
            }
        }
        return 医療費控除情報;
    }

    /**
     * 単票用医療費控除取得
     *
     * @param 被保険者番号 被保険者番号
     * @param データ区分 データ区分
     * @return 医療費控除情報
     */
    public List<IryohiKojo> getIryohikojyo_Chohyo(HihokenshaNo 被保険者番号, RString データ区分) {
        List<IryohiKojo> 単票用医療費控除 = new ArrayList<>();
        List<DbT4401IryohiKojoEntity> result = dac.select単票用医療費控除(被保険者番号, データ区分);
        if (result != null) {
            for (DbT4401IryohiKojoEntity entity : result) {
                IryohiKojo 医療費控除 = new IryohiKojo(entity);
                単票用医療費控除.add(医療費控除);
            }
        }
        return 単票用医療費控除;
    }

    /**
     * おむつ使用証明書
     *
     * @param 識別コード ShikibetsuCode
     * @param 帳票分類ID RString
     * @return おむつ使用証明書Entity OmutsusiyoSyomeishoEntity
     */
    public OmutsusiyoSyomeishoEntity editomutsusiyoSyomeisho(ShikibetsuCode 識別コード, RString 帳票分類ID) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBD介護受給, new ReportId(帳票分類ID));
        RString 管内住所編集_都道府県名付与有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 管内住所編集_郡名付与有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 管内住所編集_市町村名付与有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 管内住所編集_編集方法 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 住所編集_方書表示有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        if (帳票制御共通 != null) {
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                管内住所編集_都道府県名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                管内住所編集_郡名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                管内住所編集_市町村名付与有無 = 表示する;
            }
            管内住所編集_編集方法 = 帳票制御共通.getJushoHenshuChoikiHenshuHoho();
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                住所編集_方書表示有無 = 表示する;
            }
        }

        IKojin 宛名情報 = getAtena_Iryohikojyo(識別コード);
        if (宛名情報 == null || JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード().equals(管内住所編集_編集方法)) {
            return null;
        }
        JushoEditorBuilder jushoEditorBuilder = new JushoEditorBuilder(宛名情報.get住所());
        if (表示する.equals(管内住所編集_都道府県名付与有無)) {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.県_郡_市町村名付加, 地方公共団体);
        } else if (表示する.equals(管内住所編集_郡名付与有無)) {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.郡_市町村名付加, 地方公共団体);
        } else if (表示する.equals(管内住所編集_市町村名付与有無)) {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.市町村名付加, 地方公共団体);
        } else {
            jushoEditorBuilder.set管内住所接頭辞(JushoPrefix.付加しない, 地方公共団体);
        }

        if (JushoHenshuChoikiHenshuHoho.行政区足す番地.getコード().equals(管内住所編集_編集方法)) {
            if (表示する.equals(住所編集_方書表示有無)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地space方書);
            } else {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地);
            }
        } else if (JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.getコード().equals(管内住所編集_編集方法)) {
            if (表示する.equals(住所編集_方書表示有無)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地カッコ行政区space方書);
            } else {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.町域番地カッコ行政区);
            }
        } else {
            if (表示する.equals(住所編集_方書表示有無)) {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地space方書);
            } else {
                jushoEditorBuilder.set管内住所編集パターン(JushoKannaiEditPattern.行政区番地);
            }
        }
        jushoEditorBuilder.set行政区(宛名情報.get行政区画().getGyoseiku());

        return setおむつ使用証明書Entity(宛名情報, jushoEditorBuilder);
    }

    /**
     * 主治医意見書確認書
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 RString
     * @param 帳票分類ID RString
     * @param 作成日 RDate
     * @param 文書番号 RString
     * @param 対象年 RString
     * @param 申請日 RDate
     * @param 主治医意見書作成日 RDate
     * @param 認定期間開始日 RDate
     * @param 認定期間終了日 RDate
     * @param 日常生活自立度 RString
     * @param 尿失禁の有無 RString
     * @return ShugiiIkenshoKakuninshoEntity
     */
    public ShugiiIkenshoKakuninshoEntity editsyujiikensho_Kakunisho(ShikibetsuCode 識別コード,
            RString 被保険者番号,
            RString 帳票分類ID,
            RDate 作成日,
            RString 文書番号,
            RString 対象年,
            RDate 申請日,
            RDate 主治医意見書作成日,
            RDate 認定期間開始日,
            RDate 認定期間終了日,
            RString 日常生活自立度,
            RString 尿失禁の有無) {
        ShugiiIkenshoKakuninshoEntity 主治医意見書確認書Entity = new ShugiiIkenshoKakuninshoEntity();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通 = 帳票制御共通Dac.selectByKey(SubGyomuCode.DBD介護受給, new ReportId(帳票分類ID));
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> コンフィグ情報 = getコンフィグ情報(帳票制御共通);
        NinshoshaSource 認証者 = 認証者編集(地方公共団体, RDate.getNowDate(), 帳票制御共通);
        IKojin 宛名情報 = getAtena_Iryohikojyo(識別コード);
        Chohyokoyujoho 帳票固有情報 = new Chohyokoyujoho();
        if (!JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード().equals(コンフィグ情報.get(INT_3))) {
            SofubutsuAtesakiSource 送付物宛先 = 窓空き住所編集(地方公共団体, 識別コード, コンフィグ情報);
            主治医意見書確認書Entity.set送付物宛先(送付物宛先);
            RString 編集後住所 = 住所編集(地方公共団体, 宛名情報, コンフィグ情報);
            帳票固有情報.set住所(編集後住所);
            if (編集後住所.length() <= サーティ) {
                帳票固有情報.set住所１(RString.EMPTY);
                帳票固有情報.set住所２(RString.EMPTY);
            } else {
                帳票固有情報.set住所１(編集後住所.substring(0, サーティ));
                帳票固有情報.set住所２(編集後住所.substring(サーティ));
            }
            帳票固有情報.set文書番号(文書番号);
            帳票固有情報.set文書番号(文書番号);
        }
        主治医意見書確認書Entity.set認証者(認証者);
        帳票固有情報.set文書番号(文書番号);
        帳票固有情報.set発行日(作成日.toDateString());
        帳票固有情報.set申請日(申請日.toDateString());
        RString 氏名 = RString.EMPTY;
        if (宛名情報 != null) {
            if (JuminShubetsu.日本人.getCode().equals(宛名情報.get住民種別().getCode())) {
                氏名 = 宛名情報.get日本人氏名().getName().value();
                帳票固有情報.set氏名(氏名);
            } else if (JuminShubetsu.外国人.getCode().equals(宛名情報.get住民種別().getCode())) {
                氏名 = 宛名情報.get外国人氏名().getName().value();
                帳票固有情報.set氏名(氏名);
            }
        }
        if (氏名.length() <= サーティ) {
            帳票固有情報.set氏名１(RString.EMPTY);
            帳票固有情報.set氏名２(RString.EMPTY);
        } else {
            帳票固有情報.set氏名１(氏名.substring(0, サーティ));
            帳票固有情報.set氏名２(氏名.substring(サーティ));
        }
        帳票固有情報.set被保険者番号(被保険者番号);
        帳票固有情報.set主治医意見書作成日(主治医意見書作成日.toDateString());
        帳票固有情報.set要介護認定の有効期間開始(認定期間開始日.toDateString());
        帳票固有情報.set要介護認定の有効期間終了(認定期間終了日.toDateString());
        帳票固有情報.set寝たきり度_B1(NichijoSeikatsuJiritsudo.Ｂ１.getコード().equals(日常生活自立度)
                ? 選択する : RString.EMPTY);
        帳票固有情報.set寝たきり度_B2(NichijoSeikatsuJiritsudo.Ｂ２.getコード().equals(日常生活自立度)
                ? 選択する : RString.EMPTY);
        帳票固有情報.set寝たきり度_C1(NichijoSeikatsuJiritsudo.Ｃ１.getコード().equals(日常生活自立度)
                ? 選択する : RString.EMPTY);
        帳票固有情報.set寝たきり度_C2(NichijoSeikatsuJiritsudo.Ｃ２.getコード().equals(日常生活自立度)
                ? 選択する : RString.EMPTY);
        帳票固有情報.set尿失禁の発生可能性(new RString("はい").equals(尿失禁の有無) ? あり : なし);
        帳票固有情報.set年(対象年);
        主治医意見書確認書Entity.set帳票固有情報(帳票固有情報);
        return 主治医意見書確認書Entity;
    }

    /**
     * 宛名取得
     *
     * @param 識別コード ShikibetsuCode
     * @return 宛名情報 IKojin
     */
    public IKojin getAtena_Iryohikojyo(ShikibetsuCode 識別コード) {
        IIryoHiKojoKakuninSinseiMapper mapper = mapperProvider.create(IIryoHiKojoKakuninSinseiMapper.class);

        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        juminJotaiList.add(JuminJotai.死亡者);
        key.set住民状態(juminJotaiList);
        key.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        ShikibetsuTaishoParameter param = new ShikibetsuTaishoParameter(shikibetsuTaishoPSMSearchKey);

        UaFt200FindShikibetsuTaishoEntity 宛名情報 = mapper.select宛名情報(param);

        return 宛名情報 != null ? ShikibetsuTaishoFactory.createKojin(宛名情報) : null;
    }

    /**
     * 宛先取得
     *
     * @param 識別コード ShikibetsuCode
     * @return 宛先情報 IAtesaki
     */
    public IAtesaki getAtesaki_Iryohikojyo(ShikibetsuCode 識別コード) {
        AtesakiPSMSearchKeyBuilder key = new AtesakiPSMSearchKeyBuilder(
                AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        key.set識別コード(識別コード);
        return ShikibetsuTaishoService.getAtesakiFinder().get宛先(key.build());
    }

    private JushoPrefix get管内住所接頭辞(List<RString> コンフィグ情報) {
        if (表示する.equals(コンフィグ情報.get(0))) {
            return JushoPrefix.県_郡_市町村名付加;
        } else if (表示する.equals(コンフィグ情報.get(1))) {
            return JushoPrefix.郡_市町村名付加;
        } else if (表示する.equals(コンフィグ情報.get(2))) {
            return JushoPrefix.市町村名付加;
        }
        return JushoPrefix.付加しない;
    }

    private JushoKannaiEditPattern get管内住所編集パターン(List<RString> コンフィグ情報) {
        if (JushoHenshuChoikiHenshuHoho.行政区足す番地.getコード().equals(コンフィグ情報.get(INT_3))) {
            if (表示する.equals(コンフィグ情報.get(INT_4))) {
                return JushoKannaiEditPattern.行政区番地space方書;
            } else {
                return JushoKannaiEditPattern.行政区番地;
            }
        } else if (JushoHenshuChoikiHenshuHoho.住所足す番地_行政区.getコード().equals(コンフィグ情報.get(INT_3))) {
            if (表示する.equals(コンフィグ情報.get(INT_4))) {
                return JushoKannaiEditPattern.町域番地カッコ行政区space方書;
            } else {
                return JushoKannaiEditPattern.町域番地カッコ行政区;
            }
        } else if (表示する.equals(コンフィグ情報.get(INT_4))) {
            return JushoKannaiEditPattern.行政区番地space方書;
        } else {
            return JushoKannaiEditPattern.行政区番地;
        }
    }

    private List<RString> getコンフィグ情報(DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通) {
        List<RString> コンフィグ情報 = new ArrayList<>();
        RString 管内住所編集_都道府県名付与有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 管内住所編集_郡名付与有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 管内住所編集_市町村名付与有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 管内住所編集_編集方法 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        RString 住所編集_方書表示有無 = DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告);
        if (帳票制御共通 != null) {
            if (帳票制御共通.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                管内住所編集_都道府県名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuGunMeiHyojiUmu()) {
                管内住所編集_郡名付与有無 = 表示する;
            }
            if (帳票制御共通.getJushoHenshuShichosonMeiHyojiUmu()) {
                管内住所編集_市町村名付与有無 = 表示する;
            }
            管内住所編集_編集方法 = 帳票制御共通.getJushoHenshuChoikiHenshuHoho();
            if (帳票制御共通.getJushoHenshuKatagakiHyojiUmu()) {
                住所編集_方書表示有無 = 表示する;
            }
        }
        コンフィグ情報.add(管内住所編集_都道府県名付与有無);
        コンフィグ情報.add(管内住所編集_郡名付与有無);
        コンフィグ情報.add(管内住所編集_市町村名付与有無);
        コンフィグ情報.add(管内住所編集_編集方法);
        コンフィグ情報.add(住所編集_方書表示有無);
        return コンフィグ情報;
    }

    private SofubutsuAtesakiSource 窓空き住所編集(Association 地方公共団体,
            ShikibetsuCode 識別コード,
            List<RString> コンフィグ情報) {
        ReportAtesakiEditorBuilder atesakiEditorBuilder
                = new ReportAtesakiEditorBuilder(getAtesaki_Iryohikojyo(識別コード))
                .set氏名1名称付与区分(get敬称(R_STRING1))
                .set氏名2名称付与区分(get敬称(R_STRING0))
                .set代納区分名印字有無(false)
                .set行政区印字区分(GyoseikuInjiKubun.括弧付きで印字);
        atesakiEditorBuilder.set管内住所接頭辞(get管内住所接頭辞(コンフィグ情報), 地方公共団体);
        atesakiEditorBuilder.set管内住所編集パターン(get管内住所編集パターン(コンフィグ情報));
        ReportAtesakiEditor atesakiEditor = new ReportAtesakiEditor(atesakiEditorBuilder);
        return new SofubutsuAtesakiSourceBuilder(atesakiEditor).buildSource();
    }

    private NinshoshaSource 認証者編集(Association 地方公共団体, RDate 作成日, DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通) {
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha 帳票認証者情報 = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), new FlexibleDate(作成日.toDateString()));
        ReportManager reportManager = new ReportManager();
        ShujiiIkenshoKakuninshoProperty proerty = new ShujiiIkenshoKakuninshoProperty();
        ReportAssembler<ShujiiIkenshoKakuninshoReportSource> assembler = createAssembler(proerty, reportManager);
        ReportSourceWriter<ShujiiIkenshoKakuninshoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
        return NinshoshaSourceBuilderFactory.createInstance(帳票認証者情報,
                地方公共団体,
                reportSourceWriter.getImageFolderPath(),
                作成日,
                R_STRING1.equals(帳票制御共通.getShuchoMeiInjiIchi()),
                !帳票制御共通.getDenshiKoinInjiUmu(),
                KenmeiFuyoKubunType.付与なし).buildSource();
    }

    private RString 住所編集(Association 地方公共団体, IKojin 宛名情報, List<RString> コンフィグ情報) {
        if (宛名情報 == null || JushoHenshuChoikiHenshuHoho.表示なし_住所は印字しない.getコード().equals(コンフィグ情報.get(INT_3))) {
            return RString.EMPTY;
        }
        JushoEditorBuilder jushoEditorBuilder = new JushoEditorBuilder(宛名情報.get住所());
        jushoEditorBuilder.set管内住所接頭辞(get管内住所接頭辞(コンフィグ情報), 地方公共団体);
        jushoEditorBuilder.set管内住所編集パターン(get管内住所編集パターン(コンフィグ情報));
        jushoEditorBuilder.set行政区(宛名情報.get行政区画().getGyoseiku());
        return jushoEditorBuilder.build().editJusho().get編集後住所All();
    }

    private MeishoFuyoType get敬称(RString 敬称) {
        if (MeishoFuyoTypeEnum.様.getCode().equals(敬称)) {
            return MeishoFuyoTypeEnum.様.getMeishoFuyoType();
        }
        return MeishoFuyoTypeEnum.無し.getMeishoFuyoType();
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

    private OmutsusiyoSyomeishoEntity setおむつ使用証明書Entity(IKojin 宛名情報, JushoEditorBuilder jushoEditorBuilder) {
        OmutsusiyoSyomeishoEntity おむつ使用証明書Entity = new OmutsusiyoSyomeishoEntity();
        RString 編集後住所 = jushoEditorBuilder.build().editJusho().get編集後住所All();
        if (編集後住所.length() <= サーティ) {
            おむつ使用証明書Entity.set住所(編集後住所);
            おむつ使用証明書Entity.set住所１(RString.EMPTY);
            おむつ使用証明書Entity.set住所２(RString.EMPTY);
        } else if (編集後住所.length() <= シックスティ) {
            おむつ使用証明書Entity.set住所(RString.EMPTY);
            おむつ使用証明書Entity.set住所１(編集後住所.substring(0, サーティ));
            おむつ使用証明書Entity.set住所２(編集後住所.substring(サーティ));
        } else {
            おむつ使用証明書Entity.set住所(RString.EMPTY);
            おむつ使用証明書Entity.set住所１(編集後住所.substring(0, サーティ));
            おむつ使用証明書Entity.set住所２(編集後住所.substring(サーティ, シックスティ));
        }
        RString 氏名 = RString.EMPTY;
        if (宛名情報.get住民種別().equals(JuminShubetsu.日本人) || 宛名情報.get住民種別().equals(JuminShubetsu.住登外個人_日本人)) {
            氏名 = 宛名情報.get日本人氏名().getName().value();
            おむつ使用証明書Entity.set生年月日(宛名情報.get生年月日().toFlexibleDate()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        } else if (宛名情報.get住民種別().equals(JuminShubetsu.外国人) || 宛名情報.get住民種別().equals(JuminShubetsu.住登外個人_外国人)) {
            氏名 = 宛名情報.get外国人氏名().getName().value();
            おむつ使用証明書Entity.set生年月日(宛名情報.get生年月日().toFlexibleDate().seireki()
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        if (氏名.length() <= サーティ) {
            おむつ使用証明書Entity.set氏名(氏名);
            おむつ使用証明書Entity.set氏名１(RString.EMPTY);
            おむつ使用証明書Entity.set氏名２(RString.EMPTY);
        } else if (氏名.length() <= シックスティ) {
            おむつ使用証明書Entity.set氏名(RString.EMPTY);
            おむつ使用証明書Entity.set氏名１(編集後住所.substring(0, サーティ));
            おむつ使用証明書Entity.set氏名２(編集後住所.substring(サーティ));
        } else {
            おむつ使用証明書Entity.set氏名(RString.EMPTY);
            おむつ使用証明書Entity.set氏名１(氏名.substring(0, サーティ));
            おむつ使用証明書Entity.set氏名２(氏名.substring(サーティ, シックスティ));
        }
        if (宛名情報.get性別().getCode().equals(性別男)) {
            おむつ使用証明書Entity.set性別男(選択する);
            おむつ使用証明書Entity.set性別女(RString.EMPTY);
        } else {
            おむつ使用証明書Entity.set性別男(RString.EMPTY);
            おむつ使用証明書Entity.set性別女(選択する);
        }
        return おむつ使用証明書Entity;
    }
}

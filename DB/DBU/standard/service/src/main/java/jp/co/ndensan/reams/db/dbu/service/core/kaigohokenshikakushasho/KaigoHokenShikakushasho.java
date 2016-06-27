/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.kaigohokenshikakushasho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.KyufuseigenBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.NyushoShisetsuBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuBusiness;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.KaigoHokenShikakushashoDataBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.ShienJigyoshaBusiness;
import jp.co.ndensan.reams.db.dbu.business.core.kaigohokenshikakushasho.ShikakushashoHakkoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigohokenshikakushasho.KaigoHokenShikakushashoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.HihokenshaDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.HokenshaBangoMeishoInDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShienJigyoshaDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigohokenshikakushasho.IKaigoHokenShikakushashoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護保険資格者証のビジネスクラスです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
public class KaigoHokenShikakushasho {

    private static final RString 生年月日不詳区分_FALG = new RString("0");
    private static final int 画面のデータ件数 = 6;
    private static final RString 単位種類 = new RString("1月当たり");
    private static final RString 固定文字_単位 = new RString("単位");
    private static final RString 帳票独自 = new RString("1");
    private static final RString 市町村共通 = new RString("0");
    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private static final RString 編集方法_1 = new RString("1");
    private static final RString 編集方法_2 = new RString("2");
    private static final RString 編集方法_3 = new RString("3");
    private static final RString 編集方法_4 = new RString("4");
    private static final RString 左括弧 = new RString("、（");
    private static final RString 右括弧 = new RString("）");
    private static final RString 管内区分 = new RString("1");
    private static final RString 管外区分 = new RString("2");
    private static final RString 項目名_表示有無 = new RString("居宅支援事業者適用切れ_表示有無");
    private static final RString 項目名_表示方法 = new RString("居宅支援事業者履歴_表示方法");
    private static final RString 表示方法 = new RString("0");
    private static final RString 表示方法_星 = new RString("2");
    private static final RString 表示方法_抹消線 = new RString("3");
    private static final RString 年号_明治 = new RString("明治");
    private static final RString 年号_大正 = new RString("大正");
    private static final RString 年号_昭和 = new RString("昭和");
    private static final RString ダブルアスタリスク = new RString("＊＊");
    private static final RString アスタリスク = new RString("＊");
    private static final RString 抹消線 = new RString("―");
    private static final int SIZE_2 = 2;
    private static final int SIZE_3 = 3;
    private static final int INDEX_2 = 2;
    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac dbT7065dac;
    private final DbT7067ChohyoSeigyoHanyoDac dbT7067dac;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通Entity;

    /**
     * コンストラクタです。
     */
    public KaigoHokenShikakushasho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        this.dbT7067dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoHokenShikakushasho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoHokenShikakushasho}のインスタンス
     */
    public static KaigoHokenShikakushasho createInstance() {
        return InstanceProvider.create(KaigoHokenShikakushasho.class);
    }

    /**
     * コンストラクタです。
     *
     * @param provider
     */
    KaigoHokenShikakushasho(
            MapperProvider provider,
            DbT7065ChohyoSeigyoKyotsuDac dbT7065dac,
            DbT7067ChohyoSeigyoHanyoDac dbT7067dac) {
        this.mapperProvider = provider;
        this.dbT7065dac = dbT7065dac;
        this.dbT7067dac = dbT7067dac;
    }

    /**
     * 介護保険資格者証データを作成します。
     *
     * @param business 資格者証発行ビジネス
     * @return KaigoHokenShikakushashoDataBusiness
     */
    public KaigoHokenShikakushashoDataBusiness setKaigoHokenShikakushasho(ShikakushashoHakkoBusiness business) {
        KaigoHokenShikakushashoDataBusiness dataEntity = new KaigoHokenShikakushashoDataBusiness();
        dataEntity.setYukoKigen(dateFormat(business.get有効期限()));
        dataEntity.setHihokenshaNo(business.get被保番号());
        帳票制御共通Entity = dbT7065dac.selectByKey(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100003.getReportId());
        HihokenshaDateEntity hihokenshaDateEntity = getHihokenshajouhou(business.get識別コード());
        dataEntity.setJusho(hihokenshaDateEntity.getJusho());
        dataEntity.setHihokenshaNameKana(hihokenshaDateEntity.getHihokenshaNameKana());
        dataEntity.setHihokenshaName(hihokenshaDateEntity.getHihokenshaName());
        dataEntity.setBirthGengoMeiji(hihokenshaDateEntity.getBirthGengoMeiji());
        dataEntity.setBirthGengoTaisho(hihokenshaDateEntity.getBirthGengoTaisho());
        dataEntity.setBirthGengoShowa(hihokenshaDateEntity.getBirthGengoShowa());
        dataEntity.setBirthYMD(hihokenshaDateEntity.getBirthYMD());
        dataEntity.setSeibetsu(hihokenshaDateEntity.getSeibetsu());
        dataEntity.setKofuYMD(dateFormat(business.get交付日()));
        dataEntity.setYokaigoJotaiKubun(business.get介護状態());
        dataEntity.setNinteiYMD(dateFormat(business.get認定日()));
        dataEntity.setYukoKaishiYMD(dateFormat(business.get有効期間の開始日付()));
        dataEntity.setYukoShuryoYMD(dateFormat(business.get有効期間の終了日付()));
        dataEntity.setKubunShikyuYukoKaishiYMD(dateFormat(business.get区分支給限度額の有効開始日付()));
        dataEntity.setKubunShikyuYukoShuryoYMD(dateFormat(business.get区分支給限度額の有効終了日付()));
        dataEntity.setKizyunngaku(business.get区分支給限度額の基準額());
        dataEntity.setTaniShurui(単位種類);
        dataEntity.setTani(固定文字_単位);
        if (business.getうち種類支給限度基準額の情報() != null) {
            Collections.sort(business.getうち種類支給限度基準額の情報(), new Comparator<ShuruiShikyuGendoKizyunngakuBusiness>() {
                @Override
                public int compare(ShuruiShikyuGendoKizyunngakuBusiness business1, ShuruiShikyuGendoKizyunngakuBusiness business2) {
                    return business1.getServiceShurui().compareTo(business2.getServiceShurui());
                }
            });
            int i = 0;
            List<ShuruiShikyuGendoKizyunngakuBusiness> shikyuGendoKizyungakuList = new ArrayList<>();
            for (ShuruiShikyuGendoKizyunngakuBusiness kizyunngakuBusiness : business.getうち種類支給限度基準額の情報()) {
                if (i < 画面のデータ件数) {
                    shikyuGendoKizyungakuList.add(kizyunngakuBusiness);
                    dataEntity.setShikyuGendoKizyungakuList(shikyuGendoKizyungakuList);
                    dataEntity.getShikyuGendoKizyungakuList().get(i).setShuruiShikyuKizyunngakuTani(固定文字_単位);
                } else {
                    break;
                }
                i = i + 1;
            }
        }
        dataEntity.setServiceShitei(business.get種類の指定());
        for (KyufuseigenBusiness 給付制限の情報 : business.get給付制限の情報()) {
            給付制限の情報.setKyufuseigenKaishiYMD(dateFormat(給付制限の情報.getKyufuseigenKaishiYMD()));
            給付制限の情報.setKyufuseigenShuryoYMD(dateFormat(給付制限の情報.getKyufuseigenShuryoYMD()));
        }
        dataEntity.setKyufuseigenDataList(business.get給付制限の情報());
        ShienJigyoshaDataEntity shienJigyoshaDataEntity = getShienJigyoshajouhou(business);
        dataEntity.setJigyoshaName1(shienJigyoshaDataEntity.getJigyoshaName1());
        dataEntity.setTodokedeYMD1(shienJigyoshaDataEntity.getTodokedeYMD1());
        dataEntity.setJigyoshaName2(shienJigyoshaDataEntity.getJigyoshaName2());
        dataEntity.setJigyoshaName2Asutarisuku(shienJigyoshaDataEntity.getJigyoshaName2Asutarisuku());
        dataEntity.setJigyoshaName2Masshosen(shienJigyoshaDataEntity.getJigyoshaName2Masshosen());
        dataEntity.setTodokedeYMD2(shienJigyoshaDataEntity.getTodokedeYMD2());
        dataEntity.setTodokedeYMD2Asutarisuku(shienJigyoshaDataEntity.getTodokedeYMD2Asutarisuku());
        dataEntity.setTodokedeYMD2Masshosen(shienJigyoshaDataEntity.getTodokedeYMD2Masshosen());
        dataEntity.setJigyoshaName3(shienJigyoshaDataEntity.getJigyoshaName3());
        dataEntity.setJigyoshaName3Asutarisuku(shienJigyoshaDataEntity.getJigyoshaName3Asutarisuku());
        dataEntity.setJigyoshaName3Masshosen(shienJigyoshaDataEntity.getJigyoshaName3Masshosen());
        dataEntity.setTodokedeYMD3(shienJigyoshaDataEntity.getTodokedeYMD3());
        dataEntity.setTodokedeYMD3Asutarisuku(shienJigyoshaDataEntity.getTodokedeYMD3Asutarisuku());
        dataEntity.setTodokedeYMD3Masshosen(shienJigyoshaDataEntity.getTodokedeYMD3Masshosen());
        dataEntity.setNyushoShisetsuShurui(RString.EMPTY);
        for (NyushoShisetsuBusiness nyushoShisetsuBusiness : business.get介護保険施設等の情報()) {
            nyushoShisetsuBusiness.setShisetsuNyushoYMD(dateFormat(nyushoShisetsuBusiness.getShisetsuNyushoYMD()));
            nyushoShisetsuBusiness.setShisetsuTaishoYMD(dateFormat(nyushoShisetsuBusiness.getShisetsuTaishoYMD()));
        }
        dataEntity.setNyushoShisetsuDataList(business.get介護保険施設等の情報());
        dataEntity.setShisetsuNyusho(RString.EMPTY);
        dataEntity.setShisetsuNyuin(RString.EMPTY);
        dataEntity.setShisetsuTaisho(RString.EMPTY);
        dataEntity.setShisetsuTaiin(RString.EMPTY);
        HokenshaBangoMeishoInDataEntity hokenshaBangoMeishoInEntity = getHokenshaBangoMeishoInjouhou(business.get保険者番号());
        dataEntity.setHokenshaNo(hokenshaBangoMeishoInEntity.getHokenshaNo());
        dataEntity.setHokenshaJusho(hokenshaBangoMeishoInEntity.getHokenshaJusho());
        dataEntity.setHokenshaName(hokenshaBangoMeishoInEntity.getHokenshaName());
        dataEntity.setHokenshaTelno(hokenshaBangoMeishoInEntity.getHokenshaTelno());
        dataEntity.setDenshiKoin(hokenshaBangoMeishoInEntity.getDenshiKoin());
        dataEntity.setRemban(null);
        dataEntity.setSubTitle(RString.EMPTY);
        return dataEntity;
    }

    private HihokenshaDateEntity getHihokenshajouhou(RString shikibetsuCode) {
        HihokenshaDateEntity entity = new HihokenshaDateEntity();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                        GyomuCode.DB介護保険,
                        KensakuYusenKubun.住登外優先));
        key.set識別コード(new ShikibetsuCode(RString.isNullOrEmpty(shikibetsuCode) ? RString.EMPTY : shikibetsuCode));
        List<JuminShubetsu> 住民種別 = new ArrayList();
        List<JuminJotai> 住名状態 = new ArrayList();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        住名状態.add(JuminJotai.住民);
        住名状態.add(JuminJotai.住登外);
        住名状態.add(JuminJotai.消除者);
        住名状態.add(JuminJotai.転出者);
        key.set住民種別(住民種別);
        key.set住民状態(住名状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(
                key.getPSM検索キー());
        UaFt200FindShikibetsuTaishoEntity shikibetsuTaishoentity = mapperProvider.create(IKaigoHokenShikakushashoMapper.class)
                .getPsmShikibetsuTaisho(new KaigoHokenShikakushashoParameter(
                                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString())));
        if (shikibetsuTaishoentity != null) {
            RString kannaiKangai = ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get管内管外().code();
            if (管内区分.equals(kannaiKangai)) {
                entity.setJusho(set住所(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity)));
            } else if (管外区分.equals(kannaiKangai)) {
                RStringBuilder jushoSb = new RStringBuilder();
                jushoSb.append(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get住所());
                jushoSb.append(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get番地().getBanchi().value());
                jushoSb.append(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get方書().value());
                entity.setJusho(jushoSb.toRString());
            }
            entity.setHihokenshaNameKana(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get名称().getKana().getColumnValue());
            entity.setHihokenshaName(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get名称().getName().getColumnValue());
            RString birthYMD = setBirthYMD(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get生年月日().toFlexibleDate(),
                    ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住民種別().getCode(),
                    ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get生年月日不詳区分().getColumnValue());
            if (!RString.isNullOrEmpty(birthYMD)) {
                set年号(birthYMD, entity);
            }
            entity.setSeibetsu(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get性別().getCode());
        }
        return entity;

    }

    private RString set住所(IKojin kojin) {
        RStringBuilder 住所 = new RStringBuilder();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        if (帳票独自.equals(帳票制御共通Entity.getJushoHenshuKubun())) {
            if (帳票制御共通Entity.getJushoHenshuTodoufukenMeiHyojiUmu()) {
                住所.append(association.get都道府県名());
            }
            if (帳票制御共通Entity.getJushoHenshuGunMeiHyojiUmu()) {
                住所.append(association.get郡名());
            }
            if (帳票制御共通Entity.getJushoHenshuShichosonMeiHyojiUmu()) {
                住所.append(association.get市町村名());
            }
            if (編集方法_1.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                住所.append(kojin.get住所().get住所());
                住所.append(kojin.get住所().get番地().getBanchi().value());
            } else if (編集方法_2.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                住所.append(kojin.get行政区画().getGyoseiku().get名称());
                住所.append(kojin.get住所().get番地().getBanchi().value());
            } else if (編集方法_3.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                住所.append(kojin.get住所().get住所());
                住所.append(kojin.get住所().get番地().getBanchi().value());
                住所.append(左括弧);
                住所.append(kojin.get行政区画().getGyoseiku().get名称());
                住所.append(右括弧);
            } else if (編集方法_4.equals(帳票制御共通Entity.getJushoHenshuChoikiHenshuHoho())) {
                住所.append(kojin.get住所().get番地().getBanchi().value());
            }
            if (帳票制御共通Entity.getJushoHenshuKatagakiHyojiUmu()) {
                住所.append(kojin.get住所().get方書().value());
            }
        } else if (市町村共通.equals(帳票制御共通Entity.getJushoHenshuKubun())) {
            if (表示する.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(association.get都道府県名());
            }
            if (表示する.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(association.get郡名());
            }
            if (表示する.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(association.get市町村名());
            }
            if (編集方法_1.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(kojin.get住所().get住所());
                住所.append(kojin.get住所().get番地().getBanchi().value());
            } else if (編集方法_2.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(kojin.get行政区画().getGyoseiku().get名称());
                住所.append(kojin.get住所().get番地().getBanchi().value());
            } else if (編集方法_3.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(kojin.get住所().get住所());
                住所.append(kojin.get住所().get番地().getBanchi().value());
                住所.append(左括弧);
                住所.append(kojin.get行政区画().getGyoseiku().get名称());
                住所.append(右括弧);
            } else if (編集方法_4.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(kojin.get住所().get番地().getBanchi().value());
            }
            if (表示する.equals(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無,
                            RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                住所.append(kojin.get住所().get方書().value());
            }
        }
        return 住所.toRString();
    }

    private RString setBirthYMD(FlexibleDate oldBirthYMD, RString juminShubetsuCode, RString seinengappiFushoKubun) {
        RString newBirthYMD = RString.EMPTY;
        if (oldBirthYMD != null && !oldBirthYMD.isEmpty()) {
            if (JuminShubetsu.日本人.getCode().equals(juminShubetsuCode)
                    || JuminShubetsu.住登外個人_日本人.getCode().equals(juminShubetsuCode)) {
                newBirthYMD = set生年月日_日本人(oldBirthYMD);
            }
            if (JuminShubetsu.外国人.getCode().equals(juminShubetsuCode)
                    || JuminShubetsu.住登外個人_外国人.getCode().equals(juminShubetsuCode)) {
                newBirthYMD = set生年月日_外国人(oldBirthYMD, seinengappiFushoKubun);
            }

        }
        return newBirthYMD;
    }

    private RString set生年月日_日本人(FlexibleDate 生年月日) {
        return 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString set生年月日_外国人(FlexibleDate 生年月日, RString 生年月日不詳区分) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
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

    private HihokenshaDateEntity set年号(RString birthYMD, HihokenshaDateEntity entity) {
        RString date = birthYMD.substring(0, INDEX_2);
        birthYMD = birthYMD.substring(INDEX_2);
        if (年号_明治.equals(date)) {
            entity.setBirthGengoTaisho(ダブルアスタリスク);
            entity.setBirthGengoShowa(ダブルアスタリスク);
        } else if (年号_大正.equals(date)) {
            entity.setBirthGengoMeiji(ダブルアスタリスク);
            entity.setBirthGengoShowa(ダブルアスタリスク);
        } else if (年号_昭和.equals(date)) {
            entity.setBirthGengoMeiji(ダブルアスタリスク);
            entity.setBirthGengoTaisho(ダブルアスタリスク);
        } else {
            entity.setBirthGengoMeiji(ダブルアスタリスク);
            entity.setBirthGengoTaisho(ダブルアスタリスク);
            entity.setBirthGengoShowa(ダブルアスタリスク);
        }
        entity.setBirthYMD(birthYMD);
        return entity;
    }

    private ShienJigyoshaDataEntity getShienJigyoshajouhou(ShikakushashoHakkoBusiness business) {
        ShienJigyoshaDataEntity shienJigyoshaDataEntity = new ShienJigyoshaDataEntity();
        if (business.get支援事業者の情報() != null) {
            Collections.sort(business.get支援事業者の情報(), new Comparator<ShienJigyoshaBusiness>() {
                @Override
                public int compare(ShienJigyoshaBusiness business1, ShienJigyoshaBusiness business2) {
                    return business2.getTekiyoKaishiYMD().compareTo(business1.getTekiyoKaishiYMD());
                }
            });
            set支援事業者情報(business, shienJigyoshaDataEntity);
        }
        return shienJigyoshaDataEntity;
    }

    private ShienJigyoshaDataEntity set支援事業者情報(ShikakushashoHakkoBusiness business,
            ShienJigyoshaDataEntity shienJigyoshaDataEntity) {
        RString 最新適用終了日 = business.get支援事業者の情報().isEmpty()
                ? RString.EMPTY : business.get支援事業者の情報().get(0).getTekiyoShuryoYMD();
        RString 最新適用終了日のデータ = null;
        DbT7067ChohyoSeigyoHanyoEntity entity = dbT7067dac.selectByKey(
                SubGyomuCode.DBA介護資格,
                ReportIdDBA.DBA100003.getReportId(),
                new FlexibleYear("0000"),
                項目名_表示有無);
        if (表示しない.equals(entity.getKomokuValue())) {
            if (!RString.isNullOrEmpty(最新適用終了日) && 最新適用終了日.compareTo(business.get交付日()) == -1) {
                最新適用終了日のデータ = RString.EMPTY;
            } else {
                最新適用終了日のデータ = 最新適用終了日;
            }
        } else if (表示する.equals(entity.getKomokuValue())) {
            最新適用終了日のデータ = 最新適用終了日;
        }
        if (!RString.isNullOrEmpty(最新適用終了日のデータ)) {
            shienJigyoshaDataEntity.setJigyoshaName1(business.get支援事業者の情報().get(0).getJigyosha());
            shienJigyoshaDataEntity.setTodokedeYMD1(business.get支援事業者の情報().get(0).getTodokedeYMD());
            setNameAndYMDBy居宅支援事業者履歴(business.get支援事業者の情報(), shienJigyoshaDataEntity);
        }
        return shienJigyoshaDataEntity;
    }

    private void setNameAndYMDBy居宅支援事業者履歴(List<ShienJigyoshaBusiness> list, ShienJigyoshaDataEntity shienJigyoshaDataEntity) {
        DbT7067ChohyoSeigyoHanyoEntity entity = dbT7067dac.selectByKey(
                SubGyomuCode.DBA介護資格,
                ReportIdDBA.DBA100003.getReportId(),
                new FlexibleYear("0000"),
                項目名_表示方法);
        if (表示方法.equals(entity.getKomokuValue())) {
            setNameAndYMD(list, shienJigyoshaDataEntity);
        } else if (表示方法_星.equals(entity.getKomokuValue())) {
            setNameAndYMD(list, shienJigyoshaDataEntity);
            shienJigyoshaDataEntity.setJigyoshaName2Asutarisuku(アスタリスク);
            shienJigyoshaDataEntity.setTodokedeYMD2Asutarisuku(アスタリスク);
            shienJigyoshaDataEntity.setJigyoshaName3Asutarisuku(アスタリスク);
            shienJigyoshaDataEntity.setTodokedeYMD3Asutarisuku(アスタリスク);
        } else if (表示方法_抹消線.equals(entity.getKomokuValue())) {
            setNameAndYMD(list, shienJigyoshaDataEntity);
            shienJigyoshaDataEntity.setJigyoshaName2Masshosen(抹消線);
            shienJigyoshaDataEntity.setTodokedeYMD2Masshosen(抹消線);
            shienJigyoshaDataEntity.setJigyoshaName3Masshosen(抹消線);
            shienJigyoshaDataEntity.setTodokedeYMD3Masshosen(抹消線);
        }
    }

    private void setNameAndYMD(List<ShienJigyoshaBusiness> list, ShienJigyoshaDataEntity shienJigyoshaDataEntity) {
        if (list.size() >= SIZE_2) {
            shienJigyoshaDataEntity.setJigyoshaName2(list.get(1).getJigyosha());
            shienJigyoshaDataEntity.setTodokedeYMD2(list.get(1).getTodokedeYMD());
        }
        if (list.size() >= SIZE_3) {
            shienJigyoshaDataEntity.setJigyoshaName3(list.get(2).getJigyosha());
            shienJigyoshaDataEntity.setTodokedeYMD3(list.get(2).getTodokedeYMD());
        }
    }

    private HokenshaBangoMeishoInDataEntity getHokenshaBangoMeishoInjouhou(RString hihokenshaNo) {
        HokenshaBangoMeishoInDataEntity entity = new HokenshaBangoMeishoInDataEntity();
        entity.setHokenshaNo(hihokenshaNo);
        entity.setHokenshaJusho(DbBusinessConfig.get(ConfigNameDBU.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        entity.setHokenshaName(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        entity.setHokenshaTelno(DbBusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        return entity;
    }

    private RString dateFormat(RString date) {
        return RString.isNullOrEmpty(date) ? RString.EMPTY : new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }
}

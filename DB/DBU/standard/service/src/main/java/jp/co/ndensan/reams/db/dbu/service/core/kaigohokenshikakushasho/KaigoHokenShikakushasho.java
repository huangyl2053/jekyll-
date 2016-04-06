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
import jp.co.ndensan.reams.db.dbu.definition.mybatis.param.kaigohokenshikakushasho.KaigoHokenShikakushashoParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.HihokenshaDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.HokenshaBangoMeishoInDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.KaigoHokenShikakushashoDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShienJigyoshaDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShienJigyoshaEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShikakushashoHakkoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokenshikakushasho.ShuruiShikyuGendoKizyunngakuEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigohokenshikakushasho.IKaigoHokenShikakushashoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
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
    // TODO QA:1035 Redmine# (実装できない)
//    private static final RString 印字する = new RString("1");
//    private static final RString 印字しない = new RString("0");
    private static final RString 適用切れ非表示 = new RString("0");
    private static final RString 適用切れ表示 = new RString("1");
    private static final RString 居宅支援事業者履歴_0 = new RString("0");
    private static final RString 居宅支援事業者履歴_2 = new RString("2");
    private static final RString 居宅支援事業者履歴_3 = new RString("3");
    // TODO QA:1035 Redmine# (実装できない)
//    private static final RString 帳票独自区分_1 = new RString("1");
//    private static final RString 帳票独自区分_0 = new RString("0");
//    private static final RString 都道府県名付与有無_1 = new RString("1");
//    private static final RString 都道府県名付与有無_0 = new RString("0");
//    private static final RString 郡名付与有無_1 = new RString("1");
//    private static final RString 郡名付与有無_0 = new RString("0");
//    private static final RString 市町村名付与有無_1 = new RString("1");
//    private static final RString 市町村名付与有無_0 = new RString("0");
//    private static final RString 編集方法_1 = new RString("1");
//    private static final RString 編集方法_2 = new RString("2");
//    private static final RString 編集方法_3 = new RString("3");
//    private static final RString 編集方法_4 = new RString("4");
//    private static final RString 編集方法_5 = new RString("5");
//    private static final RString 方書表示有無_1 = new RString("1");
//    private static final RString 方書表示有無_0 = new RString("0");
    private static final RString 管内区分 = new RString("1");
    private static final RString 管外区分 = new RString("2");
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

    /**
     * コンストラクタです。
     */
    public KaigoHokenShikakushasho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
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
    KaigoHokenShikakushasho(MapperProvider provider) {
        this.mapperProvider = provider;
    }

    /**
     * 介護保険資格者証データを作成します。
     *
     * @param entity 資格者証発行Entity
     * @return KaigoHokenShikakushashoDataEntity
     */
    public KaigoHokenShikakushashoDataEntity setKaigoHokenShikakushasho(ShikakushashoHakkoEntity entity) {
        KaigoHokenShikakushashoDataEntity dataEntity = new KaigoHokenShikakushashoDataEntity();
        dataEntity.setYukoKigen(entity.getYukoKigen());
        dataEntity.setHihokenshaNo(entity.getHihokenshaNo());
        HihokenshaDateEntity hihokenshaDateEntity = getHihokenshajouhou(entity.getShikibetsuCode());
        dataEntity.setJusho(hihokenshaDateEntity.getJusho());
        dataEntity.setHihokenshaNameKana(hihokenshaDateEntity.getHihokenshaNameKana());
        dataEntity.setHihokenshaName(hihokenshaDateEntity.getHihokenshaName());
        dataEntity.setBirthGengoMeiji(hihokenshaDateEntity.getBirthGengoMeiji());
        dataEntity.setBirthGengoTaisho(hihokenshaDateEntity.getBirthGengoTaisho());
        dataEntity.setBirthGengoShowa(hihokenshaDateEntity.getBirthGengoShowa());
        dataEntity.setBirthYMD(hihokenshaDateEntity.getBirthYMD());
        dataEntity.setSeibetsu(hihokenshaDateEntity.getSeibetsu());
        dataEntity.setKofuYMD(entity.getKofuYMD());
        dataEntity.setYokaigoJotaiKubun(YokaigoJotaiKubun09.toValue(entity.getYokaigoJotai()).get名称());
        dataEntity.setNinteiYMD(entity.getNinteiYMD());
        dataEntity.setYukoKaishiYMD(entity.getYukoKaishiYMD());
        dataEntity.setYukoShuryoYMD(entity.getYukoShuryoYMD());
        dataEntity.setKubunShikyuYukoKaishiYMD(entity.getKubunShikyuYukoKaishiYMD());
        dataEntity.setKubunShikyuYukoShuryoYMD(entity.getKubunShikyuYukoShuryoYMD());
        dataEntity.setKizyunngaku(entity.getKubunShikyuKizyunngaku());
        dataEntity.setTaniShurui(単位種類);
        dataEntity.setTani(固定文字_単位);
        if (entity.getShikyuGendoKizyungakuList() != null) {
            Collections.sort(entity.getShikyuGendoKizyungakuList(), new Comparator<ShuruiShikyuGendoKizyunngakuEntity>() {
                @Override
                public int compare(ShuruiShikyuGendoKizyunngakuEntity entity1, ShuruiShikyuGendoKizyunngakuEntity entity2) {
                    return entity1.getServiceShurui().compareTo(entity2.getServiceShurui());
                }
            });
            int i = 0;
            List<ShuruiShikyuGendoKizyunngakuEntity> shikyuGendoKizyungakuList = new ArrayList<>();
            for (ShuruiShikyuGendoKizyunngakuEntity kizyunngakuEntity : entity.getShikyuGendoKizyungakuList()) {
                if (i < 画面のデータ件数) {
                    shikyuGendoKizyungakuList.add(kizyunngakuEntity);
                    dataEntity.setShikyuGendoKizyungakuList(shikyuGendoKizyungakuList);
                    dataEntity.getShikyuGendoKizyungakuList().get(i).setShuruiShikyuKizyunngakuTani(固定文字_単位);
                } else {
                    break;
                }
                i = i + 1;
            }
        }
        dataEntity.setServiceShitei(entity.getServiceShitei());
        dataEntity.setKyufuseigenNaiyo(entity.getSeigenNaiyo());
        dataEntity.setKyufuseigenKaishiYMD(entity.getSeigenKaishiYMD());
        dataEntity.setKyufuseigenShuryoYMD(entity.getSeigenShuryoYMD());
        dataEntity.setJigyoshaName1(getShienJigyoshajouhou(entity).getJigyoshaName1());
        dataEntity.setTodokedeYMD1(getShienJigyoshajouhou(entity).getTodokedeYMD1());
        dataEntity.setJigyoshaName2(getShienJigyoshajouhou(entity).getJigyoshaName2());
        dataEntity.setJigyoshaName2Asutarisuku(getShienJigyoshajouhou(entity).getJigyoshaName2Asutarisuku());
        dataEntity.setJigyoshaName2Masshosen(getShienJigyoshajouhou(entity).getJigyoshaName2Masshosen());
        dataEntity.setTodokedeYMD2(getShienJigyoshajouhou(entity).getTodokedeYMD2());
        dataEntity.setTodokedeYMD2Asutarisuku(getShienJigyoshajouhou(entity).getTodokedeYMD2Asutarisuku());
        dataEntity.setTodokedeYMD2Masshosen(getShienJigyoshajouhou(entity).getTodokedeYMD2Masshosen());
        dataEntity.setJigyoshaName3(getShienJigyoshajouhou(entity).getJigyoshaName3());
        dataEntity.setJigyoshaName3Asutarisuku(getShienJigyoshajouhou(entity).getJigyoshaName3Asutarisuku());
        dataEntity.setJigyoshaName3Masshosen(getShienJigyoshajouhou(entity).getJigyoshaName3Masshosen());
        dataEntity.setTodokedeYMD3(getShienJigyoshajouhou(entity).getTodokedeYMD3());
        dataEntity.setTodokedeYMD3Asutarisuku(getShienJigyoshajouhou(entity).getTodokedeYMD3Asutarisuku());
        dataEntity.setTodokedeYMD3Masshosen(getShienJigyoshajouhou(entity).getTodokedeYMD3Masshosen());
        dataEntity.setNyushoShisetsuShurui(RString.EMPTY);
        dataEntity.setNyushoShisetsuName(entity.getNyushoShisetsu());
        dataEntity.setShisetsuNyushoYMD(entity.getNyushoYMD());
        dataEntity.setShisetsuTaishoYMD(entity.getTaishoYMD());
        dataEntity.setShisetsuNyusho(RString.EMPTY);
        dataEntity.setShisetsuNyuin(RString.EMPTY);
        dataEntity.setShisetsuTaisho(RString.EMPTY);
        dataEntity.setShisetsuTaiin(RString.EMPTY);
        HokenshaBangoMeishoInDataEntity hokenshaBangoMeishoInEntity = getHokenshaBangoMeishoInjouhou(entity.getHokenshaNo());
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
                set住所();
            } else if (管外区分.equals(kannaiKangai)) {
                RStringBuilder jushoSb = new RStringBuilder();
                jushoSb.append(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get住所());
                jushoSb.append(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get番地());
                jushoSb.append(ShikibetsuTaishoFactory.createKojin(shikibetsuTaishoentity).get住所().get方書());
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

    private RString set住所() {
        // TODO QA:1035 Redmine# (実装できない)
//        if (帳票独自区分_1.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_帳票独自区分, SubGyomuCode.DBD介護受給))) {
//
//            if (都道府県名付与有無_1.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_都道府県名付与有無, SubGyomuCode.DBD介護受給))) {
//
//            } else if (都道府県名付与有無_0.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_都道府県名付与有無, SubGyomuCode.DBD介護受給))) {
//
//            }
//            if (郡名付与有無_1.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_郡名付与有無, SubGyomuCode.DBD介護受給))) {
//
//            } else if (郡名付与有無_0.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_郡名付与有無, SubGyomuCode.DBD介護受給))) {
//
//            }
//            if (市町村名付与有無_1.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_市町村名付与有無, SubGyomuCode.DBD介護受給))) {
//
//            } else if (市町村名付与有無_0.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_市町村名付与有無, SubGyomuCode.DBD介護受給))) {
//
//            }
//            if (編集方法_1.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_編集方法, SubGyomuCode.DBD介護受給))) {
//
//            } else if (編集方法_2.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_編集方法, SubGyomuCode.DBD介護受給))) {
//
//            } else if (編集方法_3.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_編集方法, SubGyomuCode.DBD介護受給))) {
//
//            } else if (編集方法_4.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_編集方法, SubGyomuCode.DBD介護受給))) {
//
//            } else if (編集方法_5.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_編集方法, SubGyomuCode.DBD介護受給))) {
//
//            }
//            if (方書表示有無_1.equals(BusinessConfig.get(ConfigNameDBD.資格者証_住所編集_方書表示有無, SubGyomuCode.DBD介護受給))) {
//
//            } else if (方書表示有無_0.equals(BusinessConfig.get(ConfigNameDBD.資格者証_住所編集_方書表示有無, SubGyomuCode.DBD介護受給))) {
//
//            }
//        } else if (帳票独自区分_0.equals(BusinessConfig.get(ConfigNameDBD.資格者証_管内住所編集_帳票独自区分, SubGyomuCode.DBD介護受給))) {
//            BusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集, SubGyomuCode.DBU介護統計報告);
//        }
        return null;
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
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, SubGyomuCode.DBU介護統計報告);
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
            entity.setBirthGengoMeiji(年号_明治);
            entity.setBirthGengoTaisho(ダブルアスタリスク);
            entity.setBirthGengoShowa(ダブルアスタリスク);
        } else if (年号_大正.equals(date)) {
            entity.setBirthGengoMeiji(ダブルアスタリスク);
            entity.setBirthGengoTaisho(年号_大正);
            entity.setBirthGengoShowa(ダブルアスタリスク);
        } else if (年号_昭和.equals(date)) {
            entity.setBirthGengoMeiji(ダブルアスタリスク);
            entity.setBirthGengoTaisho(ダブルアスタリスク);
            entity.setBirthGengoShowa(年号_昭和);
        } else {
            entity.setBirthGengoMeiji(ダブルアスタリスク);
            entity.setBirthGengoTaisho(ダブルアスタリスク);
            entity.setBirthGengoShowa(ダブルアスタリスク);
        }
        entity.setBirthYMD(birthYMD);
        return entity;
    }

    private ShienJigyoshaDataEntity getShienJigyoshajouhou(ShikakushashoHakkoEntity entity) {
        ShienJigyoshaDataEntity shienJigyoshaDataEntity = new ShienJigyoshaDataEntity();
        if (entity.getShienJigyoshaList() != null) {
            Collections.sort(entity.getShienJigyoshaList(), new Comparator<ShienJigyoshaEntity>() {
                @Override
                public int compare(ShienJigyoshaEntity entity1, ShienJigyoshaEntity entity2) {
                    return entity2.getTekiyoKaishiYMD().compareTo(entity1.getTekiyoKaishiYMD());
                }
            });
            set支援事業者情報(entity, shienJigyoshaDataEntity);
        }
        return shienJigyoshaDataEntity;
    }

    private ShienJigyoshaDataEntity set支援事業者情報(ShikakushashoHakkoEntity entity,
            ShienJigyoshaDataEntity shienJigyoshaDataEntity) {
        if (適用切れ非表示.equals(BusinessConfig.get(ConfigNameDBD.資格者証表示方法_居宅支援事業者, SubGyomuCode.DBD介護受給))) {
            if (RString.isNullOrEmpty(entity.getShienJigyoshaList().get(0).getTekiyoKaishiYMD())) {
                shienJigyoshaDataEntity.setJigyoshaName1(entity.getShienJigyoshaList().get(0).getJigyosha());
                shienJigyoshaDataEntity.setTodokedeYMD1(entity.getShienJigyoshaList().get(0).getTodokedeYMD());
            }
            if (entity.getShienJigyoshaList().get(1).getTekiyoKaishiYMD().compareTo(entity.getKofuYMD()) >= -1) {
                setNameAndYMD(entity.getShienJigyoshaList(), shienJigyoshaDataEntity);
            }
        } else if (適用切れ表示.equals(BusinessConfig.get(ConfigNameDBD.資格者証表示方法_居宅支援事業者, SubGyomuCode.DBD介護受給))
                && (RString.isNullOrEmpty(entity.getShienJigyoshaList().get(0).getTekiyoKaishiYMD())
                || entity.getShienJigyoshaList().get(0).getTekiyoKaishiYMD().compareTo(entity.getKofuYMD()) == -1)) {
            shienJigyoshaDataEntity.setJigyoshaName1(entity.getShienJigyoshaList().get(0).getJigyosha());
            shienJigyoshaDataEntity.setTodokedeYMD1(entity.getShienJigyoshaList().get(0).getTodokedeYMD());
            setNameAndYMDBy居宅支援事業者履歴(entity.getShienJigyoshaList(), shienJigyoshaDataEntity);
        }
        return shienJigyoshaDataEntity;
    }

    private void setNameAndYMDBy居宅支援事業者履歴(List<ShienJigyoshaEntity> list, ShienJigyoshaDataEntity shienJigyoshaDataEntity) {
        if (居宅支援事業者履歴_0.equals(
                BusinessConfig.get(ConfigNameDBD.資格者証表示方法_居宅支援事業者履歴, SubGyomuCode.DBD介護受給))) {
            setNameAndYMD(list, shienJigyoshaDataEntity);
        } else if (居宅支援事業者履歴_2.equals(
                BusinessConfig.get(ConfigNameDBD.資格者証表示方法_居宅支援事業者履歴, SubGyomuCode.DBD介護受給))) {
            setNameAndYMD(list, shienJigyoshaDataEntity);
            shienJigyoshaDataEntity.setJigyoshaName2Asutarisuku(アスタリスク);
            shienJigyoshaDataEntity.setTodokedeYMD2Asutarisuku(アスタリスク);
            shienJigyoshaDataEntity.setJigyoshaName3Asutarisuku(アスタリスク);
            shienJigyoshaDataEntity.setTodokedeYMD3Asutarisuku(アスタリスク);
        } else if (居宅支援事業者履歴_3.equals(
                BusinessConfig.get(ConfigNameDBD.資格者証表示方法_居宅支援事業者履歴, SubGyomuCode.DBD介護受給))) {
            setNameAndYMD(list, shienJigyoshaDataEntity);
            shienJigyoshaDataEntity.setJigyoshaName2Masshosen(抹消線);
            shienJigyoshaDataEntity.setTodokedeYMD2Masshosen(抹消線);
            shienJigyoshaDataEntity.setJigyoshaName3Masshosen(抹消線);
            shienJigyoshaDataEntity.setTodokedeYMD3Masshosen(抹消線);
        }
    }

    private void setNameAndYMD(List<ShienJigyoshaEntity> list, ShienJigyoshaDataEntity shienJigyoshaDataEntity) {
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
        entity.setHokenshaJusho(BusinessConfig.get(ConfigNameDBU.保険者情報_住所, SubGyomuCode.DBU介護統計報告));
        entity.setHokenshaName(BusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, SubGyomuCode.DBU介護統計報告));
        entity.setHokenshaTelno(BusinessConfig.get(ConfigNameDBU.保険者情報_電話番号, SubGyomuCode.DBU介護統計報告));
        // TODO QA:1035 Redmine# (実装できない)
//        if (印字する.equals(BusinessConfig.get(ConfigNameDBD.資格者証_電子公印出力制御_印字有無, SubGyomuCode.DBD介護受給))) {
//            INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
//            INinshoshaSourceBuilder builder = builderCreator.create(
//                    GyomuCode.DB介護保険,
//                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                    null,
//                    null);
//            entity.setDenshiKoin(builder.buildSource().denshiKoin);
//        } else if (印字しない.equals(BusinessConfig.get(ConfigNameDBD.資格者証_電子公印出力制御_印字有無, SubGyomuCode.DBD介護受給))) {
//            INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
//            INinshoshaSourceBuilder builder = builderCreator.create(
//                    GyomuCode.DB介護保険,
//                    NinshoshaDenshikoinshubetsuCode.印の字.getコード(),
//                    null,
//                    null);
//            entity.setDenshiKoin(builder.buildSource().denshiKoin);
//        }
        return entity;
    }

}

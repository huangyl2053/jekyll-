/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.benmeisyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo.BenmeiAtenaParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo.BenmeisyoMapperParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.benmeisyo.BenmeiJohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.benmeisyo.BenmeiJohoResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.benmeisyo.BenmeisyoTyohyoDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.benmeisyo.HihokenshaDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.benmeisyo.NinshoshaDenshiKoinDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.benmeisyo.BenmeisyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 弁明書のFinderクラスです。
 */
public class BenmeisyoFinder {

    private static final RString 文言_部分 = new RString("@@@@");
    private static final int 長_4 = 4;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public BenmeisyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider
     * @param iReportWriter
     */
    BenmeisyoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
//        this.iReportWriter = InstanceProvider.createWithCustomize(IReportWriter.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link BenmeisyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link BenmeisyoFinder}のインスタンス
     */
    public static BenmeisyoFinder createInstance() {
        return new BenmeisyoFinder();
    }

    /**
     * 画面のデータより、弁明書の帳票出力用データEntityを作成します。
     *
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @param 審査請求届出日 審査請求届出日
     * @return benmeisyoTyohyoDataEntity 弁明書の帳票出力用データEntity
     */
    public BenmeisyoTyohyoDataEntity setBenmeisyoTyohyoData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {
        BenmeisyoTyohyoDataEntity benmeisyoTyohyoDataEntity = new BenmeisyoTyohyoDataEntity();
        benmeisyoTyohyoDataEntity.set送付先郵便番号(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_郵便番号,
                SubGyomuCode.DBU介護統計報告));
        benmeisyoTyohyoDataEntity.set送付先住所(this.get送付先住所());
        benmeisyoTyohyoDataEntity.set送付先名称(this.get送付先名称());
        BenmeiJohoEntity benmeiJohoEntity = this.getBenmeiJohoData(識別コード, 被保険者番号, 審査請求届出日);
        benmeisyoTyohyoDataEntity.set弁明書作成日(benmeiJohoEntity.get弁明書作成日());
        benmeisyoTyohyoDataEntity.set弁明の件名(benmeiJohoEntity.get弁明の件名());
        benmeisyoTyohyoDataEntity.set弁明の内容(benmeiJohoEntity.get弁明の内容());
        NinshoshaDenshiKoinDataEntity ninshoshaDenshiKoinDataEntity = this.getNinshoshaDenshiKoinData(benmeiJohoEntity);
        benmeisyoTyohyoDataEntity.set認証者役職名(ninshoshaDenshiKoinDataEntity.get認証者役職名());
        benmeisyoTyohyoDataEntity.set認証者氏名(ninshoshaDenshiKoinDataEntity.get認職者氏名());
        benmeisyoTyohyoDataEntity.set電子公印(ninshoshaDenshiKoinDataEntity.get電子公印());
        benmeisyoTyohyoDataEntity.set公印省略(ninshoshaDenshiKoinDataEntity.get公印省略());
        benmeisyoTyohyoDataEntity.set公印文字列(ninshoshaDenshiKoinDataEntity.get公印文字列());
        benmeisyoTyohyoDataEntity.set文言(this.get文言(審査請求届出日));
        benmeisyoTyohyoDataEntity.set被保険者番号(被保険者番号);
        HihokenshaDateEntity hihokenshaDateEntity = this.getHihokenshaDate(識別コード);
        benmeisyoTyohyoDataEntity.set被保険者氏名(hihokenshaDateEntity.get氏名());
        benmeisyoTyohyoDataEntity.set被保険者郵便番号(hihokenshaDateEntity.get郵便番号());
        benmeisyoTyohyoDataEntity.set被保険者住所(hihokenshaDateEntity.get住所());
        benmeisyoTyohyoDataEntity.set被保険者生年月日(hihokenshaDateEntity.get生年月日());
        benmeisyoTyohyoDataEntity.set被保険者性別(hihokenshaDateEntity.get性別());
        return benmeisyoTyohyoDataEntity;
    }

    private RString get送付先住所() {
        StringBuilder 送付先住所 = new StringBuilder();
        送付先住所.append(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_住所１, SubGyomuCode.DBU介護統計報告));
        送付先住所.append(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_住所２, SubGyomuCode.DBU介護統計報告));
        送付先住所.append(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_住所３, SubGyomuCode.DBU介護統計報告));
        return new RString(送付先住所.toString());
    }

    private RString get送付先名称() {
        StringBuilder 送付先名称 = new StringBuilder();
        送付先名称.append(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_名称１, SubGyomuCode.DBU介護統計報告));
        送付先名称.append(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_名称２, SubGyomuCode.DBU介護統計報告));
        return new RString(送付先名称.toString());
    }

    private RString get文言(FlexibleDate 審査請求届出日) {
        RString 文言１ = BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_定型文_文言１, SubGyomuCode.DBU介護統計報告);
        RString 文言２ = BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_定型文_文言２, SubGyomuCode.DBU介護統計報告);
        RString 文言３ = BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_定型文_文言３, SubGyomuCode.DBU介護統計報告);
        StringBuilder 文言 = new StringBuilder();
        if (文言１.equals(文言_部分)) {
            RString 部分1 = 文言１.substring(0, 文言１.indexOf("@"));
            RString 部分2 = 審査請求届出日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
            RString 部分3 = 文言１.substring(文言１.indexOf("@") + 長_4);
            StringBuilder new文言１ = new StringBuilder();
            new文言１.append(部分1);
            new文言１.append(部分2);
            new文言１.append(部分3);
            文言.append(new文言１);
        } else {
            文言.append(文言１);
        }
        if (文言２.equals(文言_部分)) {
            RString 部分1 = 文言２.substring(0, 文言２.indexOf("@"));
            RString 部分2 = 審査請求届出日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
            RString 部分3 = 文言２.substring(文言２.indexOf("@") + 長_4);
            StringBuilder new文言２ = new StringBuilder();
            new文言２.append(部分1);
            new文言２.append(部分2);
            new文言２.append(部分3);
            文言.append(new文言２);
        } else {
            文言.append(文言２);
        }
        if (文言３.equals(文言_部分)) {
            RString 部分1 = 文言３.substring(0, 文言３.indexOf("@"));
            RString 部分2 = 審査請求届出日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString();
            RString 部分3 = 文言３.substring(文言３.indexOf("@") + 長_4);
            StringBuilder new文言３ = new StringBuilder();
            new文言３.append(部分1);
            new文言３.append(部分2);
            new文言３.append(部分3);
            文言.append(new文言３);
        } else {
            文言.append(文言３);
        }
        return new RString(文言.toString());
    }

    private BenmeiJohoEntity getBenmeiJohoData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日) {
        BenmeisyoMapper benmeisyoMapper = mapperProvider.create(BenmeisyoMapper.class);
        BenmeiJohoEntity entity = new BenmeiJohoEntity();
        BenmeiJohoResultEntity resultentity = benmeisyoMapper.getBenmeijoho(BenmeisyoMapperParameter.
                createSelectByKeyParam(識別コード, 被保険者番号, 審査請求届出日));
        entity.set弁明書作成日(resultentity.get弁明書作成日());
        if (resultentity.get処分種類コード() != null && !resultentity.get処分種類コード().isEmpty()) {
            entity.set弁明の件名(ShobunShuruiCode.toValue(resultentity.get処分種類コード()).get名称());
        }
        entity.set弁明の内容(resultentity.get弁明内容());
        return entity;
    }

    private HihokenshaDateEntity getHihokenshaDate(ShikibetsuCode 識別コード) {
        BenmeisyoMapper benmeisyoMapper = mapperProvider.create(BenmeisyoMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = benmeisyoMapper.selectAtena(BenmeiAtenaParameter.
                createSelectByKeyParam(識別コード, this.getPsm()));
        HihokenshaDateEntity hihokenEntity = new HihokenshaDateEntity();
        hihokenEntity.set氏名(ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報).get名称());
        hihokenEntity.set郵便番号(ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報).get住所().get郵便番号());
        StringBuilder 住所 = new StringBuilder();
        住所.append(ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報).get住所().get住所());
        住所.append(ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報).get住所().get番地());
        住所.append("　");
        住所.append(ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報).get住所().get方書());
        hihokenEntity.set住所(new RString(住所.toString()));
        FlexibleDate 生年月日 = ShikibetsuTaishoFactory.createShikibetsuTaisho(宛名情報).to個人().get生年月日().toFlexibleDate();
        hihokenEntity.set生年月日(生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        hihokenEntity.set性別(ShikibetsuTaishoFactory.createKojin(宛名情報).to個人().get性別().getName());
        return hihokenEntity;
    }

    private RString getPsm() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        juminJotaiList.add(JuminJotai.死亡者);
        key.set住民状態(juminJotaiList);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
    }

    private NinshoshaDenshiKoinDataEntity getNinshoshaDenshiKoinData(BenmeiJohoEntity entity) {
        NinshoshaDenshiKoinDataEntity ninshoshaDenshiKoinDataEntity = new NinshoshaDenshiKoinDataEntity();
        RString 種別コード = new RString(BusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_認証者_種別コード,
                SubGyomuCode.DBU介護統計報告).toString());
        NinshoshaSource ninshoshaSource = this.getNinshoshaSource(種別コード, entity);
        ninshoshaDenshiKoinDataEntity.set認証者役職名(ninshoshaSource.ninshoshaYakushokuMei);
        ninshoshaDenshiKoinDataEntity.set認職者氏名(ninshoshaSource.ninshoshaShimeiKakeru);
        ninshoshaDenshiKoinDataEntity.set電子公印(ninshoshaSource.denshiKoin);
        ninshoshaDenshiKoinDataEntity.set公印省略(ninshoshaSource.koinShoryaku);
        ninshoshaDenshiKoinDataEntity.set公印文字列(ninshoshaSource.koinMojiretsu);
        return ninshoshaDenshiKoinDataEntity;
    }

    //TODO LDNS-863 Reams_本開発課題一覧_技術点 No:34
    private NinshoshaSource getNinshoshaSource(RString 種別コード, BenmeiJohoEntity entity) {
        INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
        INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(
                GyomuCode.DB介護保険, 種別コード, entity.get弁明書作成日().toRDate(), RString.EMPTY);
        return ninshoshaSourceBuilder.buildSource();
    }

}

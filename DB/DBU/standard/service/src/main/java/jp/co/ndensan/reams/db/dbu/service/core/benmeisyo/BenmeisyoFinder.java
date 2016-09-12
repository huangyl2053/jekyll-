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
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo.BenmeiJohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo.BenmeiJohoResultEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo.BenmeisyoTyohyoDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo.HihokenshaDateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo.NinshoshaDenshiKoinDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.benmeisyo.IBenmeisyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShobunShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 弁明書のFinderクラスです。
 *
 * @reamsid_L DBU-1080-010 zhengshukai
 *
 */
public class BenmeisyoFinder {

    private static final RString 文言_部分 = new RString("@@@@");
    private static final ReportId 帳票分類ID = new ReportId("DBU100001_Bemmeisyo");
    private static final int 長_4 = 4;
    private final MapperProvider mapperProvider;
    private final DbT7065ChohyoSeigyoKyotsuDac dac;

    /**
     * コンストラクタです。
     */
    public BenmeisyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider
     * @param iReportWriter
     */
    BenmeisyoFinder(MapperProvider mapperProvider, DbT7065ChohyoSeigyoKyotsuDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
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
     * @param reportSourceWriter ReportSourceWriter
     * @return benmeisyoTyohyoDataEntity 弁明書の帳票出力用データEntity
     */
    public BenmeisyoTyohyoDataEntity setBenmeisyoTyohyoData(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleDate 審査請求届出日,
            ReportSourceWriter reportSourceWriter) {
        BenmeisyoTyohyoDataEntity benmeisyoTyohyoDataEntity = new BenmeisyoTyohyoDataEntity();
        benmeisyoTyohyoDataEntity.set送付先郵便番号(DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_郵便番号, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告));
        benmeisyoTyohyoDataEntity.set送付先住所(get送付先住所());
        benmeisyoTyohyoDataEntity.set送付先名称(get送付先名称());
        BenmeiJohoEntity benmeiJohoEntity = getBenmeiJohoData(識別コード, 被保険者番号, 審査請求届出日);
        if (benmeiJohoEntity != null) {
            benmeisyoTyohyoDataEntity.set弁明書作成日(benmeiJohoEntity.get弁明書作成日());
            benmeisyoTyohyoDataEntity.set弁明の件名(benmeiJohoEntity.get弁明の件名());
            benmeisyoTyohyoDataEntity.set弁明の内容(benmeiJohoEntity.get弁明の内容());
            if (benmeiJohoEntity.get弁明書作成日() != null && !benmeiJohoEntity.get弁明書作成日().isEmpty()) {
                NinshoshaDenshiKoinDataEntity 認証者 = getNinshoshaDenshiKoinData(benmeiJohoEntity.get弁明書作成日(), reportSourceWriter);
                benmeisyoTyohyoDataEntity.set認証者役職名(認証者.get認証者役職名());
                benmeisyoTyohyoDataEntity.set認職者氏名(認証者.get認職者氏名());
                benmeisyoTyohyoDataEntity.set電子公印(認証者.get電子公印());
                benmeisyoTyohyoDataEntity.set公印省略(認証者.get公印省略());
                benmeisyoTyohyoDataEntity.set公印文字列(認証者.get公印文字列());
            }
        }
        benmeisyoTyohyoDataEntity.set文言(get文言(審査請求届出日));
        benmeisyoTyohyoDataEntity.set被保険者番号(被保険者番号);
        HihokenshaDateEntity hihokenshaDateEntity = getHihokenshaDate(識別コード);
        benmeisyoTyohyoDataEntity.set被保険者氏名(hihokenshaDateEntity.get氏名());
        benmeisyoTyohyoDataEntity.set被保険者郵便番号(hihokenshaDateEntity.get郵便番号());
        benmeisyoTyohyoDataEntity.set被保険者住所(hihokenshaDateEntity.get住所());
        benmeisyoTyohyoDataEntity.set被保険者生年月日(hihokenshaDateEntity.get生年月日());
        benmeisyoTyohyoDataEntity.set被保険者性別(hihokenshaDateEntity.get性別());
        return benmeisyoTyohyoDataEntity;
    }

    private RString get送付先住所() {
        StringBuilder 送付先住所 = new StringBuilder();
        送付先住所.append(DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_住所１, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        送付先住所.append(DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_住所２, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        送付先住所.append(DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_住所３, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        return new RString(送付先住所.toString());
    }

    private RString get送付先名称() {
        StringBuilder 送付先名称 = new StringBuilder();
        送付先名称.append(DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_名称１, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        送付先名称.append(DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_送付先情報_名称２, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        return new RString(送付先名称.toString());
    }

    private RString get文言(FlexibleDate 審査請求届出日) {
        RString 文言１ = DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_定型文_文言１, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 文言２ = DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_定型文_文言２, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        RString 文言３ = DbBusinessConfig.get(ConfigNameDBU.不服申し立て弁明書_定型文_文言３, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        StringBuilder 文言 = new StringBuilder();
        if (文言１.contains(文言_部分)) {
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
        if (文言２.contains(文言_部分)) {
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
        if (文言３.contains(文言_部分)) {
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
        IBenmeisyoMapper benmeisyoMapper = mapperProvider.create(IBenmeisyoMapper.class);
        BenmeiJohoEntity entity = new BenmeiJohoEntity();
        BenmeiJohoResultEntity resultentity = benmeisyoMapper.getBenmeijoho(BenmeisyoMapperParameter.
                createSelectByKeyParam(識別コード, 被保険者番号, 審査請求届出日));
        if (resultentity != null) {
            if (resultentity.get弁明書作成日() != null && !resultentity.get弁明書作成日().isEmpty()) {
                entity.set弁明書作成日(resultentity.get弁明書作成日());
            }
            if (resultentity.get処分種類コード() != null && !resultentity.get処分種類コード().isEmpty()) {
                entity.set弁明の件名(ShobunShuruiCode.toValue(resultentity.get処分種類コード()).get名称());
            }
            if (resultentity.get弁明内容() != null && !resultentity.get弁明内容().isEmpty()) {
                entity.set弁明の内容(resultentity.get弁明内容());
            }
        }
        return entity;
    }

    private HihokenshaDateEntity getHihokenshaDate(ShikibetsuCode 識別コード) {
        IBenmeisyoMapper benmeisyoMapper = mapperProvider.create(IBenmeisyoMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名情報 = benmeisyoMapper.selectAtena(BenmeiAtenaParameter.
                createSelectByKeyParam(識別コード, this.getPsm()));
        HihokenshaDateEntity hihokenEntity = new HihokenshaDateEntity();
        if (宛名情報 != null) {
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
            hihokenEntity.set性別(ShikibetsuTaishoFactory.createKojin(宛名情報).to個人().get性別().getCommonName());
        }
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

    private NinshoshaDenshiKoinDataEntity getNinshoshaDenshiKoinData(FlexibleDate 弁明書作成日, ReportSourceWriter reportSourceWriter) {
        NinshoshaDenshiKoinDataEntity entity = new NinshoshaDenshiKoinDataEntity();
        DbT7065ChohyoSeigyoKyotsuEntity 帳票制御情報 = dac.selectByKey(SubGyomuCode.DBU介護統計報告, 帳票分類ID);
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha 帳票認証者情報 = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), 弁明書作成日);
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        boolean is公印に掛ける = 帳票認証者情報.is公印掛ける有無();
        boolean is公印を省略 = 帳票認証者情報.is公印省略有無();
        if (帳票制御情報 != null) {
            if (new RString("1").equals(帳票制御情報.getShuchoMeiInjiIchi())) {
                is公印に掛ける = true;
            }
            if (!帳票制御情報.getDenshiKoinInjiUmu()) {
                is公印を省略 = true;
            }
        }
        NinshoshaSource ninshoshaSource = NinshoshaSourceBuilderFactory.createInstance(帳票認証者情報, 地方公共団体,
                reportSourceWriter.getImageFolderPath(), new RDate(弁明書作成日.toString()),
                is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし).buildSource();
        entity.set認証者役職名(ninshoshaSource.ninshoshaYakushokuMei);
        entity.set認職者氏名(ninshoshaSource.ninshoshaShimeiKakeru);
        entity.set電子公印(ninshoshaSource.denshiKoin);
        entity.set公印省略(ninshoshaSource.koinShoryaku);
        entity.set公印文字列(ninshoshaSource.koinMojiretsu);
        return entity;
    }
}

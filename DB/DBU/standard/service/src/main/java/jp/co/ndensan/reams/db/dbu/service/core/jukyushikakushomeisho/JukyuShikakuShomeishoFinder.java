/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.jukyushikakushomeisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jukyushikakushomeisho.JukyuShikakuShomeishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.jukyushikakushomeisho.JukyuShikakuShomeishoDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.jukyushikakushomeisho.JukyuShikakuShomeishoKaiKoEntity;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.relate.jukyushikakushomeisho.JukyuShikakuShomeishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho.getShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 受給資格証明書のビジネスクラスです。
 */
public class JukyuShikakuShomeishoFinder {

    private static final RString 全角スペース = new RString("　");

    private final MapperProvider mapperProvider;
    private final JukyuShikakuShomeishoMapper mapper;

    /**
     * コンストラクタです。
     */
    public JukyuShikakuShomeishoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(JukyuShikakuShomeishoMapper.class);
    }

    /**
     * 受給資格証明書データ作成
     *
     * @param inEntity 受給資格証明書発行Entity
     * @return outEntity 受給資格証明書の帳票出力用データEntity
     */
    public JukyuShikakuShomeishoDataEntity setJukyuShikakuShomeisho(JukyuShikakuShomeishoKaiKoEntity inEntity) {

        JukyuShikakuShomeishoDataEntity outEntity = new JukyuShikakuShomeishoDataEntity();

        outEntity.set被保険者番号(inEntity.get被保険者番号());

        edit被保険者(outEntity, inEntity);

        outEntity.set被保険者異動予定日(inEntity.get異動予定日());

        edit保険者番号(outEntity, inEntity.get被保険者番号());

        edit認証者電子公印(outEntity, inEntity.get交付日());

        get申請状況情報(outEntity, inEntity);
        outEntity.set認定審査会の意見等(inEntity.get認定審査会の意見等());
        outEntity.set備考(inEntity.get備考());
        outEntity.set連番(null);
        outEntity.set交付年月日(inEntity.get交付年月日());

        return outEntity;
    }

    /**
     * 被保険者編集
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param inEntity 受給資格証明書発行Entity
     */
    private void edit被保険者(JukyuShikakuShomeishoDataEntity outEntity, JukyuShikakuShomeishoKaiKoEntity inEntity) {

        RString 住民種別コード1 = new RString("1");
        RString 住民種別コード2 = new RString("2");
        RString 住民種別コード3 = new RString("3");
        RString 住民種別コード4 = new RString("4");

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.set識別コード(inEntity.get識別コード());
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
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
        key.set住民状態(juminJotaiList);

        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.getPSM検索キー();
        JukyuShikakuShomeishoMyBatisParameter searchKey = new JukyuShikakuShomeishoMyBatisParameter(shikibetsuTaishoPSMSearchKey);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象PSM = mapper.get宛名識別対象PSM(searchKey);
        outEntity.set被保険者フリガナ(宛名識別対象PSM.getKanaMeisho());
        outEntity.set被保険者氏名(宛名識別対象PSM.getMeisho());
        FlexibleDate 生年月日 = 宛名識別対象PSM.getSeinengappiYMD();
        if (生年月日 != null) {
            RString 生年月日和暦 = 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 年号 = new RString(生年月日和暦.toString().substring(0, 2));
            RString 日付 = new RString(生年月日和暦.toString().substring(2));
            生年月日和暦 = 年号.concat("　").concat(日付);
            RString 生年月日西暦 = 生年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            if (住民種別コード1.equals(宛名識別対象PSM.getJuminShubetsuCode())
                    || 住民種別コード3.equals(宛名識別対象PSM.getJuminShubetsuCode())) {
                outEntity.set被保険者生年月日(生年月日和暦);
            }

            if (住民種別コード2.equals(宛名識別対象PSM.getJuminShubetsuCode())
                    || 住民種別コード4.equals(宛名識別対象PSM.getJuminShubetsuCode())) {
                if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード()
                        .equals(BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                    outEntity.set被保険者生年月日(生年月日西暦);

                } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード()
                        .equals(BusinessConfig.get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {
                    if (new RString("false").equals(宛名識別対象PSM.getSeinengappiFushoKubun())) {
                        outEntity.set被保険者生年月日(生年月日和暦);
                    } else {
                        outEntity.set被保険者生年月日(RString.EMPTY);
                    }
                }
            }
        }

        if (new RString("1").equals(宛名識別対象PSM.getSeibetsuCode())) {
            outEntity.set被保険者性別(new RString("男"));
        }
        if (new RString("2").equals(宛名識別対象PSM.getSeibetsuCode())) {
            outEntity.set被保険者性別(new RString("女"));
        }

        if (!inEntity.is住所を印字()) {
            RString 転出前の住所部分 = RString.EMPTY;
            RString 転出後の住所部分 = RString.EMPTY;

            if (new RString("1").equals(宛名識別対象PSM.getJuminJotaiCode())
                    || new RString("2").equals(宛名識別対象PSM.getJuminJotaiCode())) {
                AtenaJusho 宛名識別対象_住所 = 宛名識別対象PSM.getJusho();
                AtenaBanchi 宛名識別対象_番地 = 宛名識別対象PSM.getBanchi();
                Katagaki 宛名識別対象_方書 = 宛名識別対象PSM.getKatagaki();
                RString 住所 = RString.EMPTY;
                RString 番地 = RString.EMPTY;
                RString 方書 = RString.EMPTY;
                if (宛名識別対象_住所 != null) {
                    住所 = new RString(宛名識別対象_住所.toString());
                }
                if (宛名識別対象_番地 != null) {
                    番地 = new RString(宛名識別対象_番地.toString());
                }
                if (宛名識別対象_方書 != null) {
                    方書 = 全角スペース.concat(new RString(宛名識別対象_方書.toString()));
                }
                転出前の住所部分 = 住所.concat(番地).concat(方書);
            }

            if (new RString("3").equals(宛名識別対象PSM.getJuminJotaiCode())) {
                RString 宛名識別対象_住登内住所 = 宛名識別対象PSM.getJutonaiJusho();
                AtenaBanchi 宛名識別対象_住登内番地 = 宛名識別対象PSM.getJutonaiBanchi();
                Katagaki 宛名識別対象_住登内方書 = 宛名識別対象PSM.getJutonaiKatagaki();
                RString 住登内住所 = RString.EMPTY;
                RString 住登内番地 = RString.EMPTY;
                RString 住登内方書 = RString.EMPTY;
                if (宛名識別対象_住登内住所 != null) {
                    住登内住所 = new RString(宛名識別対象_住登内住所.toString());
                }
                if (宛名識別対象_住登内番地 != null) {
                    住登内番地 = new RString(宛名識別対象_住登内番地.toString());
                }
                if (宛名識別対象_住登内方書 != null) {
                    住登内方書 = 全角スペース.concat(new RString(宛名識別対象_住登内方書.toString()));
                }
                転出前の住所部分 = 住登内住所.concat(住登内番地).concat(住登内方書);

                if ((null == 宛名識別対象PSM.getTenshutsuKakuteiJusho() || AtenaJusho.EMPTY.equals(宛名識別対象PSM.getTenshutsuKakuteiJusho()))
                        && (null == 宛名識別対象PSM.getTenshutsuKakuteiBanchi()
                        || AtenaBanchi.EMPTY.equals(宛名識別対象PSM.getTenshutsuKakuteiBanchi()))) {
                    if ((null == 宛名識別対象PSM.getTenshutsuYoteiJusho() || AtenaJusho.EMPTY.equals(宛名識別対象PSM.getTenshutsuYoteiJusho()))
                            && (null == 宛名識別対象PSM.getTenshutsuYoteiBanchi()
                            || AtenaBanchi.EMPTY.equals(宛名識別対象PSM.getTenshutsuYoteiBanchi()))) {
                        転出後の住所部分 = RString.EMPTY;
                    } else {
                        AtenaJusho 宛名識別対象_転出予定住所 = 宛名識別対象PSM.getTenshutsuYoteiJusho();
                        AtenaBanchi 宛名識別対象_転出予定番地 = 宛名識別対象PSM.getTenshutsuYoteiBanchi();
                        Katagaki 宛名識別対象_転出予定方書 = 宛名識別対象PSM.getTenshutsuYoteiKatagaki();
                        RString 転出予定住所 = RString.EMPTY;
                        RString 転出予定番地 = RString.EMPTY;
                        RString 転出予定方書 = RString.EMPTY;
                        if (宛名識別対象_転出予定住所 != null) {
                            転出予定住所 = new RString(宛名識別対象_転出予定住所.toString());
                        }
                        if (宛名識別対象_転出予定番地 != null) {
                            転出予定番地 = new RString(宛名識別対象_転出予定番地.toString());
                        }
                        if (宛名識別対象_転出予定方書 != null) {
                            転出予定方書 = 全角スペース.concat(new RString(宛名識別対象_転出予定方書.toString()));
                        }
                        転出後の住所部分 = 転出予定住所.concat(転出予定番地).concat(転出予定方書);
                    }
                } else {
                    AtenaJusho 宛名識別対象_転出確定住所 = 宛名識別対象PSM.getTenshutsuKakuteiJusho();
                    AtenaBanchi 宛名識別対象_転出確定番地 = 宛名識別対象PSM.getTenshutsuKakuteiBanchi();
                    Katagaki 宛名識別対象_転出確定方書 = 宛名識別対象PSM.getTenshutsuKakuteiKatagaki();
                    RString 転出確定住所 = RString.EMPTY;
                    RString 転出確定番地 = RString.EMPTY;
                    RString 転出確定方書 = RString.EMPTY;
                    if (宛名識別対象_転出確定住所 != null) {
                        転出確定住所 = new RString(宛名識別対象_転出確定住所.toString());
                    }
                    if (宛名識別対象_転出確定番地 != null) {
                        転出確定番地 = new RString(宛名識別対象_転出確定番地.toString());
                    }
                    if (宛名識別対象_転出確定方書 != null) {
                        転出確定方書 = 全角スペース.concat(new RString(宛名識別対象_転出確定方書.toString()));
                    }
                    転出後の住所部分 = 転出確定住所.concat(転出確定番地).concat(転出確定方書);
                }
            }
            outEntity.set被保険者住所_転出前(転出前の住所部分);
            outEntity.set被保険者住所_転出先予定(転出後の住所部分);
        } else {
            outEntity.set被保険者住所_転出前(RString.EMPTY);
            outEntity.set被保険者住所_転出先予定(RString.EMPTY);
        }
    }

    /**
     * 保険者番号編集
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param 被保険者番号 被保険者番号
     */
    private void edit保険者番号(JukyuShikakuShomeishoDataEntity outEntity, HihokenshaNo 被保険者番号) {

        DbT1001HihokenshaDaichoDac dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);

        Code 導入形態コード = getShichosonSecurityJoho(GyomuBunrui.介護事務).get導入形態コード();
        KoikiShichosonJohoFinder koikiShichosonJohoFinder = KoikiShichosonJohoFinder.createInstance();
        if (new Code("112").equals(導入形態コード) || new Code("120").equals(導入形態コード)) {
            SearchResult<KoikiZenShichosonJoho> koikiZenShichosonJohoSearchResult = koikiShichosonJohoFinder.koseiShichosonJoho();
            if (!koikiZenShichosonJohoSearchResult.records().isEmpty()) {
                outEntity.set保険者番号(new RString(koikiZenShichosonJohoSearchResult.records().get(0).get証記載保険者番号().toString()));
            }
        } else if (new Code("111").equals(導入形態コード)) {
            List<DbT1001HihokenshaDaichoEntity> dbT1001HihokenshaDaichoEntityList = dbT1001Dac.get被保険者台帳管理情報(被保険者番号);
            if (!dbT1001HihokenshaDaichoEntityList.isEmpty()) {
                LasdecCode 措置元市町村コード = dbT1001HihokenshaDaichoEntityList.get(0).getKoikinaiTokureiSochimotoShichosonCode();
                if (措置元市町村コード != null) {
                    SearchResult<ShichosonCodeYoriShichoson> shichosonCodeYoriShichosonSearchResult
                            = koikiShichosonJohoFinder.shichosonCodeYoriShichosonJoho(措置元市町村コード);
                    if (shichosonCodeYoriShichosonSearchResult != null) {
                        outEntity.set保険者番号(new RString(shichosonCodeYoriShichosonSearchResult.records().get(0).get証記載保険者番号().toString()));
                    }
                } else {
                    SearchResult<ShichosonCodeYoriShichoson> shichosonCodeYoriShichosonSearchResult
                            = koikiShichosonJohoFinder.shichosonCodeYoriShichosonJoho(dbT1001HihokenshaDaichoEntityList.get(0).getShichosonCode());
                    if (shichosonCodeYoriShichosonSearchResult != null) {
                        outEntity.set保険者番号(new RString(shichosonCodeYoriShichosonSearchResult.records().get(0).get証記載保険者番号().toString()));
                    }
                }
            }
        }
        if (outEntity.get保険者番号().isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.保険者番号取得不可.getMessage());
        }
    }

    /**
     * 認証者電子公印編集
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param 交付日 交付日
     */
    private void edit認証者電子公印(JukyuShikakuShomeishoDataEntity outEntity, RDate 交付日) {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード());
        ReportAssembler assembler = new ReportManager().reportAssembler(new RString("DBA100004_JukyuShikakuShomeisho")).create();
        RString imageFilePath = assembler.getImageFolderPath();
        INinshoshaSourceBuilder builder = NinshoshaSourceBuilderFactory.createInstance(ninshosha, association, imageFilePath, 交付日);
        NinshoshaSource ninshoshaSource = builder.buildSource();
        FlexibleDate hakkoYMD = new FlexibleDate(ninshoshaSource.hakkoYMD);
        outEntity.set日付(hakkoYMD.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString());
        // TODO QA:75375
        outEntity.set役職名(ninshoshaSource.ninshoshaYakushokuMei);
        outEntity.set認職者氏名(new RString(""));
        outEntity.set公印省略(ninshoshaSource.denshiKoin);
        outEntity.set市町村名(association.get市町村名());
        outEntity.set電子公印_イメージファイル(new RString(""));
    }

    /**
     * 申請状況情報
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param inEntity 受給資格証明書発行Entity
     */
    private void get申請状況情報(JukyuShikakuShomeishoDataEntity outEntity, JukyuShikakuShomeishoKaiKoEntity inEntity) {

        DbT4001JukyushaDaichoDac dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        DbT4001JukyushaDaichoEntity dbT4001JukyushaDaichoEntity = dbT4001Dac.select受給者台帳(inEntity.get被保険者番号());
        if (dbT4001JukyushaDaichoEntity != null) {
            if (new RString("0").equals(dbT4001JukyushaDaichoEntity.getShinseiJokyoKubun())) {
                DbT5121ShinseiRirekiJohoDac dbT5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
                List<DbT5121ShinseiRirekiJohoEntity> dbT5121ShinseiRirekiJohoEntityList
                        = dbT5121Dac.select前回申請管理番号(dbT4001JukyushaDaichoEntity.getShinseishoKanriNo());

                FlexibleDate 認定年月日 = null;
                for (DbT5121ShinseiRirekiJohoEntity dbT5121ShinseiRirekiJohoEntity : dbT5121ShinseiRirekiJohoEntityList) {
                    if (dbT4001JukyushaDaichoEntity.getShinseishoKanriNo().equals(dbT5121ShinseiRirekiJohoEntity.getZenkaiShinseishoKanriNo())) {
                        認定年月日 = dbT4001JukyushaDaichoEntity.getNinteiYMD();
                        break;
                    }
                }

                if (!inEntity.get申請日().isEmpty()) {
                    outEntity.set申請状況(new RString("申請中"));
                    outEntity.set申請年月日(inEntity.get申請日());
                    if (認定年月日 != null) {
                        outEntity.set認定年月日(認定年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
                    }
                }
            } else if (new RString("1").equals(dbT4001JukyushaDaichoEntity.getShinseiJokyoKubun())) {
                if (inEntity.get申請日().isEmpty()) {
                    outEntity.set申請状況(new RString("認定済"));
                    outEntity.set申請年月日(RString.EMPTY);
                    FlexibleDate ninteiYMD = dbT4001JukyushaDaichoEntity.getNinteiYMD();
                    if (ninteiYMD != null) {
                        outEntity.set認定年月日(ninteiYMD.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                                .fillType(FillType.BLANK).toDateString());
                    }
                }
            }
        }
        outEntity.set要介護状態区分(inEntity.get要介護状態区分());

        outEntity.set認定の有効期間の開始年月日(new FlexibleDate(inEntity.get有効期間の開始年月日())
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());

        outEntity.set認定の有効期間の終了年月日(new FlexibleDate(inEntity.get有効期間の終了年月日())
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
    }
}

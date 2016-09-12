/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.jukyushikakushomeisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.jukyushikakushomeisho.JukyuShikakuShomeishoKaiKo;
import jp.co.ndensan.reams.db.dbu.business.report.jukyushikakushomeisho.JukyuShikakuShomeishoData;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jukyushikakushomeisho.JukyuShikakuShomeishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jukyushikakushomeisho.JukyuShikakuShomeishoDataEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jukyushikakushomeisho.IJukyuShikakuShomeishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho.getShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeinengappiFushoKubunType;
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
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 受給資格証明書のビジネスクラスです。
 *
 * @reamsid_L DBU-0490-050 wangchao
 */
public class JukyuShikakuShomeishoFinder {

    private static final RString 全角スペース = new RString("　");
    private final RString 年号_明治 = new RString("明治");
    private final RString 年号_大正 = new RString("大正");
    private final RString 年号_昭和 = new RString("昭和");
    private final RString 年号_星 = new RString("＊");

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public JukyuShikakuShomeishoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyuShikakuShomeishoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukyuShikakuShomeishoFinder}のインスタンス
     */
    public static JukyuShikakuShomeishoFinder createInstance() {
        return InstanceProvider.create(JukyuShikakuShomeishoFinder.class);
    }

    /**
     * 受給資格証明書データ作成
     *
     * @param inEntity 受給資格証明書発行Entity
     * @return outEntity 受給資格証明書の帳票出力用データEntity
     */
    public JukyuShikakuShomeishoData setJukyuShikakuShomeisho(JukyuShikakuShomeishoKaiKo inEntity) {

        JukyuShikakuShomeishoDataEntity outEntity = new JukyuShikakuShomeishoDataEntity();

        outEntity.set被保険者番号(inEntity.get被保険者番号());

        edit被保険者(outEntity, inEntity);

        outEntity.set被保険者異動予定日(inEntity.get異動予定日());

        edit保険者番号(outEntity, inEntity.get被保険者番号());

        get申請状況情報(outEntity, inEntity);
        outEntity.set認定審査会の意見等(inEntity.get認定審査会の意見等());
        outEntity.set備考(inEntity.get備考());
        outEntity.set負担割合(inEntity.get負担割合());
        outEntity.set負担割該当(inEntity.get負担割該当());
        outEntity.set連番(null);

        return edit認証者電子公印(outEntity, inEntity.get交付日());
    }

    /**
     * 被保険者編集
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param inEntity 受給資格証明書発行Entity
     */
    private void edit被保険者(JukyuShikakuShomeishoDataEntity outEntity, JukyuShikakuShomeishoKaiKo inEntity) {

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
        IJukyuShikakuShomeishoMapper mapper = mapperProvider.create(IJukyuShikakuShomeishoMapper.class);
        UaFt200FindShikibetsuTaishoEntity 宛名識別対象PSM = mapper.get宛名識別対象PSM(searchKey);
        if (null == 宛名識別対象PSM) {
            return;
        }
        outEntity.set被保険者フリガナ(宛名識別対象PSM.getKanaMeisho());
        outEntity.set被保険者氏名(宛名識別対象PSM.getMeisho());
        FlexibleDate 生年月日 = 宛名識別対象PSM.getSeinengappiYMD();
        if (生年月日 != null) {
            RString 生年月日和暦 = 生年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
            RString 年号 = new RString(生年月日和暦.toString().substring(0, 2));
            RString 日付 = new RString(生年月日和暦.toString().substring(2));
            RString 生年月日西暦 = 生年月日.seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();

            if (住民種別コード1.equals(宛名識別対象PSM.getJuminShubetsuCode())
                    || 住民種別コード3.equals(宛名識別対象PSM.getJuminShubetsuCode())) {
                生年月日編集1(年号, 日付, outEntity);
            }

            if (住民種別コード2.equals(宛名識別対象PSM.getJuminShubetsuCode())
                    || 住民種別コード4.equals(宛名識別対象PSM.getJuminShubetsuCode())) {
                外国人の場合生年月日編集(年号, 日付, outEntity, 生年月日西暦, 宛名識別対象PSM);
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
                転出前の住所部分 = get住所部分(宛名識別対象_住所, 宛名識別対象_番地, 宛名識別対象_方書);
            }

            if (new RString("3").equals(宛名識別対象PSM.getJuminJotaiCode())) {
                RString 宛名識別対象_住登内住所 = 宛名識別対象PSM.getJutonaiJusho();
                AtenaBanchi 宛名識別対象_住登内番地 = 宛名識別対象PSM.getJutonaiBanchi();
                Katagaki 宛名識別対象_住登内方書 = 宛名識別対象PSM.getJutonaiKatagaki();
                転出前の住所部分 = get住所部分(宛名識別対象_住登内住所, 宛名識別対象_住登内番地, 宛名識別対象_住登内方書);
                転出後の住所部分 = get転出後の住所部分(宛名識別対象PSM);
            }
            outEntity.set被保険者住所_転出前(転出前の住所部分);
            outEntity.set被保険者住所_転出先予定(転出後の住所部分);
        } else {
            outEntity.set被保険者住所_転出前(RString.EMPTY);
            outEntity.set被保険者住所_転出先予定(RString.EMPTY);
        }
    }

    private RString get転出後の住所部分(UaFt200FindShikibetsuTaishoEntity 宛名識別対象PSM) {
        RString 転出後の住所部分;
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
                転出後の住所部分 = get住所部分(宛名識別対象_転出予定住所, 宛名識別対象_転出予定番地, 宛名識別対象_転出予定方書);
            }
        } else {
            AtenaJusho 宛名識別対象_転出確定住所 = 宛名識別対象PSM.getTenshutsuKakuteiJusho();
            AtenaBanchi 宛名識別対象_転出確定番地 = 宛名識別対象PSM.getTenshutsuKakuteiBanchi();
            Katagaki 宛名識別対象_転出確定方書 = 宛名識別対象PSM.getTenshutsuKakuteiKatagaki();
            転出後の住所部分 = get住所部分(宛名識別対象_転出確定住所, 宛名識別対象_転出確定番地, 宛名識別対象_転出確定方書);
        }
        return 転出後の住所部分;
    }

    private RString get住所部分(AtenaJusho 宛名識別対象_住所, AtenaBanchi 宛名識別対象_番地, Katagaki 宛名識別対象_方書) {
        RString 住所 = null == 宛名識別対象_住所 ? RString.EMPTY : 宛名識別対象_住所.getColumnValue();
        RString 番地 = null == 宛名識別対象_番地 ? RString.EMPTY : 宛名識別対象_番地.getColumnValue();
        RString 方書 = RString.EMPTY;
        if (宛名識別対象_方書 != null && !RString.EMPTY.equals(宛名識別対象_方書.getColumnValue())) {
            方書 = 全角スペース.concat(宛名識別対象_方書.getColumnValue());
        }
        return 住所.concat(番地).concat(方書);
    }

    private RString get住所部分(RString 宛名識別対象_住登内住所, AtenaBanchi 宛名識別対象_住登内番地, Katagaki 宛名識別対象_住登内方書) {
        RString 住所 = null == 宛名識別対象_住登内住所 ? RString.EMPTY : 宛名識別対象_住登内住所;
        RString 番地 = null == 宛名識別対象_住登内番地 ? RString.EMPTY : 宛名識別対象_住登内番地.getColumnValue();
        RString 方書 = RString.EMPTY;
        if (宛名識別対象_住登内方書 != null && !RString.EMPTY.equals(宛名識別対象_住登内方書.getColumnValue())) {
            方書 = 全角スペース.concat(宛名識別対象_住登内方書.getColumnValue());
        }
        return 住所.concat(番地).concat(方書);
    }

    private void 外国人の場合生年月日編集(RString 年号, RString 日付,
            JukyuShikakuShomeishoDataEntity outEntity, RString 生年月日西暦, UaFt200FindShikibetsuTaishoEntity 宛名識別対象PSM) {
        RString 外国人表示制御_生年月日表示方法 = DbBusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード()
                .equals(外国人表示制御_生年月日表示方法)) {
            outEntity.set年号_大正(年号_星);
            outEntity.set年号_明治(年号_星);
            outEntity.set年号_昭和(年号_星);
            outEntity.set被保険者生年月日(生年月日西暦);
        } else if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード()
                .equals(外国人表示制御_生年月日表示方法)) {
            if (SeinengappiFushoKubunType.不詳なし.code().equals(宛名識別対象PSM.getSeinengappiFushoKubun())) {
                生年月日編集1(年号, 日付, outEntity);
            } else {
                outEntity.set被保険者生年月日(RString.EMPTY);
            }
        }
    }

    private void 生年月日編集1(RString 年号, RString 日付, JukyuShikakuShomeishoDataEntity outEntity) {
        if (年号_大正.equals(年号)) {
            outEntity.set年号_明治(年号_星);
            outEntity.set年号_昭和(年号_星);
        } else if (年号_明治.equals(年号)) {
            outEntity.set年号_大正(年号_星);
            outEntity.set年号_昭和(年号_星);
        } else if (年号_昭和.equals(年号)) {
            outEntity.set年号_大正(年号_星);
            outEntity.set年号_明治(年号_星);
        } else {
            outEntity.set年号_大正(年号_星);
            outEntity.set年号_明治(年号_星);
            outEntity.set年号_昭和(年号_星);
        }
        outEntity.set被保険者生年月日(日付);
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
            SearchResult<KoikiZenShichosonJoho> result = koikiShichosonJohoFinder.koseiShichosonJoho();
            if (!result.records().isEmpty()) {
                outEntity.set保険者番号(result.records().get(0).get証記載保険者番号().getColumnValue());
            }
        } else if (new Code("111").equals(導入形態コード)) {
            List<DbT1001HihokenshaDaichoEntity> dbT1001EntityList = dbT1001Dac.get被保険者台帳管理情報(被保険者番号);
            if (!dbT1001EntityList.isEmpty()) {
                edit広域の場合保険者番号(dbT1001EntityList, koikiShichosonJohoFinder, outEntity);
            }
        }
        if (null == outEntity.get保険者番号() || outEntity.get保険者番号().isEmpty()) {
            throw new ApplicationException(DbzErrorMessages.保険者番号取得不可.getMessage());
        }
    }

    private void edit広域の場合保険者番号(List<DbT1001HihokenshaDaichoEntity> dbT1001EntityList,
            KoikiShichosonJohoFinder koikiShichosonJohoFinder, JukyuShikakuShomeishoDataEntity outEntity) {
        LasdecCode 措置元市町村コード = dbT1001EntityList.get(0).getKoikinaiTokureiSochimotoShichosonCode();
        if (措置元市町村コード != null) {
            SearchResult<ShichosonCodeYoriShichoson> result
                    = koikiShichosonJohoFinder.shichosonCodeYoriShichosonJoho(措置元市町村コード);
            if (result != null && !result.records().isEmpty()
                    && result.records().get(0).get証記載保険者番号() != null) {
                outEntity.set保険者番号(result.records().get(0).get証記載保険者番号().getColumnValue());
            }
        } else {
            SearchResult<ShichosonCodeYoriShichoson> searchResult
                    = koikiShichosonJohoFinder.shichosonCodeYoriShichosonJoho(dbT1001EntityList.get(0).getShichosonCode());
            if (searchResult != null && !searchResult.records().isEmpty()
                    && searchResult.records().get(0).get証記載保険者番号() != null) {
                outEntity.set保険者番号(searchResult.records().get(0).get証記載保険者番号().getColumnValue());
            }
        }
    }

    /**
     * 認証者電子公印編集
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param 交付日 交付日
     */
    private JukyuShikakuShomeishoData edit認証者電子公印(JukyuShikakuShomeishoDataEntity outEntity, RString 交付日) {
        ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBA介護資格, new ReportId("DBE223001_NinteiChosaTokusokujo"));
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), new FlexibleDate(new RDate(交付日.toString()).toString()));
        outEntity.set発行日(交付日);
        return new JukyuShikakuShomeishoData(outEntity, ninshosha, association, 帳票制御共通.get首長名印字位置(), 帳票制御共通.is電子公印印字有無());
    }

    /**
     * 申請状況情報
     *
     * @param outEntity 受給資格証明書の帳票出力用データEntity
     * @param inEntity 受給資格証明書発行Entity
     */
    private void get申請状況情報(JukyuShikakuShomeishoDataEntity outEntity, JukyuShikakuShomeishoKaiKo inEntity) {

        DbT4001JukyushaDaichoDac dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        List<DbT4001JukyushaDaichoEntity> dbT4001EntityList = dbT4001Dac.select受給者台帳(inEntity.get被保険者番号());
        DbT4001JukyushaDaichoEntity dbT4001JukyushaDaichoEntity = null;
        if (!dbT4001EntityList.isEmpty()) {
            dbT4001JukyushaDaichoEntity = dbT4001EntityList.get(0);
        }
        if (dbT4001JukyushaDaichoEntity != null) {
            if (new RString("0").equals(dbT4001JukyushaDaichoEntity.getShinseiJokyoKubun())) {
                DbT5121ShinseiRirekiJohoDac dbT5121Dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
                List<DbT5121ShinseiRirekiJohoEntity> dbT5121EntityList
                        = dbT5121Dac.select前回申請管理番号(dbT4001JukyushaDaichoEntity.getShinseishoKanriNo());

                FlexibleDate 認定年月日 = get認定年月日(dbT4001EntityList, dbT5121EntityList);
                set申請状況And年月日(outEntity, inEntity, 認定年月日);
            } else if (new RString("1").equals(dbT4001JukyushaDaichoEntity.getShinseiJokyoKubun())) {
                set申請状況And年月日(outEntity, inEntity, dbT4001JukyushaDaichoEntity);
            }
        }
        outEntity.set要介護状態区分(inEntity.get要介護状態区分());

        RDate 有効期間の開始年月日
                = null == inEntity.get有効期間の開始年月日() ? RDate.MIN : new RDate(inEntity.get有効期間の開始年月日().toString());
        RDate 有効期間の終了年月日
                = null == inEntity.get有効期間の終了年月日() ? RDate.MIN : new RDate(inEntity.get有効期間の終了年月日().toString());
        outEntity.set認定の有効期間の開始年月日(有効期間の開始年月日
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());

        outEntity.set認定の有効期間の終了年月日(有効期間の終了年月日
                .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
    }

    private void set申請状況And年月日(JukyuShikakuShomeishoDataEntity outEntity, JukyuShikakuShomeishoKaiKo inEntity, FlexibleDate 認定年月日) {
        if (inEntity.get申請日() != null && !inEntity.get申請日().isEmpty()) {
            outEntity.set申請状況(new RString("0"));
            outEntity.set申請年月日(inEntity.get申請日());
            if (認定年月日 != null) {
                outEntity.set認定年月日(認定年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            }
        }
    }

    private void set申請状況And年月日(JukyuShikakuShomeishoDataEntity outEntity,
            JukyuShikakuShomeishoKaiKo inEntity, DbT4001JukyushaDaichoEntity dbT4001JukyushaDaichoEntity) {
        if (null == inEntity.get申請日() || inEntity.get申請日().isEmpty()) {
            outEntity.set申請状況(new RString("1"));
            outEntity.set申請年月日(RString.EMPTY);
            FlexibleDate ninteiYMD = dbT4001JukyushaDaichoEntity.getNinteiYMD();

            if (ninteiYMD != null) {
                outEntity.set認定年月日(ninteiYMD.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString());
            }
        }
    }

    private FlexibleDate get認定年月日(List<DbT4001JukyushaDaichoEntity> dbT4001EntityList,
            List<DbT5121ShinseiRirekiJohoEntity> dbT5121EntityList) {
        FlexibleDate 認定年月日 = null;
        if (!dbT5121EntityList.isEmpty()) {
            DbT5121ShinseiRirekiJohoEntity dbT5121ShinseiRirekiJohoEntity = dbT5121EntityList.get(0);
            for (DbT4001JukyushaDaichoEntity dbT4001Entity : dbT4001EntityList) {
                if (dbT4001Entity.getShinseishoKanriNo().equals(dbT5121ShinseiRirekiJohoEntity.getZenkaiShinseishoKanriNo())) {
                    認定年月日 = dbT4001Entity.getNinteiYMD();
                    break;
                }
            }
        }
        return 認定年月日;
    }
}

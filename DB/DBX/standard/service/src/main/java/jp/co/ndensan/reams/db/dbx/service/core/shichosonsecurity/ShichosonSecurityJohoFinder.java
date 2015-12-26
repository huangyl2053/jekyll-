/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.config.fuka.DosaKanrenConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.rojinhokenjoho.RokenJohoConfig;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.KoseiShichosonJohoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ValueObjects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.auth.AuthItem;
import jp.co.ndensan.reams.uz.uza.auth.AuthType;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村情報セキュリティ取得するクラスです。
 */
public class ShichosonSecurityJohoFinder {

    private final DbT7051KoseiShichosonMasterDac koseiShichosonMasterDac;
    private final DbT7908KaigoDonyuKeitaiDac kaigoDonyuKeitaiDac;
    private static final RString 介護導入区分_未導入 = new RString("0");
    private static final RString 介護導入区分_導入済 = new RString("1");
    private static final RString DEFAULT_市町村ＩＤ有効桁数 = new RString("2");
    private static final RString DEFAULT_市町村識別ID = new RString("00");
    private static final int MAX_市町村識別ID = 99;
    private static final int MIN_市町村識別ID = 1;
    private static final RString 介護事務_120 = new RString("120");
    private static final RString 介護事務_112 = new RString("112");
    private static final RString 介護事務_111 = new RString("111");
    private static final RString 介護認定_211 = new RString("211");
    private static final RString 介護認定_220 = new RString("220");
    private static final int WORKFLOW_管理情報から = 1;
    private static final int WORKFLOW_市町村識別IDから = 2;
    private static final int WORKFLOW_NULL = 0;
    private static final RString AUTHTYPE = new RString("koseiShichosonKengen");

    /**
     * コンストラクタです。
     */
    protected ShichosonSecurityJohoFinder() {
        this.koseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.kaigoDonyuKeitaiDac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
    }

    /**
     * インスタンスを生成します。
     *
     * @return {@link ShichosonSecurityJohoFinder}
     */
    public static ShichosonSecurityJohoFinder createInstance() {
        return InstanceProvider.create(ShichosonSecurityJohoFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param koseiShichosonMasterDac DbT7051KoseiShichosonMasterDac
     * @param kaigoDonyuKeitaiDac DbT7908KaigoDonyuKeitaiDac
     */
    ShichosonSecurityJohoFinder(
            DbT7051KoseiShichosonMasterDac koseiShichosonMasterDac,
            DbT7908KaigoDonyuKeitaiDac kaigoDonyuKeitaiDac) {
        this.koseiShichosonMasterDac = koseiShichosonMasterDac;
        this.kaigoDonyuKeitaiDac = kaigoDonyuKeitaiDac;

    }

    /**
     * 業務分類で市町村情報を取得します。
     *
     * @param gyomuBunrui 業務分類
     * @return ShichosonJohoEntity 市町村情報Entity
     */
    public ShichosonSecurityJoho getShichosonSecurityJoho(GyomuBunrui gyomuBunrui) {
        ShichosonSecurityJoho shichosonSecurityJoho = new ShichosonSecurityJoho();
        List<DbT7908KaigoDonyuKeitaiEntity> kaigoDonyuKeitaiEntityList
                = this.kaigoDonyuKeitaiDac.selectByGyomuBunrui(gyomuBunrui.getコード());
        if (kaigoDonyuKeitaiEntityList == null || kaigoDonyuKeitaiEntityList.isEmpty()) {
            shichosonSecurityJoho.set介護導入区分(介護導入区分_未導入);
            shichosonSecurityJoho.set導入形態コード(null);
            shichosonSecurityJoho.set広域タイプ(null);
            shichosonSecurityJoho.set支所管理有無フラグ(false);
            shichosonSecurityJoho.set市町村ＩＤ有効桁数(null);
            shichosonSecurityJoho.set市町村情報(null);
            return shichosonSecurityJoho;
        } else {
            RString 業務分類 = kaigoDonyuKeitaiEntityList.get(0).getGyomuBunrui();
            RString 導入形態コード = kaigoDonyuKeitaiEntityList.get(0).getDonyuKeitaiCode().value();
            boolean 支所管理有無フラグ = kaigoDonyuKeitaiEntityList.get(0).getShishoKanriUmuFlag();
            shichosonSecurityJoho.set介護導入区分(介護導入区分_導入済);
            shichosonSecurityJoho.set導入形態コード(導入形態コード);
            int workFlow = dispatchFlowByKaigoDonyuKeitai(業務分類, 導入形態コード);
            return workFlowStep(workFlow, 導入形態コード, 支所管理有無フラグ);
        }
    }

    private ShichosonSecurityJoho workFlowStep(int workFlow, RString 導入形態コード, boolean 支所管理有無フラグ) {
        if (WORKFLOW_管理情報から == workFlow) {
            return getKanriJoho(導入形態コード, 支所管理有無フラグ);
        } else if (WORKFLOW_市町村識別IDから == workFlow) {
            return getKouseiShichosonJohoByLoginUser(導入形態コード, 支所管理有無フラグ);
        } else {
            return null;
        }
    }

    private List<KoseiShichosonJohoEntity> getKouseiShichosonJoho(RString shichosonShokibetsuID) {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMaster
                = koseiShichosonMasterDac.selectBy市町村識別ID(shichosonShokibetsuID);
        List<KoseiShichosonJohoEntity> koseiShichosonJohList = new ArrayList<>();
        if (koseiShichosonMaster == null || koseiShichosonMaster.isEmpty()) {
            return null;
        }
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMaster) {
            koseiShichosonJohList.add(toKoseiShichosonJohoEntity(entity));

        }
        return koseiShichosonJohList;

    }

    private ShichosonSecurityJoho getKanriJoho(RString 導入形態コード, boolean 支所管理有無フラグ) {
        ShichosonSecurityJoho shichosonJoho = new ShichosonSecurityJoho();

        shichosonJoho.set導入形態コード(導入形態コード);
        shichosonJoho.set支所管理有無フラグ(支所管理有無フラグ);
        shichosonJoho.set市町村ＩＤ有効桁数(DEFAULT_市町村ＩＤ有効桁数);

        KoseiShichosonJohoEntity koseiShichosonJoho = new KoseiShichosonJohoEntity();
        koseiShichosonJoho.setShichosonShokibetsuID(DEFAULT_市町村識別ID);

        Association finder = AssociationFinderFactory.createInstance().getAssociation();
        koseiShichosonJoho.setShichosonCode(finder.get地方公共団体コード());
        koseiShichosonJoho.setTodofukenMeisho(finder.get都道府県名());
        koseiShichosonJoho.setGunMeisho(finder.get郡名());

        HokenshaJohoConfig hokenshaJohoConfig = new HokenshaJohoConfig();

//        shichosonJoho.set広域タイプ(config.get(HokenshaJoho.保険者情報_広域タイプ, SubGyomuCode.DBU介護統計報告));
        koseiShichosonJoho.setShoKisaiHokenshaNo(
                new ShoKisaiHokenshaNo(hokenshaJohoConfig.get保険者情報_保険者番号()));
        koseiShichosonJoho.setShichosonMeisho(hokenshaJohoConfig.get保険者情報_保険者名称());
        koseiShichosonJoho.setYubinNo(hokenshaJohoConfig.get郵便番号().value());
        koseiShichosonJoho.setJusho(hokenshaJohoConfig.get保険者住所().value());
        koseiShichosonJoho.setTelNo(hokenshaJohoConfig.get電話番号().value());
        koseiShichosonJoho.setYusenChikuCode(hokenshaJohoConfig.get最優先地区().code());

        ChohyoKyotsuJushoEditConfig jushoEditConfig = new ChohyoKyotsuJushoEditConfig();
        koseiShichosonJoho.setTyohyoTodoufukenHyojiUmu(jushoEditConfig.get都道府県名付与有無().code());
        koseiShichosonJoho.setTyohyoGunHyojiUmu(jushoEditConfig.get郡名付与有無().code());
        koseiShichosonJoho.setTyohyoShichosonHyojiUmu(jushoEditConfig.get市町村名付与有無().code());
        koseiShichosonJoho.setTyohyoJushoHenshuHouhou(jushoEditConfig.get住所編集方法().code());
        koseiShichosonJoho.setTyohyoKatagakiHyojiUmu(jushoEditConfig.get方書表示有無().code());

        RokenJohoConfig rokenJohoConfig = new RokenJohoConfig();
        koseiShichosonJoho.setRojinhokenShichosonNo(rokenJohoConfig.get市町村番号());
        koseiShichosonJoho.setRokenJukyushaNoTaikei(rokenJohoConfig.get管理体系().code());

        DosaKanrenConfig dosaKanrenConfig = new DosaKanrenConfig();
        koseiShichosonJoho.setTokuchoBunpaishuyaku(dosaKanrenConfig.get特徴分配集約システム().code());

        koseiShichosonJoho.setKokuhorenKoikiShichosonNo(RString.EMPTY);
        koseiShichosonJoho.setIkoYMD(FlexibleDate.EMPTY);
        koseiShichosonJoho.setKanyuYMD(FlexibleDate.EMPTY);
        koseiShichosonJoho.setRidatsuYMD(FlexibleDate.EMPTY);
        koseiShichosonJoho.setGappeiKyuShichosonKubun(RString.EMPTY);
        koseiShichosonJoho.setGappeiKyuShichosonHyojiUmu(RString.EMPTY);
        koseiShichosonJoho.setGappeiChiikiNo(RString.EMPTY);
        koseiShichosonJoho.setUnyoHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        koseiShichosonJoho.setUnyoKaishiYMD(FlexibleDate.EMPTY);
        koseiShichosonJoho.setUnyoShuryoYMD(FlexibleDate.EMPTY);
        koseiShichosonJoho.setUnyoKeitaiKubun(RString.EMPTY);
        shichosonJoho.set市町村情報(koseiShichosonJoho);
        return shichosonJoho;
    }

    private List<AuthorityItem> getShichosonShikibetsuId(RString reamsLoginId) {
        if (null == reamsLoginId || reamsLoginId.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("ログインユーザID"));
        }
        return AuthItem.getAuthorities(reamsLoginId, new AuthType.Of().kinds(AUTHTYPE).create(), RDate.getNowDate());
    }

    private ShichosonSecurityJoho getKouseiShichosonJohoByLoginUser(RString 導入形態コード, boolean 支所管理有無フラグ) {
        RString loginUser = getLoginUser();
        List<AuthorityItem> authorityItemList = getShichosonShikibetsuId(loginUser);
        if (authorityItemList != null) {
            RString shichosonShokibetsuID = authorityItemList.get(0).getItemId();
            return getShichosonSecurityJohoNotNull(shichosonShokibetsuID, 導入形態コード, 支所管理有無フラグ);
        } else {
            return null;
        }
    }

    private ShichosonSecurityJoho getShichosonSecurityJohoNotNull(RString shichosonShokibetsuID, RString 導入形態コード, boolean 支所管理有無フラグ) {
        ShichosonSecurityJoho shichosonJoho = new ShichosonSecurityJoho();
        int 市町村識別ID = Integer.valueOf(shichosonShokibetsuID.toString()).intValue();
        if (shichosonShokibetsuID.equals(DEFAULT_市町村識別ID)) {
            shichosonJoho.set介護導入区分(介護導入区分_導入済);
            shichosonJoho.set導入形態コード(導入形態コード);
            return getKanriJoho(導入形態コード, 支所管理有無フラグ);
        } else if (MIN_市町村識別ID <= 市町村識別ID && 市町村識別ID <= MAX_市町村識別ID) {
            KoseiShichosonJohoEntity koseiShichosonJohoEntity = getKoseiShichosonJohoEntity(市町村識別ID, shichosonShokibetsuID);
            shichosonJoho.set介護導入区分(介護導入区分_導入済);
            shichosonJoho.set導入形態コード(導入形態コード);
            shichosonJoho = getKanriJoho(導入形態コード, 支所管理有無フラグ);
            shichosonJoho.set市町村情報(koseiShichosonJohoEntity);
            return shichosonJoho;
        } else {
            return null;
        }
    }

    private KoseiShichosonJohoEntity getKoseiShichosonJohoEntity(int 市町村識別ID, RString shichosonShokibetsuID) {
        List<KoseiShichosonJohoEntity> koseiShichosonJohoEntityList
                = getKouseiShichosonJoho(shichosonShokibetsuID);
        return getKoseiShichosonJohoEntityNotNull(koseiShichosonJohoEntityList);
    }

    private KoseiShichosonJohoEntity getKoseiShichosonJohoEntityNotNull(List<KoseiShichosonJohoEntity> koseiShichosonJohoEntityList) {
        KoseiShichosonJohoEntity koseiShichosonJohoEntity = null;
        if (koseiShichosonJohoEntityList != null) {
            koseiShichosonJohoEntity = koseiShichosonJohoEntityList.get(0);
        }
        return koseiShichosonJohoEntity;
    }

    private KoseiShichosonJohoEntity toKoseiShichosonJohoEntity(
            DbT7051KoseiShichosonMasterEntity koseiShichosonMasterEntity) {
        KoseiShichosonJohoEntity koseiShichosonJohoEntity = new KoseiShichosonJohoEntity();
        koseiShichosonJohoEntity.setShichosonShokibetsuID(koseiShichosonMasterEntity.getShichosonShokibetsuID());
        koseiShichosonJohoEntity.setShichosonCode(koseiShichosonMasterEntity.getShichosonCode());
        koseiShichosonJohoEntity.setShoKisaiHokenshaNo(koseiShichosonMasterEntity.getShoKisaiHokenshaNo());
        koseiShichosonJohoEntity.setKokuhorenKoikiShichosonNo(koseiShichosonMasterEntity.getKokuhorenKoikiShichosonNo());
        koseiShichosonJohoEntity.setShichosonMeisho(koseiShichosonMasterEntity.getShichosonMeisho());
        koseiShichosonJohoEntity.setTodofukenMeisho(koseiShichosonMasterEntity.getTodofukenMeisho());
        koseiShichosonJohoEntity.setGunMeisho(koseiShichosonMasterEntity.getGunMeisho());
        koseiShichosonJohoEntity.setYubinNo(ValueObjects.valueOrRStringEMPTY(koseiShichosonMasterEntity.getYubinNo()));
        koseiShichosonJohoEntity.setJusho(ValueObjects.valueOrRStringEMPTY(koseiShichosonMasterEntity.getJusho()));
        koseiShichosonJohoEntity.setTelNo(ValueObjects.valueOrRStringEMPTY(koseiShichosonMasterEntity.getTelNo()));
        koseiShichosonJohoEntity.setYusenChikuCode(koseiShichosonMasterEntity.getYusenChikuCode());
        koseiShichosonJohoEntity.setTyohyoTodoufukenHyojiUmu(koseiShichosonMasterEntity.getTyohyoTodoufukenHyojiUmu());
        koseiShichosonJohoEntity.setTyohyoGunHyojiUmu(koseiShichosonMasterEntity.getTyohyoGunHyojiUmu());
        koseiShichosonJohoEntity.setTyohyoShichosonHyojiUmu(koseiShichosonMasterEntity.getTyohyoShichosonHyojiUmu());
        koseiShichosonJohoEntity.setTyohyoJushoHenshuHouhou(koseiShichosonMasterEntity.getTyohyoJushoHenshuHouhou());
        koseiShichosonJohoEntity.setTyohyoKatagakiHyojiUmu(koseiShichosonMasterEntity.getTyohyoKatagakiHyojiUmu());
        koseiShichosonJohoEntity.setRojinhokenShichosonNo(koseiShichosonMasterEntity.getRojinhokenShichosonNo());
        koseiShichosonJohoEntity.setRokenJukyushaNoTaikei(koseiShichosonMasterEntity.getRokenJukyushaNoTaikei());
        koseiShichosonJohoEntity.setTokuchoBunpaishuyaku(koseiShichosonMasterEntity.getTokuchoBunpaishuyaku());
        koseiShichosonJohoEntity.setIkoYMD(koseiShichosonMasterEntity.getIkoYMD());
        koseiShichosonJohoEntity.setKanyuYMD(koseiShichosonMasterEntity.getKanyuYMD());
        koseiShichosonJohoEntity.setRidatsuYMD(koseiShichosonMasterEntity.getRidatsuYMD());
        koseiShichosonJohoEntity.setGappeiKyuShichosonKubun(koseiShichosonMasterEntity.getGappeiKyuShichosonKubun());
        koseiShichosonJohoEntity.setGappeiKyuShichosonHyojiUmu(koseiShichosonMasterEntity.getGappeiKyuShichosonHyojiUmu());
        koseiShichosonJohoEntity.setGappeiChiikiNo(koseiShichosonMasterEntity.getGappeiChiikiNo());
        koseiShichosonJohoEntity.setUnyoHokenshaNo(koseiShichosonMasterEntity.getUnyoHokenshaNo());
        koseiShichosonJohoEntity.setUnyoKaishiYMD(koseiShichosonMasterEntity.getUnyoKaishiYMD());
        koseiShichosonJohoEntity.setUnyoShuryoYMD(koseiShichosonMasterEntity.getUnyoShuryoYMD());
        koseiShichosonJohoEntity.setUnyoKeitaiKubun(koseiShichosonMasterEntity.getUnyoKeitaiKubun());
        return koseiShichosonJohoEntity;

    }

    private RString getLoginUser() {
        RString loginUser = UrControlDataFactory.createInstance().getLoginInfo().getUserName();
        return ObjectUtil.defaultIfNull(loginUser, RString.EMPTY);
    }

    private int dispatchFlowByKaigoDonyuKeitai(RString 業務分類, RString 導入形態コード) {
        if ((業務分類.equals(GyomuBunrui.介護事務.getコード()) && 導入形態コード.equals(介護事務_120))
                || (業務分類.equals(GyomuBunrui.介護事務.getコード()) && 導入形態コード.equals(介護事務_112))
                || (業務分類.equals(GyomuBunrui.介護認定.getコード()) && 導入形態コード.equals(介護認定_220))) {
            return WORKFLOW_管理情報から;
        } else if ((業務分類.equals(GyomuBunrui.介護事務.getコード()) && 導入形態コード.equals(介護事務_111))
                || ((業務分類.equals(GyomuBunrui.介護認定.getコード()) && 導入形態コード.equals(介護認定_211)))) {
            return WORKFLOW_市町村識別IDから;
        } else {
            return WORKFLOW_NULL;
        }
    }

}

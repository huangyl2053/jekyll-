/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.business.config.fuka.DosaKanrenConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.rojinhokenjoho.RokenJohoConfig;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ValueObjects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
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

    private static final RString DEFAULT_市町村ＩＤ有効桁数 = new RString("2");
    private static final int MAX_市町村識別ID = 99;
    private static final int MIN_市町村識別ID = 1;
    private static final int WORKFLOW_管理情報から = 1;
    private static final int WORKFLOW_市町村識別IDから = 2;
    private static final int WORKFLOW_NULL = 0;
    private static final RString AUTHTYPE = new RString("koseiShichosonKengen");

    private final DbT7051KoseiShichosonMasterDac koseiShichosonMasterDac;
    private final KaigoDonyuKeitaiManager donyuKeitaiManager;

    /**
     * コンストラクタです。
     */
    protected ShichosonSecurityJohoFinder() {
        this.koseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.donyuKeitaiManager = KaigoDonyuKeitaiManager.createInstance();
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
     * 業務分類で{@link ShichosonSecurityJoho 市町村セキュリティ情報}を取得します。
     * <br/>
     * 市町村セキュリティ情報が取得できなかった場合、{@code null}を返却します。
     * 取得後は、かならず、{@code null}かどうかを検査してください。
     *
     * @param gyomuBunrui 業務分類
     * @return {@link ShichosonSecurityJoho}
     */
    @CheckForNull
    public ShichosonSecurityJoho getShichosonSecurityJoho(GyomuBunrui gyomuBunrui) {
        List<KaigoDonyuKeitai> list = this.donyuKeitaiManager.get介護導入形態By業務分類(gyomuBunrui);
        if (list.isEmpty()) {
            return null;
        }
        KaigoDonyuKeitai 介護導入形態 = list.get(0);
        return createShichosonSecurityJoho(
                dispatchFlowByKaigoDonyuKeitai(介護導入形態), 介護導入形態
        );
    }

    private int dispatchFlowByKaigoDonyuKeitai(KaigoDonyuKeitai 導入形態) {
        GyomuBunrui 業務分類 = 導入形態.get業務分類();
        DonyuKeitaiCode 導入形態コード = 導入形態.get導入形態コード();

        if ((業務分類 == GyomuBunrui.介護事務 && 導入形態コード == DonyuKeitaiCode.事務単一)
                || (業務分類 == GyomuBunrui.介護事務 && 導入形態コード == DonyuKeitaiCode.事務構成市町村)
                || (業務分類 == GyomuBunrui.介護認定 && 導入形態コード == DonyuKeitaiCode.認定単一)) {
            return WORKFLOW_管理情報から;
        }
        if ((業務分類 == GyomuBunrui.介護事務 && 導入形態コード == DonyuKeitaiCode.事務広域)
                || (業務分類 == GyomuBunrui.介護認定 && 導入形態コード == DonyuKeitaiCode.認定広域)) {
            return WORKFLOW_市町村識別IDから;
        }
        return WORKFLOW_NULL;
    }

    private ShichosonSecurityJoho createShichosonSecurityJoho(int workFlow, KaigoDonyuKeitai 導入形態) {
        switch (workFlow) {
            case WORKFLOW_管理情報から:
                return createShichosonSecurityJohoByKanriJoho(導入形態);
            case WORKFLOW_市町村識別IDから:
                return getKouseiShichosonJohoByLoginUser(導入形態);
            default:
                return null;
        }
    }

    private ShichosonSecurityJoho createShichosonSecurityJohoByKanriJoho(KaigoDonyuKeitai 導入形態) {
        return createShichosonSecurityJoho(導入形態, create市町村情報By管理情報());
    }

    private ShichosonSecurityJoho createShichosonSecurityJoho(KaigoDonyuKeitai 導入形態, ShichosonJoho 市町村情報) {
        ShichosonSecurityJoho.Builder builder = new ShichosonSecurityJoho.Builder(導入形態.get導入形態コード());
        builder.set支所管理有無フラグ(導入形態.exists支所管理());
        builder.set市町村ＩＤ有効桁数(DEFAULT_市町村ＩＤ有効桁数);
        builder.set市町村情報(市町村情報);
        builder.set広域タイプ(new HokenshaJohoConfig().get広域タイプ());
        return builder.build();
    }

    private ShichosonJoho create市町村情報By管理情報() {
        ShichosonJoho shichosonJoho = new ShichosonJoho();
        shichosonJoho.setShichosonShokibetsuID(ShichosonShikibetsuID.KOIKI);
        Association finder = AssociationFinderFactory.createInstance().getAssociation();
        shichosonJoho.setShichosonCode(finder.get地方公共団体コード());
        shichosonJoho.setTodofukenMeisho(finder.get都道府県名());
        shichosonJoho.setGunMeisho(finder.get郡名());
        HokenshaJohoConfig hokenshaJohoConfig = new HokenshaJohoConfig();
        shichosonJoho.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(hokenshaJohoConfig.get保険者情報_保険者番号()));
        shichosonJoho.setShichosonMeisho(hokenshaJohoConfig.get保険者情報_保険者名称());
        shichosonJoho.setYubinNo(hokenshaJohoConfig.get郵便番号().value());
        shichosonJoho.setJusho(hokenshaJohoConfig.get保険者住所().value());
        shichosonJoho.setTelNo(hokenshaJohoConfig.get電話番号().value());
        shichosonJoho.setYusenChikuCode(hokenshaJohoConfig.get最優先地区().code());
        ChohyoKyotsuJushoEditConfig jushoEditConfig = new ChohyoKyotsuJushoEditConfig();
        shichosonJoho.setTyohyoTodoufukenHyojiUmu(jushoEditConfig.get都道府県名付与有無().code());
        shichosonJoho.setTyohyoGunHyojiUmu(jushoEditConfig.get郡名付与有無().code());
        shichosonJoho.setTyohyoShichosonHyojiUmu(jushoEditConfig.get市町村名付与有無().code());
        shichosonJoho.setTyohyoJushoHenshuHouhou(jushoEditConfig.get住所編集方法().code());
        shichosonJoho.setTyohyoKatagakiHyojiUmu(jushoEditConfig.get方書表示有無().code());
        RokenJohoConfig rokenJohoConfig = new RokenJohoConfig();
        shichosonJoho.setRojinhokenShichosonNo(rokenJohoConfig.get市町村番号());
        shichosonJoho.setRokenJukyushaNoTaikei(rokenJohoConfig.get管理体系().code());
        DosaKanrenConfig dosaKanrenConfig = new DosaKanrenConfig();
        shichosonJoho.setTokuchoBunpaishuyaku(dosaKanrenConfig.get特徴分配集約システム().code());
        shichosonJoho.setKokuhorenKoikiShichosonNo(RString.EMPTY);
        shichosonJoho.setIkoYMD(FlexibleDate.EMPTY);
        shichosonJoho.setKanyuYMD(FlexibleDate.EMPTY);
        shichosonJoho.setRidatsuYMD(FlexibleDate.EMPTY);
        shichosonJoho.setGappeiKyuShichosonKubun(RString.EMPTY);
        shichosonJoho.setGappeiKyuShichosonHyojiUmu(RString.EMPTY);
        shichosonJoho.setGappeiChiikiNo(RString.EMPTY);
        shichosonJoho.setUnyoHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        shichosonJoho.setUnyoKaishiYMD(FlexibleDate.EMPTY);
        shichosonJoho.setUnyoShuryoYMD(FlexibleDate.EMPTY);
        shichosonJoho.setUnyoKeitaiKubun(RString.EMPTY);
        return shichosonJoho;
    }

    private ShichosonSecurityJoho getKouseiShichosonJohoByLoginUser(KaigoDonyuKeitai 導入形態) {
        RString loginUser = getLoginUser();
        List<AuthorityItem> authorityItemList = getShichosonShikibetsuId(loginUser);
        if (authorityItemList.isEmpty()) {
            return null;
        }
        RString shichosonShokibetsuID = authorityItemList.get(0).getItemId();
        return getShichosonSecurityJohoNotNull(shichosonShokibetsuID, 導入形態);
    }

    private RString getLoginUser() {
        RString loginUser = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
        return ObjectUtil.defaultIfNull(loginUser, RString.EMPTY);
    }

    private List<AuthorityItem> getShichosonShikibetsuId(RString reamsLoginId) {
        if (RString.isNullOrEmpty(reamsLoginId)) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("ログインユーザID"));
        }
        return AuthItem.getAuthorities(reamsLoginId, new AuthType.Of().kinds(AUTHTYPE).create(), RDate.getNowDate());
    }

    private ShichosonSecurityJoho getShichosonSecurityJohoNotNull(RString shichosonShokibetsuID, KaigoDonyuKeitai 導入形態) {
        int 市町村識別ID = Integer.valueOf(shichosonShokibetsuID.toString()).intValue();
        if (shichosonShokibetsuID.equals(ShichosonShikibetsuID.KOIKI.value())) {
            return createShichosonSecurityJohoByKanriJoho(導入形態);
        }
        if (MIN_市町村識別ID <= 市町村識別ID && 市町村識別ID <= MAX_市町村識別ID) {
            return createShichosonSecurityJoho(導入形態, getKoseiShichosonJohoEntity(shichosonShokibetsuID));
        }
        return null;
    }

    private ShichosonJoho getKoseiShichosonJohoEntity(RString shichosonShokibetsuID) {
        List<ShichosonJoho> shichosonJohoList = getKouseiShichosonJoho(shichosonShokibetsuID);
        return shichosonJohoList.isEmpty() ? null : shichosonJohoList.get(0);
    }

    private List<ShichosonJoho> getKouseiShichosonJoho(RString shichosonShokibetsuID) {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMaster
                = koseiShichosonMasterDac.selectBy市町村識別ID(shichosonShokibetsuID);

        List<ShichosonJoho> koseiShichosonJohList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMaster) {
            koseiShichosonJohList.add(toKoseiShichosonJohoEntity(entity));
        }
        return koseiShichosonJohList;
    }

    private ShichosonJoho toKoseiShichosonJohoEntity(
            DbT7051KoseiShichosonMasterEntity koseiShichosonMasterEntity) {
        ShichosonJoho koseiShichosonJohoEntity = new ShichosonJoho();
        koseiShichosonJohoEntity.setShichosonShokibetsuID(new ShichosonShikibetsuID(koseiShichosonMasterEntity.getShichosonShokibetsuID()));
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.koseishichoson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.business.config.fuka.DosaKanrenConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ChohyoKyotsuJushoEditConfig;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.rojinhokenjoho.RokenJohoConfig;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichoson;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 市町村情報_広域を取得クラスです。
 */
public class KoikiShichosonJohoFinder {

    private static final RString DEFAULT_SHICHOSON_SHOKIBETSUID = new RString("00");
    private static final RString DEFAULT_市町村識別コード = new RString("00");
    private static final RString DEFAULT_合併旧市町村区分 = new RString("0");

    private final DbT7051KoseiShichosonMasterDac koseiShichosonMasterDac;

    /**
     * コンストラクタです。
     */
    protected KoikiShichosonJohoFinder() {
        koseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * KoikiShichosonJohoFinder を生成します。
     *
     * @return KoikiShichosonJohoFinder
     */
    public static KoikiShichosonJohoFinder createInstance() {
        return InstanceProvider.create(KoikiShichosonJohoFinder.class);
    }

    /**
     * 合併前の旧市町村と最新の広域構成市町村を含む全部市町村情報を取得します
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 全部市町村情報
     */
    public List<DbT7051KoseiShichosonMasterEntity> getZenShichosonJoho() {
        return koseiShichosonMasterDac.zenShichosonJoho();
    }

    /**
     * 現市町村情報取得を取得します
     *
     * @return List<DbT7051KoseiShichosonMasterEntity> 現市町村情報
     */
    public List<DbT7051KoseiShichosonMasterEntity> getGenShichosonJoho() {
        return koseiShichosonMasterDac.genShichosonJoho();

    }

    /**
     * 構成市町村リストを作成します
     *
     * @return List<KoseiShichoson> 構成市町村リスト
     */
    public List<KoseiShichoson> getKoseiShichosonList() {
        List<KoseiShichoson> koseiShichosonList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : this.koseiShichosonMasterDac.genShichosonJoho()) {
            KoseiShichoson koseiShichoson = new KoseiShichoson(
                    entity.getShichosonCode(),
                    new ShichosonShikibetsuID(entity.getShichosonShokibetsuID()),
                    entity.getShoKisaiHokenshaNo(),
                    entity.getShichosonMeisho());
            koseiShichosonList.add(koseiShichoson);
        }
        return koseiShichosonList;

    }

    /**
     * 構成市町村ユーザ判定します
     *
     * @param 識別ID 市町村識別ID
     * @return ユーザ判定フラグ ( 市町村識別コードは’00’の合併旧市町村区分　＝'0'の場合true, 合併旧市町村区分＝'0'以外の場合false)
     */
    public boolean shichosonUserHandan(RString 識別ID) {
        DbT7051KoseiShichosonMasterEntity entity = koseiShichosonMasterDac.shichosonUserHandan(識別ID);
        return entity.getShichosonShokibetsuID().equals(DEFAULT_市町村識別コード)
               || Objects.equals(entity.getGappeiKyuShichosonKubun(), DEFAULT_合併旧市町村区分);
    }

    /**
     * ログインユーザーの属する市町村情報を取得します
     *
     * @param 識別ID 市町村識別ID
     * @return List<DbT7051KoseiShichosonMasterEntity>　ログインユーザーの属する市町村のリスト
     */
    public List<DbT7051KoseiShichosonMasterEntity> loginUserShichosonJoho(RString 識別ID) {
        return koseiShichosonMasterDac.loginUserShichosonJoho(識別ID);
    }

    /**
     * 市町村情報を取得します
     *
     * @return 広域市町村情報(DbT7051KoseiShichosonMasterEntity)のlist
     */
    public List<DbT7051KoseiShichosonMasterEntity> koseiShichosonJoho() {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonJohoList = new ArrayList<>();
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        entity.setShichosonShokibetsuID(DEFAULT_SHICHOSON_SHOKIBETSUID);
        entity.setShichosonCode(association.get地方公共団体コード());
        entity.setTodofukenMeisho(association.get都道府県名());
        entity.setGunMeisho(association.get郡名());
        entity.setKokuhorenKoikiShichosonNo(RString.EMPTY);

        HokenshaJohoConfig hokenshaJohoConfig = new HokenshaJohoConfig();
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(hokenshaJohoConfig.get保険者番号().value()));
        entity.setShichosonMeisho(hokenshaJohoConfig.get保険者名().value());
        entity.setYubinNo(hokenshaJohoConfig.get郵便番号());
        entity.setJusho(hokenshaJohoConfig.get保険者住所());
        entity.setTelNo(hokenshaJohoConfig.get電話番号());
        entity.setYusenChikuCode(hokenshaJohoConfig.get最優先地区().code());

        ChohyoKyotsuJushoEditConfig jushoEditConfig = new ChohyoKyotsuJushoEditConfig();
        entity.setTyohyoTodoufukenHyojiUmu(jushoEditConfig.get都道府県名付与有無().code());
        entity.setTyohyoGunHyojiUmu(jushoEditConfig.get郡名付与有無().code());
        entity.setTyohyoShichosonHyojiUmu(jushoEditConfig.get市町村名付与有無().code());
        entity.setTyohyoJushoHenshuHouhou(jushoEditConfig.get住所編集方法().code());
        entity.setTyohyoKatagakiHyojiUmu(jushoEditConfig.get方書表示有無().code());

        RokenJohoConfig rokenJohoConfig = new RokenJohoConfig();
        entity.setRojinhokenShichosonNo(rokenJohoConfig.get市町村番号());
        entity.setRokenJukyushaNoTaikei(rokenJohoConfig.get管理体系().code());

        DosaKanrenConfig dosaKanrenConfig = new DosaKanrenConfig();
        entity.setTokuchoBunpaishuyaku(dosaKanrenConfig.get特徴分配集約システム().code());

        entity.setIkoYMD(FlexibleDate.EMPTY);
        entity.setKanyuYMD(FlexibleDate.EMPTY);
        entity.setRidatsuYMD(FlexibleDate.EMPTY);
        entity.setGappeiKyuShichosonKubun(RString.EMPTY);
        entity.setGappeiKyuShichosonHyojiUmu(RString.EMPTY);
        entity.setGappeiChiikiNo(RString.EMPTY);
        entity.setUnyoHokenshaNo(ShoKisaiHokenshaNo.EMPTY);
        entity.setUnyoKaishiYMD(FlexibleDate.EMPTY);
        entity.setUnyoShuryoYMD(FlexibleDate.EMPTY);
        entity.setUnyoKeitaiKubun(RString.EMPTY);
        koseiShichosonJohoList.add(entity);
        return koseiShichosonJohoList;

    }

    /**
     * 指定された市町村コードの市町村が広域内の構成市町村に存在かチェック
     *
     * @param 市町村コード 市町村コード
     * @return 検索結果フラグ (検索結果がある場合true,検索結果がない場合false)
     */
    public boolean shichosonSonzaiHandan(RString 市町村コード) {
        DbT7051KoseiShichosonMasterEntity entity = koseiShichosonMasterDac.shichosonSonzaiHandan(市町村コード);
        return null != entity;
    }

    /**
     * 市町村コードによる市町村情報の検索します
     *
     * @param 市町村コード 市町村コード
     * @return List<DbT7051KoseiShichosonMasterEntity>　市町村コードによる市町村Entityのリスと
     */
    public List<DbT7051KoseiShichosonMasterEntity> shichosonCodeYoriShichosonJoho(LasdecCode 市町村コード) {
        return koseiShichosonMasterDac.shichosonCodeYoriShichosonJoho(市町村コード);
    }
}

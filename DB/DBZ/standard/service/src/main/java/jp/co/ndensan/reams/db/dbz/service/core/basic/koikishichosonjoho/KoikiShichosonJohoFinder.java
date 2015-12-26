 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.jushohenshu.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoseiShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonShikibetsuIDniYoruShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村情報_広域を取得クラスです。
 */
public class KoikiShichosonJohoFinder {

    private static final RString SHOKIBETSUID = new RString("00");
    private static final RString 市町村識別コード = new RString("00");
    private static final RString 合併旧市町村区分 = new RString("0");
    private final DbT7051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    KoikiShichosonJohoFinder() {
        dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param koseiShichosonMasterDac {@link DbT7051KoseiShichosonMasterDac}
     */
    KoikiShichosonJohoFinder(DbT7051KoseiShichosonMasterDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoikiShichosonJohoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoikiShichosonJohoFinder}のインスタンス
     */
    public static KoikiShichosonJohoFinder createInstance() {
        return InstanceProvider.create(KoikiShichosonJohoFinder.class);
    }

    /**
     * 合併前の旧市町村と最新の広域構成市町村を含む全部市町村情報を取得します。
     *
     * @return SearchResult<KoikiZenShichosonJoho> 全部市町村情報
     */
    @Transaction
    public SearchResult<KoikiZenShichosonJoho> getZenShichosonJoho() {
        List<KoikiZenShichosonJoho> koikiZenShichosonJohoList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.zenShichosonJoho();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            koikiZenShichosonJohoList.add(new KoikiZenShichosonJoho(entity));
        }
        return SearchResult.of(koikiZenShichosonJohoList, 0, false);
    }

    /**
     * 現市町村情報取得を取得します。
     *
     * @return SearchResult<KoikiZenShichosonJoho> 現市町村情報
     */
    @Transaction
    public SearchResult<KoikiZenShichosonJoho> getGenShichosonJoho() {
        List<KoikiZenShichosonJoho> koikiZenShichosonJohoList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.genShichosonJoho();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            koikiZenShichosonJohoList.add(new KoikiZenShichosonJoho(entity));
        }
        return SearchResult.of(koikiZenShichosonJohoList, 0, false);

    }

    /**
     * 構成市町村リストを作成します。
     *
     * @return SearchResult<KoseiShichoson> 構成市町村情報
     */
    @Transaction
    public SearchResult<KoseiShichoson> getKoseiShichosonList() {
        List<KoseiShichoson> koseiShichosonList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.koseiShichosonList();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            koseiShichosonList.add(new KoseiShichoson(entity));
        }
        return SearchResult.of(koseiShichosonList, 0, false);
    }

    /**
     * 構成市町村ユーザ判定します。
     *
     * @param 識別ID 市町村識別ID
     * @return ユーザ判定フラグ ( 市町村識別コードは’00’の合併旧市町村区分　＝'0'の場合true, 合併旧市町村区分＝'0'以外の場合false)
     */
    @Transaction
    public boolean isShichosonUserHandan(RString 識別ID) {
        requireNonNull(識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        DbT7051KoseiShichosonMasterEntity entity = dac.shichosonUserHandan(識別ID);
        return 市町村識別コード.equals(entity.getShichosonShokibetsuID())
                || 合併旧市町村区分.equals(entity.getGappeiKyuShichosonKubun());
    }

    /**
     * ログインユーザーの属する市町村情報を取得します。
     *
     * @param 識別ID 市町村識別ID
     * @return SearchResult<ShichosonShikibetsuIDniYoruShichosonJoho>
     * ログインユーザーの属する市町村の検索結果
     */
    @Transaction
    public SearchResult<ShichosonShikibetsuIDniYoruShichosonJoho> loginUserShichosonJoho(RString 識別ID) {
        requireNonNull(識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));
        List<ShichosonShikibetsuIDniYoruShichosonJoho> shichosonList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.loginUserShichosonJoho(識別ID);
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            shichosonList.add(new ShichosonShikibetsuIDniYoruShichosonJoho(entity));
        }
        return SearchResult.of(shichosonList, 0, false);
    }

    /**
     * 市町村情報を取得します。
     *
     * @return SearchResult<DbT7051KoseiShichosonMasterEntity>　市町村情報の検索結果
     */
    @Transaction
    public SearchResult<KoikiZenShichosonJoho> koseiShichosonJoho() {
        List<KoikiZenShichosonJoho> koseiShichosonJohoList = new ArrayList<>();
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        entity.setShichosonShokibetsuID(SHOKIBETSUID);
        entity.setShichosonCode(new LasdecCode(association.get地方公共団体コード().value()));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(BusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号,
                SubGyomuCode.DBU介護統計報告)));
        entity.setShichosonMeisho(BusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, SubGyomuCode.DBU介護統計報告));
        entity.setTodofukenMeisho(association.get都道府県名());
        entity.setGunMeisho(association.get郡名());
        entity.setYubinNo(new YubinNo(BusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_郵便番号, SubGyomuCode.DBU介護統計報告)));
        entity.setJusho(new AtenaJusho(BusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_住所, SubGyomuCode.DBU介護統計報告)));
        entity.setTelNo(new TelNo(BusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_電話番号, SubGyomuCode.DBU介護統計報告)));
        entity.setYusenChikuCode(BusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_最優先地区コード, SubGyomuCode.DBU介護統計報告));
        entity.setTyohyoTodoufukenHyojiUmu(BusinessConfig.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, SubGyomuCode.DBU介護統計報告));
        entity.setTyohyoGunHyojiUmu(BusinessConfig.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_郡名付与有無, SubGyomuCode.DBU介護統計報告));
        entity.setTyohyoShichosonHyojiUmu(BusinessConfig.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_市町村名付与有無, SubGyomuCode.DBU介護統計報告));
        entity.setTyohyoJushoHenshuHouhou(BusinessConfig.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_編集方法, SubGyomuCode.DBU介護統計報告));
        entity.setTyohyoKatagakiHyojiUmu(BusinessConfig.get(
                ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_住所編集_方書表示有無, SubGyomuCode.DBU介護統計報告));
        entity.setRojinhokenShichosonNo(BusinessConfig.get(ConfigNameDBU.老人保健情報_市町村番号, SubGyomuCode.DBU介護統計報告));
        entity.setRokenJukyushaNoTaikei(BusinessConfig.get(ConfigNameDBD.老人保健情報_管理体系, SubGyomuCode.DBD介護受給));
        entity.setTokuchoBunpaishuyaku(BusinessConfig.get(ConfigNameDBB.動作関連_特徴分配集約システム, SubGyomuCode.DBB介護賦課));
        entity.setKokuhorenKoikiShichosonNo(RString.EMPTY);
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
        koseiShichosonJohoList.add(new KoikiZenShichosonJoho(entity));
        return SearchResult.of(koseiShichosonJohoList, 0, false);
    }

    /**
     * 指定された市町村コードの市町村が広域内の構成市町村に存在かチェック。
     *
     * @param 市町村コード 市町村コード
     * @return 検索結果フラグ (検索結果がある場合true,検索結果がない場合false)
     */
    @Transaction
    public boolean isShichosonSonzaiHandan(RString 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        DbT7051KoseiShichosonMasterEntity entity = dac.shichosonSonzaiHandan(市町村コード);
        return null != entity;
    }

    /**
     * 市町村コードによる市町村情報の検索します。
     *
     * @param 市町村コード 市町村コード
     * @return SearchResult<ShichosonCodeYoriShichoson>　市町村情報の検索結果
     */
    @Transaction
    public SearchResult<ShichosonCodeYoriShichoson> shichosonCodeYoriShichosonJoho(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        List<ShichosonCodeYoriShichoson> shichosonList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.shichosonCodeYoriShichosonJoho(市町村コード);
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            shichosonList.add(new ShichosonCodeYoriShichoson(entity));
        }
        return SearchResult.of(shichosonList, 0, false);
    }
}

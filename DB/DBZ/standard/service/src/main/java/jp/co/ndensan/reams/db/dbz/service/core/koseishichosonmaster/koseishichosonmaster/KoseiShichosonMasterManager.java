/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.koseishichosonmaster.koseishichosonmaster;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.config.HokenshaJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.kyotsutokei.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.koseishichosonmaster.IKoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMasterManager;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMasterManager {

    private static final RString 市町村識別コード = new RString("00");
    private static final RString 合併旧市町村区分 = new RString("0");
    private static final RString SHICHOSONSHOKIBETSUID = new RString("00");
    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;
    private final KoseiShichosonShishoMasterManager 構成市町村支所マスタManager;

    /**
     * コンストラクタです。
     */
    KoseiShichosonMasterManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.構成市町村支所マスタManager = new KoseiShichosonShishoMasterManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 構成市町村マスタDac 構成市町村マスタDac
     * @param 構成市町村支所マスタManager 構成市町村支所マスタManager
     */
    KoseiShichosonMasterManager(
            MapperProvider mapperProvider,
            DbT7051KoseiShichosonMasterDac 構成市町村マスタDac,
            KoseiShichosonShishoMasterManager 構成市町村支所マスタManager
    ) {
        this.mapperProvider = mapperProvider;
        this.構成市町村マスタDac = 構成市町村マスタDac;
        this.構成市町村支所マスタManager = 構成市町村支所マスタManager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンス
     */
    public static KoseiShichosonMasterManager createInstance() {
        return InstanceProvider.create(KoseiShichosonMasterManager.class);
    }

    /**
     * 主キーに合致する構成市町村マスタを返します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMaster
     */
    @Transaction
    public KoseiShichosonMaster get構成市町村マスタ(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件) {
        requireNonNull(構成市町村マスタ検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ検索条件"));
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);

        KoseiShichosonMasterRelateEntity relateEntity = mapper.getKoseiShichosonEntity(構成市町村マスタ検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KoseiShichosonMaster(relateEntity);
    }

    /**
     * 構成市町村マスタ{@link KoseiShichosonMaster}を保存します。
     *
     * @param 構成市町村マスタ 構成市町村マスタ
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KoseiShichosonMaster 構成市町村マスタ) {
        requireNonNull(構成市町村マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ"));

        if (!構成市町村マスタ.hasChanged()) {
            return false;
        }
        構成市町村マスタ = 構成市町村マスタ.modifiedModel();
        save構成市町村支所マスタリスト(構成市町村マスタ.getKoseiShichosonShishoMasterList());
        return 1 == 構成市町村マスタDac.save(構成市町村マスタ.toEntity());
    }

    /**
     * 合併前の旧市町村と最新の広域構成市町村を含む構成市町村マスタ情報を取得します。
     *
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> getZenShichosonJoho() {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMasterEntityList = 構成市町村マスタDac.zenShichosonJoho();
        List<KoseiShichosonMaster> 構成市町村マスタList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMasterEntityList) {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            relateEntity.set構成市町村マスタEntity(entity);
            構成市町村マスタList.add(new KoseiShichosonMaster(relateEntity));
        }
        return 構成市町村マスタList;
    }

    /**
     * 構成市町村マスタ情報を取得します。
     *
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> getGenShichosonJoho() {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMasterEntityList = 構成市町村マスタDac.genShichosonJoho();
        List<KoseiShichosonMaster> 構成市町村マスタList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMasterEntityList) {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            relateEntity.set構成市町村マスタEntity(entity);
            構成市町村マスタList.add(new KoseiShichosonMaster(relateEntity));
        }
        return 構成市町村マスタList;
    }

    /**
     * 構成市町村マスタ情報を作成します。
     *
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> getKoseiShichosonList() {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMasterEntityList = 構成市町村マスタDac.koseiShichosonList();
        List<KoseiShichosonMaster> 構成市町村マスタList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMasterEntityList) {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            relateEntity.set構成市町村マスタEntity(entity);
            構成市町村マスタList.add(new KoseiShichosonMaster(relateEntity));
        }
        return 構成市町村マスタList;
    }

    /**
     * 構成市町村ユーザ判定します。
     *
     * @param parameter KoseiShichosonMasterMapperParameter
     * @return ユーザ判定フラグ ( 市町村識別コードは’00’と合併旧市町村区分　＝'0'の場合true,
     * 合併旧市町村区分＝'0'以外の場合false)
     */
    public boolean shichosonUserHandan(KoseiShichosonMasterMapperParameter parameter) {
        DbT7051KoseiShichosonMasterEntity entity = 構成市町村マスタDac.shichosonUserHandan(parameter.getShichosonShokibetsuID());

        return 市町村識別コード.equals(entity.getShichosonShokibetsuID())
                || 合併旧市町村区分.equals(entity.getGappeiKyuShichosonKubun());
    }

    /**
     * ログインユーザーの属する市町村情報を取得します。
     *
     * @param parameter KoseiShichosonMasterMapperParameter
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> loginUserShichosonJoho(KoseiShichosonMasterMapperParameter parameter) {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMasterEntityList
                = 構成市町村マスタDac.loginUserShichosonJoho(parameter.getShichosonShokibetsuID());
        List<KoseiShichosonMaster> 構成市町村マスタList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMasterEntityList) {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            relateEntity.set構成市町村マスタEntity(entity);
            構成市町村マスタList.add(new KoseiShichosonMaster(relateEntity));
        }
        return 構成市町村マスタList;
    }

    /**
     * 市町村情報を取得します。
     *
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> koseiShichosonJoho() {
        List<KoseiShichosonMaster> koseiShichosonMasterList = new ArrayList<>();
        KoseiShichosonMasterRelateEntity koseiShichosonMasterEntity = new KoseiShichosonMasterRelateEntity();
        DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        // TODO 凌護行 テーブルに「市町村識別コード」がない、QA回答まち。
        entity.setShichosonShokibetsuID(SHICHOSONSHOKIBETSUID);
        entity.setShichosonCode(new LasdecCode(association.get地方公共団体コード().value()));
        entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(BusinessConfig.get(HokenshaJoho.保険者情報_保険者番号,
                SubGyomuCode.DBU介護統計報告)));
        entity.setKokuhorenKoikiShichosonNo(RString.EMPTY);
        entity.setShichosonMeisho(BusinessConfig.get(HokenshaJoho.保険者情報_保険者名称, SubGyomuCode.DBU介護統計報告));
        entity.setTodofukenMeisho(association.get都道府県名());
        entity.setGunMeisho(association.get郡名());
        entity.setYubinNo(new YubinNo(BusinessConfig.get(HokenshaJoho.保険者情報_郵便番号, SubGyomuCode.DBU介護統計報告)));
        entity.setJusho(new AtenaJusho(BusinessConfig.get(HokenshaJoho.保険者情報_住所, SubGyomuCode.DBU介護統計報告)));
        entity.setTelNo(new TelNo(BusinessConfig.get(HokenshaJoho.保険者情報_電話番号, SubGyomuCode.DBU介護統計報告)));
        entity.setYusenChikuCode(BusinessConfig.get(HokenshaJoho.保険者情報_最優先地区コード, SubGyomuCode.DBU介護統計報告));
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
//         TODO 凌護行 Enum:ConfigNameDBUクラスに「老人保健情報_市町村番号」がありません。 QA回答まち
//        entity.setRojinhokenShichosonNo(BusinessConfig.get(ConfigNameDBU.老人保健情報_市町村番号, SubGyomuCode.DBU介護統計報告));
//         TODO 凌護行 Enum:ConfigNameDBDクラスがありません。 QA回答まち
//        entity.setRokenJukyushaNoTaikei(BusinessConfig.get(ConfigNameDBD.老人保健情報_管理体系, SubGyomuCode.DBD介護受給));
//         TODO 凌護行 Enum:ConfigNameDBBクラスがありません。 QA回答まち
//        entity.setTokuchoBunpaishuyaku(BusinessConfig.get(ConfigNameDBB.動作関連_特徴分配集約システム, SubGyomuCode.DBB介護賦課));
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
        koseiShichosonMasterEntity.set構成市町村マスタEntity(entity);
        koseiShichosonMasterList.add(new KoseiShichosonMaster(koseiShichosonMasterEntity));
        return koseiShichosonMasterList;

    }

    /**
     * 指定された市町村コードの市町村が広域内の構成市町村に存在かチェック。
     *
     * @param 市町村コード LasdecCode
     * @return 検索結果フラグ (検索結果がある場合true,検索結果がない場合false)
     */
    public boolean shichosonSonzaiHandan(RString 市町村コード) {
        DbT7051KoseiShichosonMasterEntity entity = 構成市町村マスタDac.shichosonSonzaiHandan(市町村コード);
        return null != entity;
    }

    /**
     * 市町村コードによる市町村情報の検索します。
     *
     * @param 市町村コード LasdecCode
     * @return List<KoseiShichosonMaster>
     */
    public List<KoseiShichosonMaster> shichosonCodeYoriShichosonJoho(LasdecCode 市町村コード) {
        List<DbT7051KoseiShichosonMasterEntity> koseiShichosonMasterEntityList = 構成市町村マスタDac.shichosonCodeYoriShichosonJoho(市町村コード);
        List<KoseiShichosonMaster> 構成市町村マスタList = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : koseiShichosonMasterEntityList) {
            KoseiShichosonMasterRelateEntity relateEntity = new KoseiShichosonMasterRelateEntity();
            relateEntity.set構成市町村マスタEntity(entity);
            構成市町村マスタList.add(new KoseiShichosonMaster(relateEntity));
        }
        return 構成市町村マスタList;
    }

    private void save構成市町村支所マスタリスト(List<KoseiShichosonShishoMaster> 構成市町村支所マスタList) {
        for (KoseiShichosonShishoMaster 構成市町村支所マスタ : 構成市町村支所マスタList) {
            構成市町村支所マスタManager.save構成市町村支所マスタ(構成市町村支所マスタ);
        }
    }
}

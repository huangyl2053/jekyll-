/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.ServiceItiranHyojiJohoBusiness;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.ServiceJohoBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.JigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kaigojigyoshashisetsukanri.IKaigoJigyoshaShisetsuKanriMapper;
import jp.co.ndensan.reams.db.dba.service.core.jigyoshatouroku.JigyoshaTourokuFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaManager;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoJogaiTokureiTaishoShisetsuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者・施設管理Managerクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public class KaigoJigyoshaShisetsuKanriManager {

    private final MapperProvider mapperProvider;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dbT7063dac;
    private static final RString 介護保険施設 = new RString("11");
    private final KaigoJigyoshaManager manager;
    private final KaigoJogaiTokureiTaishoShisetsuManager 対象施設;

    /**
     * コンストラクタです。
     */
    KaigoJigyoshaShisetsuKanriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1005dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
        this.dbT7063dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        this.manager = InstanceProvider.create(KaigoJigyoshaManager.class);
        this.対象施設 = InstanceProvider.create(KaigoJogaiTokureiTaishoShisetsuManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    KaigoJigyoshaShisetsuKanriManager(MapperProvider mapperProvider,
            DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005dac,
            DbT7063KaigoJigyoshaShiteiServiceDac dbT7063dac,
            KaigoJigyoshaManager manager,
            KaigoJogaiTokureiTaishoShisetsuManager 対象施設) {
        this.mapperProvider = mapperProvider;
        this.dbT1005dac = dbT1005dac;
        this.dbT7063dac = dbT7063dac;
        this.manager = manager;
        this.対象施設 = 対象施設;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaShisetsuKanriManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaShisetsuKanriManager}のインスタンス
     */
    public static KaigoJigyoshaShisetsuKanriManager createInstance() {
        return InstanceProvider.create(KaigoJigyoshaShisetsuKanriManager.class);
    }

    /**
     * 有効期間合理性チェックします。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return boolean
     */
    @Transaction
    public boolean checkKikanGorisei(KaigoJogaiTokureiParameter parameter) {

        FlexibleDate yukoShuryoYMD = parameter.getYukoShuryoYMD();
        boolean checkFlag = false;
        if (yukoShuryoYMD != null && !yukoShuryoYMD.isEmpty()) {
            checkFlag = parameter.getYukoKaishiYMD().isBeforeOrEquals(yukoShuryoYMD);
        } else {
            checkFlag = true;
        }
        return checkFlag;
    }

    /**
     * 有効期間重複チェックします。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @param 変更前の有効開始日 FlexibleDate
     * @return boolean true/false
     */
    @Transaction
    public boolean checkKikanJufuku(KaigoJigyoshaParameter parameter, FlexibleDate 変更前の有効開始日) {
        boolean 重複チェックフラグ = false;
        IKaigoJigyoshaShisetsuKanriMapper mapper = mapperProvider.create(IKaigoJigyoshaShisetsuKanriMapper.class);
        List<KaigoJigyoshaRelateEntity> relateEntityList;
        if (介護保険施設.equals(parameter.get事業者種別())) {
            relateEntityList = mapper.getCheckKikanJufuku(parameter);
            KaigoJigyoshaRelateEntity entity = new KaigoJigyoshaRelateEntity();
            entity.setYukoKaishiYMD(変更前の有効開始日);
            entity.setYukoShuryoYMD(parameter.getYukoShuryoYMD());
            relateEntityList.add(entity);
        } else {
            relateEntityList = mapper.getCheckKikanJufukui(parameter);
            KaigoJigyoshaRelateEntity relateentity = new KaigoJigyoshaRelateEntity();
            relateentity.setYukoKaishiYMD(parameter.getYukoKaishiYMD());
            relateentity.setYukoShuryoYMD(parameter.getYukoShuryoYMD());
            relateEntityList.add(relateentity);
        }
        Collections.sort(relateEntityList, new DateComparator());
        int count = 1;
        for (KaigoJigyoshaRelateEntity relateEntity : relateEntityList) {
            if (count != relateEntityList.size() && relateEntity.getYukoShuryoYMD() == null) {
                重複チェックフラグ = true;
                break;
            }
            if (count != relateEntityList.size() && relateEntity.getYukoShuryoYMD() != null
                    && relateEntityList.get(count).getYukoKaishiYMD() != null
                    && relateEntityList.get(count).getYukoKaishiYMD().isBeforeOrEquals(relateEntity.getYukoShuryoYMD())) {
                重複チェックフラグ = true;
                break;
            }
            count = count + 1;
        }
        return 重複チェックフラグ;
    }

    /**
     * サービスと事業者期間関連のチェックします。
     *
     * @param サービス一覧List List<ServiceJohoBusiness>
     * @param 事業者の有効開始日 FlexibleDate
     * @param 事業者の有効終了日 FlexibleDate
     */
    @Transaction
    public void サービスと事業者期間関連のチェック(List<ServiceJohoBusiness> サービス一覧List,
            FlexibleDate 事業者の有効開始日, FlexibleDate 事業者の有効終了日) {
        StringBuilder エラーメッセージ = new StringBuilder();
        for (ServiceJohoBusiness サービス一覧 : サービス一覧List) {
            FlexibleDate 有効開始日 = サービス一覧.get有効開始日();
            FlexibleDate 有効終了日 = サービス一覧.get有効終了日();
            if (有効終了日 != null && 有効終了日.isEmpty() && 事業者の有効開始日.isBefore(有効終了日)) {
                エラーメッセージ.append(サービス一覧.getサービス種類略称());
                throw new ApplicationException(DbzErrorMessages.適用期間対象外.getMessage().replace(エラーメッセージ.toString()));
            }
            if (有効終了日 != null && 有効終了日.isEmpty() && 事業者の有効終了日.isBefore(有効開始日)) {
                エラーメッセージ.append(サービス一覧.getサービス種類略称());
                throw new ApplicationException(DbzErrorMessages.適用期間対象外.getMessage().replace(エラーメッセージ.toString()));
            }
            エラーメッセージ.append(new RString(" "));
        }
    }

    /**
     * 事業者情報取得、事業者種別はサービス事業者の情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return 事業者情報取得
     */
    @Transaction
    public SearchResult<KaigoJigyosha> getJigyoshaJoho(KaigoJigyoshaShisetsuKanriMapperParameter parameter) {
        List<KaigoJigyosha> serviceShuruiList = new ArrayList<>();
        IKaigoJigyoshaShisetsuKanriMapper iKaigoJigyoshaShisetsuKanri = mapperProvider.create(IKaigoJigyoshaShisetsuKanriMapper.class);
        List<KaigoJigyoshaEntity> サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getJigyoshaJoho(parameter);
        if (サービス一覧情報 == null || サービス一覧情報.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJigyosha>emptyList(), 0, false);
        }
        for (KaigoJigyoshaEntity entity : サービス一覧情報) {
            entity.initializeMd5ToEntities();
            serviceShuruiList.add(new KaigoJigyosha(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 事業者情報取得、事業者種別はサービス事業者のサービス一覧表示情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧表示情報取得
     */
    @Transaction
    public SearchResult<ServiceItiranHyojiJohoBusiness> getServiceItiranHyojiJoho(KaigoJogaiTokureiParameter parameter) {

        List<ServiceItiranHyojiJohoBusiness> serviceShuruiList = new ArrayList();
        IKaigoJigyoshaShisetsuKanriMapper iKaigoJigyoshaShisetsuKanri = mapperProvider.create(IKaigoJigyoshaShisetsuKanriMapper.class);
        List<JigyoshaShiteiServiceEntity> サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getServiceItiranHyojiJoho(parameter);
        if (サービス一覧情報.isEmpty()) {
            サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getServiceItiranHyojiJohoForEmpty(parameter);
        }
        for (JigyoshaShiteiServiceEntity entity : サービス一覧情報) {
            JigyoshaShiteiServiceEntity relateEntity = new JigyoshaShiteiServiceEntity();
            ServiceItiranHyojiJohoBusiness business;
            if (entity == null) {
                relateEntity.setJigyoshaName(AtenaMeisho.EMPTY);
                relateEntity.setKanrishaName(AtenaMeisho.EMPTY);
                relateEntity.setServiceShuruiCode(ServiceShuruiCode.EMPTY);
                relateEntity.setYukoKaishiYMD(FlexibleDate.EMPTY);
                relateEntity.setYukoShuryoYMD(FlexibleDate.EMPTY);
                relateEntity.setServiceShuruiRyakusho(RString.EMPTY);
                business = new ServiceItiranHyojiJohoBusiness(relateEntity);
            } else {
                business = new ServiceItiranHyojiJohoBusiness(entity);
            }
            serviceShuruiList.add(business);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 事業者情報取得、事業者種別はサービス事業者のサービス一覧情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧情報取得
     */
    @Transaction
    public SearchResult<KaigoJigyoshaShiteiService> getServiceItiranJoho(KaigoJogaiTokureiParameter parameter) {

        List<KaigoJigyoshaShiteiService> serviceShuruiList = new ArrayList();
        IKaigoJigyoshaShisetsuKanriMapper iKaigoJigyoshaShisetsuKanri = mapperProvider.create(IKaigoJigyoshaShisetsuKanriMapper.class);
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getServiceItiranJoho(parameter);
        for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : サービス一覧情報) {
            KaigoJigyoshaShiteiService business = new KaigoJigyoshaShiteiService(entity);
            serviceShuruiList.add(business);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 事業者情報取得、事業者種別はその他特例施設または適用除外施設の情報を取得します。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return 事業者情報取得
     */
    @Transaction
    public SearchResult<KaigoJogaiTokureiTaishoShisetsu> selectByKoseiShichosonMasterList(KaigoJigyoshaParameter parameter) {

        List<KaigoJogaiTokureiTaishoShisetsu> serviceShuruiList = new ArrayList<>();
        List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> 事業者情報取得 = dbT1005dac.selectJigyoshaJoho(parameter.get事業者種別(), parameter.getJigyoshaNo(),
                parameter.getYukoKaishiYMD());
        if (事業者情報取得 == null || 事業者情報取得.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJogaiTokureiTaishoShisetsu>emptyList(), 0, false);
        }
        for (DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity : 事業者情報取得) {
            serviceShuruiList.add(new KaigoJogaiTokureiTaishoShisetsu(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 事業者登録処理します。
     *
     * @param 事業者登録情報 KaigoJigyosha
     * @param 事業者種別 RString
     * @param 介護除外住所地特例対象施設 KaigoJogaiTokureiTaishoShisetsu
     * @return count 件数
     */
    @Transaction
    public boolean insertJigyoshaJoho(KaigoJigyosha 事業者登録情報,
            RString 事業者種別,
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設) {
        if (事業者種別.equals(介護保険施設)) {
            return manager.save(事業者登録情報);
        } else {
            return 対象施設.save介護除外住所地特例対象施設(介護除外住所地特例対象施設);
        }
    }

    /**
     * 事業者修正処理します。
     *
     * @param 旧事業者情報 KaigoJigyosha
     * @param 事業者情報 KaigoJigyosha
     * @param 事業者種別 RString
     * @param 旧施設情報 KaigoJogaiTokureiTaishoShisetsu
     * @param 施設情報 KaigoJogaiTokureiTaishoShisetsu
     * @return count 件数
     */
    @Transaction
    public boolean updateJigyoshaJoho(KaigoJigyosha 旧事業者情報, KaigoJigyosha 事業者情報,
            RString 事業者種別,
            KaigoJogaiTokureiTaishoShisetsu 旧施設情報, KaigoJogaiTokureiTaishoShisetsu 施設情報) {
        if (介護保険施設.equals(事業者種別)) {
            if (旧事業者情報.get有効開始日().equals(事業者情報.get有効開始日())) {
                return manager.save(事業者情報);
            } else {
                JigyoshaTourokuFinder jigyoshaTourokuFinder = JigyoshaTourokuFinder.createInstance();
                KaigoJigyoshaDaihyoshaIdentifier identifier
                        = new KaigoJigyoshaDaihyoshaIdentifier(旧事業者情報.get事業者番号(), 旧事業者情報.get有効開始日());
                KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = 旧事業者情報.getKaigoJigyoshaDaihyoshaList(identifier);
                KaigoJigyoshaDaihyoshaBuilder kaigoJigyoshaDaihyoshaBuilder = kaigoJigyoshaDaihyosha.createBuilderForEdit();
                kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyoshaBuilder.build();
                KaigoJigyoshaBuilder kaigoJigyoshaBuilder = 旧事業者情報.createBuilderForEdit();
                kaigoJigyoshaBuilder.setKaigoJigyoshaDaihyosha(kaigoJigyoshaDaihyosha.deleted());
                旧事業者情報 = kaigoJigyoshaBuilder.build();
                jigyoshaTourokuFinder.saveOrDelete(旧事業者情報);
                return manager.save(事業者情報);
            }
        } else {
            if (旧施設情報.get有効開始年月日().equals(施設情報.get有効開始年月日())) {
                return 対象施設.save介護除外住所地特例対象施設(施設情報);
            } else {
                saveOrDelete(旧施設情報);
                return 対象施設.save介護除外住所地特例対象施設(施設情報);
            }
        }
    }

    /**
     * 事業者サービス情報取得。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return 事業者サービス情報取得
     */
    @Transaction
    public SearchResult<KaigoJigyoshaShiteiService> getJigyoshaServiceJoho(KaigoJigyoshaShisetsuKanriMapperParameter parameter) {

        List<KaigoJigyoshaShiteiService> serviceShuruiList = new ArrayList<>();
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> 事業者サービス情報取得 = dbT7063dac.select事業者サービス(parameter.getJigyoshaNo(),
                parameter.getサービス種類コード(), parameter.getYukoKaishiYMD());
        if (事業者サービス情報取得 == null || 事業者サービス情報取得.isEmpty()) {
            return SearchResult.of(Collections.<KaigoJigyoshaShiteiService>emptyList(), 0, false);
        }
        for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : 事業者サービス情報取得) {
            entity.initializeMd5();
            serviceShuruiList.add(new KaigoJigyoshaShiteiService(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 事業者サービス情報登録します。
     *
     * @param 事業者サービス情報登録 KaigoJigyoshaShiteiService
     * @return count 件数
     */
    @Transaction
    public boolean insertJigyoshaServiceJoho(KaigoJigyoshaShiteiService 事業者サービス情報登録) {
        if (!事業者サービス情報登録.hasChanged()) {
            return false;
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity dbT7063Entity = 事業者サービス情報登録.toEntity();
        dbT7063Entity.setState(EntityDataState.Added);
        return 1 == dbT7063dac.save(dbT7063Entity);
    }

    /**
     * 事業者サービス情報修正します。
     *
     * @param 旧事業者サービス情報 KaigoJigyoshaShiteiService
     * @param 事業者サービス情報 KaigoJigyoshaShiteiService
     * @return count 件数
     */
    @Transaction
    public boolean updateJigyoshaServiceJoho(
            KaigoJigyoshaShiteiService 旧事業者サービス情報,
            KaigoJigyoshaShiteiService 事業者サービス情報) {
        if (旧事業者サービス情報.get有効開始日().equals(事業者サービス情報.get有効開始日())) {
            DbT7063KaigoJigyoshaShiteiServiceEntity dbT7063Entity = 事業者サービス情報.toEntity();
            dbT7063Entity.setState(EntityDataState.Modified);
            return 1 == dbT7063dac.save(dbT7063Entity);
        } else {
            旧事業者サービス情報 = 旧事業者サービス情報.deleted();
            dbT7063dac.delete(旧事業者サービス情報.toEntity());
            DbT7063KaigoJigyoshaShiteiServiceEntity dbT7063Entity = 事業者サービス情報.toEntity();
            dbT7063Entity.setState(EntityDataState.Added);
            return 1 == dbT7063dac.save(dbT7063Entity);
        }
    }

    /**
     * 施設登録画面用、施設情報を物理削除します。
     *
     * @param 介護事業者 介護事業者
     * @return 更新あり:true、更新なし:false
     */
    @Transaction
    public boolean saveOrDelete(KaigoJogaiTokureiTaishoShisetsu 介護事業者) {
        requireNonNull(介護事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者"));
        if (!介護事業者.hasChanged()) {
            return false;
        }
        介護事業者 = 介護事業者.deleted();
        return 1 == dbT1005dac.saveOrDeletePhysicalBy(介護事業者.toEntity());
    }

    /**
     * 施設登録画面用、施設情報を物理削除します。
     *
     * @param 事業者種別 RString
     * @param 事業者番号 RString
     * @param 有効開始年月日 FlexibleDate
     * @return 存在します:true、存在しなし:false
     */
    @Transaction
    public boolean 施設情報存在チェック(RString 事業者種別, RString 事業者番号, FlexibleDate 有効開始年月日) {
        DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = dbT1005dac.selectByKey(事業者種別, 事業者番号, 有効開始年月日);
        return entity != null;
    }

    private static class DateComparator implements Comparator<KaigoJigyoshaRelateEntity>, Serializable {

        @Override
        public int compare(KaigoJigyoshaRelateEntity o1, KaigoJigyoshaRelateEntity o2) {
            if (o1.getYukoKaishiYMD() != null && o2.getYukoKaishiYMD() != null) {
                return o1.getYukoKaishiYMD().compareTo(o2.getYukoKaishiYMD());
            }
            return -1;
        }
    }
}

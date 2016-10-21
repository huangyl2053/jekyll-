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
import jp.co.ndensan.reams.db.dba.service.core.jigyoshaservice.JigyoshaServiceManager;
import jp.co.ndensan.reams.db.dba.service.core.jigyoshatouroku.JigyoshaTourokuFinder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceIdentifier;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.Models;
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
    private static final RString 介護保険施設 = new RString("11");
    private final KaigoJigyoshaManager 事業者Manager;
    private final JigyoshaServiceManager 事業者サービスManager;
    private final KaigoJogaiTokureiTaishoShisetsuManager 対象施設;

    /**
     * コンストラクタです。
     */
    KaigoJigyoshaShisetsuKanriManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1005dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
        this.事業者Manager = InstanceProvider.create(KaigoJigyoshaManager.class);
        this.事業者サービスManager = InstanceProvider.create(JigyoshaServiceManager.class);
        this.対象施設 = InstanceProvider.create(KaigoJogaiTokureiTaishoShisetsuManager.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    KaigoJigyoshaShisetsuKanriManager(MapperProvider mapperProvider,
            DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005dac,
            KaigoJigyoshaManager manager,
            JigyoshaServiceManager 事業者サービスManager,
            KaigoJogaiTokureiTaishoShisetsuManager 対象施設) {
        this.mapperProvider = mapperProvider;
        this.dbT1005dac = dbT1005dac;
        this.事業者Manager = manager;
        this.事業者サービスManager = 事業者サービスManager;
        this.対象施設 = 対象施設;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaShisetsuKanriManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaShisetsuKanriManager}のインスタンス
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

        FlexibleDate yukoKaishiYMD = parameter.getYukoKaishiYMD();
        yukoKaishiYMD = yukoKaishiYMD == null || yukoKaishiYMD.isEmpty() ? FlexibleDate.MIN : yukoKaishiYMD;
        FlexibleDate yukoShuryoYMD = parameter.getYukoShuryoYMD();
        boolean checkFlag;
        if (yukoShuryoYMD != null && !yukoShuryoYMD.isEmpty()) {
            checkFlag = yukoKaishiYMD.isBeforeOrEquals(yukoShuryoYMD);
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

        RStringBuilder エラーメッセージ = new RStringBuilder();
        for (ServiceJohoBusiness サービス一覧 : サービス一覧List) {
            RString サービス略称 = サービス一覧.getサービス種類略称();
            FlexibleDate 有効開始日 = サービス一覧.get有効開始日();
            FlexibleDate 有効終了日 = サービス一覧.get有効終了日();

            if (事業者の有効開始日 == null || 事業者の有効開始日.isEmpty()) {
                エラーメッセージ.append(サービス略称);
                エラーメッセージ.append(new RString(" "));
                continue;
            }
            if (有効開始日 != null && !有効開始日.isEmpty() && 有効開始日.isBefore(事業者の有効開始日)) {
                エラーメッセージ.append(サービス略称);
                エラーメッセージ.append(new RString(" "));
                continue;
            }
            if (事業者の有効終了日 != null && !事業者の有効終了日.isEmpty()
                    && 有効終了日 != null && !有効終了日.isEmpty()
                    && 事業者の有効終了日.isBefore(有効終了日)) {
                エラーメッセージ.append(サービス略称);
                エラーメッセージ.append(new RString(" "));
            }
        }
        if (エラーメッセージ.toRString().isEmpty()) {
            return;
        }
        throw new ApplicationException(DbzErrorMessages.適用期間対象外.getMessage().replace(エラーメッセージ.toRString().toString()));
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
            entity.initializeMd5();
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
            return 事業者Manager.save(事業者登録情報);
        } else {
            return 対象施設.save介護除外住所地特例対象施設(介護除外住所地特例対象施設);
        }
    }

    /**
     * 新規に追加した事業者・事業者サービスを一括で登録します。
     *
     * @param 事業者登録情報 事業者情報
     * @param サービスList 事業者サービスのList
     * @return 全ての保存に成功した場合、true
     */
    @Transaction
    public boolean insertJigyoshaAndService(KaigoJigyosha 事業者登録情報,
            Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> サービスList) {
        boolean isSave = 事業者Manager.save(事業者登録情報);

        JigyoshaNo jigyoshaNo = 事業者登録情報.get事業者番号();
        FlexibleDate yukoKaishiDate = 事業者登録情報.get有効開始日();

        for (KaigoJigyoshaShiteiService service : サービスList.values()) {
            DbT7063KaigoJigyoshaShiteiServiceEntity entity = service.toEntity();
            entity.setJigyoshaNo(jigyoshaNo);
            entity.setYukoKaishiYMD(yukoKaishiDate);
            isSave = 事業者サービスManager.insertJigyoshaServiceJoho(new KaigoJigyoshaShiteiService(entity));
        }

        return isSave;
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
                return 事業者Manager.save(事業者情報);
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
                return 事業者Manager.save(事業者情報);
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
     * 修正した事業者・事業者サービスを一括で更新します。
     *
     * @param 旧事業者情報 旧事業者情報
     * @param 事業者情報 事業者情報
     * @param サービスList 事業者サービスのList
     * @return 全ての保存に成功した場合、true
     */
    @Transaction
    public boolean updateJigyoshaAndService(KaigoJigyosha 旧事業者情報, KaigoJigyosha 事業者情報,
            Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> サービスList) {

        boolean isSave = updateJigyosha(旧事業者情報, 事業者情報);

        JigyoshaNo jigyoshaNo = 事業者情報.get事業者番号();
        FlexibleDate yukoKaishiDate = 事業者情報.get有効開始日();

        for (KaigoJigyoshaShiteiService service : サービスList.values()) {
            DbT7063KaigoJigyoshaShiteiServiceEntity oldEntity = service.toEntity();
            DbT7063KaigoJigyoshaShiteiServiceEntity newEntity = service.toEntity();
            newEntity.setJigyoshaNo(jigyoshaNo);
            newEntity.setYukoKaishiYMD(yukoKaishiDate);
            isSave = 事業者サービスManager.updateJigyoshaServiceJoho(new KaigoJigyoshaShiteiService(oldEntity), new KaigoJigyoshaShiteiService(newEntity));
        }

        return isSave;
    }

    private boolean updateJigyosha(KaigoJigyosha 旧事業者情報, KaigoJigyosha 事業者情報) {
        boolean isSave;
        if (旧事業者情報.get有効開始日().equals(事業者情報.get有効開始日())) {
            isSave = 事業者Manager.save(事業者情報);
        } else {
            JigyoshaTourokuFinder jigyoshaTourokuFinder = JigyoshaTourokuFinder.createInstance();
            if (!旧事業者情報.getKaigoJigyoshaDaihyoshaList().isEmpty()) {
                KaigoJigyoshaDaihyoshaIdentifier identifier
                        = new KaigoJigyoshaDaihyoshaIdentifier(旧事業者情報.get事業者番号(), 旧事業者情報.get有効開始日());
                KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha = 旧事業者情報.getKaigoJigyoshaDaihyoshaList(identifier);
                KaigoJigyoshaDaihyoshaBuilder kaigoJigyoshaDaihyoshaBuilder = kaigoJigyoshaDaihyosha.createBuilderForEdit();
                kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyoshaBuilder.build();
                KaigoJigyoshaBuilder kaigoJigyoshaBuilder = 旧事業者情報.createBuilderForEdit();
                kaigoJigyoshaBuilder.setKaigoJigyoshaDaihyosha(kaigoJigyoshaDaihyosha.deleted());
                旧事業者情報 = kaigoJigyoshaBuilder.build();
            }
            jigyoshaTourokuFinder.saveOrDelete(旧事業者情報);
            isSave = 事業者Manager.save(事業者情報);
        }
        return isSave;
    }

    /**
     * 対象の事業者・事業者サービスを一括で削除します。
     *
     * @param 旧事業者情報 旧事業者情報
     * @param 事業者情報 事業者情報
     * @param サービスList 事業者サービスのList
     * @return 全ての保存に成功した場合、true
     */
    @Transaction
    public boolean deleteJigyoshaAndService(KaigoJigyosha 旧事業者情報, KaigoJigyosha 事業者情報,
            Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> サービスList) {
        boolean isSave = updateJigyosha(旧事業者情報, 事業者情報);

        JigyoshaNo jigyoshaNo = 事業者情報.get事業者番号();
        FlexibleDate yukoKaishiDate = 事業者情報.get有効開始日();

        for (KaigoJigyoshaShiteiService service : サービスList.values()) {
            if (service.toEntity().getIsDeleted()) {
                continue;
            }
            DbT7063KaigoJigyoshaShiteiServiceEntity oldEntity = service.toEntity();
            DbT7063KaigoJigyoshaShiteiServiceEntity newEntity = service.toEntity();
            newEntity.setJigyoshaNo(jigyoshaNo);
            newEntity.setYukoKaishiYMD(yukoKaishiDate);
            newEntity.setState(EntityDataState.Deleted);
            isSave = 事業者サービスManager.updateJigyoshaServiceJoho(new KaigoJigyoshaShiteiService(oldEntity), new KaigoJigyoshaShiteiService(newEntity));
        }

        return isSave;
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

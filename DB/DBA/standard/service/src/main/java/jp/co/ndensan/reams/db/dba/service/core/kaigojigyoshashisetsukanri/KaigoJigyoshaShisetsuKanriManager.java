/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.kaigojigyoshashisetsukanri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiBusiness;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.kaigojigyoshashisetsukanri.IKaigoJigyoshaShisetsuKanriMapper;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.kaigojigyosha.kaigojigyosha.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyosha.KaigoJigyoshaManager;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoJogaiTokureiTaishoShisetsuManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 介護事業者・施設管理Managerクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public class KaigoJigyoshaShisetsuKanriManager {

    private final MapperProvider mapperProvider;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dbT7063dac;
    private static final RString 介護保険施設 = new RString("11");
    private static final RString 変更区分_新履歴 = new RString("1");
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
     * 事業者種別はその他特例施設または適用除外施設である場合。
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
     * 事業者情報取得。
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
     * サービス一覧情報取得。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return サービス一覧情報取得
     */
    @Transaction
    public SearchResult<KaigoJogaiTokureiBusiness> getServiceItiranJoho(KaigoJogaiTokureiParameter parameter) {

        List<KaigoJogaiTokureiBusiness> serviceShuruiList = new ArrayList();
        IKaigoJigyoshaShisetsuKanriMapper iKaigoJigyoshaShisetsuKanri = mapperProvider.create(IKaigoJigyoshaShisetsuKanriMapper.class);
        List<KaigoJogaiTokureiRelateEntity> サービス一覧情報 = iKaigoJigyoshaShisetsuKanri.getServiceItiranJoho(parameter);

        for (KaigoJogaiTokureiRelateEntity entity : サービス一覧情報) {
            KaigoJogaiTokureiRelateEntity relateEntity = new KaigoJogaiTokureiRelateEntity();
            KaigoJogaiTokureiBusiness business;
            if (entity == null) {
                relateEntity.setJigyoshaName(RString.EMPTY);
                relateEntity.setKanrishaName(RString.EMPTY);
                relateEntity.setServiceShuruiCode(RString.EMPTY);
                relateEntity.setYukoKaishiYMD(RString.EMPTY);
                relateEntity.setYukoShuryoYMD(RString.EMPTY);
                business = new KaigoJogaiTokureiBusiness(relateEntity);
            } else {
                business = new KaigoJogaiTokureiBusiness(entity);
            }
            serviceShuruiList.add(business);
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * 有効期間重複チェックします。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return boolean
     */
    @Transaction
    public boolean checkKikanJufuku(KaigoJigyoshaParameter parameter) {
        IKaigoJigyoshaShisetsuKanriMapper mapper = mapperProvider.create(IKaigoJigyoshaShisetsuKanriMapper.class);
        List<KaigoJigyoshaRelateEntity> 重複チェック;
        if (介護保険施設.equals(parameter.get事業者種別())) {
            重複チェック = mapper.getCheckKikanJufuku(parameter);
        } else {
            重複チェック = mapper.getCheckKikanJufukui(parameter);
        }
        return !重複チェック.isEmpty();
    }

    /**
     * 有効期間合理性チェックします。
     *
     * @param parameter KaigoJigyoshaShisetsuKanriMapperParameter
     * @return boolean
     */
    @Transaction
    public boolean checkKikanGorisei(KaigoJogaiTokureiParameter parameter) {
        boolean 有効期間合理性フラグ = false;
        if (parameter != null && !parameter.getYukoShuryoYMD().isEmpty()) {
            if (parameter.getYukoKaishiYMD().isBeforeOrEquals(parameter.getYukoShuryoYMD())) {
                有効期間合理性フラグ = true;
            }
        }
        return 有効期間合理性フラグ;
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
     * @param 事業者登録情報 KaigoJigyosha
     * @param 事業者種別 RString
     * @param 介護除外住所地特例対象施設 KaigoJogaiTokureiTaishoShisetsu
     * @param 変更区分 RString
     * @return count 件数
     */
    @Transaction
    public boolean updateJigyoshaJoho(KaigoJigyosha 事業者登録情報,
            RString 事業者種別,
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設, RString 変更区分) {
        if (介護保険施設.equals(事業者種別)) {
            if ((変更区分_新履歴.equals(変更区分)) && (事業者登録情報.get有効終了日() == null
                    || 事業者登録情報.get有効終了日().isEmpty())) {
                事業者登録情報 = 事業者登録情報.createBuilderForEdit()
                        .set有効終了日(事業者登録情報.get有効開始日().minusDay(1)).build();
            }
            return manager.save(事業者登録情報);
        } else {
            if (介護除外住所地特例対象施設.get有効終了年月日() == null
                    || 介護除外住所地特例対象施設.get有効終了年月日().isEmpty()) {
                介護除外住所地特例対象施設 = 介護除外住所地特例対象施設.createBuilderForEdit()
                        .set有効終了年月日(介護除外住所地特例対象施設.get有効開始年月日().minusDay(1)).build();
            }
            return 対象施設.save介護除外住所地特例対象施設(介護除外住所地特例対象施設);
        }
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
     * @param 事業者サービス情報修正 KaigoJigyoshaShiteiService
     * @param 変更区分 RString
     * @return count 件数
     */
    @Transaction
    public boolean updateJigyoshaServiceJoho(KaigoJigyoshaShiteiService 事業者サービス情報修正, RString 変更区分) {
        if ((変更区分_新履歴.equals(変更区分)) && (事業者サービス情報修正.get有効終了日() == null
                || 事業者サービス情報修正.get有効終了日().isEmpty())) {
            事業者サービス情報修正 = 事業者サービス情報修正.createBuilderForEdit()
                    .set有効終了日(事業者サービス情報修正.get有効開始日().minusDay(1)).build();
        }
        if (!事業者サービス情報修正.hasChanged()) {
            return false;
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity dbT7063Entity = 事業者サービス情報修正.toEntity();
        dbT7063Entity.setState(EntityDataState.Modified);
        return 1 == dbT7063dac.save(dbT7063Entity);
    }

    /**
     * 介護事業者{@link KaigoJigyosha}を保存します。
     *
     * @param 介護事業者 介護事業者
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jigyoshaservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jigyoshaservice.JigyoshaServiceJoho;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriMapperParameter;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.servicecode.SabisuKodoParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.basic.IDbT7130KaigoServiceShuruiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者指定サービス情報を管理します。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaServiceManager {

    private static final int 提供開始年月 = 6;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dbT7063dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public JigyoshaServiceManager() {
        dbT7063dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7063KaigoJigyoshaShiteiServiceDac}
     */
    JigyoshaServiceManager(DbT7063KaigoJigyoshaShiteiServiceDac dac, MapperProvider mapperProvider) {
        this.dbT7063dac = dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigyoshaServiceManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JigyoshaServiceManager}のインスタンス
     */
    public static JigyoshaServiceManager createInstance() {
        return InstanceProvider.create(JigyoshaServiceManager.class);
    }

    /**
     * 介護事業者指定サービス情報を物理削除します。
     *
     * @param joho 物理削除のデータ
     * @return 削除結果
     */
    public boolean 情報を物理削除(KaigoJigyoshaShiteiService joho) {
        joho = joho.deleted();
        return 1 == dbT7063dac.deletePhysical(joho.toEntity());
    }

    /**
     * 介護事業者指定サービス情報を削除します。
     *
     * @param joho 物理削除のデータ
     * @return 削除結果
     */
    public boolean delete事業者サービス(KaigoJigyoshaShiteiService joho) {
        joho = joho.deleted();
        return 1 == dbT7063dac.delete(joho.toEntity());
    }

    /**
     * サービス種類ドロップダウンリストの取得します。
     *
     * @return SearchResult<JigyoshaServiceJoho>
     */
    public SearchResult<JigyoshaServiceJoho> getserviceShuruiCdDDL() {
        List<JigyoshaServiceJoho> jigyoshaServiceJohoList = new ArrayList<>();
        IDbT7130KaigoServiceShuruiMapper mapper = mapperProvider.create(IDbT7130KaigoServiceShuruiMapper.class);
        List<DbT7130KaigoServiceShuruiEntity> entityList = mapper.getserviceShuruiCdDDL(new RString(
                FlexibleDate.getNowDate().toString().substring(0, 提供開始年月)));
        for (DbT7130KaigoServiceShuruiEntity entity : entityList) {
            jigyoshaServiceJohoList.add(new JigyoshaServiceJoho(entity));
        }
        return SearchResult.of(jigyoshaServiceJohoList, 0, false);
    }

    /**
     * 引数から受け取ったサービス種類Listから、合致するサービス種類の情報を取得します。
     *
     * @param サービス種類リスト サービス種類リスト
     * @return 条件に合致したサービス種類のリスト
     */
    public SearchResult<JigyoshaServiceJoho> getServiceShurui(List<RString> サービス種類リスト) {

        List<JigyoshaServiceJoho> jigyoshaServiceJohoList = new ArrayList<>();
        FlexibleYearMonth 基準年月 = FlexibleDate.getNowDate().getYearMonth();
        IDbT7130KaigoServiceShuruiMapper mapper = mapperProvider.create(IDbT7130KaigoServiceShuruiMapper.class);
        SabisuKodoParameter param = SabisuKodoParameter.createServiceShuruiSearchKey(サービス種類リスト, 基準年月);
        List<DbT7130KaigoServiceShuruiEntity> entityList = mapper.getServiceTypeList2(param);

        for (DbT7130KaigoServiceShuruiEntity entity : entityList) {
            jigyoshaServiceJohoList.add(new JigyoshaServiceJoho(entity));
        }
        return SearchResult.of(jigyoshaServiceJohoList, jigyoshaServiceJohoList.size(), false);
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
     * 事業者サービス情報修正します。
     *
     * @param 旧事業者サービス情報 KaigoJigyoshaShiteiService
     * @param 事業者サービス情報 KaigoJigyoshaShiteiService
     * @return count 件数
     */
    @Transaction
    public boolean deleteJigyoshaServiceJoho(
            KaigoJigyoshaShiteiService 旧事業者サービス情報,
            KaigoJigyoshaShiteiService 事業者サービス情報) {
        if (旧事業者サービス情報.get有効開始日().equals(事業者サービス情報.get有効開始日())) {
            DbT7063KaigoJigyoshaShiteiServiceEntity dbT7063Entity = 事業者サービス情報.toEntity();
            dbT7063Entity.setState(EntityDataState.Deleted);
            return 1 == dbT7063dac.save(dbT7063Entity);
        } else {
            旧事業者サービス情報 = 旧事業者サービス情報.deleted();
            dbT7063dac.delete(旧事業者サービス情報.toEntity());
            DbT7063KaigoJigyoshaShiteiServiceEntity dbT7063Entity = 事業者サービス情報.toEntity();
            dbT7063Entity.setState(EntityDataState.Deleted);
            return 1 == dbT7063dac.save(dbT7063Entity);
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
}

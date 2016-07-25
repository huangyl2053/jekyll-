package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikekkatoroku.ShinsakaiKekkaTorokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku.IShinsakaiKekkaTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員情報を管理するクラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuManager {

    private static final RString REPLACEDMESSAGE = new RString("開催番号");
    private final MapperProvider mapperProvider;
    private final DbT5502ShinsakaiWariateJohoDac dbT5502Dac;
    private final DbT5101NinteiShinseiJohoDac dbT5101Dac;
    private final DbT5102NinteiKekkaJohoDac dbT5102Dac;
    private final DbT5105NinteiKanryoJohoDac dbT5105Dac;

    /**
     * コンストラクタです。
     */
    ShinsakaiKekkaTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5502Dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
        this.dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5102Dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        this.dbT5105Dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaiKekkaTorokuManager(MapperProvider mapperProvider,
            DbT5502ShinsakaiWariateJohoDac dbT5502Dac,
            DbT5101NinteiShinseiJohoDac dbT5101Dac,
            DbT5102NinteiKekkaJohoDac dbT5102Dac,
            DbT5105NinteiKanryoJohoDac dbT5105Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5502Dac = dbT5502Dac;
        this.dbT5101Dac = dbT5101Dac;
        this.dbT5102Dac = dbT5102Dac;
        this.dbT5105Dac = dbT5105Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKekkaTorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKekkaTorokuManager}のインスタンス
     */
    public static ShinsakaiKekkaTorokuManager createInstance() {
        return InstanceProvider.create(ShinsakaiKekkaTorokuManager.class);
    }

    /**
     * 介護認定審査会開催結果登録をgetヘッドエリア内容取得します。
     *
     * @param 開催番号 開催番号
     * @return ShinsakaiKekkaTorokuBusiness 介護認定審査会開催結果登録のヘッドエリア内容Business
     */
    @Transaction
    public SearchResult<ShinsakaiKekkaTorokuBusiness> getヘッドエリア内容検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACEDMESSAGE.toString()));
        IShinsakaiKekkaTorokuMapper mapper = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class);
        ShinsakaiKekkaTorokuRelateEntity headEntity = mapper.getヘッドエリア内容検索(開催番号);
        List<ShinsakaiKekkaTorokuBusiness> kaisaiYoteiJohoBusiness = new ArrayList();
        if (headEntity != null) {
            kaisaiYoteiJohoBusiness.add(new ShinsakaiKekkaTorokuBusiness(headEntity));
        }

        return SearchResult.of(kaisaiYoteiJohoBusiness, 0, false);
    }

    /**
     * 介護認定審査会開催結果登録をget審査会委員一覧検索取得します。
     *
     * @param 開催番号 開催番号
     * @return ichiRanBusinessList 介護認定審査会開催結果登録の審査会委員一覧検索Businessリスト
     */
    @Transaction
    public SearchResult<ShinsakaiKekkaTorokuIChiRanBusiness> get審査会委員一覧検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACEDMESSAGE.toString()));
        IShinsakaiKekkaTorokuMapper mapper = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class);
        List<ShinsakaiKekkaTorokuIChiRanRelateEntity> entityList = mapper
                .get審査会委員一覧検索(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (null == entityList.get(0) || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiKekkaTorokuIChiRanBusiness>emptyList(), 0, false);
        }
        List<ShinsakaiKekkaTorokuIChiRanBusiness> ichiRanBusinessList = new ArrayList();
        for (ShinsakaiKekkaTorokuIChiRanRelateEntity entity : entityList) {
            ichiRanBusinessList.add(new ShinsakaiKekkaTorokuIChiRanBusiness(entity));
        }
        return SearchResult.of(ichiRanBusinessList, 0, false);
    }

    /**
     * 介護認定審査会割当情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return SearchResult<ShinsakaiKaisaiYoteiJoho> 介護認定審査会開催予定情報Business
     */
    @Transaction
    public SearchResult<ShinsakaiWariateJoho> get介護認定審査会割当情報(RString 開催番号) {
        List<ShinsakaiWariateJoho> resultList = new ArrayList<>();
        List<DbT5502ShinsakaiWariateJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get介護認定審査会割当情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (null == entityList.get(0) || entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (DbT5502ShinsakaiWariateJohoEntity entity : entityList) {
            entity.initializeMd5();
            resultList.add(new ShinsakaiWariateJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 要介護認定申請情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return SearchResult<NinteiShinseiJoho> 要介護認定申請情報Business
     */
    @Transaction
    public SearchResult<NinteiShinseiJoho> get要介護認定申請情報(RString 開催番号) {
        List<NinteiShinseiJoho> resultList = new ArrayList<>();
        List<DbT5101NinteiShinseiJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get要介護認定申請情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (null == entityList.get(0) || entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (DbT5101NinteiShinseiJohoEntity entity : entityList) {
            entity.initializeMd5();
            resultList.add(new NinteiShinseiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 要介護認定結果情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return SearchResult<NinteiKekkaJoho> 要介護認定申請情報Business
     */
    @Transaction
    public SearchResult<NinteiKekkaJoho> get要介護認定結果情報(RString 開催番号) {
        List<NinteiKekkaJoho> resultList = new ArrayList<>();
        List<DbT5102NinteiKekkaJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get要介護認定結果情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (null == entityList.get(0) || entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (DbT5102NinteiKekkaJohoEntity entity : entityList) {
            entity.initializeMd5();
            resultList.add(new NinteiKekkaJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 要介護認定完了情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return SearchResult<NinteiKanryoJoho> 要介護認定申請情報Business
     */
    @Transaction
    public SearchResult<NinteiKanryoJoho> get要介護認定完了情報(RString 開催番号) {
        List<NinteiKanryoJoho> resultList = new ArrayList<>();
        List<DbT5105NinteiKanryoJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get要介護認定完了情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (DbT5105NinteiKanryoJohoEntity entity : entityList) {
            entity.initializeMd5();
            resultList.add(new NinteiKanryoJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 介護認定審査会割当情報を更新です。
     *
     * @param shinsakaiWariateJoho 介護認定審査会割当情報
     * @return SearchResult<ShinsakaiWariateJoho> 介護認定審査会割当情報Business
     */
    @Transaction
    public int upd介護認定審査会割当情報(ShinsakaiWariateJoho shinsakaiWariateJoho) {
        DbT5502ShinsakaiWariateJohoEntity entity = shinsakaiWariateJoho.toEntity();
        entity.setState(EntityDataState.Modified);
        return dbT5502Dac.save(entity);
    }

    /**
     * 要介護認定申請情報を更新です。
     *
     * @param ninteiShinsei 要介護認定申請情報
     * @return SearchResult<NinteiShinseiJoho> 要介護認定申請情報Business
     */
    @Transaction
    public int upd要介護認定申請情報(NinteiShinseiJoho ninteiShinsei) {
        DbT5101NinteiShinseiJohoEntity entity = ninteiShinsei.toEntity();
        entity.setState(EntityDataState.Modified);
        return dbT5101Dac.save(entity);
    }

    /**
     * 要介護認定結果情報を新規です。
     *
     * @param ninteiKekka 要介護認定結果情報
     * @return SearchResult<NinteiKekkaJoho> 要介護認定結果情報Business
     */
    @Transaction
    public int ins要介護認定結果情報(NinteiKekkaJoho ninteiKekka) {
        DbT5102NinteiKekkaJohoEntity entity = ninteiKekka.toEntity();
        entity.setState(EntityDataState.Added);
        return dbT5102Dac.save(entity);
    }

    /**
     * 要介護認定結果情報を更新です。
     *
     * @param ninteiKekka 要介護認定結果情報
     * @return SearchResult<NinteiKekkaJoho> 要介護認定結果情報Business
     */
    @Transaction
    public int upd要介護認定結果情報(NinteiKekkaJoho ninteiKekka) {
        DbT5102NinteiKekkaJohoEntity entity = ninteiKekka.toEntity();
        entity.setState(EntityDataState.Modified);
        return dbT5102Dac.save(entity);
    }

    /**
     * 要介護認定結果情報を削除です。
     *
     * @param ninteiKekka 要介護認定結果情報
     * @return SearchResult<NinteiKekkaJoho> 要介護認定結果情報Business
     */
    @Transaction
    public int del要介護認定結果情報(NinteiKekkaJoho ninteiKekka) {
        DbT5102NinteiKekkaJohoEntity entity = ninteiKekka.toEntity();
        entity.setState(EntityDataState.Deleted);
        return dbT5102Dac.saveOrDelete(entity);
    }

    /**
     * 要介護認定完了情報を更新です。
     *
     * @param ninteiKanryo 要介護認定完了情報
     * @return SearchResult<NinteiKanryoJoho> 要介護認定完了情報Business
     */
    @Transaction
    public int upd要介護認定完了情報(NinteiKanryoJoho ninteiKanryo) {
        DbT5105NinteiKanryoJohoEntity entity = ninteiKanryo.toEntity();
        entity.setState(EntityDataState.Modified);
        return dbT5105Dac.save(entity);
    }

}

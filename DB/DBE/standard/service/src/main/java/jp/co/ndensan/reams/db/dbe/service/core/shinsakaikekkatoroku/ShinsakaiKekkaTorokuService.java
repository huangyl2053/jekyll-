package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidate;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikekkatoroku.ShinsakaiKekkaTorokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku.IShinsakaiKekkaTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員情報を管理するクラスです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuService {

    private static final RString REPLACEDMESSAGE = new RString("開催番号");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiKekkaTorokuService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link ShinsakaiKekkaTorokuManager}のインスタンスを返します。
     *
     * @return {@link ShinsakaiKekkaTorokuManager}のインスタンス
     */
    public static ShinsakaiKekkaTorokuService createInstance() {
        return InstanceProvider.create(ShinsakaiKekkaTorokuService.class);
    }

    /**
     * @param preserver
     * @return
     */
    @Transaction
    public void saveBy(IShinsaKekkaPreserver preserver) {
        preserver.saveBy(ShinsakaiKekkaTorokuManager.createInstance());
    }

    /**
     * 介護認定審査会開催結果登録をgetヘッドエリア内容取得します。
     *
     * @param 開催番号 開催番号
     * @return 検索結果
     */
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
     * @return 検索結果
     */
    public SearchResult<ShinsakaiKekkaTorokuIChiRanBusiness> get審査会委員一覧検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage(REPLACEDMESSAGE.toString()));
        IShinsakaiKekkaTorokuMapper mapper = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class);
        List<ShinsakaiKekkaTorokuIChiRanRelateEntity> entityList = mapper
                .get審査会委員一覧検索(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (entityList.isEmpty() || null == entityList.get(0)) {
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
     * @return 検索結果
     */
    public SearchResult<ShinsakaiWariateJoho> get介護認定審査会割当情報(RString 開催番号) {
        List<ShinsakaiWariateJoho> resultList = new ArrayList<>();
        List<DbT5502ShinsakaiWariateJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get介護認定審査会割当情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        int count = 0;
        for (DbT5502ShinsakaiWariateJohoEntity entity : entityList) {
            if (null == entity || entityList.isEmpty()) {
                count = count + 1;
                continue;
            } else {
                entity.initializeMd5();
                resultList.add(new ShinsakaiWariateJoho(entity));
            }
        }
        if (entityList.size() == count) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 要介護認定申請情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return 検索結果
     */
    public SearchResult<NinteiShinseiJoho> get要介護認定申請情報(RString 開催番号) {
        List<NinteiShinseiJoho> resultList = new ArrayList<>();
        List<DbT5101NinteiShinseiJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get要介護認定申請情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        int count = 0;
        for (DbT5101NinteiShinseiJohoEntity entity : entityList) {
            if (null == entity || entityList.isEmpty()) {
                count = count + 1;
            } else {
                entity.initializeMd5();
                resultList.add(new NinteiShinseiJoho(entity));
            }
        }
        if (entityList.size() == count) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 要介護認定結果情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return 検索結果
     */
    public SearchResult<NinteiKekkaJoho> get要介護認定結果情報(RString 開催番号) {
        List<NinteiKekkaJoho> resultList = new ArrayList<>();
        List<DbT5102NinteiKekkaJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get要介護認定結果情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        int count = 0;
        for (DbT5102NinteiKekkaJohoEntity entity : entityList) {
            if (null == entity || entityList.isEmpty()) {
                count = count + 1;
                continue;
            } else {
                entity.initializeMd5();
                resultList.add(new NinteiKekkaJoho(entity));
            }
        }
        if (entityList.size() == count) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 要介護認定完了情報を取得です。
     *
     * @param 開催番号 開催番号
     * @return 検索結果
     */
    public SearchResult<NinteiKanryoJoho> get要介護認定完了情報(RString 開催番号) {
        List<NinteiKanryoJoho> resultList = new ArrayList<>();
        List<DbT5105NinteiKanryoJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get要介護認定完了情報(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        int count = 0;
        for (DbT5105NinteiKanryoJohoEntity entity : entityList) {
            if (null == entity || entityList.isEmpty()) {
                count = count + 1;
                continue;
            } else {
                entity.initializeMd5();
                resultList.add(new NinteiKanryoJoho(entity));
            }
        }
        if (entityList.size() == count) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * @param 開催番号 審査会開催番号
     * @return 指定の審査会開催番号に対応する削除候補の情報
     */
    public Map<ShinseishoKanriNo, ShinsakaiKekkaTorokuDeletionCandidate> get削除候補情報(RString 開催番号) {
        List<ShinsakaiKekkaTorokuDeletionCandidateEntity> entities
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get削除候補s(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        Map<ShinseishoKanriNo, ShinsakaiKekkaTorokuDeletionCandidate> map = new HashMap<>();
        for (ShinsakaiKekkaTorokuDeletionCandidateEntity entity : entities) {
            entity.initMd5();
            map.put(entity.getShinseishoKanriNo(), new ShinsakaiKekkaTorokuDeletionCandidate(entity));
        }
        return map;
    }
}

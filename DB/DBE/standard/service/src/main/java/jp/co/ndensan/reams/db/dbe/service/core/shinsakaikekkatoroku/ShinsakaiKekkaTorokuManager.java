package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikekkatoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikekkatoroku.ShinsakaiKekkaTorokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku.IShinsakaiKekkaTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
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
public class ShinsakaiKekkaTorokuManager {

    private static final RString REPLACEDMESSAGE = new RString("開催番号");
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiKekkaTorokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaiKekkaTorokuManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
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
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiKekkaTorokuIChiRanBusiness>emptyList(), 0, false);
        }
        List<ShinsakaiKekkaTorokuIChiRanBusiness> ichiRanBusinessList = new ArrayList();
        for (ShinsakaiKekkaTorokuIChiRanRelateEntity entity : entityList) {
            ichiRanBusinessList.add(new ShinsakaiKekkaTorokuIChiRanBusiness(entity));
        }
        return SearchResult.of(ichiRanBusinessList, 0, false);
    }

    /**
     * 審査会委員一覧検索_業務概念を取得です。
     *
     * @param 開催番号 開催番号
     * @return SearchResult<ShinsakaiKaisaiYoteiJoho> 介護認定審査会開催予定情報Business
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiYoteiJoho2> get審査会委員一覧検索_業務概念_1(RString 開催番号) {
        List<ShinsakaiKaisaiYoteiJoho2> resultList = new ArrayList<>();
        List<DbT5502ShinsakaiWariateJohoEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get審査会委員一覧更新_1(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
//        for (ShinsakaiKaisaiYoteiJohoRelateEntity entity : entityList) {
//            entity.initializeMd5ToEntities();
//            resultList.add(new ShinsakaiKaisaiYoteiJoho(entity));
//        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * get審査会委員一覧検索_業務概念_2を取得です。
     *
     * @param 開催番号 開催番号
     * @return SearchResult<NinteiShinseiJoho> 要介護認定申請情報Business
     */
    @Transaction
    public SearchResult<NinteiShinseiJoho> get審査会委員一覧検索_業務概念_2(RString 開催番号) {
        List<NinteiShinseiJoho> resultList = new ArrayList<>();
        List<NinteiShinseiJohoRelateEntity> entityList
                = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class)
                .get審査会委員一覧情報更新_2(ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(開催番号));
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (NinteiShinseiJohoRelateEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            resultList.add(new NinteiShinseiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaiKaisaiKekka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei.GogitaiJohoSakuseiRsult;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiKaisaiKekka.ShinsakaiWariateIinJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.shinsakaiKaisaiKekka.IShinsakaiKaisaiKekkaMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 介護認定審査会開催結果登録
 */
public class ShinsakaiKaisaiKekkaFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiKekkaFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    ShinsakaiKaisaiKekkaFinder(
            MapperProvider mapperProvider
    ) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiKekkaFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiKekkaFinder}のインスタンス
     */
    public static ShinsakaiKaisaiKekkaFinder createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiKekkaFinder.class);
    }

    /**
     *
     * ヘッドエリア内容を取得する
     *
     * @param 開催番号 開催番号
     * @return ヘッドエリア内容
     */
    @Transaction
    public ShinsakaiKaisaiYoteiJohoBusiness getヘッドエリア内容検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        IShinsakaiKaisaiKekkaMapper mapper = mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class);
        ShinsakaiKaisaiYoteiJohoEntity yoteiJohoEntity = mapper.getヘッドエリア内容検索(開催番号);
        return new ShinsakaiKaisaiYoteiJohoBusiness(yoteiJohoEntity);
    }

    /**
     * 審査会委員一覧検索を取得する
     *
     * @param 開催番号 開催番号
     * @return 審査会委員一覧
     */
    @Transaction
    public SearchResult<ShinsakaiWariateIinJohoBusiness> get審査会委員一覧検索(RString 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        IShinsakaiKaisaiKekkaMapper mapper = mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class);
        List<ShinsakaiWariateIinJohoEntity> entityList = mapper.get審査会委員一覧検索(開催番号);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiWariateIinJohoBusiness>emptyList(), 0, false);
        }
        List<ShinsakaiWariateIinJohoBusiness> wariateIinJohoBusiness = new ArrayList();
        for (ShinsakaiWariateIinJohoEntity entity : entityList) {
            wariateIinJohoBusiness.add(new ShinsakaiWariateIinJohoBusiness(entity));
        }
        return SearchResult.of(wariateIinJohoBusiness, 0, false);
    }

    /**
     * 審査会委員一覧検索を取得する
     *
     * @param 開催番号 開催番号
     * @return 審査会委員一覧
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiYoteiJoho> get審査会委員(RString 開催番号) {
        List<ShinsakaiKaisaiYoteiJoho> resultList = new ArrayList<>();
        List<ShinsakaiKaisaiYoteiJohoRelateEntity> entityList
                = mapperProvider.create(IShinsakaiKaisaiKekkaMapper.class).get開催予定情報更新(開催番号);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<GogitaiJohoSakuseiRsult>emptyList(), 0, false);
        }
        for (ShinsakaiKaisaiYoteiJohoRelateEntity entity : entityList) {
            entity.initializeMd5ToEntities();
            resultList.add(new ShinsakaiKaisaiYoteiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }
}

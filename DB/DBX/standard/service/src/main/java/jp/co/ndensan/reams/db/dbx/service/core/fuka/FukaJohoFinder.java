/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.fuka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.fukajoho.FukaJohoRelateSearchResult;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.fukajoho.FukaJohoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.fukajoho.IFukaJohoMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネス設計_DBBMN00030_【共有子Div】賦課根拠照会のビジネスクラスです。
 *
 * @reamsid_L DBB-5723-020 xuxin
 */
public class FukaJohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    FukaJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    FukaJohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaJohoFinder}のインスタンスを返します。
     *
     * @return FukaJohoFinder
     */
    public static FukaJohoFinder createInstance() {
        return InstanceProvider.create(FukaJohoFinder.class);
    }

    /**
     * 全ての賦課の情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return 検索結果{@link SearchResult}
     */
    @Transaction
    public SearchResult<FukaJohoRelateSearchResult> find全ての賦課の情報(ShikibetsuCode 識別コード) {

        IFukaJohoMapper mapper = mapperProvider.create(IFukaJohoMapper.class);
        List<FukaJohoEntity> entityList = mapper.get賦課情報(識別コード);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<FukaJohoRelateSearchResult>emptyList(), 0, false);
        }
        List<FukaJohoRelateSearchResult> resultList = new ArrayList();
        for (FukaJohoEntity entity : entityList) {
            FukaJohoRelateSearchResult result = new FukaJohoRelateSearchResult();
            result.set介護賦課Result(new Fuka(entity.get介護賦課Entity()));
            result.set期(entity.get期());
            result.set調定額(entity.get調定額());
            resultList.add(result);
        }
        return SearchResult.of(resultList, entityList.size(), false);
    }

}

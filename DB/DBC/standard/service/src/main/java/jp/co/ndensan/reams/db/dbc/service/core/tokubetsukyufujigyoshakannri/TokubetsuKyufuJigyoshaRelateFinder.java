/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.tokubetsukyufujigyoshakannri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.tokubetsukyufujigyoshakannri.TokubetsuKyufuJigyoshaSearchResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc2210011.TokubetsuKyufuJigyoshaRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.tokubetsukyufujigyoshakannri.ITokubetsuKyufuJigyoshaRelateMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付・サービス事業者管理を検索するクラスです。
 *
 * @reamsid_L DBC-3430-010 miaojin
 */
public class TokubetsuKyufuJigyoshaRelateFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TokubetsuKyufuJigyoshaRelateFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     */
    TokubetsuKyufuJigyoshaRelateFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokubetsuKyufuJigyoshaRelateFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokubetsuKyufuJigyoshaRelateFinder}のインスタンス
     */
    public static TokubetsuKyufuJigyoshaRelateFinder createInstance() {
        return InstanceProvider.create(TokubetsuKyufuJigyoshaRelateFinder.class);
    }

    /**
     * 検索条件より、市町村特別給付・サービス事業者情報を取得します。
     *
     * @param 事業者番号 検索条件
     * @return SearchResult<TokubetsuKyufuJigyoshaSearchResult> 事業者情報リスト
     */
    @Transaction
    public SearchResult<TokubetsuKyufuJigyoshaSearchResult> select事業者情報(JigyoshaNo 事業者番号) {
        ITokubetsuKyufuJigyoshaRelateMapper mapper = mapperProvider.create(ITokubetsuKyufuJigyoshaRelateMapper.class);
        List<TokubetsuKyufuJigyoshaSearchResult> businessList = new ArrayList<>();
        List<TokubetsuKyufuJigyoshaRelateEntity> entityList = mapper.get事業者情報(事業者番号);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<TokubetsuKyufuJigyoshaSearchResult>emptyList(), 0, false);
        }
        for (TokubetsuKyufuJigyoshaRelateEntity entity : entityList) {
            businessList.add(new TokubetsuKyufuJigyoshaSearchResult(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyoshurui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui.SogojigyoShuruiSearchResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshuruishikyugendogaku.SogojigyoShuruiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyoshuruishikyugendogaku.ISogojigyoShuruiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合事業種類支給限度額情報の取得クラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SogojigyoShuruiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    SogojigyoShuruiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SogojigyoShuruiFinder}のインスタンスを返します。
     *
     * @return SogojigyoShuruiFinder
     */
    public static SogojigyoShuruiFinder createInstance() {
        return InstanceProvider.create(SogojigyoShuruiFinder.class);
    }

    /**
     * 総合事業種類支給限度額情報を取得します。
     *
     * @return 検索結果{@link SearchResult}
     */
    @Transaction
    public SearchResult<SogojigyoShuruiSearchResult> get総合事業種類支給限度額情報() {
        ISogojigyoShuruiMapper mapper = mapperProvider.create(ISogojigyoShuruiMapper.class);
        List<SogojigyoShuruiEntity> resultList = mapper.get総合事業種類情報();
        if (resultList.isEmpty()) {
            return SearchResult.of(Collections.<SogojigyoShuruiSearchResult>emptyList(), 0, false);
        }
        List<SogojigyoShuruiSearchResult> businessList = new ArrayList();
        for (SogojigyoShuruiEntity entity : resultList) {
            businessList.add(new SogojigyoShuruiSearchResult(entity));
        }
        return SearchResult.of(businessList, resultList.size(), false);
    }

}

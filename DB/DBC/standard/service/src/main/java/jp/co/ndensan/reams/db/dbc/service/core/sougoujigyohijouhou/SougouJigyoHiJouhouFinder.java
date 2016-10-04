/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sougoujigyohijouhou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.sougoujigyohijouhou.SougouJigyoHiJouhouBusiness;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sougoujigyohijouhou.SougouJigyoHiJouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sougoujigyohijouhou.SougouJigyoHiJouhouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sougoujigyohijouhou.ISougouJigyoHiJouhouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 汎用リスト出力(総合事業費情報)のFinderです。
 *
 * @reamsid_L DBC-3107-010 wanghuafeng
 */
public class SougouJigyoHiJouhouFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SougouJigyoHiJouhouFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SougouJigyoHiJouhouFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SougouJigyoHiJouhouFinder}のインスタンス
     */
    public static SougouJigyoHiJouhouFinder createInstance() {
        return InstanceProvider.create(SougouJigyoHiJouhouFinder.class);
    }

    /**
     * サービス種類データを取得します。
     *
     * @param parameter SougouJigyoHiJouhouParameter
     * @return SearchResult<SougouJigyoHiJouhouBusiness>
     */
    public SearchResult<SougouJigyoHiJouhouBusiness> getサービス種類(SougouJigyoHiJouhouParameter parameter) {
        ISougouJigyoHiJouhouMapper mapper = mapperProvider.create(ISougouJigyoHiJouhouMapper.class);
        List<SougouJigyoHiJouhouEntity> entityList = mapper.getサービス種類(parameter);
        List<SougouJigyoHiJouhouBusiness> list = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<SougouJigyoHiJouhouBusiness>emptyList(), 0, false);
        }
        for (SougouJigyoHiJouhouEntity entity : entityList) {
            list.add(new SougouJigyoHiJouhouBusiness(entity));
        }
        return SearchResult.of(list, 0, false);
    }
}

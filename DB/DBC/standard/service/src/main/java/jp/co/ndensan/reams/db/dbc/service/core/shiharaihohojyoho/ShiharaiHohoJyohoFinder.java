/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.KozaJoho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shiharaihohojyoho.IShiharaiHohoJyohoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0715KozaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.psm.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 支払方法情報を取得するクラスです。
 */
public class ShiharaiHohoJyohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShiharaiHohoJyohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoJyohoFinder}のインスタンスを返します。
     *
     * @return ShiharaiHohoJyohoFinder
     */
    public static ShiharaiHohoJyohoFinder createInstance() {

        return InstanceProvider.create(ShiharaiHohoJyohoFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link MapperProvider}
     */
    ShiharaiHohoJyohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 口座情報パラメータで支払方法情報を取得する。
     *
     * @param parameter 口座情報パラメータ
     * @return SearchResult<KozaJoho>
     */
    public SearchResult<KozaJoho> get口座IDリスト(KozaParameter parameter) {
        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
        List<KozaJoho> 口座ID = new ArrayList<>();
        List<UrT0715KozaEntity> entityList = mapper.get口座IDリストByKozaParameter(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(口座ID, 0, false);
        }
        for (UrT0715KozaEntity entity : entityList) {
            口座ID.add(new KozaJoho(entity));
        }
        return SearchResult.of(口座ID, 0, false);
    }

    public SearchResult<KozaJoho> get口座情報ByKey(KozaParameter parameter) {
        IShiharaiHohoJyohoMapper mapper = mapperProvider.create(IShiharaiHohoJyohoMapper.class);
        UrT0715KozaEntity entity = mapper.get口座情報ByKey(parameter);
        if (entity == null) {
            return null;
        }
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setGyomuCode(entity.getGyomuCode());
        builder.setSubGyomuCode(entity.getSubGyomuCode());
        builder.setKamokuCode(entity.getKamokuCode());
        builder.setGyomuKoyuKey(entity.getGyomuKoyuKey());
        builder.setYotoKubun(entity.getYotoKubun());

//        return SearchResult.of(口座ID, 0, false);
        return null;
    }
}

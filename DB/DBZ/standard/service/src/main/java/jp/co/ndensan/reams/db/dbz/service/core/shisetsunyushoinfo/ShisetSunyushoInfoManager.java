/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shisetsunyushoinfo;

import jp.co.ndensan.reams.db.dbz.business.core.shisetsunyushoinfo.ShisetSunyushoInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.param.shisetsunyushoinfo.ShisetSunyushoInfoParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shisetsunyushoinfo.IShisetSunyushoInfoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設入所情報取得です。
 *
 */
public class ShisetSunyushoInfoManager {

    private final MapperProvider mapperProvider;

    ShisetSunyushoInfoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    ShisetSunyushoInfoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShisetSunyushoInfoManager}のインスタンスを返します。
     *
     * @return ShisetSunyushoInfoManager
     *
     */
    public static ShisetSunyushoInfoManager createInstance() {
        return InstanceProvider.create(ShisetSunyushoInfoManager.class);

    }

    /**
     * 施設入所情報Divの初期化時intializeメッソドの検索処理します。
     *
     * @param 識別コード 識別コード
     * @return ShisetSunyushoInfoBusiness
     */
    public ShisetSunyushoInfoBusiness onLoad(ShikibetsuCode 識別コード) {
        IShisetSunyushoInfoMapper mapper = mapperProvider.create(IShisetSunyushoInfoMapper.class);
        return new ShisetSunyushoInfoBusiness(mapper.getSelect(ShisetSunyushoInfoParameter.createParam(識別コード)));
    }
}

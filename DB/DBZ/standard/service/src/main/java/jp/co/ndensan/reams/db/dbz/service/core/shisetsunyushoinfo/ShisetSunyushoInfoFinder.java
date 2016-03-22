/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shisetsunyushoinfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.shisetsunyushoinfo.ShisetSunyushoInfoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.param.shisetsunyushoinfo.ShisetSunyushoInfoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ShisetSunyushoInfoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shisetsunyushoinfo.IShisetSunyushoInfoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設入所情報取得です。
 *
 */
public class ShisetSunyushoInfoFinder {

    private final MapperProvider mapperProvider;

    ShisetSunyushoInfoFinder() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    ShisetSunyushoInfoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShisetSunyushoInfoFinder}のインスタンスを返します。
     *
     * @return ShisetSunyushoInfoFinder
     */
    public static ShisetSunyushoInfoFinder createInstance() {
        return InstanceProvider.create(ShisetSunyushoInfoFinder.class);
    }

    /**
     * 施設入所情報Divの初期化時intializeメッソドの検索処理します。
     *
     * @param 識別コード 識別コード
     * @return SearchResult<ShisetSunyushoInfoBusiness>
     */
    public SearchResult<ShisetSunyushoInfoBusiness> onLoad(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        IShisetSunyushoInfoMapper mapper = mapperProvider.create(IShisetSunyushoInfoMapper.class);
        List<ShisetSunyushoInfoRelateEntity> entityList = mapper.getSelect(ShisetSunyushoInfoParameter.createParam(識別コード));
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShisetSunyushoInfoBusiness>emptyList(), 0, false);
        }
        List<ShisetSunyushoInfoBusiness> besiness = new ArrayList<>();
        for (ShisetSunyushoInfoRelateEntity entity : entityList) {
            besiness.add(new ShisetSunyushoInfoBusiness(entity));
        }
        return SearchResult.of(besiness, 0, false);
    }
}

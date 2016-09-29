/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahoshushokai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshushokai.NinteichosahoshushokaiBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005.NinteiChosaHoshuShokaiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahoshushokai.NinteiChosaHoshuShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahoshushokai.INinteiChosaHoshuShokaiRelateMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査報酬照会のServiceクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
public class NinteiChosaHoshuShokaiFinder {

    private final MapperProvider mapperProvider;

    NinteiChosaHoshuShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    NinteiChosaHoshuShokaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaHoshuShokaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiChosaHoshuShokaiFinder}のインスタンス
     */
    public static NinteiChosaHoshuShokaiFinder createInstance() {
        return InstanceProvider.create(NinteiChosaHoshuShokaiFinder.class);
    }

    /**
     * 認定調査報酬実績データの取得です。
     *
     * @param chosaParamter NinteiChosaHoshuShokaiMapperParameter
     * @return SearchResult<NinteichosahoshushokaiBusiness>
     */
    public SearchResult<NinteichosahoshushokaiBusiness> get認定調査報酬情報(NinteiChosaHoshuShokaiMapperParameter chosaParamter) {
        INinteiChosaHoshuShokaiRelateMapper mapper = mapperProvider.create(INinteiChosaHoshuShokaiRelateMapper.class);
        List<NinteichosahoshushokaiBusiness> list = new ArrayList<>();
        List<NinteiChosaHoshuShokaiRelateEntity> entityList = mapper.get報酬実績データ情報(chosaParamter);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosahoshushokaiBusiness>emptyList(), 0, false);
        }
        for (NinteiChosaHoshuShokaiRelateEntity entity : entityList) {
            list.add(new NinteichosahoshushokaiBusiness(entity));
        }
        return SearchResult.of(list, 0, false);
    }

}

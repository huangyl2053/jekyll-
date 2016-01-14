/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteichosairaishokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosairaishokai.NinteiChosaIraiShokaiMaster;
import jp.co.ndensan.reams.db.dbz.definition.param.ninteichosairaishokai.NinteiChosaIraiShokaiParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteichosairaishokai.NinteiChosaIraiShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosairaishokai.INinteiChosaIraiShokaiMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 認定調査情報を取得するのクラスです。
 */
public class NinteiChosaIraiShokaiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiChosaIraiShokaiManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    NinteiChosaIraiShokaiManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaIraiShokaiManager}のインスタンスを返します。
     *
     * @return NinteiChosaIraiShokaiManager
     *
     */
    public static NinteiChosaIraiShokaiManager createInstance() {
        return InstanceProvider.create(NinteiChosaIraiShokaiManager.class);
    }

    /**
     * 認定調査情報を取得の処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<NinteiChosaIraiShokaiRelateEntity>
     */
    public SearchResult<NinteiChosaIraiShokaiMaster> getNinteiChousaJouhou(RString 被保険者番号) {
        NinteiChosaIraiShokaiParameter parament = NinteiChosaIraiShokaiParameter.createParam(被保険者番号);
        INinteiChosaIraiShokaiMapper mapper = mapperProvider.create(INinteiChosaIraiShokaiMapper.class);
        List<NinteiChosaIraiShokaiRelateEntity> entityList = mapper.get認定調査情報(parament);

        List<NinteiChosaIraiShokaiMaster> shokaiMaster = new ArrayList<>();
        for (NinteiChosaIraiShokaiRelateEntity entity : entityList) {
            shokaiMaster.add(new NinteiChosaIraiShokaiMaster(entity));
        }
        return SearchResult.of(shokaiMaster, 0, false);
    }
}

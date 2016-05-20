/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakushokaitaishoshakensaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuResultEntity;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuSearch;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakushokaitaishoshakensaku.IKogakuShokaiTaishoshaKensakuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 高額介護サービス費照会（対象者検索）（画面）
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
public class KogakuShokaiTaishoshaKensaku {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KogakuShokaiTaishoshaKensaku() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 初期化メソッド
     *
     * @return KogakuShokaiTaishoshaKensaku
     */
    public static KogakuShokaiTaishoshaKensaku createInstance() {
        return InstanceProvider.create(KogakuShokaiTaishoshaKensaku.class);
    }

    /**
     * 検索条件より、対象者一覧を取得する。
     *
     * @param condition 高額介護サービス費一覧検索条件Entity
     * @return list＜高額介護サービス費一覧＞
     */
    public List<KogakuShokaiTaishoshaKensakuResultEntity> selectTaishosha(KogakuShokaiTaishoshaKensakuSearch condition) {
        IKogakuShokaiTaishoshaKensakuMapper mapper = mapperProvider.create(IKogakuShokaiTaishoshaKensakuMapper.class);
        List<KogakuShokaiTaishoshaKensakuEntity> entityList = mapper.selectTaishosha(condition);
        List<KogakuShokaiTaishoshaKensakuResultEntity> result = new ArrayList<>();
        if (entityList == null || entityList.isEmpty()) {
            return null;
        } else {
            for (KogakuShokaiTaishoshaKensakuEntity entity : entityList) {
                result.add(new KogakuShokaiTaishoshaKensakuResultEntity(entity));
            }
        }
        return result;
    }
}

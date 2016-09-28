/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futangendogakurirekijyoho;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futangendogakurirekijyoho.FutanGendogakuRirekiJyohoRelateEntity;

/**
 * GemmenGengakuRirekiJyoho_負担限度額履歴情報取得
 *
 * @reamsid_L DBC-4350-090 liuxiaoyu
 */
public interface IFutanGendogakuRirekiJyohoMapper {

    /**
     * 負担限度額履歴情報取得です。
     *
     * @param param Map<String, Object>
     *
     * @return List<FutanGendogakuRirekiJyohoRelateEntity>
     */
    List<FutanGendogakuRirekiJyohoRelateEntity> get負担限度額履歴情報(Map<String, Object> param);
}

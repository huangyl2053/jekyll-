/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hyojunfutangakugemmenjyoho;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hyojunfutangakugemmenjyoho.HyojunFutangakuGemmenJyohoRelateEntity;

/**
 * GemmenGengakuRirekiJyoho_標準負担額減免履歴情報取得
 *
 * @reamsid_L DBC-4350-090 liuxiaoyu
 */
public interface IHyojunFutangakuGemmenJyohoMapper {

    /**
     * 標準負担額減免履歴情報取得です。
     *
     * @param param Map<String, Object>
     *
     * @return List<HyojunFutangakuGemmenJyohoRelateEntity>
     */
    List<HyojunFutangakuGemmenJyohoRelateEntity> get標準負担額減免履歴情報(Map<String, Object> param);
}

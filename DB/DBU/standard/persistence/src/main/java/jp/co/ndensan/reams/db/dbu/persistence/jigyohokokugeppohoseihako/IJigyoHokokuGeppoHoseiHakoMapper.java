/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.jigyohokokugeppohoseihako;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.jigyohokokugeppoo.JigyoHokokuGeppoSearchParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.jigyohokokugeppohoseihako.JigyoHokokuGeppoHoseiHakoEntity;

/**
 *
 * @author sunhui
 */
public interface IJigyoHokokuGeppoHoseiHakoMapper {

    /**
     * 事業報告集計一覧データを取得します。
     *
     * @param parameter
     * @return List<JigyoHokokuGeppoHoseiHakoEntity>
     */
    List<JigyoHokokuGeppoHoseiHakoEntity> select事業報告集計一覧データ(JigyoHokokuGeppoSearchParameter parameter);
}

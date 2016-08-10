/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.keikakurirekiichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.keikakurirekiichiran.KeikakuRirekiIchiranEnitity;

/**
 * 居宅給付計画届出情報の取得
 *
 * @reamsid_L DBC-4350-080 liuxiaoyu
 */
public interface IKeikakuRirekiIchiranMapper {

    /**
     * 居宅給付計画届出情報取得する
     *
     * @param parameter Map<String, Object>
     * @return List<KeikakuRirekiIchiranEnitity>
     */
    List<KeikakuRirekiIchiranEnitity> select居宅給付計画届出情報(Map<String, Object> parameter);

}

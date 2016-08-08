/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.ninteirirekiichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.ninteirirekiichiran.JyukyuuSyaDaiTyouEntity;

/**
 * 認定履歴一覧（画面）
 *
 * @reamsid_L DBC-4350-070 wangxingpeng
 */
public interface INinteiRirekiIchiranMapper {

    /**
     * insert受給者台帳情報取得
     *
     * @param map Map<String, Object>
     * @return List<JyukyuuSyaDaiTyouEntity> 受給者台帳情報
     */
    List<JyukyuuSyaDaiTyouEntity> select受給者台帳情報取得(Map<String, Object> map);

}

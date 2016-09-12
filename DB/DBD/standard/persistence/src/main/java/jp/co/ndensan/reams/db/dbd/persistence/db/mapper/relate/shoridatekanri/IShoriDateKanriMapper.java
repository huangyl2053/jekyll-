/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shoridatekanri;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.ShoriDateKanriEntity;

/**
 * 処理日付管理マスタ更新のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public interface IShoriDateKanriMapper {

    /**
     * 処理日付管理マスタ更新処理
     *
     * @param entity パラメータ
     * @return int
     */
    int updDbt7022ShoriDateKanri(ShoriDateKanriEntity entity);

}

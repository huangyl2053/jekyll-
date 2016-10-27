/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteiidokanendo;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendo.HonsanteiIdoKanendoEntity;

/**
 * ビジネス設計_DBBBZ45001_本算定異動（過年度）
 *
 * @reamsid_L DBB-0920-020 quxiaodong
 */
public interface IHonsanteiIdoKanendoMapper {

    /**
     * 確定日時取得です。
     *
     * @return HonsanteiIdoKanendoEntity
     */
    HonsanteiIdoKanendoEntity select確定日時();

}

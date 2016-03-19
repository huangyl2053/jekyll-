/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.honsanteiidokanendofukakakutei;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kanendoidofukakakutei.KanendoIdoFukaKakuteiEntity;

/**
 *
 * 異動賦課対象取得用ビジネスです
 */
@lombok.Getter
@lombok.Setter
public class KanendoIdoFukaKakutei {

    KanendoIdoFukaKakuteiEntity fukaKakuteiEntity;

    /**
     * 異動賦課対象取得用ビジネスです
     *
     * @param fukaKakuteiEntity fukaKakuteiEntity
     */
    public KanendoIdoFukaKakutei(KanendoIdoFukaKakuteiEntity fukaKakuteiEntity) {
        this.fukaKakuteiEntity = fukaKakuteiEntity;
    }

}

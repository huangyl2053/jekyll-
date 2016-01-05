/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.persistence.mapper.relate.koikinaijushochitokurei;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei.KoikinaiJushochiTokureiRelateEntity;

/**
 *
 * 広域内住所地特例者情報を取得クラスです。
 */
public interface IKoikinaiJushochiTokureiMapper {
    
    /**
     * 広住特適用情報を取得します。
     * @return 広住特適用情報のエンティティクラスです
     */
    KoikinaiJushochiTokureiRelateEntity get広住特適用情報();
    
}

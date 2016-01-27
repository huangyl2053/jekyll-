/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic.KojinJokyoShokai;

import jp.co.ndensan.reams.db.dbd.definition.parameter.KojinJokyoShokaiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.relate.KojinJokyoShokai.KojinJokyoShokaiRelateEntity;

/**
 *
 * @author soft863
 */
public interface KojinJokyoShokaiMapper {

    /**
     * KojinJokyoShokaiRelateEntityを取得します。
     *
     * @param parameter
     * @return ShujiiJohoRelateEntity 検索結果の{@link ShujiiJohoRelateEntity}
     */
    KojinJokyoShokaiRelateEntity getKojinJokyoShokaiRelateEntity(KojinJokyoShokaiParameter parameter);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.roujinhokenjukyushadaichokanrimapper;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.roujinhokenjukyushadaichokanri.RoujinHokenJukyushaDaichoKanriParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 老人保健受給者情報のマッパーインタフェースです。
 *
 * @reamsid_L DBU-1110-020 zhangzhiming
 */
public interface IRoujinHokenJukyushaDaichoKanriMapper {

    /**
     * 宛名情報取得します。
     *
     * @param 老人保健受給者検索条件 老人保健受給者を特定するためのMyBatis用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity selectJyohou(RoujinHokenJukyushaDaichoKanriParameter 老人保健受給者検索条件);

}

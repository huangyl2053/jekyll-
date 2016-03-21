/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shisetsunyushoinfo;

import jp.co.ndensan.reams.db.dbz.definition.param.shisetsunyushoinfo.ShisetSunyushoInfoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ShisetSunyushoInfoRelateEntity;

/**
 * 施設入所情報を取得するのマッパーインタフェースです。
 *
 */
public interface IShisetSunyushoInfoMapper {

    /**
     * 施設入所情報を取得します。
     *
     * @param params ShisetSunyushoInfoParameter
     * @return ShisetSunyushoInfoRelateEntity
     */
    // ShisetSunyushoInfoRelateEntity getSelect(ShisetSunyushoInfoParameter params);
    ShisetSunyushoInfoRelateEntity getSelect(ShisetSunyushoInfoParameter params);
}

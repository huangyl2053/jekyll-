/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.kanri;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kanri.ChosyuHohoHenkoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuhoho.ChoshuHohoEntity;

/**
 * 徴収方法変更、徴収方法取得
 */
public interface IChosyuHohoHenkoMapper {

    /**
     * 徴収方法変更、徴収方法取得します。
     *
     * @param parameter ChosyuHohoHenkoMapperParameter
     * @return ChoshuHohoEntity
     */
    ChoshuHohoEntity selectChosyuHoho(ChosyuHohoHenkoMapperParameter parameter);

}

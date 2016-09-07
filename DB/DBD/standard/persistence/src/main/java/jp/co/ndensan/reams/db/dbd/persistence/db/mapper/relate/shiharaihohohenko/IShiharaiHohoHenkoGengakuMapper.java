/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.shiharaihohohenko.ShiharaiHohoHenkoGengakuMapperParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoGengakuEntity;

/**
 * 支払方法変更減額のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IShiharaiHohoHenkoGengakuMapper {

    /**
     * 支払方法変更減額情報をキー検索で１件取得します。
     *
     * @param 支払方法変更減額検索条件 支払方法変更減額検索条件
     * @return ShiharaiHohoHenkoGengakuEntity
     */
    ShiharaiHohoHenkoGengakuEntity select支払方法変更減額ByKey(ShiharaiHohoHenkoGengakuMapperParameter 支払方法変更減額検索条件);

}

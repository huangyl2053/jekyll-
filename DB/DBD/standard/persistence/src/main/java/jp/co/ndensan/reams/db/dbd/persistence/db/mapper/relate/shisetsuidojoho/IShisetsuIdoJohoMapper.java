/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shisetsuidojoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shisetsuidojoho.ShisetsuIdoJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 【共有子Div】施設入退のマッパーインタフェースです。
 *
 * @reamsid_L DBD-3560-120 wangjie2
 */
public interface IShisetsuIdoJohoMapper {

    /**
     * 介護施設入退所情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return List<ShisetsuIdoJohoEntity>
     */
    List<ShisetsuIdoJohoEntity> get介護施設入退所情報(ShikibetsuCode 識別コード);

}

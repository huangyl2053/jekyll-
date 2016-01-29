/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.entity.db.jigyohokokugeppohoseihako;

import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sunhui
 */
@Getter
@Setter
public class JigyoHokokuGeppoHoseiHakoEntity {
    private DbT7021JigyoHokokuTokeiDataEntity entity;
    private RString yoshiCode;

    public JigyoHokokuGeppoHoseiHakoEntity(DbT7021JigyoHokokuTokeiDataEntity entity, RString yoshiCode) {
        this.entity = entity;
        this.yoshiCode = yoshiCode;
    }
    
}

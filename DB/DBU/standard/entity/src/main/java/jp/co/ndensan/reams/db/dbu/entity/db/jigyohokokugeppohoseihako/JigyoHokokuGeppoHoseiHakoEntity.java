/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.jigyohokokugeppohoseihako;

import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告集計一覧データEntityクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoHoseiHakoEntity {

    private final DbT7021JigyoHokokuTokeiDataEntity entity;
    private final RString yoshiCode;
    private final RString shichosonName;

    public JigyoHokokuGeppoHoseiHakoEntity(DbT7021JigyoHokokuTokeiDataEntity entity,
            RString yoshiCode,
            RString shichosonName) {
        this.entity = entity;
        this.yoshiCode = yoshiCode;
        this.shichosonName = shichosonName;
    }

}

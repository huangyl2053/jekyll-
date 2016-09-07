/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohoseihako;

import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業報告集計一覧データEntityクラスです。
 *
 * @reamsid_L DBU-1100-100 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoHoseiHakoEntity {

    private DbT7021JigyoHokokuTokeiDataEntity entity;
    private RString yoshiCode;
    private RString shichosonName;
}

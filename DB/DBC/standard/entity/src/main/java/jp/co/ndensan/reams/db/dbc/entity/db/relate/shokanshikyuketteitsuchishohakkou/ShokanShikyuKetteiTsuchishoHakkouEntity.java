/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteitsuchishohakkou;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;

/**
 * 償還払支給判定結果Entityです。
 *
 * @reamsid_L DBD-5310-010 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiTsuchishoHakkouEntity {

    private DbT3036ShokanHanteiKekkaEntity dbT3036Entity;
    private DbT3034ShokanShinseiEntity dbT3034Entity;
}

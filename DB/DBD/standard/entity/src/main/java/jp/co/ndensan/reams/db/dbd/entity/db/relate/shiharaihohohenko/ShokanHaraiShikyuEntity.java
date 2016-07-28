/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;

/**
 * 償還払支給情報RelateEntityクラスです。
 *
 * @reamsid_L DBD-3620-070 xuyue
 */
@lombok.Getter
@lombok.Setter
public class ShokanHaraiShikyuEntity {

    private DbT3034ShokanShinseiEntity 償還払支給申請Entity;
    private DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity;
    private DbT3053ShokanShukeiEntity 償還払請求集計Entity;
    private DbT4024ShiharaiHohoHenkoSashitomeEntity 支払方法変更差止Entity;
}

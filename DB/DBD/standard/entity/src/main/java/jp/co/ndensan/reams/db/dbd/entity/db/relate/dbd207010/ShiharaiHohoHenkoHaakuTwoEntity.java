/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス2SQL検索結果クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuTwoEntity {

    private DbT3034ShokanShinseiEntity 償還払支給申請Entity;
    private DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity;
}

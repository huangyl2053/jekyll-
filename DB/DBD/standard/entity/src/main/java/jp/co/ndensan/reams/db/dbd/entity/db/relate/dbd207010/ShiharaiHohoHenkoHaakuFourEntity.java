/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス4SQL検索結果クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHohoHenkoHaakuFourEntity {

    private DbT4021ShiharaiHohoHenkoEntity 支払方法変更Entity;
    private List<DbT4024ShiharaiHohoHenkoSashitomeEntity> 支払方法変更差止リスト;
    private List<ShokanShinseiHanteiKekkaJohoEntity> 償還情報リスト;
}

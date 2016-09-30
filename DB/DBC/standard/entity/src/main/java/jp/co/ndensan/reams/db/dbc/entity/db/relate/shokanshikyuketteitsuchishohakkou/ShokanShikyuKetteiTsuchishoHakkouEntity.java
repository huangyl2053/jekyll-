/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteitsuchishohakkou;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;

/**
 * 償還払支給判定結果Entityです。
 *
 * @reamsid_L DBC-5310-010 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuKetteiTsuchishoHakkouEntity implements Serializable {

    private DbT3036ShokanHanteiKekkaEntity dbT3036Entity;
    private DbT3034ShokanShinseiEntity dbT3034Entity;

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     * DbT3036ShokanHanteiKekkaEntityが持つDbT3034ShokanShinseiEntity<br/>
     * のMD5値を計算し、設定します。
     */
    public void initializeMd5ToEntities() {
        this.dbT3034Entity.initializeMd5();
        this.dbT3036Entity.initializeMd5();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;

/**
 * 高額介護サービス費情報のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKaigoServiceHiRelateEntity {

    private DbT3056KogakuShikyuShinseiEntity 支給申請;
    private DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果;
    private DbT3055KogakuKyufuTaishoshaGokeiEntity 給付対象者合計;
    private DbT3054KogakuKyufuTaishoshaMeisaiEntity 給付対象者明細;
    private DbT3058KogakuShikyuShinsaKetteiEntity 支給審査決定;

    private ShinseiJohoTempEntity 申請情報;

    /**
     * コンストラクタです。
     */
    public KogakuKaigoServiceHiRelateEntity() {
        this.支給申請 = new DbT3056KogakuShikyuShinseiEntity();
        this.支給判定結果 = new DbT3057KogakuShikyuHanteiKekkaEntity();
        this.給付対象者合計 = new DbT3055KogakuKyufuTaishoshaGokeiEntity();
        this.給付対象者明細 = new DbT3054KogakuKyufuTaishoshaMeisaiEntity();
        this.支給審査決定 = new DbT3058KogakuShikyuShinsaKetteiEntity();
        this.申請情報 = new ShinseiJohoTempEntity();
    }

}

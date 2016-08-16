/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;

/**
 * 事業高額介護サービス費情報のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikyoKogakuKaigoServiceHiRelateEntity {

    private DbT3110JigyoKogakuShikyuShinseiEntity 支給申請;
    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity 支給判定結果;
    private DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 給付対象者合計;
    private DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity 給付対象者明細;
    private DbT3112KogakuShikyuShinsaKetteiEntity 支給審査決定;

    private ShinseiJohoTempEntity 申請情報;

    /**
     * コンストラクタです。
     */
    public JikyoKogakuKaigoServiceHiRelateEntity() {
        this.支給申請 = new DbT3110JigyoKogakuShikyuShinseiEntity();
        this.支給判定結果 = new DbT3111JigyoKogakuShikyuHanteiKekkaEntity();
        this.支給審査決定 = new DbT3112KogakuShikyuShinsaKetteiEntity();
        this.申請情報 = new ShinseiJohoTempEntity();
        this.給付対象者合計 = new DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity();
        this.給付対象者明細 = new DbT3108JigyoKogakuKyufuTaishoshaMeisaiEntity();
    }

}

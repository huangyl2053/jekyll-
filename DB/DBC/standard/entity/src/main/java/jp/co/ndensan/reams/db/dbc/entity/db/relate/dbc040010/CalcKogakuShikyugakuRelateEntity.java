/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の高額支給額集計RelateEntityです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CalcKogakuShikyugakuRelateEntity {

    private JissekiFutangakuDataTempEntity 実績負担額データEntity;
    private DbT3056KogakuShikyuShinseiEntity 支給申請Entity;
    private DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果Entity;
    private DbT3058KogakuShikyuShinsaKetteiEntity 支給審査決定Entity;
    private DbT3055KogakuKyufuTaishoshaGokeiEntity 給付対象者合計Entity;

}

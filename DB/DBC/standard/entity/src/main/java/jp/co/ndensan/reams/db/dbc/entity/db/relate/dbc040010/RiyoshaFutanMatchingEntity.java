/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040010;

import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）の実績負担額データ<br/>
 * と給付実績基本を紐つけを行い、サービス提供年月を取得する。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class RiyoshaFutanMatchingEntity extends DbTableEntityBase<RiyoshaFutanMatchingEntity> implements IDbAccessable {

    private RiyoshaFutangakuEntity 利用者負担;
    private JissekiFutangakuDataTempEntity 実績負担額データ;

}

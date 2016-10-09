/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020080;

import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * ビジネス設計_DBCMN62006_自己負担額計算（一括）のCalcKogakuShikyugakuEntityエンティティです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class CalcKogakuShikyugakuEntity extends DbTableEntityBase<CalcKogakuShikyugakuEntity> implements IDbAccessable {

    private JissekiFutangakuDataTempEntity 実績負担額データ;
    private KogakuShikyugakuEntity 関連データ;

}

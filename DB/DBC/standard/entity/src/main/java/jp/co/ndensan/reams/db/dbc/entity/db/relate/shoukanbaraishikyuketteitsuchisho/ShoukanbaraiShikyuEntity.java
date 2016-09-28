/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBCMN12028_償還払い支給（不支給）決定通知書作成（単）のEntity。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanbaraiShikyuEntity {

    private DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果;
    private DbT3034ShokanShinseiEntity 償還払支給申請;

}

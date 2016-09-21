/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;

/**
 *
 * @reamsid_L DBC-5010-030 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomimeisaiFurikomiEntity {

    private DbT3036ShokanHanteiKekkaEntity 償還払支給判定結果Entity;

    private DbT3034ShokanShinsei 償還払支給申請Entity;
}

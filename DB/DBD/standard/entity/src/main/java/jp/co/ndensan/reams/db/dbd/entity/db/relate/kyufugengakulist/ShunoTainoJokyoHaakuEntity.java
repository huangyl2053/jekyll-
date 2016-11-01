/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.TaishoshaJohoTempTableEntity;

/**
 * 収納滞納状況把握情報の取得SQL用結果クラスです．
 *
 * @reamsid_L DBD-3610-050 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoTainoJokyoHaakuEntity {

    private ShunoJokyoTempTableEntity 収納状況TmpTblEntity;
    private TaishoshaJohoTempTableEntity 対象者TmpTblEntity;
    private DbT4022ShiharaiHohoHenkoTainoEntity 支払方法変更滞納Entity;

}

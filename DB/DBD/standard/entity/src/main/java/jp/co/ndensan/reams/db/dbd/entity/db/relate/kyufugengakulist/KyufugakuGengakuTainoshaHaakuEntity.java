/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.TaishoshaJohoTempTableEntity;

/**
 * 給付額減額滞納者把握情報の取得SQL用結果クラスです．
 *
 * @reamsid_L DBD-3610-050 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugakuGengakuTainoshaHaakuEntity {

    private ShunoTainoJokyoTempTableEntity 収納滞納状況TmpTblEntity;
    private TaishoshaJohoTempTableEntity 対象者TmpTblEntity;
    private DbT4022ShiharaiHohoHenkoTainoEntity 支払方法変更滞納Entity;

}

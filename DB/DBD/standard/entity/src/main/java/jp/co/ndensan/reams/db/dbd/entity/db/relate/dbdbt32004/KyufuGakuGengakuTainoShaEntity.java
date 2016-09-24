/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 給付額減額滞納者把握情報取得Entity
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGakuGengakuTainoShaEntity {

    private TaishoShaKanriJohoTableEntity 対象者情報一時Entity;
    private List<ShunoTainoJokyoTempTableEntity> 収納滞納状況一時Entity;
    private List<DbT4025ShiharaiHohoHenkoGengakuEntity> 支払方法変更減額Entity;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.ShunoTainoJokyoTempTableEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.TaishoshaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;

/**
 * 給付額減額滞納者把握情報の取得SQL用結果クラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGengakuHaakuListSakuseiEntity {

    private ShunoTainoJokyoTempTableEntity 収納滞納状況TmpTblEntity;
    private TaishoshaJohoTempTableEntity 対象者TmpTblEntity;
    private DbT4025ShiharaiHohoHenkoGengakuEntity 支払方法変更減額Entity;

    private DbT1001HihokenshaDaichoEntity 資格情報Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生保情報Entity;
    private NinteiJohoEntity 認定情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private HihokenshaNo 申請中被保険者;

}

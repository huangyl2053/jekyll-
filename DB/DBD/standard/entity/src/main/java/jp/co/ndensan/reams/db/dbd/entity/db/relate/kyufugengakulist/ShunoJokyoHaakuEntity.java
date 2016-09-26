/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;

/**
 * 給付額減額滞納者把握リスト（バッチ）の収納状況把握情報のRelateEntityクラスです。
 *
 * @reamsid_L DBD-3610-050 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJokyoHaakuEntity {

    private DbT1001HihokenshaDaichoEntity 資格情報Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生保情報Entity;
    private NinteiJohoEntity 認定情報;
    private ShunoJohoEntity 収納情報;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private HihokenshaNo 申請中被保険者;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import java.util.List;
import jp.co.ndensan.reams.ca.cax.entity.db.basic.CaT1018TokusokuHakkoRirekiEntity;
import jp.co.ndensan.reams.ca.cax.entity.db.relate.TotalShunyuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;

/**
 * 給付額減額滞納者把握リスト（バッチ）の収納状況把握情報のRelateEntityクラスです。
 *
 * @reamsid_L DBD-3610-050 wangchao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJokyoHaakuEntity {

    private DbT1001HihokenshaDaichoEntity hihokenshaDaichoEntity;
    private UrT0508SeikatsuHogoJukyushaEntity seikatsuHogoJukyushaEntity;
    private NinteiJohoEntity ninteiJohoEntity;
    private List<ShunoJohoEntity> shunoJohoEntity;
    private UaFt200FindShikibetsuTaishoEntity findShikibetsuTaishoEntity;
    private TotalShunyuRelateEntity totalShunyuRelateEntity;
    private CaT1018TokusokuHakkoRirekiEntity tokusokuHakkoRirekiEntity;
}

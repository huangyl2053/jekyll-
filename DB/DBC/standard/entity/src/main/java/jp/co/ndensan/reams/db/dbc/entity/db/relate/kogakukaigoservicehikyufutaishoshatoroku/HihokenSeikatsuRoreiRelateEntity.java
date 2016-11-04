/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;

/**
 * 被保・生保・老齢情報のエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class HihokenSeikatsuRoreiRelateEntity {

    private TempSetaiinShotokuHanteiEntity 判定明細Entity;
    private DbT1001HihokenshaDaichoEntity 被保険者情報Entity;
    private UrT0508SeikatsuHogoJukyushaEntity 生保情報Entity;
    private DbT7006RoreiFukushiNenkinJukyushaEntity 老齢情報Entity;

}

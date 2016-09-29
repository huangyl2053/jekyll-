/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;

/**
 * 世帯員把握の結果のエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class SetaiHihokenshaResultEntity {

    private SetaiShotokuEntity 世帯員所得情報Entity;
    private DbT1001HihokenshaDaichoEntity 被保険者情報Entity;

}

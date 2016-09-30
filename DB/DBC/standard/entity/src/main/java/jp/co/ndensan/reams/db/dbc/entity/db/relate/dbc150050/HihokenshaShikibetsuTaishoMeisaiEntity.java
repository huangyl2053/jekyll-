/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 被保険者・宛名情報の取得Entityクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaShikibetsuTaishoMeisaiEntity {

    private int 連番;
    private DbWT3470ServiceMeisaiTempEntity サービス明細;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理;

}

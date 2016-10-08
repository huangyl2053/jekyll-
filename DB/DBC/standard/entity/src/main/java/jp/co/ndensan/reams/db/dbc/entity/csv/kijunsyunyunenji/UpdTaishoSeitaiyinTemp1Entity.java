/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;

/**
 * 対象世帯員クラスTempに更新1Entityクラスです
 *
 * @reamsid_L DBC-4630-050 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdTaishoSeitaiyinTemp1Entity {

    private TaishoSetaiinEntity 対象世帯員;
    private DbV1001HihokenshaDaichoEntity 被保険者台帳管理Newest;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteiidokanendofuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;

/**
 * 被保険者台帳管理、賦課Newestをもとに取得した情報
 *
 * @reamsid_L DBB-0910-020 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT1001AndFukaJohoEntity {

    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理;
    private FukaJohoRelateEntity 賦課Newest;
}

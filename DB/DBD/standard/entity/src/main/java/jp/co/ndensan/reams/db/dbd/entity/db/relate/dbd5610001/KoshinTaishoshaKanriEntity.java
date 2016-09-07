/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5610001;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;

/**
 * 更新申請対象者情報Entity
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinTaishoshaKanriEntity {

    private DbT4101NinteiShinseiJohoEntity dbT4101NinteiShinseiJohoEntity;
    private DbT4121ShinseiRirekiJohoEntity dbT4121ShinseiRirekJohoEntity;
    private DbT4102NinteiKekkaJohoEntity dbT4102NinteiKekkaJohoEntity;
    private DbT4101NinteiShinseiJohoEntity seihoDbT4101NinteiShinseiJohoEntity;
}

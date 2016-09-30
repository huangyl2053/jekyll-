/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;

/**
 * 認定情報のRelateEntityクラスです。
 *
 * @reamsid_L DBD-3610-050 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiJohoEntity {

    private DbV4001JukyushaDaichoEntity 受給者Entity;
    private DbT4101NinteiShinseiJohoEntity 要介護認定申請Entity;
}

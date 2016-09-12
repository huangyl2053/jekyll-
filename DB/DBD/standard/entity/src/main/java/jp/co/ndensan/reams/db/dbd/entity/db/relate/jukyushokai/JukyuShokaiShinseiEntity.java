/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.jukyushokai;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;

/**
 * 申請情報RelateEntityクラスです。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyuShokaiShinseiEntity {

    private DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity;

    /**
     * コンストラクタです。
     */
    public JukyuShokaiShinseiEntity() {
        受給者台帳Entity = new DbT4001JukyushaDaichoEntity();
        要介護認定インターフェース情報Entity = new DbT4003YokaigoNinteiInterfaceEntity();
    }

}

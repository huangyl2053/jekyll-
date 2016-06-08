/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査委託先情報
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaItakusaki {

    private DbT5910NinteichosaItakusakiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaItakusaki() {
        this.entity = new DbT5910NinteichosaItakusakiJohoEntity();
    }
}

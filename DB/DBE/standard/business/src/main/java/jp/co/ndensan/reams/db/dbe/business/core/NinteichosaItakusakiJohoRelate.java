/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査委託先情報
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosaItakusakiJohoRelate {

    private NinteichosaItakusakiJohoRelateEntity entity;

    /**
     * コンストラクタです。
     */
    public NinteichosaItakusakiJohoRelate() {
        this.entity = new NinteichosaItakusakiJohoRelateEntity();
    }
}

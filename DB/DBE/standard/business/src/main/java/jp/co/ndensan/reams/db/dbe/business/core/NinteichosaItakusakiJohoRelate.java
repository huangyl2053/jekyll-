/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core;

import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
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

    /**
     * コンストラクタです。
     *
     * @param entity NinteichosaItakusakiJohoRelateEntity
     */
    public NinteichosaItakusakiJohoRelate(NinteichosaItakusakiJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定調査委託先情報を返します。
     *
     * @return NinteichosaItakusakiJoho
     */
    public NinteichosaItakusakiJoho getNinteichosaItakusakiJoho() {
        return new NinteichosaItakusakiJoho(entity);
    }

    /**
     * 調査員情報を返します。
     *
     * @return ChosainJoho
     */
    public ChosainJoho getChosainJoho() {
        return new ChosainJoho(entity.get調査員情報Entity().get(0));
    }
}

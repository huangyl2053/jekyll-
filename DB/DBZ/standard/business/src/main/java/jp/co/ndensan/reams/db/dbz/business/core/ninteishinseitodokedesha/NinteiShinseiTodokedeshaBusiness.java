/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinseitodokedesha.NinteiShinseiTodokedeshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;

/**
 * 介護認定申請届出者のentityクラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class NinteiShinseiTodokedeshaBusiness {

    private final NinteiShinseiTodokedeshaEntity relateEntity;

    /**
     * コンストラクタです。
     *
     * @param relateEntity NinteiShinseiTodokedeshaEntity
     */
    public NinteiShinseiTodokedeshaBusiness(NinteiShinseiTodokedeshaEntity relateEntity) {
        this.relateEntity = relateEntity;
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return relateEntity.getTelNo();
    }

    /**
     * PsmEntityを取得します。
     *
     * @return PsmEntity
     */
    public UaFt200FindShikibetsuTaishoEntity getPsmEntity() {
        return relateEntity.getPsmEntity();
    }

}

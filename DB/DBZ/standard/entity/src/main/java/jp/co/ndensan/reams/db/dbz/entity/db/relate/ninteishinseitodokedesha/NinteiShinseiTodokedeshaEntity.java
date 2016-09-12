/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.ninteishinseitodokedesha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;

/**
 * 介護認定申請届出者のentityクラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiTodokedeshaEntity {

    private TelNo telNo;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
}

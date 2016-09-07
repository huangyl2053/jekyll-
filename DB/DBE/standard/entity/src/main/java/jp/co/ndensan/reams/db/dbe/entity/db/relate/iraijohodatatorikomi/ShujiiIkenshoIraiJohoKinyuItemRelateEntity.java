/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;

/**
 * 要介護認定主治医意見書記入項目のRelateEntityクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoIraiJohoKinyuItemRelateEntity {

    private int ikenshoIraiRirekiNo;
    private List<DbT5303ShujiiIkenshoKinyuItemEntity> entity;
}

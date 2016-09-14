/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）の介護徴収方法情報のエンティティクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class AtenaSealJohoEntity
        extends DbTableEntityBase<AtenaSealJohoEntity> implements IDbAccessable {

    private HihokenshaNo 被保険者番号;
    private List<UaFt200FindShikibetsuTaishoEntity> 宛名識別対象PSM;
    private List<UaFt250FindAtesakiEntity> 宛先PSM;
}

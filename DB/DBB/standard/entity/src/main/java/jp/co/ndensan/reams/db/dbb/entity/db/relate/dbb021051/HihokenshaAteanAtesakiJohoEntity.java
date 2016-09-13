/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.dbb021051;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）の 被保険者台帳宛名情報のエンティティクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter

public class HihokenshaAteanAtesakiJohoEntity
        extends DbTableEntityBase<HihokenshaAteanAtesakiJohoEntity> implements IDbAccessable {

    private DBB021051TableJohoTempEntity 介護情報一時テーブル;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
    private List<UaFt250FindAtesakiEntity> 宛先PSM;
}

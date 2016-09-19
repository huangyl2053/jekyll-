/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * バッチ設計_DBD571001_受給者台帳の異動抽出対象用エンティティを取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoChushutsuDaichoEntity {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;

}

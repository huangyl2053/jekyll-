/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmen.shinseisho.hakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 利用者負担額免除申請書Entityクラスです。
 *
 * @reamsid_L DBD-3530-080 mawy
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutangakuGemmenShinseishoHakkoEntity {

    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private boolean 旧措置者フラグ;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private LasdecCode 市町村コード;
    private LasdecCode 広住特措置元市町村コード;
}

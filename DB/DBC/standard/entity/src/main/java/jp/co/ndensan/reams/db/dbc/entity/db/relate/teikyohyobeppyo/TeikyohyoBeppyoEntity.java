/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.teikyohyobeppyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC0150011_サービス提供票別表 Entity
 *
 * @reamsid_L DBC-5110-010 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TeikyohyoBeppyoEntity {

    private HihokenshaNo 被保険者番号;
    private RString 総合事業区分;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}

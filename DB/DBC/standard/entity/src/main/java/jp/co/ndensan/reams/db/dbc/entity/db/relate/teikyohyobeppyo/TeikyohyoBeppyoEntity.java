/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.teikyohyobeppyo;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBC0150011_サービス提供票別表のEntityクラスです。
 *
 * @reamsid_L DBC-5100-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TeikyohyoBeppyoEntity {

    private FlexibleYearMonth 対象年月;
    private int 履歴番号;
    private RString 総合事業区分;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯員所得情報クラスです
 *
 * @reamsid_L DBD-3830-040 tianyh
 */
@Getter
@Setter
public class Setaiinshotokujoho {

    private ShikibetsuCode 識別コード;
    private RString 本人課税区分;
    private Decimal 課税所得額;
    private UaFt200FindShikibetsuTaishoEntity 世帯員宛名;
}

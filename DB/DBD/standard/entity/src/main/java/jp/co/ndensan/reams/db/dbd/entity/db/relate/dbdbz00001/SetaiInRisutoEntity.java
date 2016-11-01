/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 世帯員所得情報クラスです
 *
 * @reamsid_L DBD-3960-050 x_liuwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiInRisutoEntity {

    private RString 識別コード;
    private RString 課税区分;
    private Decimal 課税所得額;
    private UaFt200FindShikibetsuTaishoEntity 世帯員宛名;
    private boolean is受給者;

}

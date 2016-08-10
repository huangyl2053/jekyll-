/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員情報Entityクラスです．
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeteiYouEntity {
    private RString 識別コード;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private RString 課税区分;
    private RString 課税所得額;
}

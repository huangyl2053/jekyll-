/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist;

import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 期別毎の収納情報です。
 *
 * @reamsid_L DBD-3630-050 xuyue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoKibetsuEntity {

    private RString 期別;
    private Decimal 保険料金;
    private FlexibleDate 納期限;
    private Decimal 滞納額;
    private TainoKubun 滞納区分;
    private FlexibleDate 時効起算日;
    private RString 時効起算事由;

}

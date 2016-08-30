/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特例施設入退所情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokureiShisetuNyutaishojohoEntity {

    private RString 特例施設入退所区分;
    private RString 明細番号;
    private FlexibleDate 入所日;
    private FlexibleDate 退所日;
    private RString 事業所番号;
    private RString 事業所;
    private RString 電話番号;
}

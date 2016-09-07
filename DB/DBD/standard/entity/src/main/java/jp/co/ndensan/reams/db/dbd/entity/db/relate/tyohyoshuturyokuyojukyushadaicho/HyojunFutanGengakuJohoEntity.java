/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 標準負担減額情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HyojunFutanGengakuJohoEntity {

    private RString 標準負担減額区分;
    private RString 明細番号;
    private FlexibleDate 減免申請日;
    private FlexibleDate 減免決定日;
    private FlexibleDate 減免開始日;
    private FlexibleDate 減免終了日;
    private RString 負担額;

}

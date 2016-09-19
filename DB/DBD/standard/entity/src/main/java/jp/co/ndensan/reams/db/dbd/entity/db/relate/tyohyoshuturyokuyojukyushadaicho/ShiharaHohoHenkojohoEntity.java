/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaHohoHenkojohoEntity {

    private RString 支払方法変更区分;
    private RString 明細番号;
    private ShiharaiHenkoTorokuKubun 給付制限;
    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private ShiharaiHenkoShuryoKubun 終了事由;
    private RString 差止状況;
    private FlexibleYearMonth 提供年月;
    private RString 整理番号;
    private RString 控除;
}

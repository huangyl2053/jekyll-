/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanGendogakuNinteiJohoEntity {

    private RString 負担限度額認定区分;
    private RString 明細番号;
    private FlexibleDate 申請年月日;
    private RString 申請理由;
    private FlexibleDate 決定年月日;
    private FlexibleDate 適用年月日;
    private FlexibleDate 有効期限;
    private RString 負担段階;
    private RString 旧措置;
    private RString 居室種別;
    private Decimal 食費;
    private Decimal ユ個;
    private Decimal ユ準;
    private Decimal 従特養;
    private Decimal 従老健;
    private Decimal 多床;
    private RString 境界層;
    private RString 激変緩和;

}

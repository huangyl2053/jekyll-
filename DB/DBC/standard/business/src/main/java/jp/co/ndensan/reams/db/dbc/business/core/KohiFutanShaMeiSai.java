/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 公費負担者分再審査決定通知書情報（明細）のクラスです。
 *
 * @reamsid_L DBC-2820-020 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KohiFutanShaMeiSai {

    private FlexibleYearMonth 取扱年月;
    private RString 履歴番号;
    private RString 事業所番号;
    private RString 事業所名;
    private RString 公費受給者番号;
    private RString 公費受給者氏名;
    private RString 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString サービス種類コード;
    private RString サービス種類名;
    private RString 再審査申立事由コード;
    private RString 再審査申立事由;
    private RString 再審査結果コード;
    private Decimal 当初請求単位数;
    private RString 原番単位数;
    private Decimal 申立単位数;
    private Decimal 決定単位数;
    private Decimal 調整単位数;
    private Decimal 公費負担額;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kijunshunyugaku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBC1000062_基準収入額適用申請登録_基準収入額データ
 *
 * @reamsid_L DBC-4620-040 zhouchuanlin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuDate implements Serializable {

    private RString 識別コード;
    private RString 被保険者番号;
    private RString 氏名;
    private RString 氏名カナ;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 年齢;
    private RString 続柄;
    private RString 住民税;
    private Decimal 合計所得金額;
    private Decimal 年金等収入;
    private Decimal 年金等所得;
    private Decimal 課税所得;

}

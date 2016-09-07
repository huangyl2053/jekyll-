/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohiseikyugakutsuchishokohi;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 請求額通知書一時TBLのEntityです。
 *
 * @reamsid_L DBC-4700-030 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiSeikyugakuTsuchishoKohiChoyoEntity implements Serializable {

    private int 連番;
    private HokenshaNo 保険者番号;
    private RString 保険者名;
    private RString 証記載保険者番号;
    private RString 証記載保険者名;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private RString 款コード;
    private RString 款名;
    private RString 項コード;
    private RString 項名;
    private FlexibleYearMonth 審査年月;
    private RString 国保連合会名;
    private RString 目コード;
    private RString 目名;
    private RString サービス種類コード;
    private RString サービス種類名;
    private int 通常分_件数;
    private int 通常分_実日数;
    private Decimal 通常分_単位数;
    private Decimal 通常分_金額;
    private int 再審査_過誤_件数;
    private Decimal 再審査_過誤_単位数;
    private Decimal 再審査_過誤_調整額;
    private RString 介護給付_総合事業費;
    private Decimal 利用者負担額;
    private Decimal 公費負担額;
    private RString 合計_帳票レコード種別;
    private int 合計_通常分_件数;
    private Decimal 合計_通常分_単位数;
    private Decimal 合計_通常分_金額;
    private int 合計_再審査_過誤_件数;
    private Decimal 合計_再審査_過誤_単位数;
    private Decimal 合計_再審査_過誤_調整額;
    private RString 合計_介護給付_総合事業費;
    private Decimal 合計_利用者負担額;
    private Decimal 合計_公費負担額;
    private RString 累計_帳票レコード種別;
    private int 累計_通常分_件数;
    private Decimal 累計_通常分_単位数;
    private Decimal 累計_通常分_金額;
    private int 累計_再審査_過誤_件数;
    private Decimal 累計_再審査_過誤_単位数;
    private Decimal 累計_再審査_過誤_調整額;
    private RString 累計_介護給付_総合事業費;
    private Decimal 累計_利用者負担額;
    private Decimal 累計_公費負担額;
    private RString 手数料_帳票レコード種別;
    private Decimal 手数料_請求額;
    private Decimal 手数料_累計請求額;
}

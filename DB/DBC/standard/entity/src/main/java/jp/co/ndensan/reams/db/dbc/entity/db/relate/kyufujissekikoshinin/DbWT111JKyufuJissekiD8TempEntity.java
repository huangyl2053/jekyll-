/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D8一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111JKyufuJissekiD8TempEntity {

    private int 連番;
    private RString レコード番号;
    private RString 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 給付実績情報作成区分コード;
    private RString 給付実績区分コード;
    private RString 通し番号;
    private FlexibleDate 受付年月日;
    private FlexibleDate 決定年月日;
    private RString 公費１負担番号;
    private RString 公費２負担番号;
    private RString 公費３負担番号;
    private int 利用者負担額;
    private int 公費１負担額;
    private int 公費２負担額;
    private int 公費３負担額;
    private int 支給額;
    private int 公費１支給額;
    private int 公費２支給額;
    private int 公費３支給額;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 送付年月;
    private FlexibleYearMonth 取込年月;
    private RString 作成区分;
    private RString 管理番号;
    private boolean 保険者保有給付実績情報削除済フラグ;
}

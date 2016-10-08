/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績D7一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT111IKyufuJissekiD7TempEntity {

    private int 連番;
    private RString レコード番号;
    private RString 交換情報識別番号;
    private NyuryokuShikibetsuNo 入力識別番号;
    private RString レコード種別コード;
    private HokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private JigyoshaNo 事業所番号;
    private RString 通し番号;
    private RString 明細番号;
    private ServiceCode サービスコード;
    private FlexibleDate 住宅改修着工年月日;
    private RString 住宅改修事業者名;
    private RString 住宅改修住宅住所;
    private Decimal 改修金額;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}

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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績DD一時TBL
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111OKyufuJissekiDDTempEntity {

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
    private ServiceShuruiCode サービス種類コード;
    private ServiceKomokuCode サービス項目コード;
    private Decimal 単位数;
    private Decimal 日数_回数;
    private Decimal 公費１対象日数_回数;
    private Decimal 公費２対象日数_回数;
    private Decimal 公費３対象日数_回数;
    private int サービス単位数;
    private int 公費１対象サービス単位数;
    private int 公費２対象サービス単位数;
    private int 公費３対象サービス単位数;
    private ShoKisaiHokenshaNo 施設所在保険者番号;
    private RString 摘要;
    private Decimal 後_単位数;
    private Decimal 後_日数_回数;
    private Decimal 後_公費１対象日数_回数;
    private Decimal 後_公費２対象日数_回数;
    private Decimal 後_公費３対象日数_回数;
    private int 後_サービス単位数;
    private int 後_公費１対象サービス単位数;
    private int 後_公費２対象サービス単位数;
    private int 後_公費３対象サービス単位数;
    private Decimal 再審査回数;
    private Decimal 過誤回数;
    private FlexibleYearMonth 審査年月;
    private RString 整理番号;
    private FlexibleYearMonth 取込年月;
}

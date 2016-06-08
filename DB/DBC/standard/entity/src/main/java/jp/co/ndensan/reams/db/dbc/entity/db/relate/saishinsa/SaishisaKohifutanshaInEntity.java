/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsa;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 再審査決定通知書情報取込（公費負担者分）Entityです。
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishisaKohifutanshaInEntity {

    private FlexibleYearMonth 取扱年月;
    private RString 履歴番号;
    private int 介護給付費請求件数;
    private Decimal 介護給付費請求単位数;
    private int 介護給付費決定件数;
    private Decimal 介護給付費請求公費負担額;
    private Decimal 介護給付費決定単位数;
    private Decimal 介護給付費決定公費負担額;
    private int 介護給付費調整件数;
    private Decimal 介護給付費調整単位数;
    private Decimal 介護給付費調整公費負担額;
    private int 高額介護サービス費請求件数;
    private Decimal 高額介護サービス費請求単位数;
    private Decimal 高額介護サービス費請求公費負担額;
    private int 高額介護サービス費決定件数;
    private Decimal 高額介護サービス費決定単位数;
    private Decimal 高額介護サービス費決定公費負担額;
    private int 高額介護サービス費調整件数;
    private Decimal 高額介護サービス費調整単位数;
    private Decimal 高額介護サービス費調整公費負担額;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString 審査委員会名;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private RString 公費受給者番号;
    private RString 公費受給者氏名;
    private HokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Code 再審査申立事由コード;
    private RString 再審査申立事由;
    private Code 再審査結果コード;
    private Decimal 当初請求単位数;
    private Decimal 原番単位数;
    private Decimal 申立単位数;
    private Decimal 決定単位数;
    private Decimal 調整単位数;
    private Decimal 公費負担額;
}

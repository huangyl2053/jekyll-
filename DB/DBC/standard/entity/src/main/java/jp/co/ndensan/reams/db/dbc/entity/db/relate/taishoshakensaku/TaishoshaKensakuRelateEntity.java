/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.taishoshakensaku;

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
 * 過誤申立決定情報照会のRelateEntityクラスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoshaKensakuRelateEntity {

    private FlexibleYearMonth 取扱年月;
    private RString 保険者区分;
    private Decimal 履歴番号;
    private int 介護給付費件数;
    private Decimal 介護給付費単位数;
    private Decimal 介護給付費保険者負担額;
    private int 高額介護サービス費件数;
    private Decimal 高額介護サービス費単位数;
    private Decimal 高額介護サービス費保険者負担額;
    private int 特定入所者介護サービス費等件数;
    private Decimal 特定入所者介護サービス費等費用額;
    private Decimal 特定入所者介護サービス費等保険者負担額;
    private RString 公費負担者番号;
    private FlexibleDate 作成年月日;
    private FlexibleYearMonth 取込年月;
    private FlexibleYearMonth 取扱年月_明細;
    private RString 保険者区分_明細;
    private int 履歴番号_明細;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private HihokenshaNo 被保険者番号;
    private RString 公費受給者番号;
    private HokenshaNo 証記載保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Code 過誤申立事由コード;
    private RString 過誤申立事由;
    private Decimal 単位数;
    private Decimal 保険者負担額;
    private RString コード略称;
    private FlexibleYearMonth 取込年月_明細;
    private RString 保険者区分_再;
    private Decimal 履歴番号_再;
    private RString 被保険者氏名;
}

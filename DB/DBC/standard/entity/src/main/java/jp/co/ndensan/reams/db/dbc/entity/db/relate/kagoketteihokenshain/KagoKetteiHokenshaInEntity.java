/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteihokenshain;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 過誤決定通知書情報取込一覧表情報（保険者分）Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaInEntity implements Serializable {

    private FlexibleYearMonth 取扱年月;
    private HokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;

    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private FlexibleYearMonth サービス提供年月;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private Code 過誤申立事由コード;
    private RString 過誤申立事由;
    private Decimal 単位数;
    private Decimal 保険者負担額;

    private int 介護給付費の件数;
    private Decimal 介護給付費の単位数;
    private Decimal 介護給付費の保険者負担額;
    private int 高額介護サービス費の件数;
    private Decimal 高額介護サービス費の単位数;
    private Decimal 高額介護サービス費の保険者負担額;
    private int 特定入所者介護サービス費等の件数;
    private Decimal 特定入所者介護サービス費等の単位数;
    private Decimal 特定入所者介護サービス費等の保険者負担額;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120160;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @reamsid_L DBC-0980-300 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiHokenshaChohyoEntity implements Serializable {

    private ShoKisaiHokenshaNo 保険者番号;
    private RString 保険者名;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 証記載保険者名;
    private int no;
    private FlexibleYearMonth 取扱年月;
    private JigyoshaNo 事業者番号;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private FlexibleYearMonth サービ提供年月;
    private ServiceShuruiCode サービス種類コード;
    private Code 過誤申立事由コード;
    private Decimal 単位数;
    private RString 事業者名;
    private RString サービス種類名;
    private RString 過誤申立事由;
    private Decimal 保険者負担額;
    private int 介護給付費の件数;
    private Decimal 介護給付費の単位数;
    private Decimal 介護給付費の負担額;
    private int 高額介護サービス費の件数;
    private Decimal 高額介護サービス費の単位数;
    private Decimal 高額介護サービス費の負担額;
    private int 特定入所者介護費等の件数;
    private Decimal 特定入所者介護費等の単位数;
    private Decimal 特定入所者介護費等の負担額;
    private ShikibetsuCode 識別コード;
}

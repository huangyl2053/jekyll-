/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求集計一時テーブルのエンティティ。
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanBaraShiketteiShuukeiEntity implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private JigyoshaNo 事業所番号;
    private ServiceShuruiCode サービス種類コード;
    private RString 支給区分コード;
    private Decimal 単位数_金額;
    private Decimal 支払金額;
    private int 増減点;
    private RString 増減理由;
}

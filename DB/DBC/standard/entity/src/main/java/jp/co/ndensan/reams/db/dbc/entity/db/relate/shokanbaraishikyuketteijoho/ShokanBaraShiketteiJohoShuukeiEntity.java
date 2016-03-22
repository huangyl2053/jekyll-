/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraishikyuketteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 償還払支給判定結果の登録用集計Entity
 */
@Getter
@Setter
public class ShokanBaraShiketteiJohoShuukeiEntity implements Serializable {

    private KokanShikibetsuNo 交換情報識別番号;
    private RString 帳票レコード種別;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 保険者名;
    private FlexibleDate 作成年月日;
    private RString 国保連合会名;
    private RString no;
    private RString 整理番号;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 支払金額;
    private RString 支払方法区分コード;
    private Decimal 前回支払金額;
    private Decimal 差額金額合計;
}

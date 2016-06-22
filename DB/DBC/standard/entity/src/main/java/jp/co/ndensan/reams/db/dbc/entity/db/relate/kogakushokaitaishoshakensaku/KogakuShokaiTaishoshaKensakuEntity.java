/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費一覧Entity
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiTaishoshaKensakuEntity {

    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 申請者氏名;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 高額支給額;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private RString 支給区分コード;
    private Decimal 支給金額;
    private boolean 高額自動償還;
    private Decimal 履歴番号;
}

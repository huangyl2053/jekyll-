/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakushokaitaishoshakensaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額介護サービス費一覧検索条件Entityです。
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiTaishoshaKensakuSearch {

    private boolean 指定して場合;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth 提供年月From;
    private FlexibleYearMonth 提供年月To;
    private FlexibleYearMonth 申請年月From;
    private FlexibleYearMonth 申請年月To;
    private FlexibleYearMonth 決定年月From;
    private FlexibleYearMonth 決定年月To;
    private FlexibleYearMonth 提供年月;
    private FlexibleYearMonth 申請年月;
    private FlexibleYearMonth 決定年月;
}

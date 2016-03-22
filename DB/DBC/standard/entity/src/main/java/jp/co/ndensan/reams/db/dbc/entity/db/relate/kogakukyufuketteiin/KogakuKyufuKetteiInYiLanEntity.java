/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufuketteiin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額サービス費決定情報一覧Entity
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiInYiLanEntity {

    private RString 国保連合会名;
    private HokenshaNo 保険者番号;
    private RString 保険者名;
    private RString 通知書番号;
    private AtenaKanaMeisho 氏名カナ;
    private FlexibleYearMonth サービス提供年月;
    private RString 支払可否;
    private Decimal 利用者負担額;
    private RString 喪失事由;
    private RString 住所コード;
    private YubinNo 郵便番号;
    private AtenaJusho 住所;
    private RString 行政区;
    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 氏名;
    private FlexibleYearMonth 決定年月;
    private RString 支払方法;
    private Decimal 決定支給額;
    private FlexibleDate 喪失年月日;
    private RString 行政区コード;
    private RString 備考;
    private HokenshaNo 証記載保険者番号;
}

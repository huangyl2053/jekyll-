/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費対象者一覧表Entity
 *
 * @reamsid_L DBC-2010-100 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuServicehiTaishoshaIchiranEntity {

    private FlexibleYearMonth 審査年月;
    private LasdecCode 市町村コード;
    private HihokenshaNo 被保険者番号;
    private RString 被保険者名;
    private ShikibetsuCode 識別コード;
    private FlexibleYearMonth サービス提供年月;
    private RString 旧措置者フラグ;
    private Code 要介護認定状態区分コード;
    private FlexibleDate 認定有効開始年月日;
    private FlexibleDate 認定有効終了年月日;
    private SetaiCode 世帯コード;
    private Decimal 利用者負担額;
    private Decimal 支給予定金額;
    private RString 備考;
    private YubinNo 郵便番号;
    private ChoikiCode 町域コード;
    private GyoseikuCode 行政区コード;
    private RString 氏名５０音カナ;
    private HokenshaNo 証記載保険者番号;
}

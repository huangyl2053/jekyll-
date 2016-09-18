/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc200025;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給申請一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2570-040 jiangxiaolong
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT2111ShokanShinseiEntity {

    private RString 連番;
    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private FlexibleDate 受付年月日;
    private FlexibleDate 申請年月日;
    private RString 申請理由;
    private RString 申請者区分;
    private RString 申請者氏名;
    private RString 申請者氏名カナ;
    private YubinNo 申請者郵便番号;
    private RString 申請者住所;
    private TelNo 申請者電話番号;
    private JigyoshaNo 申請事業者番号;
    private FlexibleDate 理由書作成日;
    private RString 理由書作成者;
    private RString 理由書作成者カナ;
    private JigyoshaNo 理由書作成事業者番号;
    private Decimal 支払金額合計;
    private Decimal 保険対象費用額;
    private Decimal 保険給付額;
    private Decimal 利用者負担額;
    private RString 支給申請審査区分;
    private RString 審査方法区分;
    private RString 送付区分;
    private FlexibleYearMonth 送付年月;
    private boolean 国保連再送付フラグ;
    private RString 支払方法区分コード;
    private RString 支払場所;
    private FlexibleDate 支払期間開始年月日;
    private FlexibleDate 支払期間終了年月日;
    private RString 支払窓口開始時間;
    private RString 支払窓口終了時間;
    private long 口座ID;
    private RString 受領委任契約番号;
    private RString 住宅所有者;
    private RString 被保険者との関係;
    private boolean 要介護状態３段階変更;
    private boolean 住宅住所変更;
    private FlexibleDate 審査年月日;
    private RString 審査結果;
    private FlexibleYearMonth 事前申請サービス提供年月;
    private RString 事前申請整理番号;
    private RString 住宅改修申請区分;
    private RString 住宅改修申請取消事由コード;
    private FlexibleDate 領収年月日;
    private boolean 送付除外フラグ;
    private HokenshaNo 保険者番号;
    private RString 保険者名;
    private boolean 受給者台帳フラグ;
    private boolean 旧措置者フラグ;
    private RString 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;

}

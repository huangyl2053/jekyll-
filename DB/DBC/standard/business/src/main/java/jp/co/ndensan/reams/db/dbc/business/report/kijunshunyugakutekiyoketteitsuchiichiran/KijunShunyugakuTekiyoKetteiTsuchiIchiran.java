/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票設計_DBC200092_基準収入額適用決定通知一覧表のパラメータクラスです。
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoKetteiTsuchiIchiran {

    private LasdecCode 市町村番号;
    private RString 市町村名;
    private RString 出力順１;
    private RString 出力順２;
    private RString 出力順３;
    private RString 出力順４;
    private RString 出力順５;
    private RString 改頁１;
    private RString 改頁２;
    private RString 改頁３;
    private RString 改頁４;
    private RString 改頁５;
    private int 通番;
    private SetaiCode 世帯コード;
    private FlexibleYear 年度;
    private HihokenshaNo 被保険者番号;
    private AtenaMeisho 氏名;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private FlexibleYearMonth 適用開始年月;
    private Decimal 算定基準額;
    private RString 備考;
}

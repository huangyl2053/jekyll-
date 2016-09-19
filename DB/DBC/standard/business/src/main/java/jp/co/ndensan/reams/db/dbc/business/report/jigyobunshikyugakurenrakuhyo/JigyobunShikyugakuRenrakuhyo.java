/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jigyobunshikyugakurenrakuhyo;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業分支給額計算出力帳票用データのクラスです。
 *
 * @reamsid_L DBC-4830-040 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuRenrakuhyo {

    private GassanJigyobunKekkaIchiranEntity 帳票用データ;
    private RString 出力対象区分;
    private FlexibleYearMonth 受取年月;

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 年度;
    private RString 市町村名;
}

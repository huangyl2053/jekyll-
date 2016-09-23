/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.koseitaishojissekiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC200097_更正対象給付実績一覧表のEntity。
 *
 * @reamsid_L DBC-4960-040 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiTaishoJissekiIchiranEntity {

    private LasdecCode 地方公共団体コード;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 年度;
    private FlexibleYearMonth サービス提供年月;
    private RString 市町村名;
    private RString 氏名;
    private RString 入力識別番号;
    private RString 事業者番号;
    private RString 整理番号;
    private RString サービス種類;
    private Decimal 軽減率;
    private Decimal 高額サービス費用額;
    private Decimal 更正前給付率;
    private Decimal 更正後給付率;
    private Decimal サービス費用額;
    private Decimal 更正前請求額;
    private Decimal 更正前自己負担額;
    private Decimal 更正後請求額;
    private Decimal 更正後自己負担額;
    private Decimal 自己負担差額;

}

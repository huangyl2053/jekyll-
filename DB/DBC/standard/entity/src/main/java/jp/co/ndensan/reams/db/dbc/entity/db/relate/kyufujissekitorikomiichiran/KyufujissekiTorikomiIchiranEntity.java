/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekitorikomiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 帳票設計_DBC200007_給付実績情報取込結果一覧表のEntity。
 *
 * @reamsid_L DBC-2440-030 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiTorikomiIchiranEntity {

    private HihokenshaNo 被保険者_登録被保険者番号;
    private RString 被保険者_宛名カナ名称;
    private RString 被保険者_宛名名称;
    private RString 識別コード;
    private boolean コントロール;

    private HokenshaNo 給付実績_保険者番号;
    private RString 給付実績_保険者名;
    private RString 給付実績_入力識別番号;
    private RString 給付実績_入力識別名称;
    private RString 給付実績_情報作成区分コード;
    private FlexibleYearMonth 給付実績_サービス提供年月;
    private RString 給付実績_給付実績区分;
    private JigyoshaNo 給付実績_事業所番号;
    private RString 給付実績_整理番号;
    private int 給付実績_レコード件数H1;
    private int 給付実績_レコード件数D1;
    private int 給付実績_レコード件数DD;
    private int 給付実績_レコード件数D2;
    private int 給付実績_レコード件数D3;
    private int 給付実績_レコード件数D4;
    private int 給付実績_レコード件数D5;
    private int 給付実績_レコード件数D6;
    private int 給付実績_レコード件数D7;
    private int 給付実績_レコード件数D8;
    private int 給付実績_レコード件数DE;
    private int 給付実績_レコード件数T1;
    private int 給付実績_レコード件数D9;
    private int 給付実績_レコード件数DA;
    private int 給付実績_レコード件数DB;
    private int 給付実績_レコード件数DC;
    private RString 給付実績_警告区分コード;
    private RString 給付実績_事業者名称;
    private Decimal 給付実績_出力データ件数;
}

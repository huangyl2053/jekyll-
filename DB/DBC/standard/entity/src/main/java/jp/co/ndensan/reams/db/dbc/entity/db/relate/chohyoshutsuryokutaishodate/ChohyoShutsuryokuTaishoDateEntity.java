/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.chohyoshutsuryokutaishodate;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200054_給付実績更新結果情報一覧表のEntity
 *
 * @reamsid_L DBC-2470-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoShutsuryokuTaishoDateEntity {

    private int 被保険者_連番;
    private RString 被保険者_証記載保険者番号;
    private RString 被保険者_被保険者番号;
    private RString 被保険者_サービス提供年月末日;
    private RString 被保険者_被保険者カナ氏名;
    private RString 被保険者_被保険者氏名;
    private RString 被保険者_旧市町村コード;
    private RString 被保険者_変換被保険者番号;
    private RString 被保険者_登録被保険者番号;
    private RString 被保険者_市町村コード;
    private RString 被保険者_管内管外区分;
    private RString 被保険者_郵便番号;
    private RString 被保険者_町域コード;
    private RString 被保険者_行政区コード;
    private RString 被保険者_行政区名;
    private RString 被保険者_住所;
    private RString 被保険者_番地;
    private RString 被保険者_方書;
    private RString 被保険者_宛名カナ名称;
    private RString 被保険者_宛名名称;
    private RString 被保険者_氏名50音カナ;
    private RString 被保険者_識別コード;
    private RString 被保険者_資格取得日;
    private RString 被保険者_資格取得事由コード;
    private RString 被保険者_資格喪失日;
    private RString 被保険者_資格喪失事由コード;
    private RString 被保険者_世帯集約番号;
    private int 給付実績_連番;
    private RString 給付実績_交換情報識別番号;
    private RString 給付実績_入力識別番号;
    private RString 給付実績_レコード種別コード;
    private RString 給付実績_給付実績情報作成区分コード;
    private FlexibleYearMonth 給付実績_サービス提供年月;
    private RString 給付実績_給付実績区分;
    private RString 給付実績_事業所番号;
    private RString 給付実績_整理番号;
    private int 給付実績_レコード件数H1;
    private int 給付実績_レコード件数D1;
    private int 給付実績_レコード件数DD;
    private int 給付実績_レコード件数D2;
    private int 給付実績_レコード件数DC;
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
    private RString 給付実績_警告区分コード;
    private RString 給付実績_コントロールレコード保険者番号;
    private RString 給付実績_コントロールレコード保険者名;
    private RString 給付実績_事業者名称;
    private RString 給付実績_入力識別名称;

}

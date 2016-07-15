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
 * @reamsid_L DBC-2470-030 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoShutsuryokuTaishoDateEntity {

    private RString 保険者番号;
    private RString 保険者名;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 氏名５０音カナ;
    private RString 市町村コード;
    private RString 被保険者番号;
    private RString 被保険者名_カナ;
    private RString 宛名カナ名称;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業者番号;
    private RString 入力識別番号;
    private RString 入力識別名称_上段;
    private RString 整理番号;
    private RString 作成区分;
    private RString 作成区分コード;
    private RString 給付実績区分;
    private RString レコード件数_H1;
    private RString レコード件数_D1;
    private RString レコード件数_DD;
    private RString レコード件数_D2;
    private RString レコード件数_D3;
    private RString レコード件数_D4;
    private RString レコード件数_D5;
    private RString レコード件数_D6;
    private RString レコード件数_D7;
    private RString レコード件数_D8;
    private RString レコード件数_DE;
    private RString レコード件数_T1;
    private RString レコード件数_D9;
    private RString レコード件数_DA;
    private RString レコード件数_DC;
    private RString 備考;
    private RString 警告区分コード;
    private RString 入力識別名称_下段;
    private RString 入力識別名称;
    private RString 被保険者名_漢字;
    private RString 宛名名称;
    private RString 事業者名;
    private RString 事業者名称;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikohijukyusha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護予防・日常生活支援総合事業費公費受給者別一覧表情報取込の一覧表用entity。
 *
 * @reamsid_L DBC-4710-030 chenjie
 */
@lombok.Getter
@lombok.Setter
public class SogojigyohiKohiJukyushaEntity {

    private FlexibleYearMonth 審査年月;
    private RString 国保連合会名;
    private RString 公費負担者番号;
    private RString 公費負担者名;
    private RString 公費受給者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業者番号;
    private RString 事業者名;
    private RString サービスコード;
    private RString サービス種類名;
    private RString サービス項目名;
    private Decimal 日数回数;
    private Decimal 公費対象単位数;
    private Decimal 公費負担金額;
    private Decimal 公費分本人負担額;
    private HihokenshaNo 登録被保険者番号;
    private RString 宛名名称;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private Decimal 公費対象単位数集計;
    private Decimal 公費負担金額集計;
    private Decimal 公費分本人負担額集計;
    private ShikibetsuCode 識別コード;
    private HihokenshaNo 被保険者番号;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 氏名５０音カナ;
    private LasdecCode 市町村コード;

}

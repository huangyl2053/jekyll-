/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshikakushogohyoin;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 総合事業費資格照合表CSV出力対象
 *
 * @reamsid_L DBC-2890-012 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShikakuShogohyoInEntity implements Serializable {

    private int 連番;
    private ServiceShuruiCode サービス種類コード;
    private RString サービス種類名;
    private FlexibleYearMonth サービス提供年月;
    private RString 種別;
    private JigyoshaNo 事業所番号;
    private RString 事業所名;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private Code 要介護区分コード;
    private RString 旧措置入所者特例コード;
    private FlexibleDate 認定有効期間_開始年月日;
    private FlexibleDate 認定有効期間_終了年月日;
    private FlexibleDate 限度額適用期間_開始年月日;
    private FlexibleDate 限度額適用期間_終了年月日;
    private Decimal 支給限度額;
    private Code 居宅サービス計画作成区分コード;
    private JigyoshaNo 支援事業所番号;
    private Decimal 食事標準負担額_月額;
    private Decimal 食事標準負担額_日額;
    private Decimal 食費負担限度額;
    private Decimal 居住費負担限度額1;
    private Decimal 居住費負担限度額2;
    private Decimal 居住費負担限度額3;
    private Decimal 居住費負担限度額4;
    private Decimal 居住費負担限度額5;
    private Decimal 単位数単価;
    private HokenKyufuRitsu 保険給付率;
    private HokenKyufuRitsu 公費１給付率;
    private HokenKyufuRitsu 公費２給付率;
    private HokenKyufuRitsu 公費３給付率;
    private int サービス日数_回数;
    private Decimal サービス単位数;
    private Decimal 特定入所者介護サービス費等;
    private Decimal 利用者負担額;
    private Decimal 食事標準負担額;
    private HihokenshaNo 資格照合_保険者番号;
    private RString 資格照合_保険者名;
    private FlexibleYearMonth 審査年月;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private HihokenshaNo 被保険者_被保険者番号;
    private FlexibleDate サービス提供年月末日;
    private RString 被保険者カナ氏名;
    private RString 被保険者氏名;
    private LasdecCode 旧市町村コード;
    private HihokenshaNo 変換被保険者番号;
    private HihokenshaNo 登録被保険者番号;
    private LasdecCode 市町村コード;
    private RString 管内管外区分;
    private RString 郵便番号;
    private RString 町域コード;
    private RString 行政区コード;
    private RString 行政区名;
    private RString 住所;
    private RString 番地;
    private RString 方書;
    private RString 宛名カナ名称;
    private RString 宛名名称;
    private RString 氏名50音カナ;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 資格取得日;
    private RString 資格取得事由コード;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由コード;
    private HihokenshaNo 世帯集約番号;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 送付ファイル作成で一時表から取得データです。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiSofuEntity {

    private int 連番;
    private KokanShikibetsuNo 交換情報識別番号;
    private HihokenshaNo 給付実績_被保険者番号;
    private RString 支給申請書整理番号;
    private RString 整理番号;
    private RString 自己負担額証明書整理番号;
    private RString 保険制度コード;
    private RString 給付実績作成区分コード;
    private ShoKisaiHokenshaNo 給付実績_証記載保険者番号;
    private RString 国保_被保険者証記号;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private Decimal 自己負担総額;
    private Decimal 支給額;
    private FlexibleYearMonth 処理年月;
    private FlexibleYearMonth 受取年月;
    private FlexibleYearMonth 送付年月;
    private RString データ区分;
    private boolean 送付除外フラグ;
    private HokenshaNo 被保険者_保険者番号;
    private RString 被保険者_保険者名;
    private ShoKisaiHokenshaNo 被保険者_証記載保険者番号;
    private HihokenshaNo 被保険者_被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private boolean 変換対象フラグ;
    private LasdecCode 旧市町村コード;
    private HihokenshaNo 送付被保険者番号;
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
    private RString 世帯集約番号;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private FlexibleDate 市町村加入年月日;
    private FlexibleDate 市町村脱退年月日;
}

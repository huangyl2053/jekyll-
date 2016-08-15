/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoshokai;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付管理票照会（画面）のEntityです。
 *
 * @reamsid_L DBC-2960-060 chenxiangyu
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuKanrihyoShokaiEntity {

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleYearMonth 審査年月;
    private FlexibleYearMonth サービス提供年月;
    private HihokenshaNo 被保険者番号;
    private RString 給付管理票種別区分コード;
    private RString 給付管理票明細行番号;
    private HokenshaNo 証記載保険者番号;
    private JigyoshaNo 居宅支援事業所番号;
    private RString 給付管理票情報作成区分コード;
    private FlexibleDate 給付管理票作成年月日;
    private HokenshaNo 保険者番号;
    private FlexibleDate 被保険者生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private FlexibleYearMonth 限度額適用開始年月;
    private FlexibleYearMonth 限度額適用終了年月;
    private int 居宅_介護予防支給限度額;
    private RString 居宅サービス計画作成区分コード;
    private JigyoshaNo サービス事業所番号;
    private RString 指定_基準該当_地域密着型サービス識別コード;
    private ServiceShuruiCode サービス種類コード;
    private int 給付計画単位数_日数;
    private int 限度額管理期間における前月までの給付計画日数;
    private int 指定サービス分小計;
    private int 基準該当サービス分小計;
    private int 給付計画合計単位数_日数;
    private RString 担当介護支援専門員番号;
    private JigyoshaNo 委託先の居宅介護支援事業所番号;
    private RString 委託先の担当介護支援専門員番号;
    private FlexibleDate 当初登録年月日;
    private FlexibleYearMonth 取込年月;
    private RString 氏名;
}

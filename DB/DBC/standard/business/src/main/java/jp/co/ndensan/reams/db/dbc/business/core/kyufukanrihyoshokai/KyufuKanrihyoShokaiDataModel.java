/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai;

import java.io.Serializable;
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
 * 給付管理票照会のDataModelです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
@Getter
@Setter
public final class KyufuKanrihyoShokaiDataModel implements Serializable {

    private static final long serialVersionUID = -1185858210492467270L;
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted;
    private int updateCount;
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
    private RString サービス事業者名;

    /**
     * コンストラクタです。
     */
    public KyufuKanrihyoShokaiDataModel() {
    }

    private KyufuKanrihyoShokaiDataModel(
            RString insertDantaiCd,
            RDateTime insertTimestamp,
            RString insertReamsLoginId,
            UUID insertContextId,
            boolean isDeleted,
            int updateCount,
            RDateTime lastUpdateTimestamp,
            RString lastUpdateReamsLoginId,
            FlexibleYearMonth 審査年月,
            FlexibleYearMonth サービス提供年月,
            HihokenshaNo 被保険者番号,
            RString 給付管理票種別区分コード,
            RString 給付管理票明細行番号,
            HokenshaNo 証記載保険者番号,
            JigyoshaNo 居宅支援事業所番号,
            RString 給付管理票情報作成区分コード,
            FlexibleDate 給付管理票作成年月日,
            HokenshaNo 保険者番号,
            FlexibleDate 被保険者生年月日,
            RString 性別コード,
            RString 要介護状態区分コード,
            FlexibleYearMonth 限度額適用開始年月,
            FlexibleYearMonth 限度額適用終了年月,
            int 居宅_介護予防支給限度額,
            RString 居宅サービス計画作成区分コード,
            JigyoshaNo サービス事業所番号,
            RString 指定_基準該当_地域密着型サービス識別コード,
            ServiceShuruiCode サービス種類コード,
            int 給付計画単位数_日数,
            int 限度額管理期間における前月までの給付計画日数,
            int 指定サービス分小計,
            int 基準該当サービス分小計,
            int 給付計画合計単位数_日数,
            RString 担当介護支援専門員番号,
            JigyoshaNo 委託先の居宅介護支援事業所番号,
            RString 委託先の担当介護支援専門員番号,
            FlexibleDate 当初登録年月日,
            FlexibleYearMonth 取込年月,
            RString 氏名,
            RString サービス事業者名) {
        this.insertDantaiCd = insertDantaiCd;
        this.insertTimestamp = insertTimestamp;
        this.insertReamsLoginId = insertReamsLoginId;
        this.insertContextId = insertContextId;
        this.isDeleted = isDeleted;
        this.updateCount = updateCount;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
        this.審査年月 = 審査年月;
        this.サービス提供年月 = サービス提供年月;
        this.被保険者番号 = 被保険者番号;
        this.給付管理票種別区分コード = 給付管理票種別区分コード;
        this.給付管理票明細行番号 = 給付管理票明細行番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.居宅支援事業所番号 = 居宅支援事業所番号;
        this.給付管理票情報作成区分コード = 給付管理票情報作成区分コード;
        this.給付管理票作成年月日 = 給付管理票作成年月日;
        this.保険者番号 = 保険者番号;
        this.被保険者生年月日 = 被保険者生年月日;
        this.性別コード = 性別コード;
        this.要介護状態区分コード = 要介護状態区分コード;
        this.限度額適用開始年月 = 限度額適用開始年月;
        this.限度額適用終了年月 = 限度額適用終了年月;
        this.居宅_介護予防支給限度額 = 居宅_介護予防支給限度額;
        this.居宅サービス計画作成区分コード = 居宅サービス計画作成区分コード;
        this.サービス事業所番号 = サービス事業所番号;
        this.指定_基準該当_地域密着型サービス識別コード = 指定_基準該当_地域密着型サービス識別コード;
        this.サービス種類コード = サービス種類コード;
        this.給付計画単位数_日数 = 給付計画単位数_日数;
        this.限度額管理期間における前月までの給付計画日数 = 限度額管理期間における前月までの給付計画日数;
        this.指定サービス分小計 = 指定サービス分小計;
        this.基準該当サービス分小計 = 基準該当サービス分小計;
        this.給付計画合計単位数_日数 = 給付計画合計単位数_日数;
        this.担当介護支援専門員番号 = 担当介護支援専門員番号;
        this.委託先の居宅介護支援事業所番号 = 委託先の居宅介護支援事業所番号;
        this.委託先の担当介護支援専門員番号 = 委託先の担当介護支援専門員番号;
        this.当初登録年月日 = 当初登録年月日;
        this.取込年月 = 取込年月;
        this.氏名 = 氏名;
        this.サービス事業者名 = サービス事業者名;
    }

    /**
     * 給付管理票照会のDataModelを生成します。
     *
     * @param business 給付管理票照会のBusiness
     * @return KyufuKanrihyoShokaiDataModel
     */
    public static KyufuKanrihyoShokaiDataModel createDataModel(KyufuKanrihyoShokaiBusiness business) {
        return new KyufuKanrihyoShokaiDataModel(
                business.getInsertDantaiCd(),
                business.getInsertTimestamp(),
                business.getInsertReamsLoginId(),
                business.getInsertContextId(),
                business.isDeleted(),
                business.getUpdateCount(),
                business.getLastUpdateTimestamp(),
                business.getLastUpdateReamsLoginId(),
                business.get審査年月(),
                business.getサービス提供年月(),
                business.get被保険者番号(),
                business.get給付管理票種別区分コード(),
                business.get給付管理票明細行番号(),
                business.get証記載保険者番号(),
                business.get居宅支援事業所番号(),
                business.get給付管理票情報作成区分コード(),
                business.get給付管理票作成年月日(),
                business.get保険者番号(),
                business.get被保険者生年月日(),
                business.get性別コード(),
                business.get要介護状態区分コード(),
                business.get限度額適用開始年月(),
                business.get限度額適用終了年月(),
                business.get居宅_介護予防支給限度額(),
                business.get居宅サービス計画作成区分コード(),
                business.getサービス事業所番号(),
                business.get指定_基準該当_地域密着型サービス識別コード(),
                business.getサービス種類コード(),
                business.get給付計画単位数_日数(),
                business.get限度額管理期間における前月までの給付計画日数(),
                business.get指定サービス分小計(),
                business.get基準該当サービス分小計(),
                business.get給付計画合計単位数_日数(),
                business.get担当介護支援専門員番号(),
                business.get委託先の居宅介護支援事業所番号(),
                business.get委託先の担当介護支援専門員番号(),
                business.get当初登録年月日(),
                business.get取込年月(),
                business.get氏名(),
                business.getサービス事業者名());
    }
}

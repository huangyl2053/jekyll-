/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyoshokai;

import java.io.Serializable;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoshokai.KyufuKanrihyoShokaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票照会のbusinessです。
 *
 * @reamsid_L DBC-2960-010 chenxiangyu
 */
public class KyufuKanrihyoShokaiBusiness implements Serializable {

    private static final long serialVersionUID = -9210665008367509044L;

    private final KyufuKanrihyoShokaiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 給付管理票照会（画面）のEntityです。
     */
    public KyufuKanrihyoShokaiBusiness(KyufuKanrihyoShokaiEntity entity) {
        this.entity = entity;
    }

    /**
     * insertDantaiCdを取得します。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return entity.getInsertDantaiCd();
    }

    /**
     * insertTimestampを取得します。
     *
     * @return insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return entity.getInsertTimestamp();
    }

    /**
     * insertReamsLoginIdを取得します。
     *
     * @return insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return entity.getInsertReamsLoginId();
    }

    /**
     * insertContextIdを取得します。
     *
     * @return insertContextId
     */
    public UUID getInsertContextId() {
        return entity.getInsertContextId();
    }

    /**
     * isDeletedを取得します。
     *
     * @return isDeleted
     */
    public boolean isDeleted() {
        return entity.isDeleted();
    }

    /**
     * updateCountを取得します。
     *
     * @return updateCount
     */
    public int getUpdateCount() {
        return entity.getUpdateCount();
    }

    /**
     * lastUpdateTimestampを取得します。
     *
     * @return lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return entity.getLastUpdateTimestamp();
    }

    /**
     * lastUpdateReamsLoginIdを取得します。
     *
     * @return lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return entity.getLastUpdateReamsLoginId();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.get審査年月();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 居宅支援事業所番号を返します。
     *
     * @return 居宅支援事業所番号
     */
    public JigyoshaNo get居宅支援事業所番号() {
        return entity.get居宅支援事業所番号();
    }

    /**
     * 給付管理票情報作成区分コードを返します。
     *
     * @return 給付管理票情報作成区分コード
     */
    public RString get給付管理票情報作成区分コード() {
        return entity.get給付管理票情報作成区分コード();
    }

    /**
     * 給付管理票作成年月日を返します。
     *
     * @return 給付管理票作成年月日
     */
    public FlexibleDate get給付管理票作成年月日() {
        return entity.get給付管理票作成年月日();
    }

    /**
     * 給付管理票種別区分コードを返します。
     *
     * @return 給付管理票種別区分コード
     */
    public RString get給付管理票種別区分コード() {
        return entity.get給付管理票種別区分コード();
    }

    /**
     * 給付管理票明細行番号を返します。
     *
     * @return 給付管理票明細行番号
     */
    public RString get給付管理票明細行番号() {
        return entity.get給付管理票明細行番号();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.get保険者番号();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 被保険者生年月日を返します。
     *
     * @return 被保険者生年月日
     */
    public FlexibleDate get被保険者生年月日() {
        return entity.get被保険者生年月日();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.get性別コード();
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return entity.get要介護状態区分コード();
    }

    /**
     * 限度額適用開始年月を返します。
     *
     * @return 限度額適用開始年月
     */
    public FlexibleYearMonth get限度額適用開始年月() {
        return entity.get限度額適用開始年月();
    }

    /**
     * 限度額適用終了年月を返します。
     *
     * @return 限度額適用終了年月
     */
    public FlexibleYearMonth get限度額適用終了年月() {
        return entity.get限度額適用終了年月();
    }

    /**
     * 居宅・介護予防支給限度額を返します。
     *
     * @return 居宅・介護予防支給限度額
     */
    public int get居宅_介護予防支給限度額() {
        return entity.get居宅_介護予防支給限度額();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.get居宅サービス計画作成区分コード();
    }

    /**
     * サービス事業所番号を返します。
     *
     * @return サービス事業所番号
     */
    public JigyoshaNo getサービス事業所番号() {
        return entity.getサービス事業所番号();
    }

    /**
     * 指定/基準該当/地域密着型サービス識別コードを返します。
     *
     * @return 指定/基準該当/地域密着型サービス識別コード
     */
    public RString get指定_基準該当_地域密着型サービス識別コード() {
        return entity.get指定_基準該当_地域密着型サービス識別コード();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getサービス種類コード();
    }

    /**
     * 給付計画単位数／日数を返します。
     *
     * @return 給付計画単位数／日数
     */
    public int get給付計画単位数_日数() {
        return entity.get給付計画単位数_日数();
    }

    /**
     * 限度額管理期間における前月までの給付計画日数を返します。
     *
     * @return 限度額管理期間における前月までの給付計画日数
     */
    public int get限度額管理期間における前月までの給付計画日数() {
        return entity.get限度額管理期間における前月までの給付計画日数();
    }

    /**
     * 指定サービス分小計を返します。
     *
     * @return 指定サービス分小計
     */
    public int get指定サービス分小計() {
        return entity.get指定サービス分小計();
    }

    /**
     * 基準該当サービス分小計を返します。
     *
     * @return 基準該当サービス分小計
     */
    public int get基準該当サービス分小計() {
        return entity.get基準該当サービス分小計();
    }

    /**
     * 給付計画合計単位数/日数を返します。
     *
     * @return 給付計画合計単位数/日数
     */
    public int get給付計画合計単位数_日数() {
        return entity.get給付計画合計単位数_日数();
    }

    /**
     * 担当介護支援専門員番号を返します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号() {
        return entity.get担当介護支援専門員番号();
    }

    /**
     * 委託先の居宅介護支援事業所番号を返します。
     *
     * @return 委託先の居宅介護支援事業所番号
     */
    public JigyoshaNo get委託先の居宅介護支援事業所番号() {
        return entity.get委託先の居宅介護支援事業所番号();
    }

    /**
     * 委託先の担当介護支援専門員番号を返します。
     *
     * @return 委託先の担当介護支援専門員番号
     */
    public RString get委託先の担当介護支援専門員番号() {
        return entity.get委託先の担当介護支援専門員番号();
    }

    /**
     * 当初登録年月日を返します。
     *
     * @return 当初登録年月日
     */
    public FlexibleDate get当初登録年月日() {
        return entity.get当初登録年月日();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.get取込年月();
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return entity.get氏名();
    }
}

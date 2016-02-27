/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 被保険者証資格証発行情報取得パラメータクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshoShikakushoHakkoMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString メニューID;
    private final RString 有効無効区分;
    private final Boolean 論理削除フラグ;
    private final RString 指定サービス種類;
    private final FlexibleDate 提供開始年月;
    private final FlexibleDate 提供終了年月;
    private final RString 要介護状態区分;
    private final FlexibleDate 認定有効期間開始年月日;
    private final FlexibleDate 認定有効期間終了年月日;

    private HihokenshoShikakushoHakkoMapperParameter(
            HihokenshaNo 被保険者番号,
            RString メニューID,
            RString 有効無効区分,
            Boolean 論理削除フラグ,
            RString 指定サービス種類,
            FlexibleDate 提供開始年月,
            FlexibleDate 提供終了年月,
            RString 要介護状態区分,
            FlexibleDate 認定有効期間開始年月日,
            FlexibleDate 認定有効期間終了年月日) {
        this.被保険者番号 = 被保険者番号;
        this.メニューID = メニューID;
        this.有効無効区分 = 有効無効区分;
        this.論理削除フラグ = 論理削除フラグ;
        this.指定サービス種類 = 指定サービス種類;
        this.提供開始年月 = 提供開始年月;
        this.提供終了年月 = 提供終了年月;
        this.要介護状態区分 = 要介護状態区分;
        this.認定有効期間開始年月日 = 認定有効期間開始年月日;
        this.認定有効期間終了年月日 = 認定有効期間終了年月日;
    }

    /**
     * 被保険者証資格証発行情報のパラメータです。
     *
     * @param 被保険者番号 被保険者番号
     * @param メニューID メニューID
     * @param 有効無効区分 有効無効区分
     * @param 論理削除フラグ 論理削除フラグ
     * @param 指定サービス種類 指定サービス種類
     * @param 提供開始年月 提供開始年月
     * @param 提供終了年月 提供終了年月
     * @param 要介護状態区分 要介護状態区分
     * @param 認定有効期間開始年月日 認定有効期間開始年月日
     * @param 認定有効期間終了年月日 認定有効期間終了年月日
     * @return HihokenshoShikakushoHakkoMapperParameter
     *
     */
    public static HihokenshoShikakushoHakkoMapperParameter createParam(
            HihokenshaNo 被保険者番号,
            RString メニューID,
            RString 有効無効区分,
            Boolean 論理削除フラグ,
            RString 指定サービス種類,
            FlexibleDate 提供開始年月,
            FlexibleDate 提供終了年月,
            RString 要介護状態区分,
            FlexibleDate 認定有効期間開始年月日,
            FlexibleDate 認定有効期間終了年月日
    ) {
        return new HihokenshoShikakushoHakkoMapperParameter(
                被保険者番号,
                メニューID,
                有効無効区分,
                論理削除フラグ,
                指定サービス種類,
                提供開始年月,
                提供終了年月,
                要介護状態区分,
                認定有効期間開始年月日,
                認定有効期間終了年月日);
    }
}

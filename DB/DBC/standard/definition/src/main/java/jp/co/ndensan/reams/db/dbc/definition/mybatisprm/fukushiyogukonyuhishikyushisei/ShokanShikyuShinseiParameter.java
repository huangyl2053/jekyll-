/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給申請一覧検索用パラメータ
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanShikyuShinseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 福祉用具販売費;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param 福祉用具販売費 被保険者番号
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private ShokanShikyuShinseiParameter(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull RString 福祉用具販売費) {
        this.被保険者番号 = 被保険者番号;
        this.福祉用具販売費 = 福祉用具販売費;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 福祉用具販売費 福祉用具販売費
     * @return 支給申請一覧検索用パラメータ
     */
    public static ShokanShikyuShinseiParameter createParameter(
            HihokenshaNo 被保険者番号,
            RString 福祉用具販売費) {
        return new ShokanShikyuShinseiParameter(被保険者番号, 福祉用具販売費);
    }
}

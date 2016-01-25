/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 請求額集計登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShukeiEntity {

    private final RString 連番;
    private final ServiceShuruiCode サービス種類;
    private final int サービス実日数;
    private final int 計画単位数;
    private final int 限度額管理対象単位数;
    private final int 限度額管理対象外単位数;
    private final int 短期入所計画日数;
    private final int 短期入所実日数;
    private final int 単位数合計;
    private final Decimal 単位数単価;
    private final Decimal 請求額;
    private final int 利用者負担;
    private final int 出来高医療費単位数合計;
    private final Decimal 出来高医療費請求額;
    private final Decimal 出来高医療費利用者負担額;
    private final RString 審査方法区分コード;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービス種類
     * @param サービス実日数
     * @param 計画単位数
     * @param 限度額管理対象単位数
     * @param 限度額管理対象外単位数
     * @param 短期入所計画日数
     * @param 短期入所実日数
     * @param 単位数合計
     * @param 単位数単価
     * @param 請求額
     * @param 利用者負担
     * @param 出来高医療費単位数合計
     * @param 出来高医療費請求額
     * @param 出来高医療費利用者負担額
     * @param 審査方法区分コード
     * @param 状態
     */
    protected ShokanShukeiEntity(RString 連番, ServiceShuruiCode サービス種類,
            int サービス実日数, int 計画単位数, int 限度額管理対象単位数, int 限度額管理対象外単位数,
            int 短期入所計画日数, int 短期入所実日数, int 単位数合計, Decimal 単位数単価, Decimal 請求額,
            int 利用者負担, int 出来高医療費単位数合計, Decimal 出来高医療費請求額,
            Decimal 出来高医療費利用者負担額, RString 審査方法区分コード, RString 状態) {

        this.連番 = 連番;
        this.サービス種類 = サービス種類;
        this.サービス実日数 = サービス実日数;
        this.計画単位数 = 計画単位数;
        this.限度額管理対象単位数 = 限度額管理対象単位数;
        this.限度額管理対象外単位数 = 限度額管理対象外単位数;
        this.短期入所計画日数 = 短期入所計画日数;
        this.短期入所実日数 = 短期入所実日数;
        this.単位数合計 = 単位数合計;
        this.単位数単価 = 単位数単価;
        this.請求額 = 請求額;
        this.利用者負担 = 利用者負担;
        this.出来高医療費単位数合計 = 出来高医療費単位数合計;
        this.出来高医療費請求額 = 出来高医療費請求額;
        this.出来高医療費利用者負担額 = 出来高医療費利用者負担額;
        this.審査方法区分コード = 審査方法区分コード;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービス種類
     * @param サービス実日数
     * @param 計画単位数
     * @param 限度額管理対象単位数
     * @param 限度額管理対象外単位数
     * @param 短期入所計画日数
     * @param 短期入所実日数
     * @param 単位数合計
     * @param 単位数単価
     * @param 請求額
     * @param 利用者負担
     * @param 出来高医療費単位数合計
     * @param 出来高医療費請求額
     * @param 出来高医療費利用者負担額
     * @param 審査方法区分コード
     * @param 状態
     * @return
     */
    public static ShokanShukeiEntity createSelectByKeyParam(RString 連番, ServiceShuruiCode サービス種類,
            int サービス実日数, int 計画単位数, int 限度額管理対象単位数, int 限度額管理対象外単位数,
            int 短期入所計画日数, int 短期入所実日数, int 単位数合計, Decimal 単位数単価, Decimal 請求額,
            int 利用者負担, int 出来高医療費単位数合計, Decimal 出来高医療費請求額, Decimal 出来高医療費利用者負担額,
            RString 審査方法区分コード, RString 状態) {
        return new ShokanShukeiEntity(連番, サービス種類, サービス実日数, 計画単位数, 限度額管理対象単位数,
                限度額管理対象外単位数, 短期入所計画日数, 短期入所実日数, 単位数合計, 単位数単価, 請求額, 利用者負担,
                出来高医療費単位数合計, 出来高医療費請求額, 出来高医療費利用者負担額, 審査方法区分コード, 状態);
    }
}

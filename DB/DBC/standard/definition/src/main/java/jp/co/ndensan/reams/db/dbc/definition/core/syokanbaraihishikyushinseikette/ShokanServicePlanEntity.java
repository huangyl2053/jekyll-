/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * サービス計画費登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanServicePlanEntity {

    private final RString 連番;
    private final RString 事業者区分コード;
    private final FlexibleDate 届出日;
    private final ServiceCode サービスコード;
    private final int 単位数;
    private final int 回数;
    private final int サービス単位数;
    private final Decimal 単位数単価;
    private final int サービス単位数合計;
    private final RString 担当介護支援専門員番号;
    private final RString 摘要;
    private final RString 審査方法コード;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 事業者区分コード
     * @param 届出日
     * @param サービスコード
     * @param 単位数
     * @param 回数
     * @param サービス単位数
     * @param 単位数単価
     * @param サービス単位数合計
     * @param 担当介護支援専門員番号
     * @param 摘要
     * @param 審査方法コード
     * @param 状態
     */
    protected ShokanServicePlanEntity(RString 連番, RString 事業者区分コード,
            FlexibleDate 届出日, ServiceCode サービスコード, int 単位数, int 回数, int サービス単位数,
            Decimal 単位数単価, int サービス単位数合計, RString 担当介護支援専門員番号, RString 摘要,
            RString 審査方法コード, RString 状態) {
        this.連番 = 連番;
        this.事業者区分コード = 事業者区分コード;
        this.届出日 = 届出日;
        this.サービスコード = サービスコード;
        this.単位数 = 単位数;
        this.回数 = 回数;
        this.サービス単位数 = サービス単位数;
        this.単位数単価 = 単位数単価;
        this.サービス単位数合計 = サービス単位数合計;
        this.担当介護支援専門員番号 = 担当介護支援専門員番号;
        this.摘要 = 摘要;
        this.審査方法コード = 審査方法コード;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param 事業者区分コード
     * @param 届出日
     * @param サービスコード
     * @param 単位数
     * @param 回数
     * @param サービス単位数
     * @param 単位数単価
     * @param サービス単位数合計
     * @param 担当介護支援専門員番号
     * @param 摘要
     * @param 審査方法コード
     * @param 状態
     * @return
     */
    public static ShokanServicePlanEntity createSelectByKeyParam(RString 連番, RString 事業者区分コード,
            FlexibleDate 届出日, ServiceCode サービスコード, int 単位数, int 回数, int サービス単位数,
            Decimal 単位数単価, int サービス単位数合計, RString 担当介護支援専門員番号, RString 摘要,
            RString 審査方法コード, RString 状態) {
        return new ShokanServicePlanEntity(連番, 事業者区分コード, 届出日, サービスコード, 単位数, 回数,
                サービス単位数, 単位数単価, サービス単位数合計, 担当介護支援専門員番号, 摘要, 審査方法コード, 状態);
    }
}

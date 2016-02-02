/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特定入所者費用登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanTokuteiNyushoshaKaigoServiceHiyoEntity {

    private final RString 連番;
    private final ServiceShuruiCode サービス種類コード;
    private final ServiceKomokuCode サービス項目コード;
    private final Decimal 標準単価;
    private final Decimal 負担限度額;
    private final Decimal 日数;
    private final int 費用額;
    private final int 保険分;
    private final int 利用者負担額;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービス種類コード
     * @param サービス項目コード
     * @param 標準単価
     * @param 負担限度額
     * @param 日数
     * @param 費用額
     * @param 保険分
     * @param 利用者負担額
     * @param 状態
     */
    protected ShokanTokuteiNyushoshaKaigoServiceHiyoEntity(RString 連番,
            ServiceShuruiCode サービス種類コード, ServiceKomokuCode サービス項目コード,
            Decimal 標準単価, Decimal 負担限度額, Decimal 日数, int 費用額, int 保険分, int 利用者負担額,
            RString 状態) {
        this.連番 = 連番;
        this.サービス種類コード = サービス種類コード;
        this.サービス項目コード = サービス項目コード;
        this.標準単価 = 標準単価;
        this.負担限度額 = 負担限度額;
        this.日数 = 日数;
        this.費用額 = 費用額;
        this.保険分 = 保険分;
        this.利用者負担額 = 利用者負担額;
        this.状態 = 状態;
    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービス種類コード
     * @param 標準単価
     * @param サービス項目コード
     * @param 負担限度額
     * @param 日数
     * @param 費用額
     * @param 保険分
     * @param 利用者負担額
     * @param 状態
     * @return
     */
    public static ShokanTokuteiNyushoshaKaigoServiceHiyoEntity createSelectByKeyParam(RString 連番,
            ServiceShuruiCode サービス種類コード, ServiceKomokuCode サービス項目コード,
            Decimal 標準単価, Decimal 負担限度額, Decimal 日数, int 費用額, int 保険分, int 利用者負担額,
            RString 状態) {
        return new ShokanTokuteiNyushoshaKaigoServiceHiyoEntity(連番, サービス種類コード, サービス項目コード,
                標準単価, 負担限度額, 日数, 費用額, 保険分, 利用者負担額, 状態);
    }
}

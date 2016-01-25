/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 食事費用登録更新処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShokujiHiyoEntity {

    private final RString 連番;
    private final RString サービスコード;
    private final Decimal 単位;
    private final Decimal 回数日数;
    private final int 金額;
    private final RString 状態;

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービスコード
     * @param 単位
     * @param 回数日数
     * @param 金額
     * @param 状態
     */
    protected ShokanShokujiHiyoEntity(RString 連番, RString サービスコード, Decimal 単位,
            Decimal 回数日数, int 金額, RString 状態) {
        this.連番 = 連番;
        this.サービスコード = サービスコード;
        this.単位 = 単位;
        this.回数日数 = 回数日数;
        this.金額 = 金額;
        this.状態 = 状態;

    }

    /**
     * コンストラクタです。
     *
     * @param 連番
     * @param サービスコード
     * @param 単位
     * @param 回数日数
     * @param 金額
     * @param 状態
     * @return
     */
    public static ShokanShokujiHiyoEntity createSelectByKeyParam(RString 連番, RString サービスコード, Decimal 単位,
            Decimal 回数日数, int 金額, RString 状態) {
        return new ShokanShokujiHiyoEntity(連番, サービスコード, 単位, 回数日数, 金額, 状態);
    }
}

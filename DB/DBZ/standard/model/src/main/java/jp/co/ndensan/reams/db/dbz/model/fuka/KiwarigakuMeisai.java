/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期割額の明細情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KiwarigakuMeisai implements Serializable {

    private final KibetsuChoteiKyotsuModel 期別調定共通;
    private final Decimal 収入額;

    /**
     * コンストラクタです。
     *
     * @param 期別調定共通 期別調定共通
     * @param 収入額 収入額
     */
    public KiwarigakuMeisai(KibetsuChoteiKyotsuModel 期別調定共通, Decimal 収入額) {
        this.期別調定共通 = 期別調定共通;
        this.収入額 = 収入額;
    }

    /**
     * 期別調定共通を返します。
     *
     * @return 期別調定共通
     */
    public KibetsuChoteiKyotsuModel get期別調定共通() {
        return 期別調定共通;
    }

    /**
     * 収入額を返します。
     *
     * @return 収入額
     */
    public Decimal get収入額() {
        return 収入額;
    }
}

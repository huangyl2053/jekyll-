/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.model.relate.KibetsuChoteiKyotsuModel;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

// TODO N8156 宮本 康 別ブランチで対応中。マージ時に差し替える。
public class KiwarigakuMeisai implements Serializable {

    private final KibetsuChoteiKyotsuModel 期別調定共通;
    private final Decimal 収入額;

    public KiwarigakuMeisai(KibetsuChoteiKyotsuModel 期別調定共通, Decimal 収入額) {
        this.期別調定共通 = 期別調定共通;
        this.収入額 = 収入額;
    }

    public KibetsuChoteiKyotsuModel get期別調定共通() {
        return 期別調定共通;
    }

    public Decimal get収入額() {
        return 収入額;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 介護保険受領委任払い取扱事業者登録申請書のEntityです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem {
    private final RString ninshoshaYakushokuMei;

    /**
     * コンストラクタです。
     * @param ninshoshaYakushokuMei 認証者
     */
    public JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishItem(RString ninshoshaYakushokuMei) {
        this.ninshoshaYakushokuMei = ninshoshaYakushokuMei;
    }
}

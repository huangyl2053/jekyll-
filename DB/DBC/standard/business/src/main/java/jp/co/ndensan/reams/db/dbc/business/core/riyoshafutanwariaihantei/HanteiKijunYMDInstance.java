/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.riyoshafutanwariaihantei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合判定（共通）の判定基準日です。
 *
 * @reamsid_L DBC-4950-032 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HanteiKijunYMDInstance {

    private static final HanteiKijunYMDInstance 実例 = new HanteiKijunYMDInstance();
    private RString 判定基準日;

    private HanteiKijunYMDInstance() {
        判定基準日 = RString.EMPTY;
    }

    /**
     * 判定基準日を獲得します。
     *
     * @return HanteiKijunYMDInstance
     */
    public static HanteiKijunYMDInstance getInstance() {
        return 実例;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * 介護認定審査会スケジュール表_帳票パラメータクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaisukejuruhyoItem {

    private final ShinsakaisukejuruhyoHeadItem headItem;
    private final ShinsakaisukejuruhyoBodyItem bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 介護認定審査会スケジュール表ヘッダのITEM
     * @param bodyItem 介護認定審査会スケジュール表ボディのITEM
     */
    public ShinsakaisukejuruhyoItem(
            ShinsakaisukejuruhyoHeadItem headItem,
            ShinsakaisukejuruhyoBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}

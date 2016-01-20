/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査スケジュール表(事務所)ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoBodyItem {

    private final RString 日付;
    private final RString 曜日;
    private final RString 空き_AM;
    private final RString 空き_件数1;
    private final RString 空き_PM;
    private final RString 空き_件数2;
    private final RString 仮予約_AM;
    private final RString 仮予約_件数1;
    private final RString 仮予約_PM;
    private final RString 仮予約_件数2;
    private final RString 確定_AM;
    private final RString 確定_件数1;
    private final RString 確定_PM;
    private final RString 確定_件数2;

    /**
     * インスタンスを生成します。
     *
     * @param 日付 日付
     * @param 曜日 曜日
     * @param 空き_AM 空き_AM
     * @param 空き_件数1 件数
     * @param 空き_PM 空き_PM
     * @param 空き_件数2 件数
     * @param 仮予約_AM 仮予約_AM
     * @param 仮予約_件数1 件数
     * @param 仮予約_PM 仮予約_PM
     * @param 仮予約_件数2 件数
     * @param 確定_AM 確定_AM
     * @param 確定_件数1 件数
     * @param 確定_PM 確定_PM
     * @param 確定_件数2 件数
     */
    public ChosaSchedulehyoBodyItem(
            RString 日付,
            RString 曜日,
            RString 空き_AM,
            RString 空き_件数1,
            RString 空き_PM,
            RString 空き_件数2,
            RString 仮予約_AM,
            RString 仮予約_件数1,
            RString 仮予約_PM,
            RString 仮予約_件数2,
            RString 確定_AM,
            RString 確定_件数1,
            RString 確定_PM,
            RString 確定_件数2) {

        this.日付 = 日付;
        this.曜日 = 曜日;
        this.空き_AM = 空き_AM;
        this.空き_件数1 = 空き_件数1;
        this.空き_PM = 空き_PM;
        this.空き_件数2 = 空き_件数2;
        this.仮予約_AM = 仮予約_AM;
        this.仮予約_件数1 = 仮予約_件数1;
        this.仮予約_PM = 仮予約_PM;
        this.仮予約_件数2 = 仮予約_件数2;
        this.確定_AM = 確定_AM;
        this.確定_件数1 = 確定_件数1;
        this.確定_PM = 確定_PM;
        this.確定_件数2 = 確定_件数2;
    }
}

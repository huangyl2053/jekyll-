/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定調査スケジュール登録・認定調査スケジュール表(調査員)ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaSchedulehyoBodyItem {

    private final RString List1_1;
    private final RString List1_2;
    private final RString List1_3;
    private final RString List1_4;
    private final RString List1_5;
    private final RString List1_6;
    private final RString List1_7;
    private final RString List1_8;
    private final RString List1_9;
    private final RString List1_10;
    private final RString List1_11;
    private final RString List1_12;
    private final RString List1_13;
    private final RString List1_14;

    /**
     * インスタンスを生成します。
     *
     * @param List1_1 日付
     * @param List1_2 曜日
     * @param List1_3 空き_AM
     * @param List1_4 件数
     * @param List1_5 空き_PM
     * @param List1_6 件数
     * @param List1_7 仮予約_AM
     * @param List1_8 件数
     * @param List1_9 仮予約_PM
     * @param List1_10 件数
     * @param List1_11 確定_AM
     * @param List1_12 件数
     * @param List1_13 確定_PM
     * @param List1_14 件数
     */
    public ChosaSchedulehyoBodyItem(
            RString List1_1,
            RString List1_2,
            RString List1_3,
            RString List1_4,
            RString List1_5,
            RString List1_6,
            RString List1_7,
            RString List1_8,
            RString List1_9,
            RString List1_10,
            RString List1_11,
            RString List1_12,
            RString List1_13,
            RString List1_14) {

        this.List1_1 = List1_1;
        this.List1_2 = List1_2;
        this.List1_3 = List1_3;
        this.List1_4 = List1_4;
        this.List1_5 = List1_5;
        this.List1_6 = List1_6;
        this.List1_7 = List1_7;
        this.List1_8 = List1_8;
        this.List1_9 = List1_9;
        this.List1_10 = List1_10;
        this.List1_11 = List1_11;
        this.List1_12 = List1_12;
        this.List1_13 = List1_13;
        this.List1_14 = List1_14;
    }
}

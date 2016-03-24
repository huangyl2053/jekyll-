/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 共有子Div「印刷設定」のhandlerクラスです
 */
public class PrintContentsSettingHandler {

    private final PrintContentsSettingDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 印刷設定Div
     */
    public PrintContentsSettingHandler(PrintContentsSettingDiv div) {
        this.div = div;
    }

    /**
     * 印刷設定Divの初期化です。
     *
     * @param 発行日表示有無 boolean
     * @param 発行日初期表示日付 RDate
     * @param 発行日システム日付有無 boolean
     * @param 送付日表示有無 boolean
     * @param 送付日初期表示日付 RDate
     * @param 送付日システム日付有無 boolean
     */
    public void initialize(boolean 発行日表示有無, RDate 発行日初期表示日付,
            boolean 発行日システム日付有無, boolean 送付日表示有無,
            RDate 送付日初期表示日付, boolean 送付日システム日付有無) {
        div.getTxtIssueDate().setVisible(発行日表示有無);
        div.getTxtSendDate().setVisible(送付日表示有無);
        if (発行日初期表示日付 != null) {
            div.getTxtIssueDate().setValue(発行日初期表示日付);
        } else {
            if (発行日システム日付有無) {
                div.getTxtIssueDate().setValue(RDate.getNowDate());
            }
        }
        if (送付日初期表示日付 != null) {
            div.getTxtSendDate().setValue(送付日初期表示日付);
        } else {
            if (送付日システム日付有無) {
                div.getTxtSendDate().setValue(RDate.getNowDate());
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteitbun;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitbun.KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource;

/**
 *
 * 過誤決定通知書情報取込一覧表（保険者分） 帳票HeaderEditor
 */
public class HeaderEditor implements IKagoKetteitsuchishoTorikomiIchiranHokenshaBunEditor {

    private final KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem item;

    /**
     * コンストラクタです
     *
     * @param item KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem
     */
    public HeaderEditor(KagoKetteitsuchishoTorikomiIchiranHokenshaBunItem item) {
        this.item = item;
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource edit(KagoKetteitsuchishoTorikomiIchiranHokenshaBunSource t) {
        t.printTimeStamp = item.getPrintTimeStamp();
        return t;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteitsuchishotorikomiichirankohifutanshabun.KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票HeaderEditor
 */
public class HeaderEditor implements IKagoKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor {

    private final KagoKetteiKohifutanshaInItem item;

    /**
     * コンストラクタです
     *
     * @param item KagoKetteiKohifutanshaInItem
     */
    public HeaderEditor(KagoKetteiKohifutanshaInItem item) {
        this.item = item;
    }

    @Override
    public KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource edit(KagoKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {
        source.printTimeStamp = item.get印刷日時();
        source.torikomiYM = item.get処理年月();
        return source;
    }
}

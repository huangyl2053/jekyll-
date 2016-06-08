/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsa;

import jp.co.ndensan.reams.db.dbc.business.core.SaishinsaKohifutanshaBunSourceData;
import jp.co.ndensan.reams.db.dbc.entity.report.saishinsa.SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource;

/**
 * 再審査決定通知書情報取込一覧表（公費負担者分）帳票HeaderEditor
 *
 * @reamsid_L DBC-2820-050 sunhui
 */
public class HeaderEditor implements ISaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunEditor {

    private final SaishinsaKohifutanshaBunSourceData item;

    /**
     * コンストラクタです
     *
     * @param item SaishinsaKohifutanshaBunSourceData
     */
    public HeaderEditor(SaishinsaKohifutanshaBunSourceData item) {
        this.item = item;
    }

    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource edit(
            SaishinsaKetteitsuchishoTorikomiIchiranKohifutanshaBunSource source) {

        source.printTimeStamp = item.get印刷日時();
        source.torikomiYM = item.get処理年月();
        source.kokuhorenName = item.get国保連合会名();
        source.shinsakaiName = item.get審査委員会名();
        return source;
    }

}

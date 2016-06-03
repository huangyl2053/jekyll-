/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kagoketteikohifutanshain.KagoKetteiKohifutanshaInSource;

/**
 *
 * 誤決定通知書情報取込一覧表（公費負担者分）帳票HeaderEditor
 *
 * @reamsid_L DBC-0980-510 surun
 */
public class KagoKetteiKohifutanshaInHeaderEditor implements IKagoKetteiKohifutanshaInEditor {

    private final KagoKetteiKohifutanshaInItem item;

    /**
     * コンストラクタです
     *
     * @param item KagoKetteiKohifutanshaInItem
     */
    public KagoKetteiKohifutanshaInHeaderEditor(KagoKetteiKohifutanshaInItem item) {
        this.item = item;
    }

    @Override
    public KagoKetteiKohifutanshaInSource edit(KagoKetteiKohifutanshaInSource source) {
        source.printTimeStamp = item.get印刷日時();
        source.torikomiYM = item.get処理年月();
        return source;
    }
}

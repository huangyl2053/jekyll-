/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.Wareki;

/**
 * 要介護認定調査票（基本調査）のEditorです。
 */
public class ChosahyoKihonchosaKatamenEditor implements IChosahyoKihonchosaKatamenEditor {

    private final ChosahyoKihonchosaKatamenItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoKihonchosaKatamenItem}
     */
    protected ChosahyoKihonchosaKatamenEditor(ChosahyoKihonchosaKatamenItem item) {
        this.item = item;
    }

    @Override
    public ChosahyoKihonchosaKatamenReportSource edit(ChosahyoKihonchosaKatamenReportSource source) {
        source.hihokenshaNo = item.getHihokenshaNo();
        if (RDate.canConvert(item.getShinseiYMD())) {
            Wareki shinseiYMD = new RDate(item.getShinseiYMD().toString()).wareki();
            source.shinseiYY = shinseiYMD.getYear();
            source.shinseiMM = shinseiYMD.getMonth();
            source.shinseiMM = shinseiYMD.getDay();
        }
        source.hokenshaNo = item.getHokenshaNo();
        return source;
    }
}

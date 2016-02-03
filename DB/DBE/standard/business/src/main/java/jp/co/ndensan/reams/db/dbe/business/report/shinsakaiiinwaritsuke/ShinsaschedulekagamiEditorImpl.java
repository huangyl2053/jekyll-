/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会スケジュール表かがみのEditorです。
 */
public class ShinsaschedulekagamiEditorImpl implements IShinsaschedulekagamiEditor {

    private final ShinsaschedulekagamiItem item;
    private final int remban;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokuTaishoshaIchiranhyoItem}
     * @param remban 連番
     */
    protected ShinsaschedulekagamiEditorImpl(ShinsaschedulekagamiItem item, int remban) {
        this.remban = remban;
        this.item = item;
    }

    @Override
    public ShinsaschedulekagamiReportSource edit(ShinsaschedulekagamiReportSource source) {
        return editSource(source);
    }

    private ShinsaschedulekagamiReportSource editSource(ShinsaschedulekagamiReportSource source) {
        source.hakkoYMD = item.getHakkoYMD();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.koinShoryaku = item.getKoinShoryaku();
        source.denshiKoin = item.getDenshiKoin();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.shoriMikomiKaishiYMD = item.getShoriMikomiKaishiYMD();
        source.shoriMikomiShuryoYMD = item.getShoriMikomiShuryoYMD();
        source.tsuchibun2 = item.getTsuchibun2();
        source.remban = new RString(String.valueOf(remban));
        return source;
    }

}

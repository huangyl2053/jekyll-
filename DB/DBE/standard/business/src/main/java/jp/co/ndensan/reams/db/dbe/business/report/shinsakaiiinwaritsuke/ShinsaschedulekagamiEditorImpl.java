/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;

/**
 * 介護認定審査会スケジュール表かがみのEditorです。
 */
public class ShinsaschedulekagamiEditorImpl implements IShinsaschedulekagamiEditor {

    private final ShinsaschedulekagamiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsaschedulekagamiItem}
     */
    protected ShinsaschedulekagamiEditorImpl(ShinsaschedulekagamiItem item) {
        this.item = item;
    }

    /**
     * 介護認定審査会スケジュール表かがみを編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
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
        return source;
    }

}

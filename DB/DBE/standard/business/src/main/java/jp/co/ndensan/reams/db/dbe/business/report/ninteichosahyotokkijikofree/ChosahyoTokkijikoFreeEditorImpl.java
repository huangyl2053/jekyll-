/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijikofree;

import jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko.ChosahyoTokkijikoItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;

/**
 * 要介護認定調査票（特記事項）フリー様式のEditorです。
 */
public class ChosahyoTokkijikoFreeEditorImpl implements IChosahyoTokkijikoFreeEditor {

    private final ChosahyoTokkijikoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoTokkijikoItem}
     */
    protected ChosahyoTokkijikoFreeEditorImpl(ChosahyoTokkijikoItem item) {
        this.item = item;
    }

    /**
     * 要介護認定調査票（特記事項）フリー様式を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.shinseiYY1 = item.getShinseiYY1();
        source.shinseiYY2 = item.getShinseiYY2();
        source.shinseiMM1 = item.getShinseiMM1();
        source.shinseiMM2 = item.getShinseiMM2();
        source.shinseiDD1 = item.getShinseiDD1();
        source.shinseiDD2 = item.getShinseiDD2();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.hihokenshaName = item.getHihokenshaName();
        return source;
    }
}

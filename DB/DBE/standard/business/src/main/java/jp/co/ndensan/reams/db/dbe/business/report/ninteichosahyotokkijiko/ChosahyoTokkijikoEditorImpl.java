/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;

/**
 * 要介護認定調査票（特記事項）のEditorです。
 */
public class ChosahyoTokkijikoEditorImpl implements IChosahyoTokkijikoEditor {

    private final ChosahyoTokkijikoItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoTokkijikoItem}
     */
    protected ChosahyoTokkijikoEditorImpl(ChosahyoTokkijikoItem item) {
        this.item = item;
    }

    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
        // TODO 内部QA:667 Redmine#: (Formファイルは不正、一つ項目を設定する。)
        source.hokenshaNo = item.getHokenshaNo();
        source.shinseiYY = item.getHokenshaNo();
        source.shinseiMM = item.getHokenshaNo();
        source.shinseiDD = item.getHokenshaNo();
        source.hihokenshaName = item.getHokenshaNo();
        source.hihokenshaNo = item.getHokenshaNo();
        return source;
    }

}

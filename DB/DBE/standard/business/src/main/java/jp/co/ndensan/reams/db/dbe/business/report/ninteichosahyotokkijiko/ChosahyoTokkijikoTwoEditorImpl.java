/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko.IChosahyoTokkijikoEditor;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;

/**
 *
 */
public class ChosahyoTokkijikoTwoEditorImpl implements IChosahyoTokkijikoEditor {

    private final ChosahyoTokkijikoBusiness item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosahyoTokkijikoEntity}
     */
    protected ChosahyoTokkijikoTwoEditorImpl(ChosahyoTokkijikoBusiness item) {
        this.item = item;
    }

    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
        // TODO 内部QA:667 Redmine#:75887 (四つ帳票formファイルがあるので、処置に惑います。)
        // TODO 内部QA:849 Redmine#: (Formファイルは不正、項目未設定。)
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
//        source.hishokenshaNo1 = item.getHihokenshaNo1();
//        source.hishokenshaNo2 = item.getHihokenshaNo2();
//        source.hishokenshaNo3 = item.getHihokenshaNo3();
//        source.hishokenshaNo4 = item.getHihokenshaNo4();
//        source.hishokenshaNo5 = item.getHihokenshaNo5();
//        source.hishokenshaNo6 = item.getHihokenshaNo6();
//        source.hishokenshaNo7 = item.getHihokenshaNo7();
//        source.hishokenshaNo8 = item.getHihokenshaNo8();
//        source.hishokenshaNo9 = item.getHihokenshaNo9();
//        source.hishokenshaNo10 = item.getHihokenshaNo10();
//        source.shinseishaName = item.getHihokenshaName();
        return source;
    }

}

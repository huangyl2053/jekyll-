/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;

/**
 * 要介護認定調査票（特記事項）-片面のEditorです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoKatamenEditorImpl implements IChosahyoTokkijikoEditor {

    private final ChosahyoTokkijikoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link ChosahyoTokkijikoBusiness}
     */
    protected ChosahyoTokkijikoKatamenEditorImpl(ChosahyoTokkijikoBusiness business) {
        this.business = business;
    }

    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
        source.shinseiYY1 = business.getShinseiYY1();
        source.shinseiYY2 = business.getShinseiYY2();
        source.shinseiMM1 = business.getShinseiMM1();
        source.shinseiMM2 = business.getShinseiMM2();
        source.shinseiDD1 = business.getShinseiDD1();
        source.shinseiDD2 = business.getShinseiDD2();
        source.hokenshaNo1 = business.getHokenshaNo1();
        source.hokenshaNo2 = business.getHokenshaNo2();
        source.hokenshaNo3 = business.getHokenshaNo3();
        source.hokenshaNo4 = business.getHokenshaNo4();
        source.hokenshaNo5 = business.getHokenshaNo5();
        source.hokenshaNo6 = business.getHokenshaNo6();
        source.shinseishaName = business.getHihokenshaName();
        source.hishokenshaNo7 = business.getHihokenshaNo7();
        source.hishokenshaNo8 = business.getHihokenshaNo8();
        source.hishokenshaNo9 = business.getHihokenshaNo9();
        source.hishokenshaNo10 = business.getHihokenshaNo10();
        source.hishokenshaNo1 = business.getHihokenshaNo1();
        source.hishokenshaNo2 = business.getHihokenshaNo2();
        source.hishokenshaNo3 = business.getHihokenshaNo3();
        source.hishokenshaNo4 = business.getHihokenshaNo4();
        source.hishokenshaNo5 = business.getHihokenshaNo5();
        source.hishokenshaNo6 = business.getHihokenshaNo6();
        source.layout = Layouts.鑑;
        source.識別コード = business.get識別コード();
        source.拡張情報 = business.get拡張情報();
        return source;
    }

}

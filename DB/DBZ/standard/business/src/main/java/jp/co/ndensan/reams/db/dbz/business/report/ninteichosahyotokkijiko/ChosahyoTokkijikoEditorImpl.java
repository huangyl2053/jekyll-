/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定調査票（特記事項）のEditorです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoEditorImpl implements IChosahyoTokkijikoEditor {

    private final ChosahyoTokkijikoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link ChosahyoTokkijikoBusiness}
     */
    protected ChosahyoTokkijikoEditorImpl(ChosahyoTokkijikoBusiness business) {
        this.business = business;
    }

    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
        source.hokenshaNo1 = business.getHokenshaNo1();
        source.hokenshaNo2 = business.getHokenshaNo2();
        source.hokenshaNo3 = business.getHokenshaNo3();
        source.hokenshaNo4 = business.getHokenshaNo4();
        source.hokenshaNo5 = business.getHokenshaNo5();
        source.hokenshaNo6 = business.getHokenshaNo6();
        source.shinseiYY1 = business.getShinseiYY1();
        source.shinseiYY2 = business.getShinseiYY2();
        source.shinseiMM1 = business.getShinseiMM1();
        source.shinseiMM2 = business.getShinseiMM2();
        source.shinseiDD1 = business.getShinseiDD1();
        source.shinseiDD2 = business.getShinseiDD2();
        source.hihokenshaNo1 = business.getHihokenshaNo1();
        source.hihokenshaNo2 = business.getHihokenshaNo2();
        source.hihokenshaNo3 = business.getHihokenshaNo3();
        source.hihokenshaNo4 = business.getHihokenshaNo4();
        source.hihokenshaNo5 = business.getHihokenshaNo5();
        source.hihokenshaNo6 = business.getHihokenshaNo6();
        source.hihokenshaNo7 = business.getHihokenshaNo7();
        source.hihokenshaNo8 = business.getHihokenshaNo8();
        source.hihokenshaNo9 = business.getHihokenshaNo9();
        source.hihokenshaNo10 = business.getHihokenshaNo10();
        source.hihokenshaName = business.getHihokenshaName();
        source.oCR_shinseiYY1 = business.getShinseiYY1();
        source.oCR_shinseiYY2 = business.getShinseiYY2();
        source.oCR_shinseiMM1 = business.getShinseiMM1();
        source.oCR_shinseiMM2 = business.getShinseiMM2();
        source.oCR_shinseiDD1 = business.getShinseiDD1();
        source.oCR_shinseiDD2 = business.getShinseiDD2();
        source.oCR_hokenshaNo1 = business.getHokenshaNo1();
        source.oCR_hokenshaNo2 = business.getHokenshaNo2();
        source.oCR_hokenshaNo3 = business.getHokenshaNo3();
        source.oCR_hokenshaNo4 = business.getHokenshaNo4();
        source.oCR_hokenshaNo5 = business.getHokenshaNo5();
        source.oCR_hokenshaNo6 = business.getHokenshaNo6();
        source.oCR_shinseishaName = business.getHihokenshaName();
        source.oCR_hishokenshaNo7 = business.getHihokenshaNo7();
        source.oCR_hishokenshaNo8 = business.getHihokenshaNo8();
        source.oCR_hishokenshaNo9 = business.getHihokenshaNo9();
        source.oCR_hishokenshaNo10 = business.getHihokenshaNo10();
        source.oCR_hishokenshaNo1 = business.getHihokenshaNo1();
        source.oCR_hishokenshaNo2 = business.getHihokenshaNo2();
        source.oCR_hishokenshaNo3 = business.getHihokenshaNo3();
        source.oCR_hishokenshaNo4 = business.getHihokenshaNo4();
        source.oCR_hishokenshaNo5 = business.getHihokenshaNo5();
        source.oCR_hishokenshaNo6 = business.getHihokenshaNo6();
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        RStringBuilder builder = new RStringBuilder();
        builder.append(business.getHihokenshaNo1());
        builder.append(business.getHihokenshaNo2());
        builder.append(business.getHihokenshaNo3());
        builder.append(business.getHihokenshaNo4());
        builder.append(business.getHihokenshaNo5());
        builder.append(business.getHihokenshaNo6());
        builder.append(business.getHihokenshaNo7());
        builder.append(business.getHihokenshaNo8());
        builder.append(business.getHihokenshaNo9());
        builder.append(business.getHihokenshaNo10());
        source.hishokenshaNo = new ExpandedInformation(Code.EMPTY, new RString("被保険者番号"), builder.toRString());
        return source;
    }

}

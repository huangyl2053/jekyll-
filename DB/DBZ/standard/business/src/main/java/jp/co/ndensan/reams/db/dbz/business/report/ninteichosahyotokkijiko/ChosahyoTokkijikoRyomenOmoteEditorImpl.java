/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.report.saichekkuhyo.Layouts;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定調査票（特記事項）両面-表のEditorです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoRyomenOmoteEditorImpl implements IChosahyoTokkijikoEditor {

    private final ChosahyoTokkijikoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link ChosahyoTokkijikoBusiness}
     */
    protected ChosahyoTokkijikoRyomenOmoteEditorImpl(ChosahyoTokkijikoBusiness business) {
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

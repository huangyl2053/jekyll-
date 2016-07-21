/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyogaikyotokki.GaikyotokkiA4Business;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 要介護認定調査票（概況特記）のEditorです。
 *
 * @reamsid_L DBE-0080-190 xuyannan
 */
public class GaikyotokkiA4EditorImpl implements IGaikyotokkiA4Editor {

    private final GaikyotokkiA4Business business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link GaikyotokkiA4Business}
     */
    protected GaikyotokkiA4EditorImpl(GaikyotokkiA4Business business) {
        this.business = business;
    }

    /**
     * 要介護認定調査票（概況特記）を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public GaikyotokkiA4ReportSource edit(GaikyotokkiA4ReportSource source) {
        return editSource(source);
    }

    private GaikyotokkiA4ReportSource editSource(GaikyotokkiA4ReportSource source) {
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
        source.shinseishaName = business.getShinseishaName();
        return source;
    }
}

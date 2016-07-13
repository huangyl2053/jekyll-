/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyogaikyotokki.GaikyotokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
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

    private final GaikyotokkiA4Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link GaikyotokkiA4Entity}
     */
    protected GaikyotokkiA4EditorImpl(GaikyotokkiA4Entity entity) {
        this.entity = entity;
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
        builder.append(entity.getHihokenshaNo1());
        builder.append(entity.getHihokenshaNo2());
        builder.append(entity.getHihokenshaNo3());
        builder.append(entity.getHihokenshaNo4());
        builder.append(entity.getHihokenshaNo5());
        builder.append(entity.getHihokenshaNo6());
        builder.append(entity.getHihokenshaNo7());
        builder.append(entity.getHihokenshaNo8());
        builder.append(entity.getHihokenshaNo9());
        builder.append(entity.getHihokenshaNo10());
        source.hishokenshaNo = new ExpandedInformation(Code.EMPTY, new RString("被保険者番号"), builder.toRString());
        source.hokenshaNo1 = entity.getHokenshaNo1();
        source.hokenshaNo2 = entity.getHokenshaNo2();
        source.hokenshaNo3 = entity.getHokenshaNo3();
        source.hokenshaNo4 = entity.getHokenshaNo4();
        source.hokenshaNo5 = entity.getHokenshaNo5();
        source.hokenshaNo6 = entity.getHokenshaNo6();
        source.shinseiYY1 = entity.getShinseiYY1();
        source.shinseiYY2 = entity.getShinseiYY2();
        source.shinseiMM1 = entity.getShinseiMM1();
        source.shinseiMM2 = entity.getShinseiMM2();
        source.shinseiDD1 = entity.getShinseiDD1();
        source.shinseiDD2 = entity.getShinseiDD2();
        source.hihokenshaNo1 = entity.getHihokenshaNo1();
        source.hihokenshaNo2 = entity.getHihokenshaNo2();
        source.hihokenshaNo3 = entity.getHihokenshaNo3();
        source.hihokenshaNo4 = entity.getHihokenshaNo4();
        source.hihokenshaNo5 = entity.getHihokenshaNo5();
        source.hihokenshaNo6 = entity.getHihokenshaNo6();
        source.hihokenshaNo7 = entity.getHihokenshaNo7();
        source.hihokenshaNo8 = entity.getHihokenshaNo8();
        source.hihokenshaNo9 = entity.getHihokenshaNo9();
        source.hihokenshaNo10 = entity.getHihokenshaNo10();
        source.shinseishaName = entity.getShinseishaName();
        return source;
    }
}

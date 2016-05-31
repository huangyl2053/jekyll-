/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyotokkijiko.ChosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
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

    private final ChosahyoTokkijikoEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link ChosahyoTokkijikoEntity}
     */
    protected ChosahyoTokkijikoEditorImpl(ChosahyoTokkijikoEntity entity) {
        this.entity = entity;
    }

    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
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
        source.hihokenshaName = entity.getHihokenshaName();
        source.oCR_shinseiYY1 = entity.getShinseiYY1();
        source.oCR_shinseiYY2 = entity.getShinseiYY2();
        source.oCR_shinseiMM1 = entity.getShinseiMM1();
        source.oCR_shinseiMM2 = entity.getShinseiMM2();
        source.oCR_shinseiDD1 = entity.getShinseiDD1();
        source.oCR_shinseiDD2 = entity.getShinseiDD2();
        source.oCR_hokenshaNo1 = entity.getHokenshaNo1();
        source.oCR_hokenshaNo2 = entity.getHokenshaNo2();
        source.oCR_hokenshaNo3 = entity.getHokenshaNo3();
        source.oCR_hokenshaNo4 = entity.getHokenshaNo4();
        source.oCR_hokenshaNo5 = entity.getHokenshaNo5();
        source.oCR_hokenshaNo6 = entity.getHokenshaNo6();
        source.oCR_shinseishaName = entity.getHihokenshaName();
        source.oCR_hishokenshaNo7 = entity.getHihokenshaNo7();
        source.oCR_hishokenshaNo8 = entity.getHihokenshaNo8();
        source.oCR_hishokenshaNo9 = entity.getHihokenshaNo9();
        source.oCR_hishokenshaNo10 = entity.getHihokenshaNo10();
        source.oCR_hishokenshaNo1 = entity.getHihokenshaNo1();
        source.oCR_hishokenshaNo2 = entity.getHihokenshaNo2();
        source.oCR_hishokenshaNo3 = entity.getHihokenshaNo3();
        source.oCR_hishokenshaNo4 = entity.getHihokenshaNo4();
        source.oCR_hishokenshaNo5 = entity.getHihokenshaNo5();
        source.oCR_hishokenshaNo6 = entity.getHihokenshaNo6();
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
        return source;
    }

}

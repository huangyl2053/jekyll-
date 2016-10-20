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
 * 要介護認定調査票（特記事項）なし-カラーのEditorです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoNashiColorEditorImpl implements IChosahyoTokkijikoEditor {

    private final ChosahyoTokkijikoBusiness business;

    /**
     * インスタンスを生成します。
     *
     * @param business {@link ChosahyoTokkijikoBusiness}
     */
    protected ChosahyoTokkijikoNashiColorEditorImpl(ChosahyoTokkijikoBusiness business) {
        this.business = business;
    }

    @Override
    public ChosahyoTokkijikoReportSource edit(ChosahyoTokkijikoReportSource source) {
        return editSource(source);
    }

    private ChosahyoTokkijikoReportSource editSource(ChosahyoTokkijikoReportSource source) {
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

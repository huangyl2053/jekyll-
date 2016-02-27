/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyokihonchosakatamen;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（基本調査）のプロパティです。
 */
public class ChosahyoKihonchosaKatamenProperty extends ReportPropertyBase<ChosahyoKihonchosaKatamenReportSource> {

    private static final RString 概況調査区分_両面用 = new RString("1");

    public ChosahyoKihonchosaKatamenProperty(ReportId reportId) {
        super(SubGyomuCode.DBC介護給付, reportId);
    }

    public static ChosahyoKihonchosaKatamenProperty createInstance(RString chosaJyokyo) {
        if (概況調査区分_両面用.equals(chosaJyokyo)) {
            return new ChosahyoKihonchosaKatamenProperty(ReportIdDBE.DBE221003.getReportId());
        }
        return new ChosahyoKihonchosaKatamenProperty(ReportIdDBE.DBE221002.getReportId());
    }
}

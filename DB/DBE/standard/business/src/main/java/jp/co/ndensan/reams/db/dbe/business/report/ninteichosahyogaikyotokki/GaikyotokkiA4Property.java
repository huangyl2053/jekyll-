/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosahyogaikyotokki;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.ninteichosahyogaikyotokki.GaikyotokkiA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（概況特記）のプロパティです。
 *
 * @reamsid_L DBE-0080-190 xuyannan
 */
public class GaikyotokkiA4Property extends ReportPropertyBase<GaikyotokkiA4ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public GaikyotokkiA4Property() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE221051.getReportId());
    }

}

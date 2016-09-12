/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.atenaseal;

import jp.co.ndensan.reams.db.dbz.entity.report.atenaseal.AtenaSealCreateReportSource;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 宛名シールのプロパティです。
 *
 * @reamsid_L DBA-1210-050 zhengsongling
 */
public class AtenaSealProperty extends ReportPropertyBase<AtenaSealCreateReportSource> {

    /**
     * インスタンスを生成します。
     */
    public AtenaSealProperty() {
        super(SubGyomuCode.DBZ介護共通, ReportIdDBZ.DBZ100001.getReportId());
    }

}

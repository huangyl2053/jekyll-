/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.kaigohokenrenrakuhyo;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.kaigohokenrenrakuhyo.KaigohokenRenrakuhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * KaigohokenRenrakuhyoProertyのプロパティです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 *
 */
public class KaigohokenRenrakuhyoProerty extends ReportPropertyBase<KaigohokenRenrakuhyoReportSource> {

    /**
     * コンストラクタです。
     */
    public KaigohokenRenrakuhyoProerty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU100002.getReportId());
    }
}

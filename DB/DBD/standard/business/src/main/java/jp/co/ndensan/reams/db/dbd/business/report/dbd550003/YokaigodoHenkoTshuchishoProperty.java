/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd550003;

import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link YokaigodoHenkoTshuchishoReportSource}のプロパティです。
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public class YokaigodoHenkoTshuchishoProperty extends ReportPropertyBase<YokaigodoHenkoTshuchishoReportSource> {

    /**
     * コンストラクタです。
     */
    public YokaigodoHenkoTshuchishoProperty() {
        super(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD550003.getReportId());
    }

}

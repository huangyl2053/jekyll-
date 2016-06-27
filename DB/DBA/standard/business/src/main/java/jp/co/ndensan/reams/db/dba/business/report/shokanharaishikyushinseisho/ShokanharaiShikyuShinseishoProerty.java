/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shokanharaishikyushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.shokanharaishikyushinseisho.ShokanharaiShikyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険償還払支給申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-706 yaodongsheng
 */
public class ShokanharaiShikyuShinseishoProerty extends ReportPropertyBase<ShokanharaiShikyuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public ShokanharaiShikyuShinseishoProerty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBA.DBC800009.getReportId());
    }
}

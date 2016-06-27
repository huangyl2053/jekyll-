/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hokenryogenmenchoshuyoyushinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hokenryogenmenchoshuyoyushinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link HokenryoGenmenChoshuYoyuShinseishoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0540-692 suguangjun
 */
public class HokenryoGenmenChoshuYoyuShinseishoProerty extends ReportPropertyBase<HokenryoGenmenChoshuYoyuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HokenryoGenmenChoshuYoyuShinseishoProerty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBA.DBB800001.getReportId());
    }
}

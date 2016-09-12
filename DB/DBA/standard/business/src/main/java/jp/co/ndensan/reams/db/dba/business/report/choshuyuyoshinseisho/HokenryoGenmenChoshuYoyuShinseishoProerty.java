/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.choshuyuyoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.choshuyuyoshinseisho.HokenryoGenmenChoshuYoyuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険料徴収猶予申請書のプロパティです。
 *
 * @reamsid_L DBA-0540-693 xuyannan
 */
public class HokenryoGenmenChoshuYoyuShinseishoProerty extends
        ReportPropertyBase<HokenryoGenmenChoshuYoyuShinseishoReportSource> {

    /**
     * コンストラクタです。
     */
    public HokenryoGenmenChoshuYoyuShinseishoProerty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBA.DBB800002.getReportId());
    }
}

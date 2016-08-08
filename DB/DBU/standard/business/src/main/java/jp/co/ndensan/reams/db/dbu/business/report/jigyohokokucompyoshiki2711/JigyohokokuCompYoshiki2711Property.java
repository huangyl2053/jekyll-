/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2711;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2711.JigyohokokuCompYoshiki2711ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告年報（様式2-7）のPropertyです。
 *
 * @reamsid_L DBU-5600-280 guoqilin
 */
public class JigyohokokuCompYoshiki2711Property extends ReportPropertyBase<JigyohokokuCompYoshiki2711ReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki2711Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300191.getReportId());
    }

}

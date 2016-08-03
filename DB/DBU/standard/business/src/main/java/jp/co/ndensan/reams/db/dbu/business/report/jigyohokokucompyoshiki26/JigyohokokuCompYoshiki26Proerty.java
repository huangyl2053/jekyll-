/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki26;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki26.JigyohokokuCompYoshikiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報（様式2-6）のProertyです。
 *
 * @reamsid_L DBU-5600-270 guoqilin
 */
public class JigyohokokuCompYoshiki26Proerty extends ReportPropertyBase<JigyohokokuCompYoshikiReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki26Proerty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU30018.getReportId());
    }

}

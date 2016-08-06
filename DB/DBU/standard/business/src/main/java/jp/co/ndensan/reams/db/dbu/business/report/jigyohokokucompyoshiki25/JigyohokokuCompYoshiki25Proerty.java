/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki25;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.JigyohokokuCompYoshiki25.JigyohokokuCompYoshiki25ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報（様式2-5）のProertyです。
 *
 * @reamsid_L DBU-5600-260 guoqilin
 */
public class JigyohokokuCompYoshiki25Proerty extends ReportPropertyBase<JigyohokokuCompYoshiki25ReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki25Proerty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300017.getReportId());
    }

}

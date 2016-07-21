/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153.JigyohokokuCompYoshiki153ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報・一般状況（様式1-5）のReportSourceクラスです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153Proerty extends ReportPropertyBase<JigyohokokuCompYoshiki153ReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki153Proerty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300007.getReportId());
    }
}

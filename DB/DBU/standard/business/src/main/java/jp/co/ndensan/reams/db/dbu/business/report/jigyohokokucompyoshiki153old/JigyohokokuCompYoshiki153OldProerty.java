/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153old;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki153old.JigyohokokuCompYoshiki153OldReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のPropertyです。
 *
 * @reamsid_L DBU-5550-050 dangjingjing
 */
public class JigyohokokuCompYoshiki153OldProerty extends ReportPropertyBase<JigyohokokuCompYoshiki153OldReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki153OldProerty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300007.getReportId());
    }

}

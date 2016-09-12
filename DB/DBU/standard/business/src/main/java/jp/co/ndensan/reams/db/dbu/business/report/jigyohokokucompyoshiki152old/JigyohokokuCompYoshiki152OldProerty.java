/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki152old;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152old.JigyohokokuCompYoshiki152OldReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報・一般状況（様式1-5） のPropertyです。
 *
 * @reamsid_L DBU-5550-040 dangjingjing
 */
public class JigyohokokuCompYoshiki152OldProerty extends ReportPropertyBase<JigyohokokuCompYoshiki152OldReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki152OldProerty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300006.getReportId());
    }

}

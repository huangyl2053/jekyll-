/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki3003;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki3003.JigyohokokuCompYoshiki3003ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報・一般状況（様式1-3） のPropertyです。
 *
 * @reamsid_L DBU-5530-060 dangjingjing
 */
public class JigyohokokuCompYoshiki3003Property extends ReportPropertyBase<JigyohokokuCompYoshiki3003ReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuCompYoshiki3003Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300003.getReportId());
    }
}

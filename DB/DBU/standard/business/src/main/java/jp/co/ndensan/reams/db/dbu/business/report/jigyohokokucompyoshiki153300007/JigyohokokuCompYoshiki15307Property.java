/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki153300007;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki152300006.JigyohokokuCompYoshiki15206ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告年報・一般状況（様式1-5）のプロパティです。
 *
 * @reamsid_L DBU-5600-170 wangrenze
 */
public class JigyohokokuCompYoshiki15307Property extends ReportPropertyBase<JigyohokokuCompYoshiki15206ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshiki15307Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300007.getReportId());
    }
}

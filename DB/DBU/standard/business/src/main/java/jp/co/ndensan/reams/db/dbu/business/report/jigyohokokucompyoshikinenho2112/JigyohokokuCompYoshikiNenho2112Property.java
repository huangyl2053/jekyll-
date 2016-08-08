
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshikinenho2112;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshikinenho2112.JigyohokokuCompYoshikiNenho2112ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告年報（様式2-2）のPropertyです。
 *
 * @reamsid_L DBU-5600-210 zhaoran
 */
public class JigyohokokuCompYoshikiNenho2112Property extends ReportPropertyBase<JigyohokokuCompYoshikiNenho2112ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshikiNenho2112Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300112.getReportId());
    }
}

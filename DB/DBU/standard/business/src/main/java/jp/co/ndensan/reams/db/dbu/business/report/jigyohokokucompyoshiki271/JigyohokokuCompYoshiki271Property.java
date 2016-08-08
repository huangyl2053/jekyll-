/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JigyohokokuCompYoshiki271Property}のプロパティです。
 *
 * @reamsid_L DBU-5580-040　wanghuafeng
 */
public class JigyohokokuCompYoshiki271Property extends ReportPropertyBase<JigyohokokuCompYoshiki271ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshiki271Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300019.getReportId());
    }

}

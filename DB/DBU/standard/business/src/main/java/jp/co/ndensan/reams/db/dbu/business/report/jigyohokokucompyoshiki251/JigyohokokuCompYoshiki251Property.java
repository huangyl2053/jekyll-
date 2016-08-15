/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki251;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki251.JigyohokokuCompYoshiki251ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事業報告複合様式_05のプロパティです。
 *
 * @reamsid_L DBU-5560-060 wanghuafeng
 */
public class JigyohokokuCompYoshiki251Property extends ReportPropertyBase<JigyohokokuCompYoshiki251ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshiki251Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU3000171.getReportId());
    }

}

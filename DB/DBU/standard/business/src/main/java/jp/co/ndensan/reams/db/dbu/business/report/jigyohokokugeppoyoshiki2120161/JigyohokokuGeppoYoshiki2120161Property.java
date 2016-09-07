/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshiki2120161;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshiki2120161.JigyohokokuGeppoYoshiki2120161ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事業報告月報様式_03のPropertyのクラスです。
 *
 * @reamsid_L DBU-5560-070 wanghuafeng
 */
public class JigyohokokuGeppoYoshiki2120161Property extends ReportPropertyBase<JigyohokokuGeppoYoshiki2120161ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuGeppoYoshiki2120161Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU3000211.getReportId());
    }

}

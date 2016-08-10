/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki2021;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki2021.JigyohokokuCompYoshiki2021ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JigyohokokuCompYoshiki2021Property}のプロパティです。
 *
 * @reamsid_L DBU-5560-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki2021Property extends ReportPropertyBase<JigyohokokuCompYoshiki2021ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshiki2021Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300010.getReportId());
    }

}

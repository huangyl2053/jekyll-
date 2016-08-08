/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.ｊigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JigyohokokuCompYoshiki272Property}のプロパティです。
 *
 * @reamsid_L DBU-5590-050 wanghuafeng
 */
public class JigyohokokuCompYoshiki272Property extends ReportPropertyBase<JigyohokokuCompYoshiki272ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public JigyohokokuCompYoshiki272Property() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300020.getReportId());
    }
}

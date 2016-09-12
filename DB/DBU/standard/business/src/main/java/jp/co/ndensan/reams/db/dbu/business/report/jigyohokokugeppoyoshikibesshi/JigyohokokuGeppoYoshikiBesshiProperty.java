/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokugeppoyoshikibesshi;

import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokugeppoyoshikibesshi.JigyohokokuGeppoYoshikiBesshiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護事業状況報告月報・一般状況（別紙） のPropertyです。
 *
 * @reamsid_L DBU-5530-090 dangjingjing
 */
public class JigyohokokuGeppoYoshikiBesshiProperty extends ReportPropertyBase<JigyohokokuGeppoYoshikiBesshiReportSource> {

    /**
     * コンストラクタです。
     */
    public JigyohokokuGeppoYoshikiBesshiProperty() {
        super(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBU300008.getReportId());
    }
}

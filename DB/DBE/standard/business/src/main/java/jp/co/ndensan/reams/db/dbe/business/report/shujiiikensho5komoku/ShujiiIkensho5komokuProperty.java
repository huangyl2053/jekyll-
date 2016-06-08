/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho5komoku;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho5komoku.ShujiiIkensho5komokuReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 主治医意見書5項目確認一覧表のプロパティです。
 *
 * @reamsid_L DBE-1390-170 suguangjun
 */
public class ShujiiIkensho5komokuProperty extends ReportPropertyBase<ShujiiIkensho5komokuReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkensho5komokuProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE013005.getReportId());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定主治医意見書記入用紙のプロパティです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiProperty extends ReportPropertyBase<IkenshokinyuyoshiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public IkenshokinyuyoshiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBZ.DBE231001.getReportId());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.jukirendotorokulist;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.jukirendotorokulist.JukiRendoTorokuListReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link JukiRendoTorokuListReportSource}のプロパティです。
 *
 * @author n3423
 */
public class JukiRendoTorokuListProperty extends ReportPropertyBase<JukiRendoTorokuListReportSource> {

    /**
     * コンストラクタです。
     */
    public JukiRendoTorokuListProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200007.getReportId());
    }
}

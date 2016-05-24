/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaishiryoa4;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa4.ShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事務局用介護認定審査対象者一覧表のプロパティです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
public class ShinsakaishiryoA4Property extends ReportPropertyBase<ShinsakaishiryoA4ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsakaishiryoA4Property() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517011.getReportId());
    }
}

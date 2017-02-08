/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.sonotashiryo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.sonotashiryo.SonoTashiryoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 事務局用その他資料のプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class SonotashiryoProperty extends ReportPropertyBase<SonoTashiryoReportSource> {

    /**
     * コンストラクタです。
     */
    public SonotashiryoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517016.getReportId());
    }
}

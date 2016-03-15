/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaisukejuruhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaisukejuruhyo.ShinsakaisukejuruhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 介護認定審査会スケジュール表のReport}のプロパティです。
 */
public class ShinsakaisukejuruhyoProperty extends ReportPropertyBase<ShinsakaisukejuruhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShinsakaisukejuruhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE514001.getReportId());
    }
}

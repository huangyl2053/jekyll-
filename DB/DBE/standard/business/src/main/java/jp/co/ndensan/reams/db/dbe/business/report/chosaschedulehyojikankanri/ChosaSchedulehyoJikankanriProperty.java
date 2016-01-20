/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 認定調査スケジュール表(時間管理)のReport}のプロパティです。
 */
public class ChosaSchedulehyoJikankanriProperty extends ReportPropertyBase<ChosaSchedulehyoJikankanriReportSource> {

    private static final ReportId ID = new ReportId("DBE202011");

    /**
     * インスタンスを生成します。
     */
    public ChosaSchedulehyoJikankanriProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}

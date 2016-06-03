/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyojikankanri;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyojikankanri.ChosaSchedulehyoJikankanriReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link 認定調査スケジュール表(時間管理)のReport}のプロパティです。
 *
 * @reamsid_L DBE-0020-100 lishengli
 */
public class ChosaSchedulehyoJikankanriProperty extends ReportPropertyBase<ChosaSchedulehyoJikankanriReportSource> {

    //TODO 出力順指定 調査員コード＞認定調査予定開始時間＞被保険者番号
    /**
     * インスタンスを生成します。
     */
    public ChosaSchedulehyoJikankanriProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE202011.getReportId());
    }
}

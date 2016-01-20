/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 認定調査スケジュール表(調査員)のReport}のプロパティです。
 */
public class ChosaSchedulehyoTyousayinProperty extends ReportPropertyBase<ChosaSchedulehyoTyousayinReportSource> {

    private static final ReportId ID = new ReportId("DBE202001");

    /**
     * インスタンスを生成します。
     */
    public ChosaSchedulehyoTyousayinProperty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}

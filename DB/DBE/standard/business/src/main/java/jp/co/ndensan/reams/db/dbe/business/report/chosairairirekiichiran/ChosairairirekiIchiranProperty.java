/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.chosairairirekiichiran.ChosairairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査依頼履歴一覧表のプロパティです。
 *
 * @reamsid_L DBE-1590-031 sunhaidi
 */
public class ChosairairirekiIchiranProperty extends ReportPropertyBase<ChosairairirekiIchiranReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosairairirekiIchiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE220004.getReportId());
    }
}

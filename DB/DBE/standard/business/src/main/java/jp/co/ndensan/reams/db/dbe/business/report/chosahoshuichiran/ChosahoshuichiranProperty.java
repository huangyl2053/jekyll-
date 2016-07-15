/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshuichiran;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshuichiran.ChosahoshuichiranReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査報酬一覧表のプロパティです。
 *
 * @reamsid_L DBE-1940-030 jinjue
 */
public class ChosahoshuichiranProperty extends ReportPropertyBase<ChosahoshuichiranReportSource> {

    /**
     * コンストラクタです。
     */
    public ChosahoshuichiranProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE601006.getReportId());
    }
}

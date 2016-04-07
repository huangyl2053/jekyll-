/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaicho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaicho.HihokenshaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link HihokenshaDaichoProerty}のプロパティです。
 *
 * @reamsid_L DBA-0500-040 zuotao
 */
public class HihokenshaDaichoProerty extends ReportPropertyBase<HihokenshaDaichoReportSource> {

    private static final ReportId ID = ReportIdDBA.DBA100009.getReportId();

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoProerty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}

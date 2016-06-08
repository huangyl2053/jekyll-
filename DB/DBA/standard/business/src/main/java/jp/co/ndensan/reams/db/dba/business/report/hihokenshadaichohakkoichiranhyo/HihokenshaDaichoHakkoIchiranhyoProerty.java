package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshadaichohakkoichiranhyo.HihokenshaDaichoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link HihokenshaDaichoHakkoIchiranhyoReportSource}のプロパティです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
public class HihokenshaDaichoHakkoIchiranhyoProerty extends ReportPropertyBase<HihokenshaDaichoHakkoIchiranhyoReportSource> {

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoHakkoIchiranhyoProerty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200002.getReportId());
    }
}

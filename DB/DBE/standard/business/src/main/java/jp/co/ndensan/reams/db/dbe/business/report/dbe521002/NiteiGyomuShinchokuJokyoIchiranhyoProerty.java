/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 
 * {@link NiteiGyomuShinchokuJokyoIchiranhyoReport}のプロパティです。
 * @reamsid_L DBE-0210-020 dongyabin
 */
public class NiteiGyomuShinchokuJokyoIchiranhyoProerty extends ReportPropertyBase<NiteiGyomuShinchokuJokyoIchiranhyoReportSource> {
    
    private static final ReportId ID = ReportIdDBE.DBE521002.getReportId();
    
    /**
     * コンストラクタです。
     */
    public NiteiGyomuShinchokuJokyoIchiranhyoProerty() {
        super(SubGyomuCode.DBE認定支援, ID);
    }
}

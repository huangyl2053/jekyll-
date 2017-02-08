/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo42;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo42ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査票情報_02Aのプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaJohohyo02AProperty extends ReportPropertyBase<NinteiChosaJohohyo42ReportSource> {

    /**
     * コンストラクタです。
     */
    public NinteiChosaJohohyo02AProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091042.getReportId());
    }
}

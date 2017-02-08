/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosajohohyo32;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosajohohyo.NinteiChosaJohohyo32ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 認定調査票情報_06Aのプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaJohohyo06AProperty extends ReportPropertyBase<NinteiChosaJohohyo32ReportSource> {

    /**
     * コンストラクタです。
     */
    public NinteiChosaJohohyo06AProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091032.getReportId());
    }
}

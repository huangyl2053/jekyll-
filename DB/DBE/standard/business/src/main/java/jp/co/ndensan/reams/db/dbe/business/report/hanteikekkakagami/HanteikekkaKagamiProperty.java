/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkakagami;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.hanteikekkakagami.HanteikekkaKagamiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護認定審査判定結果（鑑）のプロパティです。
 *
 * @reamsid_L DBE-0170-030 wangkun
 */
public class HanteikekkaKagamiProperty extends ReportPropertyBase<HanteikekkaKagamiReportSource> {

    /**
     * インスタンスを生成します。
     */
    public HanteikekkaKagamiProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE525006.getReportId());
    }
}

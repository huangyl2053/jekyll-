/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsuhenkotsuchisho;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsuhenkotsuchisho.ShisetsuHenkoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険住所地特例施設変更通知書ののプロパティです。
 */
public class ShisetsuHenkoTsuchishoProperty extends ReportPropertyBase<ShisetsuHenkoTsuchishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShisetsuHenkoTsuchishoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100006.getReportId());
    }
}

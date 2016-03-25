/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shisetsutaishotsuchisho;

import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.source.shisetsutaishotsuchisho.ShisetsuTaishoTsuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護保険住所地特例施設退所通知書ののプロパティです。
 */
public class ShisetsuTaishoTsuchishoProperty extends ReportPropertyBase<ShisetsuTaishoTsuchishoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ShisetsuTaishoTsuchishoProperty() {
        super(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA100005.getReportId());
    }
}

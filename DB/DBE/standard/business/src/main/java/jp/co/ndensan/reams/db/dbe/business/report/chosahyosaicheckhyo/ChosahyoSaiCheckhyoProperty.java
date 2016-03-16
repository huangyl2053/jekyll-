/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo;

import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * {@link 前回認定調査結果との比較表のReport}のプロパティです。
 */
public class ChosahyoSaiCheckhyoProperty extends ReportPropertyBase<ChosahyoSaiCheckhyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public ChosahyoSaiCheckhyoProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE293001.getReportId());
    }
}

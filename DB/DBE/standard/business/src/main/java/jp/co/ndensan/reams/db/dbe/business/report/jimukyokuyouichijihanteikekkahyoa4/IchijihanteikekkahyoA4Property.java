/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimukyokuyouichijihanteikekkahyoa4;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ichijihanteikekkahyoa4.IchijihanteikekkahyoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * {@link IchijihanteikekkahyoA4Report}のプロパティです。
 *
 * @reamsid_L DBE-0150-400 lishengli
 */
public class IchijihanteikekkahyoA4Property extends ReportPropertyBase<IchijihanteikekkahyoReportSource> {

    /**
     * インスタンスを生成します。
     */
    public IchijihanteikekkahyoA4Property() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517181.getReportId());
    }
}

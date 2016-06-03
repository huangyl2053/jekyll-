/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmen.KaigoHokenryoGenmenKetteiTsuchishoTateSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険料減免決定通知書 A4縦タイプPropertyクラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
public class GenmenKetteiTsuchiShoTateProperty extends
        ReportPropertyBase<KaigoHokenryoGenmenKetteiTsuchishoTateSource> {

    private static final ReportId ID = ReportIdDBB.DBB100078.getReportId();

    /**
     * コンストラクタです。
     */
    public GenmenKetteiTsuchiShoTateProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

}

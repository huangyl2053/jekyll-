/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa;

import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定調査票（概況調査）のプロパティです。
 *
 * @reamsid_L DBE-0080-030 xuyannan
 */
public class ChosahyoGaikyochosaProperty extends ReportPropertyBase<ChosahyoGaikyochosaReportSource> {

    /**
     * デザイン用紙(両面)用のインスタンスを生成します。
     *
     * @return インスタンス
     */
    public static ChosahyoGaikyochosaProperty createPropertyFor両面デザイン用紙() {
        return new ChosahyoGaikyochosaProperty(ReportIdDBZ.DBE221001.getReportId());
    }

    /**
     * デザイン用紙(片面)用のインスタンスを生成します。
     *
     * @return インスタンス
     */
    public static ChosahyoGaikyochosaProperty createPropertyFor片面デザイン用紙() {
        return new ChosahyoGaikyochosaProperty(ReportIdDBZ.DBE221002.getReportId());
    }

    /**
     * 概況特記用紙用のインスタンスを生成します。
     *
     * @return インスタンス
     */
    public static ChosahyoGaikyochosaProperty createPropertyFor概況特記用紙() {
        return new ChosahyoGaikyochosaProperty(ReportIdDBZ.DBE221051.getReportId());
    }

    /**
     * インスタンスを生成します。
     */
    private ChosahyoGaikyochosaProperty(ReportId reportId) {
        super(SubGyomuCode.DBE認定支援, reportId);
    }

    @Override
    protected Breakers<ChosahyoGaikyochosaReportSource> defineBreakers(Breakers<ChosahyoGaikyochosaReportSource> breakers,
            BreakerCatalog<ChosahyoGaikyochosaReportSource> catalog) {
        return breakers.fixed();
    }
}

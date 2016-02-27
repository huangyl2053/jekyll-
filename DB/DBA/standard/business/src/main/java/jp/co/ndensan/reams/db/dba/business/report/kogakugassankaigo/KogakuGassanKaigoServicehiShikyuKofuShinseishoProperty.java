/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo;

import jp.co.ndensan.reams.db.dba.definition.reportId.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のプロパティです。
 */
public class KogakuGassanKaigoServicehiShikyuKofuShinseishoProperty
        extends ReportPropertyBase<KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource> {

    private static final ReportId ID = ReportIdDBA.DBC800016.getReportId();

    /**
     * インスタンスを生成します。
     */
    public KogakuGassanKaigoServicehiShikyuKofuShinseishoProperty() {
        super(SubGyomuCode.DBA介護資格, ID);
    }
}

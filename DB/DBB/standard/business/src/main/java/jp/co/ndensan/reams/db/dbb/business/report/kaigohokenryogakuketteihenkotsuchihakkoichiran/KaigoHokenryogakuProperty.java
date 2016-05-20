/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenryogakuketteihenkotsuchihakkoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenryogakuketteihenkotsuchihakkoichiran.KaigoHokenryogakuSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBRP43002_5_介護保険料額変更通知書発行一覧表 KaigoHokenryogakuProperty
 *
 * @reamsid_L DBB-0780-120 yangchenbing
 */
public class KaigoHokenryogakuProperty extends ReportPropertyBase<KaigoHokenryogakuSource> {

    /**
     * コンストラクタです。
     */
    public KaigoHokenryogakuProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200012.getReportId());
    }
}

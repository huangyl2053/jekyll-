/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer21.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN43002_高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）Propertyするクラスです。
 *
 * @reamsid_L DBC-2000-070 lijian
 */
public class KogakuKetteiTsuchiShoSealer2Property extends
        ReportPropertyBase<KogakuKetteiTsuchiShoSealer2Source> {

    /**
     * コンストラクタです。
     *
     */
    public KogakuKetteiTsuchiShoSealer2Property() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100010.getReportId());
    }
}

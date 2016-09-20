/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijiari;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書((支払予定日あり))のPropertyクラスです。
 *
 * @reamsid_L DBC-2000-040 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty extends ReportPropertyBase<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiSource> {

    /**
     * コンストラクタです。
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100008.getReportId());
    }
}

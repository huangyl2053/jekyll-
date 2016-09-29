/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のPropertyクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaProperty extends ReportPropertyBase<KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource> {

    /**
     * コンストラクタです。
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100007_支給.getReportId());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shikakushogohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.shikakushogohyo.ShikakuShogohyoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 *
 * 介護給付費資格照合表Propertyクラスです。
 *
 * @reamsid_L DBC-2890-030 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShogohyoProperty extends ReportPropertyBase<ShikakuShogohyoSource> {

    private final List<RString> pageBreakKeys;

    /**
     * コンストラクタです。
     *
     */
    public ShikakuShogohyoProperty() {
        super(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100017.getReportId());
        pageBreakKeys = new ArrayList<>();
        pageBreakKeys.add(new RString(ShikakuShogohyoSource.ReportSourceFields.hokenshaNo.name()));

    }

}

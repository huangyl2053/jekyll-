/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteiidou;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.source.gennendohonsanteiidou.GenNendoHonsanteiIdouSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 本算定異動（現年度）結果一覧表帳票Propertyクラスです
 *
 * @reamsid_L DBB-0930-030 sunhui
 */
public class GenNendoHonsanteiIdouProperty extends ReportPropertyBase<GenNendoHonsanteiIdouSource> {

    /**
     * コンストラクタです。
     */
    public GenNendoHonsanteiIdouProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200015.getReportId());
    }
}

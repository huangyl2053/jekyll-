/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表のProperty
 *
 * @reamsid_L DBB-1720-060 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranProperty extends ReportPropertyBase<ShotokushokaihyoHakkoIchiranSource> {

    /**
     * コンストラクタです。
     */
    public ShotokushokaihyoHakkoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200024.getReportId());
    }
}

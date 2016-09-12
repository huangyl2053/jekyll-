/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoYokoSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR51002_所得照会票のクラスです。
 *
 * @reamsid_L DBB-1710-030 xuhao
 */
public class ShotokuShokaihyoYokoProperty extends ReportPropertyBase<ShotokuShokaihyoYokoSource> {

    /**
     * コンストラクタです。
     */
    public ShotokuShokaihyoYokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100001.getReportId());
    }

}

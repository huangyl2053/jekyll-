/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険料徴収猶予取消通知書 A4縦タイプpropertyするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoA4TateProperty extends
        ReportPropertyBase<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoA4TateSource> {

    private static final ReportId ID = ReportIdDBB.DBB100084.getReportId();

    /**
     * コンストラクタです。
     */
    public ChoshuYuyoTorikesiTsuchiShoA4TateProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }
}

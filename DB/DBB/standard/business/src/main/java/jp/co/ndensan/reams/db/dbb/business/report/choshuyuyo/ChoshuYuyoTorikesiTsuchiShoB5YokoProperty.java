/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.choshuyuyo.KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険料徴収猶予取消通知書 B5横タイプpropertyするクラスです。
 *
 * @reamsid_L DBB-0740-070 chenaoqi
 */
public class ChoshuYuyoTorikesiTsuchiShoB5YokoProperty extends
        ReportPropertyBase<KaigoHokenHokenryoChoshuyoyoTorikeshiTsuchishoB5YokoSource> {

    private static final ReportId ID = ReportIdDBB.DBB100083.getReportId();

    /**
     * コンストラクタです。
     */
    public ChoshuYuyoTorikesiTsuchiShoB5YokoProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }
}

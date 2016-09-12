/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmentorikesitsuchisho;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.gemmentorikesitsuchisho.KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 介護保険料減免取消通知書 A4縦タイプPropertyするクラスです。
 *
 * @reamsid_L DBB-0740-060 chenaoqi
 */
public class GemmenTorikesiTsuchiShoA4TateProperty extends
        ReportPropertyBase<KaigoHokenHokenryoGenmenTorikeshiTsuchishoA4TateSource> {

    private static final ReportId ID = ReportIdDBB.DBB100080.getReportId();

    /**
     * コンストラクタです。
     */
    public GemmenTorikesiTsuchiShoA4TateProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }
}

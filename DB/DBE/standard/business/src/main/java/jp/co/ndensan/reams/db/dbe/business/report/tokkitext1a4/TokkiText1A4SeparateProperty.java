/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.tokkitext1a4;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitext1a4.TokkiText1ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特記事項(１つずつ)のプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class TokkiText1A4SeparateProperty extends ReportPropertyBase<TokkiText1ReportSource> {

    /**
     * コンストラクタです。
     */
    public TokkiText1A4SeparateProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517132.getReportId());
    }
}

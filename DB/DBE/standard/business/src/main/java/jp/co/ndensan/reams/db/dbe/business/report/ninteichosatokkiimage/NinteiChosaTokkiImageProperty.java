/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ninteichosatokkiimage;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ninteichosatokkiimage.NinteiChosaTokkiImageReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特記事項(イメージ)のプロパティです。
 *
 * @author N3212 竹内 和紀
 */
public class NinteiChosaTokkiImageProperty extends ReportPropertyBase<NinteiChosaTokkiImageReportSource> {

    /**
     * コンストラクタです。
     */
    public NinteiChosaTokkiImageProperty() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE091003.getReportId());
    }
}

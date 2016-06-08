/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkaichirana3;

import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.hanteikekkaichirana3.HanteiKekkaIchiranA3ReportSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 要介護認定判定結果一覧表Ａ３版のプロパティです。
 *
 * @reamsid_L DBE-0180-050 xuyannan
 */
public class HanteiKekkaIchiranA3Property extends ReportPropertyBase<HanteiKekkaIchiranA3ReportSource> {

    /**
     * インスタンスを生成します。
     */
    public HanteiKekkaIchiranA3Property() {
        super(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE525002.getReportId());
    }

}

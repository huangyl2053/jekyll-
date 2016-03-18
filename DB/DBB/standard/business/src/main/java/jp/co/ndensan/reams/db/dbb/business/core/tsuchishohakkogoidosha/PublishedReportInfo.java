/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 発行帳票情報
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PublishedReportInfo {

    private ReportId 帳票ID;
    private YMDHMS 帳票作成日時;

    /**
     * コンストラクタです
     */
    public PublishedReportInfo() {
    }

    /**
     * コンストラクタです
     *
     * @param 帳票ID ReportId
     * @param 帳票作成日時 YMDHMS
     */
    public PublishedReportInfo(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }
}

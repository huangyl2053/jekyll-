/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaisho;

import java.util.List;

/**
 * 要介護認定調査依頼書作成_帳票パラメータクラスです。
 *
 * @reamsid_L DBE-0010-020 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraishoReportJoho {

    private final List<ChosaIraishoHeadItem> headItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItemList 要介護認定調査依頼書ヘッダ
     */
    public ChosaIraishoReportJoho(List<ChosaIraishoHeadItem> headItemList) {

        this.headItemList = headItemList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairaisho;

/**
 *
 * 要介護認定調査依頼書作成_帳票パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraishoReportJoho {

    private final ChosaIraishoHeadItem headItem;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 要介護認定調査依頼書ヘッダ
     */
    public ChosaIraishoReportJoho(
            ChosaIraishoHeadItem headItem) {

        this.headItem = headItem;
    }
}

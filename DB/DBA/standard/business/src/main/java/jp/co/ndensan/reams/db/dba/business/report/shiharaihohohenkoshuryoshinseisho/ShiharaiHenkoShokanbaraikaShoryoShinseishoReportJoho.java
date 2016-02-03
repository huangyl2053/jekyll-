/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

/**
 * 支払方法変更（償還払い化）終了申請書_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHenkoShokanbaraikaShoryoShinseishoReportJoho {

    private final ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 支払方法変更（償還払い化）終了申請書ヘッダ
     */
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoReportJoho(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem) {
        this.headItem = headItem;
    }
}

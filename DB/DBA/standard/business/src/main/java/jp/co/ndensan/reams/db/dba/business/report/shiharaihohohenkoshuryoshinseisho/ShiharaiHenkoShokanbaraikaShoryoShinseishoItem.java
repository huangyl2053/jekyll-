/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.shiharaihohohenkoshuryoshinseisho;

import lombok.Getter;

/**
 * 支払方法変更（償還払い化）終了申請書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiHenkoShokanbaraikaShoryoShinseishoItem {

    private final ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 支払方法変更（償還払い化）終了申請書
     */
    public ShiharaiHenkoShokanbaraikaShoryoShinseishoItem(
            ShiharaiHenkoShokanbaraikaShoryoShinseishoHeadItem headItem) {
        this.headItem = headItem;
    }
}

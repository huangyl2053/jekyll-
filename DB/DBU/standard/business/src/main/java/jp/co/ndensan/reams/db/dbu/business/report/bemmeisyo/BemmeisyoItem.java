/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

import lombok.Getter;

/**
 * 弁明書のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BemmeisyoItem {

    private final BemmeisyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 弁明書
     * @param bodyItem 弁明書
     */
    public BemmeisyoItem(
            BemmeisyoHeadItem headItem) {
        this.headItem = headItem;
    }
}

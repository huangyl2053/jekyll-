/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaitenkyokekkaichiranhyo;

import lombok.Getter;

/**
 * 広域内転居結果一覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiTenkyoKekkaIchiranhyoItem {

    private final KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 広域内転居結果一覧表
     */
    public KoikinaiTenkyoKekkaIchiranhyoItem(
            KoikinaiTenkyoKekkaIchiranhyoHeadItem headItem) {
        this.headItem = headItem;
    }
}

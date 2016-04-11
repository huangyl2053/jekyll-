/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import java.util.List;
import lombok.Getter;

/**
 * 転入転出未登録一覧表のITEMです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMiTorokuIchiranhyoItem {

    private final TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem;
    private final List<TennyuTenshutsuMiTorokuIchiranhyoBodyItem> bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 転入転出未登録一覧表ヘッダのITEM
     * @param bodyItem 転入転出未登録一覧表ボディのITEM
     */
    public TennyuTenshutsuMiTorokuIchiranhyoItem(
            TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem,
            List<TennyuTenshutsuMiTorokuIchiranhyoBodyItem> bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}

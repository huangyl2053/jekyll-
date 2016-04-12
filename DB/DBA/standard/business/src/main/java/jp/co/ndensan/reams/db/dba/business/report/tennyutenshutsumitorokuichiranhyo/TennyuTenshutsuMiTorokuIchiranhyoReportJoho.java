/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

import java.util.List;

/**
 * 転入転出未登録一覧表作成_帳票クラスパラメータクラスです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMiTorokuIchiranhyoReportJoho {

    private final TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem;
    private final List<TennyuTenshutsuMiTorokuIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 転入転出未登録一覧表情報ヘッダ
     * @param bodyItemList 転入転出未登録一覧表情報ボディリスト
     */
    public TennyuTenshutsuMiTorokuIchiranhyoReportJoho(
            TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem,
            List<TennyuTenshutsuMiTorokuIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}

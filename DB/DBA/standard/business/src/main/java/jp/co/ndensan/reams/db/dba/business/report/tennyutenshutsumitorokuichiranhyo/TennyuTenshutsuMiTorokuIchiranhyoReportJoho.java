/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo;

/**
 * 転入転出未登録一覧表作成_帳票クラスパラメータクラスです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TennyuTenshutsuMiTorokuIchiranhyoReportJoho {

    private final TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem;
    private final TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 転入転出未登録一覧表情報ヘッダ
     * @param bodyItem 転入転出未登録一覧表情報ボディ
     */
    public TennyuTenshutsuMiTorokuIchiranhyoReportJoho(
            TennyuTenshutsuMiTorokuIchiranhyoHeadItem headItem,
            TennyuTenshutsuMiTorokuIchiranhyoBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}

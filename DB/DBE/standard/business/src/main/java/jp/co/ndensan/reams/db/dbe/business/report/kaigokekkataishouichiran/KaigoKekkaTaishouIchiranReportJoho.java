/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kaigokekkataishouichiran;

/**
 * 要介護認定結果通知書対象者一覧表作成_帳票クラスパラメータクラスです。
 *
 * @reamsid_L DBE-0190-020 lizhuoxuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoKekkaTaishouIchiranReportJoho {

    private final KaigoKekkaTaishouIchiranHeadItem headItem;
    private final KaigoKekkaTaishouIchiranBodyItem bodyItem;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 要介護認定結果通知書対象者一覧情報ヘッダ
     * @param bodyItem 要介護認定結果通知書対象者一覧情報ボディリスト
     */
    public KaigoKekkaTaishouIchiranReportJoho(
            KaigoKekkaTaishouIchiranHeadItem headItem,
            KaigoKekkaTaishouIchiranBodyItem bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}

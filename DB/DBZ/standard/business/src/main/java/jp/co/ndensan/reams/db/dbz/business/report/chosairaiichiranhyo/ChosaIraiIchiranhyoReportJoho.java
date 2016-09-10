/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo;

import java.util.List;

/**
 * 認定調査依頼一覧表作成_帳票パラメータクラスです。
 *
 * @reamsid_L DBE-0010-030 lishengli
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaIraiIchiranhyoReportJoho {

    private final List<ChosaIraiIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param bodyItemList 認定調査依頼一覧情報ボディリスト
     */
    public ChosaIraiIchiranhyoReportJoho(
            List<ChosaIraiIchiranhyoBodyItem> bodyItemList) {

        this.bodyItemList = bodyItemList;
    }
}

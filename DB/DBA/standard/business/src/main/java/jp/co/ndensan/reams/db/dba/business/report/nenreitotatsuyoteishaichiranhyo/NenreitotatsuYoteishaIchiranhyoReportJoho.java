/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import java.util.List;

/**
 * 年齢到達予定者一覧表作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreitotatsuYoteishaIchiranhyoReportJoho {

    private final NenreitotatsuYoteishaIchiranhyoHeadItem headItem;
    private final List<NenreitotatsuYoteishaIchiranhyoBodyItem> bodyItemList;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 年齢到達予定者一覧表情報ヘッダ
     * @param bodyItemList 年齢到達予定者一覧表情報ボディリスト
     */
    public NenreitotatsuYoteishaIchiranhyoReportJoho(
            NenreitotatsuYoteishaIchiranhyoHeadItem headItem,
            List<NenreitotatsuYoteishaIchiranhyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }
}

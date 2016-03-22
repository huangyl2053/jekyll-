/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo;

import java.util.List;
import lombok.Getter;

/**
 * 年齢到達予定者一覧表のITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreitotatsuYoteishaIchiranhyoItem {

    private final NenreitotatsuYoteishaIchiranhyoHeadItem headItem;
    private final List<NenreitotatsuYoteishaIchiranhyoBodyItem> bodyItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 年齢到達予定者一覧表ヘッダのITEM
     * @param bodyItem 年齢到達予定者一覧表ボディのITEM
     */
    public NenreitotatsuYoteishaIchiranhyoItem(
            NenreitotatsuYoteishaIchiranhyoHeadItem headItem,
            List<NenreitotatsuYoteishaIchiranhyoBodyItem> bodyItem) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }
}

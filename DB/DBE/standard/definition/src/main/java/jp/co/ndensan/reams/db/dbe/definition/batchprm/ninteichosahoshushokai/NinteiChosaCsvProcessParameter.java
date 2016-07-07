/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

/**
 * 認定調査報酬照会CSV作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaCsvProcessParameter {

    private Object itemList;

    /**
     * 認定調査報酬照会の情報データの取得です。
     *
     * @return 認定調査報酬照会の情報リスト
     */
    public Object getNinteiChosaItemList() {
        return itemList;
    }

    /**
     * 認定調査報酬照会の情報データの設定です。
     *
     * @param ninteiItemList 認定調査報酬照会の情報リスト
     */
    public void setNinteiChosaItemList(Object ninteiItemList) {
        this.itemList = ninteiItemList;
    }
}

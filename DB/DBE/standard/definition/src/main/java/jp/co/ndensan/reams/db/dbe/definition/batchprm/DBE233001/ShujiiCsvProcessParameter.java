/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 *
 * 主治医意見書督促対象者一覧表CSV作成_バッチ処理クラスパラメータクラスです。
 *
 * @reamsid_L DBE-0060-040 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiCsvProcessParameter implements IBatchProcessParameter {

    private Object itemList;

    /**
     * 主治医意見書督促対象者一覧表の情報データの取得です。
     *
     * @return shujiiItemList 主治医意見書督促対象者一覧表の情報リスト
     */
    public Object getShujiiItemList() {
        return itemList;
    }

    /**
     * 主治医意見書督促対象者一覧表の情報データの設定です。
     *
     * @param shujiiItemList 主治医意見書督促対象者一覧表の情報リスト
     */
    public void setShujiiItemList(Object shujiiItemList) {
        this.itemList = shujiiItemList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;

/**
 *　
 * 認定調査督促対象者一覧表CSV作成_バッチ処理クラスパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
public class NinteiChosaTokusokuTaishoshaIchiranhyoCsvProcessParameter implements IBatchProcessParameter {
    
    private Object itemList;
    
   /**
     * 認定調査督促対象者一覧表の情報データの取得です。
     *
     * @return ninteiChosaTokusokuTaishoshaIchiranhyoItemList　認定調査督促対象者一覧表の情報リスト
     */
    public Object getNinteiChosaTokusokuTaishoshaIchiranhyoItemList() {
        return itemList;
    }

    /**
     * 認定調査督促対象者一覧表の情報データの設定です。
     *
     * @param ninteiChosaTokusokuItemList 認定調査督促対象者一覧表の情報リスト
     */
    public void setNinteiChosaTokusokuTaishoshaIchiranhyoItemList(Object ninteiChosaTokusokuItemList) {
        this.itemList = ninteiChosaTokusokuItemList;
    }
    
}

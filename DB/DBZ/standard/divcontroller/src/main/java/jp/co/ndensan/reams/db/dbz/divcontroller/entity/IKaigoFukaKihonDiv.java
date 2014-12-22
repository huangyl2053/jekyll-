/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoFukaKihonSearchKey;

/**
 * 介護賦課基本情報Divのインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface IKaigoFukaKihonDiv {

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 検索キー 介護賦課基本情報の検索キー
     */
    void load(KaigoFukaKihonSearchKey 検索キー);
}

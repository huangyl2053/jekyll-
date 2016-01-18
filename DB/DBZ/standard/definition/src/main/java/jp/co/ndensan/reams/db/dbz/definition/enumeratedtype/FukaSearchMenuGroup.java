/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

// TODO N8156 宮本 康 メニューグループは要精査
/**
 * 賦課対象者検索用のメニューグループを定義した列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum FukaSearchMenuGroup {

    /**
     * メニューグループが「照会系」であることを表します。
     */
    照会系,
    /**
     * メニューグループが「賦課照会系」であることを表します。
     */
    賦課照会系,
    /**
     * メニューグループが「所得照会系」であることを表します。
     */
    所得照会系,
    /**
     * メニューグループが「更新系」であることを表します。
     */
    更新系,
    /**
     * メニューグループが「所得入力系」であることを表します。
     */
    所得入力系,
    /**
     * メニューグループが「更正計算系」であることを表します。
     */
    更正計算系,
    /**
     * メニューグループが「即時更正系」であることを表します。
     */
    即時更正系,
    /**
     * メニューグループが「通知書発行系」であることを表します。
     */
    通知書発行系;
}

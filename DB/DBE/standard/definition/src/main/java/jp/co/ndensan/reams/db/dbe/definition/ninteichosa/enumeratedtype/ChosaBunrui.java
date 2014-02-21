/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

/**
 * 要介護認定調査の調査分類を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum ChosaBunrui {

    /**
     * 調査分類が「第１群」であることを表します。
     */
    第１群,
    /**
     * 調査分類が「第２群」であることを表します。
     */
    第２群,
    /**
     * 調査分類が「第３群」であることを表します。
     */
    第３群,
    /**
     * 調査分類が「第４群」であることを表します。
     */
    第４群,
    /**
     * 調査分類が「第５群」であることを表します。
     */
    第５群,
    /**
     * 調査分類が「特別医療」であることを表します。
     */
    特別医療,
    /**
     * 調査分類が「自立度」であることを表します。
     */
    自立度;
}

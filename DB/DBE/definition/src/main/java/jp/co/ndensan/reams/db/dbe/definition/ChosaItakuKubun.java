/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

/**
 * 調査委託先の区分を表すコードです
 * 
 * @author N1013 松本直樹
 */
public enum ChosaItakuKubun {
    /**
     * 指定なしを示すコードです
     */
    指定なし,
    /**
     * 保険者（市町村等）を示すコードです
     */
    保険者,
    /**
     * 指定市町村事務受託法人を示すコードです
     */
    指定市町村事務受託法人,
    /**
     * 指定居宅介護支援事業者を示すコードです
     */
    指定居宅介護支援事業者,
    /**
     * 介護保険施設を示すコードです
     */
    介護保険施設,
    /**
     * 介護支援専門員を示すコードです
     */
    介護支援専門員,
    /**
     * 他市町村を示すコードです
     */
    他市町村,
    /**
     * その他を示すコードです
     */
    その他
}

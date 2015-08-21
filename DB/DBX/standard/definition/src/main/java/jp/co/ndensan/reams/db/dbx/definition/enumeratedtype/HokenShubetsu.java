/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

/**
 * 保険種別を表す列挙型です。
 *
 * @author n8168 岩山 慎吾
 * @jpName 保険種別
 * @bizDomain 保険・福祉
 * @category 保険料
 * @subCategory
 * @mainClass
 * @reference
 */
public enum HokenShubetsu {

    /**
     * 国民健康保険であることを表します。
     */
    国民健康保険,
    /**
     * 介護保険であることを表します。
     */
    介護保険,
    /**
     * 後期高齢者であることを表します。
     */
    後期高齢者,
    /**
     * 社会保険であることを表します。
     */
    社会保険;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

/**
 * 取下げ区分を表す列挙型です。
 *
 * @author n3310 酒井 裕亮
 * @jpName 取下げ区分
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public enum TorisageKubun {

    /**
     * 認定申請有効します。
     */
    認定申請有効,
    /**
     * 区分変更却下します。
     */
    区分変更却下,
    /**
     * 認定申請取下げします。
     */
    認定申請取下げ,
    /**
     * 認定申請削除します。
     */
    認定申請削除;
}

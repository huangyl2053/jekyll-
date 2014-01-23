/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

/**
 * 介護認定申請の取下げ区分を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum TorisageKubun {

    /**
     * 認定申請有効
     */
    認定申請有効,
    /**
     * 区分変更却下
     */
    区分変更却下,
    /**
     * 認定申請取下げ
     */
    認定申請取下げ,
    /**
     * 認定申請削除
     */
    認定申請削除;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査委託先情報を表す列挙型です。
 * @author N1013 松本直樹
 */
public enum NinteichosaItakusakiJoho implements IColumnDefinition {
    /**
     * 市町村コード
     */
    SHICHOSON_CD,
    /**
     * 介護事業者番号
     */
    KAIGO_JIGYOSHA_NO,
    /**
     * 事業者番号
     */
    JIGYOSHA_NO,
    /**
     * 介護事業者状況
     */
    KAIGO_JIGYOSHA_JOKYO,
    /**
     * 調査委託区分
     */
    CHOSA_ITAKU_KUBUN,
    /**
     * 割付定員
     */
    WARITSUKE_TEIIN,
    /**
     * 割付地区
     */
    WARITSUKE_TIKU,
    /**
     * 機関の区分
     */
    KIKAN_KUBUN
    
}
